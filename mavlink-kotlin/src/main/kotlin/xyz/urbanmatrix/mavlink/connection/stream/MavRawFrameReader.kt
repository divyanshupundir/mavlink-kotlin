package xyz.urbanmatrix.mavlink.connection.stream

import xyz.urbanmatrix.mavlink.frame.MavFrameType
import xyz.urbanmatrix.mavlink.frame.MavRawFrame
import java.io.EOFException
import java.io.IOException
import java.io.InputStream

internal class MavRawFrameReader(
    inputStream: InputStream
) {
    companion object {
        const val BUFFER_SIZE = 280
    }

    private val inputStream = TransactionalInputStream(inputStream, BUFFER_SIZE)

    @Throws(IOException::class)
    fun next(): MavRawFrame {
        while (!Thread.currentThread().isInterrupted) {
            inputStream.commit()

            val versionMarker = inputStream.read()
            if (versionMarker == -1) throw EOFException()

            val payloadLength = inputStream.read()
            if (payloadLength == -1) throw EOFException()

            when (versionMarker.toUByte()) {
                MavFrameType.V1.magic -> {
                    val success = inputStream.advance(
                        MavRawFrame.SIZE_SEQ + MavRawFrame.SIZE_SYS_ID +
                                MavRawFrame.SIZE_COMP_ID + MavRawFrame.SIZE_MSG_ID_V1 +
                            payloadLength + MavRawFrame.SIZE_CHECKSUM
                    )
                    if (!success) {
                        drop()
                        continue
                    }

                    return MavRawFrame.fromV1Bytes(inputStream.buffer)
                }

                MavFrameType.V2.magic -> {
                    val incompatibleFlags = inputStream.read()
                    if (incompatibleFlags == -1) throw EOFException()

                    val signatureSize = if (incompatibleFlags.toUByte() == MavRawFrame.INCOMPAT_FLAG_SIGNED) {
                        MavRawFrame.SIZE_SIGNATURE
                    } else {
                        0
                    }

                    val success = inputStream.advance(
                        MavRawFrame.SIZE_COMPAT_FLAGS + MavRawFrame.SIZE_SEQ +
                                MavRawFrame.SIZE_SYS_ID + MavRawFrame.SIZE_COMP_ID +
                                MavRawFrame.SIZE_MSG_ID_V2 + payloadLength +
                                MavRawFrame.SIZE_CHECKSUM + signatureSize
                    )
                    if (!success) {
                        drop()
                        continue
                    }

                    return MavRawFrame.fromV2Bytes(inputStream.buffer)
                }

                else -> {
                    drop()
                }
            }
        }

        throw IOException()
    }

    @Throws(IOException::class)
    fun drop() {
        inputStream.run {
            rollback()
            skip(1)
            commit()
        }
    }
}

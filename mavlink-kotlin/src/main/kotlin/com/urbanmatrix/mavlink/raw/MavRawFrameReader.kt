package com.urbanmatrix.mavlink.raw

import java.io.IOException
import java.io.InputStream

class MavRawFrameReader(
    inputStream: InputStream
) {
    companion object {
        const val BUFFER_SIZE = 280
    }

    private val inputStream = TransactionalInputStream(inputStream, BUFFER_SIZE)

    @Throws(IOException::class)
    fun next(): MavRawFrame {
        inputStream.commit()

        while (!Thread.currentThread().isInterrupted) {
            val versionMarker = inputStream.read()
            if (versionMarker == -1) continue

            val payloadLength = inputStream.read()
            if (payloadLength == -1) continue

            when (versionMarker) {
                MavFrameType.V1.magic -> {
                    val success = inputStream.advance(
                        MavRawFrame.SIZE_SEQ + MavRawFrame.SIZE_SYS_ID +
                            MavRawFrame.SIZE_COMP_ID + MavRawFrame.SIZE_MSG_ID_V1 +
                            payloadLength + MavRawFrame.SIZE_CHECKSUM
                    )
                    if (!success) continue

                    return MavRawFrame.fromV1Bytes(inputStream.buffer)
                }

                MavFrameType.V2.magic -> {
                    val incompatibleFlags = inputStream.read()
                    if (incompatibleFlags == -1) continue

                    val signatureSize = if (incompatibleFlags == MavRawFrame.INCOMPAT_FLAG_SIGNED) {
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
                    if (!success) continue

                    return MavRawFrame.fromV2Bytes(inputStream.buffer)
                }

                else -> drop()
            }
        }

        throw IOException()
    }

    @Throws(IOException::class)
    fun drop() {
        inputStream.run {
            rollback()
            skip(1)
        }
    }
}

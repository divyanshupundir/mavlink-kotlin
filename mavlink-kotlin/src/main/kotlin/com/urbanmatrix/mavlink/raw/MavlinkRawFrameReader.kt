package com.urbanmatrix.mavlink.raw

import java.io.IOException
import java.io.InputStream

class MavlinkRawFrameReader(
    inputStream: InputStream
) {
    companion object {
        const val BUFFER_SIZE = 280
    }

    private val inputStream = TransactionalInputStream(inputStream, BUFFER_SIZE)

    @Throws(IOException::class)
    fun next(): MavlinkRawFrame {
        inputStream.commit()

        while (!Thread.currentThread().isInterrupted) {
            val versionMarker = inputStream.read()
            if (versionMarker == -1) continue

            val payloadLength = inputStream.read()
            if (payloadLength == -1) continue

            when (versionMarker) {
                MavlinkFrameType.V1.magic -> {
                    val success = inputStream.advance(
                        MavlinkRawFrame.SIZE_SEQ + MavlinkRawFrame.SIZE_SYS_ID +
                            MavlinkRawFrame.SIZE_COMP_ID + MavlinkRawFrame.SIZE_MSG_ID_V1 +
                            payloadLength + MavlinkRawFrame.SIZE_CHECKSUM
                    )
                    if (!success) continue

                    return MavlinkRawFrame.fromV1Bytes(inputStream.buffer)
                }

                MavlinkFrameType.V2.magic -> {
                    val incompatibleFlags = inputStream.read()
                    if (incompatibleFlags == -1) continue

                    val signatureSize = if (incompatibleFlags == MavlinkRawFrame.INCOMPAT_FLAG_SIGNED) {
                        MavlinkRawFrame.SIZE_SIGNATURE
                    } else {
                        0
                    }

                    val success = inputStream.advance(
                        MavlinkRawFrame.SIZE_COMPAT_FLAGS + MavlinkRawFrame.SIZE_SEQ +
                            MavlinkRawFrame.SIZE_SYS_ID + MavlinkRawFrame.SIZE_COMP_ID +
                            MavlinkRawFrame.SIZE_MSG_ID_V2 + payloadLength +
                            MavlinkRawFrame.SIZE_CHECKSUM + signatureSize
                    )
                    if (!success) continue

                    return MavlinkRawFrame.fromV2Bytes(inputStream.buffer)
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

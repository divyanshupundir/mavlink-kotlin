package com.divpundir.mavlink.connection.stream

import com.divpundir.mavlink.frame.MavFrameType
import com.divpundir.mavlink.frame.MavRawFrame
import okio.BufferedSource
import java.io.EOFException
import java.io.IOException

internal class MavRawFrameReader(
    private val source: BufferedSource
) {
    @Throws(IOException::class)
    fun next(): MavRawFrame {
        while (!Thread.currentThread().isInterrupted) {
            val versionMarker = source.readByte()

            when (versionMarker.toUByte()) {
                MavFrameType.V1.magic -> {
                    val peeked = source.peek()
                    val payloadSize = peeked.readByte()

                    val remainingSize = MavRawFrame.SIZE_SEQ + MavRawFrame.SIZE_SYS_ID + MavRawFrame.SIZE_COMP_ID +
                            MavRawFrame.SIZE_MSG_ID_V1 + payloadSize + MavRawFrame.SIZE_CHECKSUM

                    if (!peeked.request(remainingSize.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalLength = MavRawFrame.SIZE_STX + MavRawFrame.SIZE_LEN + remainingSize.toLong()

                    return MavRawFrame.fromV1Bytes(source.readByteArray(totalLength))
                }

                MavFrameType.V2.magic -> {
                    val peeked = source.peek()
                    val payloadSize = peeked.readByte()
                    val incompatibleFlags = peeked.readByte()

                    val signatureSize = if (incompatibleFlags.toUByte() == MavRawFrame.INCOMPAT_FLAG_SIGNED) {
                        MavRawFrame.SIZE_SIGNATURE
                    } else {
                        0
                    }

                    val remainingSize = MavRawFrame.SIZE_COMPAT_FLAGS + MavRawFrame.SIZE_SEQ +
                            MavRawFrame.SIZE_SYS_ID + MavRawFrame.SIZE_COMP_ID + MavRawFrame.SIZE_MSG_ID_V2 +
                            payloadSize + MavRawFrame.SIZE_CHECKSUM + signatureSize

                    if (!peeked.request(remainingSize.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalSize = MavRawFrame.SIZE_STX + MavRawFrame.SIZE_LEN + MavRawFrame.SIZE_INCOMPAT_FLAGS +
                            remainingSize.toLong()

                    return MavRawFrame.fromV2Bytes(source.readByteArray(totalSize))
                }

                else -> {
                    source.skip(1)
                }
            }
        }

        throw EOFException()
    }
}

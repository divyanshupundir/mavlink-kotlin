package com.divpundir.mavlink.connection.stream

import com.divpundir.mavlink.frame.MavFrameType
import com.divpundir.mavlink.frame.MavRawFrame
import okio.BufferedSource
import java.io.EOFException
import java.io.IOException
import java.io.InputStream

internal class MavRawFrameReader(
    private val source: BufferedSource
) {
    @Throws(IOException::class)
    fun next(): MavRawFrame {
        while (!Thread.currentThread().isInterrupted) {
            val peeked = source.peek()

            if (!peeked.request(MavRawFrame.SIZE_STX.toLong())) {
                source.skip(1)
                continue
            }
            val versionMarker = peeked.readByte().toUByte()

            if (!peeked.request(MavRawFrame.SIZE_LEN.toLong())) {
                source.skip(1)
                continue
            }
            val payloadLength = peeked.readByte()

            when (versionMarker) {
                MavFrameType.V1.magic -> {
                    val remainingLength = MavRawFrame.SIZE_SEQ + MavRawFrame.SIZE_SYS_ID + MavRawFrame.SIZE_COMP_ID +
                            MavRawFrame.SIZE_MSG_ID_V1 + payloadLength + MavRawFrame.SIZE_CHECKSUM

                    if (!peeked.request(remainingLength.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalLength = MavRawFrame.SIZE_STX + MavRawFrame.SIZE_LEN + remainingLength.toLong()

                    return MavRawFrame.fromV1Bytes(source.readByteArray(totalLength))
                }

                MavFrameType.V2.magic -> {
                    if (!peeked.request(MavRawFrame.SIZE_INCOMPAT_FLAGS.toLong())) {
                        source.skip(1)
                        continue
                    }
                    val incompatibleFlags = source.readByte()

                    val signatureSize = if (incompatibleFlags.toUByte() == MavRawFrame.INCOMPAT_FLAG_SIGNED) {
                        MavRawFrame.SIZE_SIGNATURE
                    } else {
                        0
                    }

                    val remainingLength = MavRawFrame.SIZE_COMPAT_FLAGS + MavRawFrame.SIZE_SEQ +
                            MavRawFrame.SIZE_SYS_ID + MavRawFrame.SIZE_COMP_ID + MavRawFrame.SIZE_MSG_ID_V2 +
                            payloadLength + MavRawFrame.SIZE_CHECKSUM + signatureSize

                    if (!peeked.request(remainingLength.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalLength = MavRawFrame.SIZE_STX + MavRawFrame.SIZE_LEN + MavRawFrame.SIZE_INCOMPAT_FLAGS +
                            remainingLength.toLong()

                    return MavRawFrame.fromV2Bytes(source.readByteArray(totalLength))
                }

                else -> {
                    source.skip(1)
                }
            }
        }

        throw IOException()
    }

    fun drop() {
        source.skip(1)
    }
}

package com.divpundir.mavlink.connection

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
                MavRawFrame.Stx.V1 -> {
                    val peeked = source.peek()
                    val payloadSize = peeked.readByte()

                    val remainingSize = MavRawFrame.Sizes.SEQ + MavRawFrame.Sizes.SYS_ID + MavRawFrame.Sizes.COMP_ID +
                            MavRawFrame.Sizes.MSG_ID_V1 + payloadSize + MavRawFrame.Sizes.CHECKSUM

                    if (!peeked.request(remainingSize.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalLength = MavRawFrame.Sizes.STX + MavRawFrame.Sizes.LEN + remainingSize.toLong()

                    return MavRawFrame.fromV1Bytes(source.readByteArray(totalLength))
                }

                MavRawFrame.Stx.V2 -> {
                    val peeked = source.peek()
                    val payloadSize = peeked.readByte()
                    val incompatibleFlags = peeked.readByte()

                    val signatureSize = if (incompatibleFlags.toUByte() == MavRawFrame.Flags.INCOMPAT_SIGNED) {
                        MavRawFrame.Sizes.SIGNATURE
                    } else {
                        0
                    }

                    val remainingSize = MavRawFrame.Sizes.COMPAT_FLAGS + MavRawFrame.Sizes.SEQ +
                            MavRawFrame.Sizes.SYS_ID + MavRawFrame.Sizes.COMP_ID + MavRawFrame.Sizes.MSG_ID_V2 +
                            payloadSize + MavRawFrame.Sizes.CHECKSUM + signatureSize

                    if (!peeked.request(remainingSize.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalSize = MavRawFrame.Sizes.STX + MavRawFrame.Sizes.LEN + MavRawFrame.Sizes.INCOMPAT_FLAGS +
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

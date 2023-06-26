package com.divpundir.mavlink.connection

import okio.BufferedSource
import okio.EOFException
import okio.IOException

internal class MavRawFrameReader(
    private val source: BufferedSource
) {
    @Throws(IOException::class)
    fun next(): MavRawFrame {
        while (!Thread.currentThread().isInterrupted) {
            val peeked = source.peek()

            when (peeked.readByte().toUByte()) {
                MavRawFrame.Stx.V1 -> {
                    val payloadSize = peeked.readByte().toUByte().toInt()

                    val remainingSize = MavRawFrame.Sizes.SEQ +
                            MavRawFrame.Sizes.SYS_ID + MavRawFrame.Sizes.COMP_ID + MavRawFrame.Sizes.MSG_ID_V1 +
                            payloadSize + MavRawFrame.Sizes.CHECKSUM

                    if (!peeked.request(remainingSize.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalSize = MavRawFrame.Sizes.STX + MavRawFrame.Sizes.LEN + remainingSize.toLong()

                    return MavRawFrame.fromV1Bytes(source.readByteArray(totalSize))
                }

                MavRawFrame.Stx.V2 -> {
                    val payloadSize = peeked.readByte().toUByte().toInt()
                    val incompatibleFlags = peeked.readByte().toUByte()

                    val signatureTotalSize = if (incompatibleFlags == MavRawFrame.Flags.INCOMPAT_SIGNED) {
                        MavRawFrame.Sizes.SIGNATURE_LINK_ID + MavRawFrame.Sizes.SIGNATURE_TIMESTAMP + MavRawFrame.Sizes.SIGNATURE
                    } else {
                        0
                    }

                    val remainingSize = MavRawFrame.Sizes.COMPAT_FLAGS +
                            MavRawFrame.Sizes.SEQ +
                            MavRawFrame.Sizes.SYS_ID + MavRawFrame.Sizes.COMP_ID + MavRawFrame.Sizes.MSG_ID_V2 +
                            payloadSize + MavRawFrame.Sizes.CHECKSUM +
                            signatureTotalSize

                    if (!peeked.request(remainingSize.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalSize = MavRawFrame.Sizes.STX + MavRawFrame.Sizes.LEN +
                            MavRawFrame.Sizes.INCOMPAT_FLAGS + remainingSize.toLong()

                    return MavRawFrame.fromV2Bytes(source.readByteArray(totalSize))
                }

                else -> {
                    source.skip(1)
                    continue
                }
            }
        }

        throw EOFException()
    }
}

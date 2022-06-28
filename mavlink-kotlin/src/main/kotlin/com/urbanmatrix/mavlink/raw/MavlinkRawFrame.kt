package com.urbanmatrix.mavlink.raw

import com.urbanmatrix.mavlink.serialization.*
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.security.MessageDigest

data class MavlinkRawFrame(
    val stx: Int,
    val len: Int,
    val incompatFlags: Int,
    val compatFlags: Int,
    val seq: Int,
    val systemId: Int,
    val componentId: Int,
    val messageId: Int,
    val payload: ByteArray,
    val checksum: Int,
    val signature: ByteArray,
    val rawBytes: ByteArray
) {
    val isSigned: Boolean
        get() = (incompatFlags and INCOMPAT_FLAG_SIGNED) != 0

    val signatureLinkId: Int
        get() = if (isSigned) {
            signature.first().toInt() and 0xFF
        } else {
            -1
        }

    val signatureTimestamp: Long
        get() = if (isSigned) {
            ByteBuffer
                .wrap(signature)
                .order(ByteOrder.LITTLE_ENDIAN)
                .position(SIZE_SIGNATURE_LINK_ID)
                .decodeUnsignedIntegerValue(SIZE_SIGNATURE_TIMESTAMP)
        } else {
            -1
        }

    fun validateCrc(crcExtra: Int): Boolean =
        rawBytes.generateCrc(crcExtra) == checksum

    fun validateSignature(secretKey: ByteArray): Boolean =
        isSigned && signature.contentEquals(
            rawBytes.generateSignature(
                signatureLinkId,
                signatureTimestamp,
                secretKey
            )
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MavlinkRawFrame

        if (stx != other.stx) return false
        if (len != other.len) return false
        if (incompatFlags != other.incompatFlags) return false
        if (compatFlags != other.compatFlags) return false
        if (seq != other.seq) return false
        if (systemId != other.systemId) return false
        if (componentId != other.componentId) return false
        if (messageId != other.messageId) return false
        if (!payload.contentEquals(other.payload)) return false
        if (checksum != other.checksum) return false
        if (!signature.contentEquals(other.signature)) return false
        if (!rawBytes.contentEquals(other.rawBytes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = stx
        result = 31 * result + len
        result = 31 * result + incompatFlags
        result = 31 * result + compatFlags
        result = 31 * result + seq
        result = 31 * result + systemId
        result = 31 * result + componentId
        result = 31 * result + messageId
        result = 31 * result + payload.contentHashCode()
        result = 31 * result + checksum
        result = 31 * result + signature.contentHashCode()
        result = 31 * result + rawBytes.contentHashCode()
        return result
    }

    companion object {

        private const val SIZE_STX = 1
        private const val SIZE_LEN = 1
        private const val SIZE_INCOMPAT_FLAGS = 1
        private const val SIZE_COMPAT_FLAGS = 1
        private const val SIZE_SEQ = 1
        private const val SIZE_SYS_ID = 1
        private const val SIZE_COMP_ID = 1

        private const val SIZE_MSG_ID_V1 = 1
        private const val SIZE_MSG_ID_V2 = 3

        private const val SIZE_CHECKSUM = 2

        private const val SIZE_SIGNATURE_LINK_ID = 1
        private const val SIZE_SIGNATURE_TIMESTAMP = 6
        private const val SIZE_SIGNATURE_DATA = 6

        private const val SIZE_SIGNATURE = SIZE_SIGNATURE_LINK_ID +
            SIZE_SIGNATURE_TIMESTAMP + SIZE_SIGNATURE_DATA

        private const val INCOMPAT_FLAG_SIGNED = 0x01

        @Throws(Exception::class)
        private fun ByteArray.generateCrc(crcExtra: Int): Int {
            val frameSizeTillMsgId: Int = when (this.first().toInt() and 0xFF) {
                MavlinkFrameType.V1.magic -> SIZE_STX + SIZE_LEN +
                    SIZE_SEQ + SIZE_SYS_ID + SIZE_COMP_ID + SIZE_MSG_ID_V1

                MavlinkFrameType.V2.magic -> SIZE_STX + SIZE_LEN +
                    SIZE_INCOMPAT_FLAGS + SIZE_COMPAT_FLAGS +
                    SIZE_SEQ + SIZE_SYS_ID + SIZE_COMP_ID + SIZE_MSG_ID_V2

                else -> throw IllegalArgumentException("Not a MAVLink frame")
            }

            val payloadSize: Int = this[1].toInt() and 0xFF

            val frameSizeTillPayload = frameSizeTillMsgId + payloadSize

            return with(CrcX25()) {
                accumulate(this@generateCrc, 1, frameSizeTillPayload)
                accumulate(crcExtra)
                get()
            }
        }

        @Throws(IOException::class)
        private fun ByteArray.generateSignature(
            linkId: Int,
            timestamp: Long,
            secretKey: ByteArray
        ): ByteArray {
            if (this[0].toInt() and MavlinkFrameType.V2.magic != MavlinkFrameType.V2.magic ||
                this[2].toInt() and INCOMPAT_FLAG_SIGNED == 0
            ) {
                return ByteArray(0)
            }

            val payloadLength: Int = this[1].toInt() and 0xFF

            val frameSizeTillCrc = SIZE_STX + SIZE_LEN +
                SIZE_INCOMPAT_FLAGS + SIZE_COMPAT_FLAGS +
                SIZE_SEQ + SIZE_SYS_ID + SIZE_COMP_ID + SIZE_MSG_ID_V2 +
                payloadLength + SIZE_CHECKSUM

            val signatureBuffer = ByteBuffer.allocate(SIZE_SIGNATURE)
            signatureBuffer.encodeIntegerValue(linkId.toLong(), SIZE_SIGNATURE_LINK_ID)
            signatureBuffer.encodeIntegerValue(timestamp, SIZE_SIGNATURE_TIMESTAMP)

            val hash = with(MessageDigest.getInstance("SHA-256")) {
                update(secretKey)
                update(this@generateSignature, 0, frameSizeTillCrc)
                update(signatureBuffer.array(), 0, SIZE_SIGNATURE_LINK_ID + SIZE_SIGNATURE_TIMESTAMP)
                digest()
            }

            signatureBuffer.put(hash, 0, SIZE_SIGNATURE_DATA)
            return signatureBuffer.array()
        }

        fun fromV1Bytes(rawBytes: ByteArray): MavlinkRawFrame =
            with(ByteBuffer.wrap(rawBytes).order(ByteOrder.LITTLE_ENDIAN)) {
                val stx = decodeUint8()
                val len = decodeUint8()
                val seq = decodeUint8()
                val systemId = decodeUint8()
                val componentId = decodeUint8()
                val messageId = decodeUint8()
                val payload = ByteArray(len).also { get(it) }
                val checksum = decodeUint16()

                MavlinkRawFrame(
                    stx = stx,
                    len = len,
                    incompatFlags = -1,
                    compatFlags = -1,
                    seq = seq,
                    systemId = systemId,
                    componentId = componentId,
                    messageId = messageId,
                    payload = payload,
                    checksum = checksum,
                    signature = ByteArray(0),
                    rawBytes = rawBytes
                )
            }
    }
}

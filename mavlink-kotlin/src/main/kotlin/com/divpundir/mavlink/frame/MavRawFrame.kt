package com.divpundir.mavlink.frame

import com.divpundir.mavlink.serialization.*
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.security.MessageDigest

internal data class MavRawFrame(
    val stx: UByte,
    val len: UByte,
    val incompatFlags: UByte,
    val compatFlags: UByte,
    val seq: UByte,
    val systemId: UByte,
    val componentId: UByte,
    val messageId: UInt,
    val payload: ByteArray,
    val checksum: UShort,
    val signature: ByteArray,
    val rawBytes: ByteArray
) {
    val isSigned: Boolean
        get() = incompatFlags == Flags.INCOMPAT_SIGNED

    val signatureLinkId: UByte
        get() = if (isSigned) {
            signature.first().toUByte()
        } else {
            0u
        }

    val signatureTimestamp: UInt
        get() = if (isSigned) {
            ByteBuffer
                .wrap(signature)
                .order(ByteOrder.LITTLE_ENDIAN)
                .position(Sizes.SIGNATURE_LINK_ID)
                .decodeUnsignedIntegerValue(Sizes.SIGNATURE_TIMESTAMP)
                .toUInt()
        } else {
            0u
        }

    fun validateCrc(crcExtra: Byte): Boolean =
        rawBytes.generateChecksum(crcExtra) == checksum

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

        other as MavRawFrame

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
        return rawBytes.contentEquals(other.rawBytes)
    }

    override fun hashCode(): Int {
        var result = stx.hashCode()
        result = 31 * result + len.hashCode()
        result = 31 * result + incompatFlags.hashCode()
        result = 31 * result + compatFlags.hashCode()
        result = 31 * result + seq.hashCode()
        result = 31 * result + systemId.hashCode()
        result = 31 * result + componentId.hashCode()
        result = 31 * result + messageId.hashCode()
        result = 31 * result + payload.contentHashCode()
        result = 31 * result + checksum.hashCode()
        result = 31 * result + signature.contentHashCode()
        result = 31 * result + rawBytes.contentHashCode()
        return result
    }

    object Stx {
        const val V1: UByte = 0xFEu
        const val V2: UByte = 0xFDu
    }

    object Flags {
        const val INCOMPAT_SIGNED: UByte = 0x01u
    }

    object Sizes {
        const val STX = 1
        const val LEN = 1
        const val INCOMPAT_FLAGS = 1
        const val COMPAT_FLAGS = 1
        const val SEQ = 1
        const val SYS_ID = 1
        const val COMP_ID = 1

        const val MSG_ID_V1 = 1
        const val MSG_ID_V2 = 3

        const val CHECKSUM = 2

        const val SIGNATURE_LINK_ID = 1
        const val SIGNATURE_TIMESTAMP = 6
        const val SIGNATURE_DATA = 6

        const val SIGNATURE = SIGNATURE_LINK_ID + SIGNATURE_TIMESTAMP + SIGNATURE_DATA
    }

    companion object {

        @Throws(Exception::class)
        private fun ByteArray.generateChecksum(crcExtra: Byte): UShort {
            val frameSizeTillMsgId: Int = when (this.first().toUByte()) {
                Stx.V1 -> Sizes.STX + Sizes.LEN + Sizes.SEQ + Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V1

                Stx.V2 -> Sizes.STX + Sizes.LEN + Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS + Sizes.SEQ +
                        Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2

                else -> throw IllegalArgumentException("Not a MAVLink frame")
            }

            val payloadSize: Int = this[1].toUByte().toInt()

            val frameSizeTillPayload = frameSizeTillMsgId + payloadSize

            return with(CrcX25()) {
                accumulate(this@generateChecksum, 1, frameSizeTillPayload)
                accumulate(crcExtra)
                get()
            }
        }

        @Throws(IOException::class)
        private fun ByteArray.generateSignature(
            linkId: UByte,
            timestamp: UInt,
            secretKey: ByteArray
        ): ByteArray {
            if (this[0].toUByte() != Stx.V2 || this[2].toUByte() != Flags.INCOMPAT_SIGNED) {
                return ByteArray(0)
            }

            val payloadLength = this[1].toUByte().toInt()

            val frameSizeTillCrc = Sizes.STX + Sizes.LEN + Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS + Sizes.SEQ +
                    Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2 + payloadLength + Sizes.CHECKSUM

            val signatureBuffer = ByteBuffer.allocate(Sizes.SIGNATURE)
            signatureBuffer.encodeIntegerValue(linkId.toLong(), Sizes.SIGNATURE_LINK_ID)
            signatureBuffer.encodeIntegerValue(timestamp.toLong(), Sizes.SIGNATURE_TIMESTAMP)

            val hash = with(MessageDigest.getInstance("SHA-256")) {
                update(secretKey)
                update(this@generateSignature, 0, frameSizeTillCrc)
                update(signatureBuffer.array(), 0, Sizes.SIGNATURE_LINK_ID + Sizes.SIGNATURE_TIMESTAMP)
                digest()
            }

            signatureBuffer.put(hash, 0, Sizes.SIGNATURE_DATA)
            return signatureBuffer.array()
        }

        @Throws(Exception::class)
        fun fromV1Bytes(rawBytes: ByteArray): MavRawFrame =
            with(ByteBuffer.wrap(rawBytes).order(ByteOrder.LITTLE_ENDIAN)) {
                val stx = decodeUInt8()
                val len = decodeUInt8()
                val seq = decodeUInt8()
                val systemId = decodeUInt8()
                val componentId = decodeUInt8()
                val messageId = decodeUInt8().toUInt()
                val payload = ByteArray(len.toInt()).also { get(it) }
                val checksum = decodeUInt16()

                MavRawFrame(
                    stx = stx,
                    len = len,
                    incompatFlags = 0u,
                    compatFlags = 0u,
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

        @Throws(Exception::class)
        fun fromV2Bytes(rawBytes: ByteArray): MavRawFrame =
            with(ByteBuffer.wrap(rawBytes).order(ByteOrder.LITTLE_ENDIAN)) {
                val stx = decodeUInt8()
                val len = decodeUInt8()
                val incompatFlags = decodeUInt8()
                val compatFlags = decodeUInt8()
                val seq = decodeUInt8()
                val systemId = decodeUInt8()
                val componentId = decodeUInt8()
                val messageId = decodeUnsignedIntegerValue(Sizes.MSG_ID_V2).toUInt()
                val payload = ByteArray(len.toInt()).also { get(it) }
                val checksum = decodeUInt16()
                val signature = if (incompatFlags == Flags.INCOMPAT_SIGNED) {
                    if (remaining() < Sizes.SIGNATURE) {
                        ByteArray(0)
                    } else {
                        ByteArray(Sizes.SIGNATURE).also { get(it) }
                    }
                } else {
                    ByteArray(0)
                }

                MavRawFrame(
                    stx = stx,
                    len = len,
                    incompatFlags = incompatFlags,
                    compatFlags = compatFlags,
                    seq = seq,
                    systemId = systemId,
                    componentId = componentId,
                    messageId = messageId,
                    payload = payload,
                    checksum = checksum,
                    signature = signature,
                    rawBytes = rawBytes
                )
            }

        fun createV1(
            seq: UByte,
            systemId: UByte,
            componentId: UByte,
            messageId: UInt,
            payload: ByteArray,
            crcExtra: Byte
        ): MavRawFrame {
            val frameLength = Sizes.STX + Sizes.LEN + Sizes.SEQ + Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V1 +
                    payload.size + Sizes.CHECKSUM

            val rawBuffer = with(ByteBuffer.allocate(frameLength).order(ByteOrder.LITTLE_ENDIAN)) {
                encodeUInt8(Stx.V1)
                encodeUInt8(payload.size.toUByte())
                encodeUInt8(seq)
                encodeUInt8(systemId)
                encodeUInt8(componentId)
                encodeUInt8(messageId.toUByte())
                put(payload)
            }

            val checksum = rawBuffer.array().generateChecksum(crcExtra)
            rawBuffer.encodeUInt16(checksum)

            return MavRawFrame(
                stx = Stx.V1,
                len = payload.size.toUByte(),
                incompatFlags = 0u,
                compatFlags = 0u,
                seq = seq,
                systemId = systemId,
                componentId = componentId,
                messageId = messageId,
                payload = payload,
                checksum = checksum,
                signature = ByteArray(0),
                rawBytes = rawBuffer.array()
            )
        }

        fun createUnsignedV2(
            seq: UByte,
            systemId: UByte,
            componentId: UByte,
            messageId: UInt,
            payload: ByteArray,
            crcExtra: Byte
        ): MavRawFrame {
            val frameLength = Sizes.STX + Sizes.LEN + Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS + Sizes.SEQ +
                    Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2 + payload.size + Sizes.CHECKSUM

            val rawBuffer = with(ByteBuffer.allocate(frameLength).order(ByteOrder.LITTLE_ENDIAN)) {
                encodeUInt8(Stx.V2)
                encodeUInt8(payload.size.toUByte())
                encodeUInt8(0u)
                encodeUInt8(0u)
                encodeUInt8(seq)
                encodeUInt8(systemId)
                encodeUInt8(componentId)
                encodeIntegerValue(messageId.toLong(), Sizes.MSG_ID_V2)
                put(payload)
            }

            val checksum = rawBuffer.array().generateChecksum(crcExtra)
            rawBuffer.encodeUInt16(checksum)

            return MavRawFrame(
                stx = Stx.V2,
                len = payload.size.toUByte(),
                incompatFlags = 0u,
                compatFlags = 0u,
                seq = seq,
                systemId = systemId,
                componentId = componentId,
                messageId = messageId,
                payload = payload,
                checksum = checksum,
                signature = ByteArray(0),
                rawBytes = rawBuffer.array()
            )
        }

        fun createSignedV2(
            seq: UByte,
            systemId: UByte,
            componentId: UByte,
            messageId: UInt,
            payload: ByteArray,
            crcExtra: Byte,
            linkId: UByte,
            timestamp: UInt,
            secretKey: ByteArray
        ): MavRawFrame {
            val frameLength = Sizes.STX + Sizes.LEN + Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS + Sizes.SEQ +
                    Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2 + payload.size + Sizes.CHECKSUM + Sizes.SIGNATURE

            val rawBuffer = with(ByteBuffer.allocate(frameLength).order(ByteOrder.LITTLE_ENDIAN)) {
                encodeUInt8(Stx.V2)
                encodeUInt8(payload.size.toUByte())
                encodeUInt8(Flags.INCOMPAT_SIGNED)
                encodeUInt8(0u)
                encodeUInt8(seq)
                encodeUInt8(systemId)
                encodeUInt8(componentId)
                encodeIntegerValue(messageId.toLong(), Sizes.MSG_ID_V2)
                put(payload)
            }

            val checksum = rawBuffer.array().generateChecksum(crcExtra)
            rawBuffer.encodeUInt16(checksum)

            val signature = rawBuffer.array().generateSignature(linkId, timestamp, secretKey)
            rawBuffer.put(signature)

            return MavRawFrame(
                stx = Stx.V2,
                len = payload.size.toUByte(),
                incompatFlags = Flags.INCOMPAT_SIGNED,
                compatFlags = 0u,
                seq = seq,
                systemId = systemId,
                componentId = componentId,
                messageId = messageId,
                payload = payload,
                checksum = checksum,
                signature = signature,
                rawBytes = rawBuffer.array()
            )
        }
    }
}

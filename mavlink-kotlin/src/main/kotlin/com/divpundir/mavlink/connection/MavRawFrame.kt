package com.divpundir.mavlink.connection

import com.divpundir.mavlink.serialization.*
import okio.Buffer

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
    val signatureLinkId: UByte,
    val signatureTimestamp: UInt,
    val signature: ByteArray,
    val rawBytes: ByteArray
) {
    val isSigned: Boolean
        get() = incompatFlags == Flags.INCOMPAT_SIGNED

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
        if (signatureLinkId != other.signatureLinkId) return false
        if (signatureTimestamp != other.signatureTimestamp) return false
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
        result = 31 * result + signatureLinkId.hashCode()
        result = 31 * result + signatureTimestamp.hashCode()
        result = 31 * result + signature.contentHashCode()
        result = 31 * result + rawBytes.contentHashCode()
        return result
    }

    object Stx {
        const val V1: UByte = 0xFEu
        const val V2: UByte = 0xFDu
    }

    object Flags {
        const val INCOMPAT_UNSIGNED: UByte = 0x00u
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
        const val SIGNATURE = 6
    }

    companion object {

        @Throws(Exception::class)
        private fun ByteArray.generateChecksum(crcExtra: Byte): UShort {
            val frameSizeTillMsgId = when (this[0].toUByte()) {
                Stx.V1 -> Sizes.STX + Sizes.LEN +
                        Sizes.SEQ + Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V1

                Stx.V2 -> Sizes.STX + Sizes.LEN +
                        Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS +
                        Sizes.SEQ + Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2

                else -> throw IllegalArgumentException("Not a MAVLink frame")
            }

            val payloadSize = this[1].toUByte().toInt()

            val frameSizeTillPayload = frameSizeTillMsgId + payloadSize

            return with(CrcX25()) {
                accumulate(this@generateChecksum, 1, frameSizeTillPayload)
                accumulate(crcExtra)
                get()
            }
        }

        private fun ByteArray.generateSignature(
            linkId: UByte,
            timestamp: UInt,
            secretKey: ByteArray
        ): ByteArray {
            val versionMarker = this[0].toUByte()
            if (versionMarker == Stx.V1) {
                return ByteArray(0)
            }

            val incompatFlags = this[2].toUByte()
            if (incompatFlags != Flags.INCOMPAT_SIGNED) {
                return ByteArray(0)
            }

            val payloadLength = this[1].toUByte().toInt()

            val frameSizeTillCrc = Sizes.STX + Sizes.LEN +
                    Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS +
                    Sizes.SEQ + Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2 +
                    payloadLength + Sizes.CHECKSUM

            val buffer = Buffer().apply {
                this.write(secretKey)
                this.write(this@generateSignature, offset = 0, byteCount = frameSizeTillCrc)
                this.encodeUInt8(linkId)
                this.encodeIntegerValue(timestamp.toLong(), Sizes.SIGNATURE_TIMESTAMP)
            }

            return buffer.readByteString().sha256().substring(0, Sizes.SIGNATURE).toByteArray()
        }

        @Throws(Exception::class)
        fun fromV1Bytes(rawBytes: ByteArray): MavRawFrame = with(Buffer().write(rawBytes)) {
            val stx = this.decodeUInt8()
            val len = this.decodeUInt8()
            val seq = this.decodeUInt8()
            val systemId = this.decodeUInt8()
            val componentId = this.decodeUInt8()
            val messageId = this.decodeUInt8().toUInt()
            val payload = ByteArray(len.toInt()).also { this.read(it) }
            val checksum = this.decodeUInt16()

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
                signatureLinkId = 0u,
                signatureTimestamp = 0u,
                signature = ByteArray(0),
                rawBytes = rawBytes
            )
        }

        @Throws(Exception::class)
        fun fromV2Bytes(rawBytes: ByteArray): MavRawFrame = with(Buffer().write(rawBytes)) {
            val stx = this.decodeUInt8()
            val len = this.decodeUInt8()
            val incompatFlags = this.decodeUInt8()
            val compatFlags = this.decodeUInt8()
            val seq = this.decodeUInt8()
            val systemId = this.decodeUInt8()
            val componentId = this.decodeUInt8()
            val messageId = this.decodeUnsignedIntegerValue(Sizes.MSG_ID_V2).toUInt()
            val payload = ByteArray(len.toInt()).also { this.read(it) }
            val checksum = this.decodeUInt16()
            val signatureLinkId = this.decodeUInt8()
            val signatureTimestamp = this.decodeUnsignedIntegerValue(Sizes.SIGNATURE_TIMESTAMP).toUInt()
            val signature = if (incompatFlags == Flags.INCOMPAT_SIGNED) {
                if (size < Sizes.SIGNATURE) {
                    ByteArray(0)
                } else {
                    ByteArray(Sizes.SIGNATURE).also { this.read(it) }
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
                signatureLinkId = signatureLinkId,
                signatureTimestamp = signatureTimestamp,
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
            val buffer = Buffer().apply {
                this.encodeUInt8(Stx.V1)
                this.encodeUInt8(payload.size.toUByte())
                this.encodeUInt8(seq)
                this.encodeUInt8(systemId)
                this.encodeUInt8(componentId)
                this.encodeUInt8(messageId.toUByte())
                this.write(payload)
            }

            val checksum = buffer.copy().readByteArray().generateChecksum(crcExtra)
            buffer.encodeUInt16(checksum)

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
                signatureLinkId = 0u,
                signatureTimestamp = 0u,
                signature = ByteArray(0),
                rawBytes = buffer.readByteArray()
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
            val buffer = Buffer().apply {
                this.encodeUInt8(Stx.V2)
                this.encodeUInt8(payload.size.toUByte())
                this.encodeUInt8(Flags.INCOMPAT_UNSIGNED)
                this.encodeUInt8(0u)
                this.encodeUInt8(seq)
                this.encodeUInt8(systemId)
                this.encodeUInt8(componentId)
                this.encodeIntegerValue(messageId.toLong(), Sizes.MSG_ID_V2)
                this.write(payload)
            }

            val checksum = buffer.copy().readByteArray().generateChecksum(crcExtra)
            buffer.encodeUInt16(checksum)

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
                signatureLinkId = 0u,
                signatureTimestamp = 0u,
                signature = ByteArray(0),
                rawBytes = buffer.readByteArray()
            )
        }

        fun createSignedV2(
            seq: UByte,
            systemId: UByte,
            componentId: UByte,
            messageId: UInt,
            payload: ByteArray,
            crcExtra: Byte,
            signatureLinkId: UByte,
            signatureTimestamp: UInt,
            secretKey: ByteArray
        ): MavRawFrame {
            val buffer = Buffer().apply {
                this.encodeUInt8(Stx.V2)
                this.encodeUInt8(payload.size.toUByte())
                this.encodeUInt8(Flags.INCOMPAT_SIGNED)
                this.encodeUInt8(0u)
                this.encodeUInt8(seq)
                this.encodeUInt8(systemId)
                this.encodeUInt8(componentId)
                this.encodeIntegerValue(messageId.toLong(), Sizes.MSG_ID_V2)
                this.write(payload)
            }

            val checksum = buffer.copy().readByteArray().generateChecksum(crcExtra)
            buffer.encodeUInt16(checksum)

            val signature = buffer.copy().readByteArray().generateSignature(signatureLinkId, signatureTimestamp, secretKey)
            buffer.encodeUInt8(signatureLinkId)
            buffer.encodeIntegerValue(signatureTimestamp.toLong(), Sizes.SIGNATURE_TIMESTAMP)
            buffer.write(signature)

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
                signatureLinkId = signatureLinkId,
                signatureTimestamp = signatureTimestamp,
                signature = signature,
                rawBytes = buffer.readByteArray()
            )
        }
    }
}

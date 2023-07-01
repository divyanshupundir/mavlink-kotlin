package com.divpundir.mavlink.connection

import com.divpundir.mavlink.serialization.*
import okio.ByteString.Companion.toByteString

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

        const val SECRET_KEY = 32
    }

    companion object {

        @Throws(Exception::class)
        private fun ByteArray.generateChecksum(crcExtra: Byte): UShort {
            val frameSizeTillMsgId = when (this[0].toUByte()) {
                Stx.V1 -> Sizes.STX + Sizes.LEN +
                        Sizes.SEQ +
                        Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V1

                Stx.V2 -> Sizes.STX + Sizes.LEN +
                        Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS +
                        Sizes.SEQ +
                        Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2

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
                    Sizes.SEQ +
                    Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2 +
                    payloadLength + Sizes.CHECKSUM

            val signEncoder = MavDataEncoder.allocate(
                Sizes.SECRET_KEY +
                        frameSizeTillCrc +
                        Sizes.SIGNATURE_LINK_ID + Sizes.SIGNATURE_TIMESTAMP
            )

            signEncoder.encodeByteArray(secretKey.copyOf(Sizes.SECRET_KEY))
            signEncoder.encodeByteArray(this, offset = 0, length = frameSizeTillCrc)
            signEncoder.encodeUInt8(linkId)
            signEncoder.encodeIntegerValue(timestamp.toLong(), Sizes.SIGNATURE_TIMESTAMP)

            return signEncoder
                .bytes
                .toByteString()
                .sha256()
                .substring(0, Sizes.SIGNATURE)
                .toByteArray()
        }

        @Throws(Exception::class)
        fun fromV1Bytes(rawBytes: ByteArray): MavRawFrame = with(MavDataDecoder.wrap(rawBytes)) {
            val stx = this.safeDecodeUInt8()
            val len = this.safeDecodeUInt8()
            val seq = this.safeDecodeUInt8()
            val systemId = this.safeDecodeUInt8()
            val componentId = this.safeDecodeUInt8()
            val messageId = this.safeDecodeUInt8().toUInt()
            val payload = ByteArray(len.toInt()).also { this.decodeByteArray(it) }
            val checksum = this.safeDecodeUInt16()

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
        fun fromV2Bytes(rawBytes: ByteArray): MavRawFrame = with(MavDataDecoder.wrap(rawBytes)) {
            val stx = this.safeDecodeUInt8()
            val len = this.safeDecodeUInt8()
            val incompatFlags = this.safeDecodeUInt8()
            val compatFlags = this.safeDecodeUInt8()
            val seq = this.safeDecodeUInt8()
            val systemId = this.safeDecodeUInt8()
            val componentId = this.safeDecodeUInt8()
            val messageId = this.safeDecodeUnsignedInteger(Sizes.MSG_ID_V2).toUInt()
            val payload = ByteArray(len.toInt()).also { this.decodeByteArray(it) }
            val checksum = this.safeDecodeUInt16()
            val signatureLinkId = this.safeDecodeUInt8()
            val signatureTimestamp = this.safeDecodeUnsignedInteger(Sizes.SIGNATURE_TIMESTAMP).toUInt()
            val signature = if (incompatFlags == Flags.INCOMPAT_SIGNED) {
                if (remaining < Sizes.SIGNATURE) {
                    ByteArray(0)
                } else {
                    ByteArray(Sizes.SIGNATURE).also { this.decodeByteArray(it) }
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
            val frameLength = Sizes.STX + Sizes.LEN +
                    Sizes.SEQ +
                    Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V1 +
                    payload.size + Sizes.CHECKSUM

            val encoder = MavDataEncoder.allocate(frameLength)
            encoder.encodeUInt8(Stx.V1)
            encoder.encodeUInt8(payload.size.toUByte())
            encoder.encodeUInt8(seq)
            encoder.encodeUInt8(systemId)
            encoder.encodeUInt8(componentId)
            encoder.encodeUInt8(messageId.toUByte())
            encoder.encodeByteArray(payload)

            val checksum = encoder.bytes.generateChecksum(crcExtra)
            encoder.encodeUInt16(checksum)

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
                rawBytes = encoder.bytes
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
            val frameLength = Sizes.STX + Sizes.LEN +
                    Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS +
                    Sizes.SEQ +
                    Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2 +
                    payload.size + Sizes.CHECKSUM

            val encoder = MavDataEncoder.allocate(frameLength)
            encoder.encodeUInt8(Stx.V2)
            encoder.encodeUInt8(payload.size.toUByte())
            encoder.encodeUInt8(Flags.INCOMPAT_UNSIGNED)
            encoder.encodeUInt8(0u)
            encoder.encodeUInt8(seq)
            encoder.encodeUInt8(systemId)
            encoder.encodeUInt8(componentId)
            encoder.encodeIntegerValue(messageId.toLong(), Sizes.MSG_ID_V2)
            encoder.encodeByteArray(payload)

            val checksum = encoder.bytes.generateChecksum(crcExtra)
            encoder.encodeUInt16(checksum)

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
                rawBytes = encoder.bytes
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
            val frameLength = Sizes.STX + Sizes.LEN +
                    Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS +
                    Sizes.SEQ +
                    Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2 +
                    payload.size + Sizes.CHECKSUM +
                    Sizes.SIGNATURE_LINK_ID + Sizes.SIGNATURE_TIMESTAMP + Sizes.SIGNATURE

            val buffer = MavDataEncoder.allocate(frameLength)
            buffer.encodeUInt8(Stx.V2)
            buffer.encodeUInt8(payload.size.toUByte())
            buffer.encodeUInt8(Flags.INCOMPAT_SIGNED)
            buffer.encodeUInt8(0u)
            buffer.encodeUInt8(seq)
            buffer.encodeUInt8(systemId)
            buffer.encodeUInt8(componentId)
            buffer.encodeIntegerValue(messageId.toLong(), Sizes.MSG_ID_V2)
            buffer.encodeByteArray(payload)

            val checksum = buffer.bytes.generateChecksum(crcExtra)
            buffer.encodeUInt16(checksum)

            val signature = buffer.bytes.generateSignature(signatureLinkId, signatureTimestamp, secretKey)
            buffer.encodeUInt8(signatureLinkId)
            buffer.encodeIntegerValue(signatureTimestamp.toLong(), Sizes.SIGNATURE_TIMESTAMP)
            buffer.encodeByteArray(signature)

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
                rawBytes = buffer.bytes
            )
        }
    }
}

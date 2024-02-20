package com.divpundir.mavlink.connection

import com.divpundir.mavlink.connection.MavRawFrame.Companion.generateSignature
import com.divpundir.mavlink.serialization.*
import okio.ByteString.Companion.toByteString

/**
 * Represents a mid-level MAVLink Frame, i.e., a frame that is in between a fully deserialized high-level object, and a
 * wire-format ByteArray.
 *
 * Note: Several functions of this class are not fault-tolerant. They assume that the input raw bytes are valid
 * ByteArrays. For example, [generateSignature] assumes that its input `frameBytes` is a correct MAVLink v2 frame in the
 * form of raw bytes. Therefore, the users of this class should be careful while using it.
 *
 * Refer: [MAVLink Serialization](https://mavlink.io/en/guide/serialization.html)
 */
public data class MavRawFrame(
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
    /**
     * Returns true if the frame is a signed MAVLink v2 frame, false otherwise.
     */
    public val isSigned: Boolean
        get() = incompatFlags == Flags.INCOMPAT_SIGNED

    /**
     * Validates the frame's [checksum] using the MAVLink message [crcExtra] and the frame's [rawBytes].
     */
    public fun validateCrc(crcExtra: Byte): Boolean =
        generateChecksum(rawBytes, crcExtra) == checksum

    /**
     * Validates the frame's [signature] using the given [secretKey]. If the [secretKey]'s size is less than 32 then it
     * is padded with zeroes. If the size is more than 32, then only the first 32 bytes are taken.
     */
    public fun validateSignature(secretKey: ByteArray): Boolean =
        isSigned && signature.contentEquals(
            generateSignature(
                rawBytes,
                signatureLinkId,
                signatureTimestamp,
                secretKey
            )
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

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
        if (!rawBytes.contentEquals(other.rawBytes)) return false

        return true
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

    public object Stx {
        public const val V1: UByte = 0xFEu
        public const val V2: UByte = 0xFDu
    }

    public object Flags {
        public const val INCOMPAT_UNSIGNED: UByte = 0x00u
        public const val INCOMPAT_SIGNED: UByte = 0x01u
    }

    public object Sizes {
        public const val STX: Int = 1
        public const val LEN: Int = 1

        public const val INCOMPAT_FLAGS: Int = 1
        public const val COMPAT_FLAGS: Int = 1

        public const val SEQ: Int = 1
        public const val SYS_ID: Int = 1
        public const val COMP_ID: Int = 1

        public const val MSG_ID_V1: Int = 1
        public const val MSG_ID_V2: Int = 3

        public const val CHECKSUM: Int = 2

        public const val SIGNATURE_LINK_ID: Int = 1
        public const val SIGNATURE_TIMESTAMP: Int = 6
        public const val SIGNATURE: Int = 6

        public const val SECRET_KEY: Int = 32
    }

    public companion object {

        /**
         * Generates the MAVLink checksum using the [frameBytes] and the [crcExtra] of the MAVLink message.
         *
         * Refer: [MAVLink Checksum and CRC Extra Calculation](https://mavlink.io/en/guide/serialization.html#checksum)
         */
        public fun generateChecksum(frameBytes: ByteArray, crcExtra: Byte): UShort {
            val frameSizeTillMsgId = when (frameBytes[0].toUByte()) {
                Stx.V1 -> Sizes.STX + Sizes.LEN +
                    Sizes.SEQ +
                    Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V1

                Stx.V2 -> Sizes.STX + Sizes.LEN +
                    Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS +
                    Sizes.SEQ +
                    Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2

                else -> throw IllegalArgumentException("Not a MAVLink frame")
            }

            val payloadSize = frameBytes[1].toUByte().toInt()

            val frameSizeTillPayload = frameSizeTillMsgId + payloadSize

            return with(CrcX25()) {
                accumulate(frameBytes, 1, frameSizeTillPayload)
                accumulate(crcExtra)
                get()
            }
        }

        /**
         * Generates the 6-byte MAVLink signature using the [frameBytes]. If the [secretKey]'s size is less than 32 then it
         * is padded with zeroes. If the size is more than 32, then only the first 32 bytes are taken.
         *
         * Refer: [MAVLink Message Signing](https://mavlink.io/en/guide/message_signing.html)
         */
        public fun generateSignature(
            frameBytes: ByteArray,
            linkId: UByte,
            timestamp: UInt,
            secretKey: ByteArray
        ): ByteArray {
            val versionMarker = frameBytes[0].toUByte()
            if (versionMarker == Stx.V1) {
                return ByteArray(0)
            }

            val incompatFlags = frameBytes[2].toUByte()
            if (incompatFlags != Flags.INCOMPAT_SIGNED) {
                return ByteArray(0)
            }

            val payloadLength = frameBytes[1].toUByte().toInt()

            val frameSizeTillCrc = Sizes.STX + Sizes.LEN +
                Sizes.INCOMPAT_FLAGS + Sizes.COMPAT_FLAGS +
                Sizes.SEQ +
                Sizes.SYS_ID + Sizes.COMP_ID + Sizes.MSG_ID_V2 +
                payloadLength + Sizes.CHECKSUM

            val signEncoder = MavDataEncoder(
                Sizes.SECRET_KEY +
                    frameSizeTillCrc +
                    Sizes.SIGNATURE_LINK_ID + Sizes.SIGNATURE_TIMESTAMP
            )

            signEncoder.encodeByteArray(secretKey.copyOf(Sizes.SECRET_KEY))
            signEncoder.encodeByteArray(frameBytes, offset = 0, length = frameSizeTillCrc)
            signEncoder.encodeUInt8(linkId)
            signEncoder.encodeInteger(timestamp.toLong(), Sizes.SIGNATURE_TIMESTAMP)

            return signEncoder
                .bytes
                .toByteString()
                .sha256()
                .substring(0, Sizes.SIGNATURE)
                .toByteArray()
        }

        /**
         * Creates a MAVLink v1 [MavRawFrame] from the [rawBytes].
         */
        public fun fromV1Bytes(rawBytes: ByteArray): MavRawFrame = with(MavDataDecoder(rawBytes)) {
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

        /**
         * Creates a MAVLink v2 [MavRawFrame] from the [rawBytes].
         */
        public fun fromV2Bytes(rawBytes: ByteArray): MavRawFrame = with(MavDataDecoder(rawBytes)) {
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

        /**
         * Creates a MAVLink v1 [MavRawFrame].
         */
        public fun createV1(
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

            val encoder = MavDataEncoder(frameLength)
            encoder.encodeUInt8(Stx.V1)
            encoder.encodeUInt8(payload.size.toUByte())
            encoder.encodeUInt8(seq)
            encoder.encodeUInt8(systemId)
            encoder.encodeUInt8(componentId)
            encoder.encodeUInt8(messageId.toUByte())
            encoder.encodeByteArray(payload)

            val checksum = generateChecksum(encoder.bytes, crcExtra)
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

        /**
         * Creates an unsigned MAVLink v2 [MavRawFrame].
         */
        public fun createUnsignedV2(
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

            val encoder = MavDataEncoder(frameLength)
            encoder.encodeUInt8(Stx.V2)
            encoder.encodeUInt8(payload.size.toUByte())
            encoder.encodeUInt8(Flags.INCOMPAT_UNSIGNED)
            encoder.encodeUInt8(0u)
            encoder.encodeUInt8(seq)
            encoder.encodeUInt8(systemId)
            encoder.encodeUInt8(componentId)
            encoder.encodeInteger(messageId.toLong(), Sizes.MSG_ID_V2)
            encoder.encodeByteArray(payload)

            val checksum = generateChecksum(encoder.bytes, crcExtra)
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

        /**
         * Creates a signed MAVLink v2 [MavRawFrame].
         */
        public fun createSignedV2(
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

            val encoder = MavDataEncoder(frameLength)
            encoder.encodeUInt8(Stx.V2)
            encoder.encodeUInt8(payload.size.toUByte())
            encoder.encodeUInt8(Flags.INCOMPAT_SIGNED)
            encoder.encodeUInt8(0u)
            encoder.encodeUInt8(seq)
            encoder.encodeUInt8(systemId)
            encoder.encodeUInt8(componentId)
            encoder.encodeInteger(messageId.toLong(), Sizes.MSG_ID_V2)
            encoder.encodeByteArray(payload)

            val checksum = generateChecksum(encoder.bytes, crcExtra)
            encoder.encodeUInt16(checksum)

            val signature = generateSignature(encoder.bytes, signatureLinkId, signatureTimestamp, secretKey)
            encoder.encodeUInt8(signatureLinkId)
            encoder.encodeInteger(signatureTimestamp.toLong(), Sizes.SIGNATURE_TIMESTAMP)
            encoder.encodeByteArray(signature)

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
                rawBytes = encoder.bytes
            )
        }
    }
}

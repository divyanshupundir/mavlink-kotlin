package com.urbanmatrix.mavlink.raw

data class MavlinkRawFrame(
    val frameType: MavlinkFrameType,
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
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MavlinkRawFrame

        if (frameType != other.frameType) return false
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
        var result = frameType.hashCode()
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
}

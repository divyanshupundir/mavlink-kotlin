package com.divpundir.mavlink.serialization

public class LittleEndianDataEncoder private constructor(
    private val size: Int
) : DataEncoder {

    private var position = 0

    override val bytes: ByteArray = ByteArray(size)

    override val remaining: Int
        get() = size - position

    override fun encodeByte(value: Byte) {
        bytes[position++] = value
    }

    override fun encodeShort(value: Short) {
        bytes[position++] = value.toByte()
        bytes[position++] = (value.toInt() shr 8).toByte()
    }

    override fun encodeInt(value: Int) {
        bytes[position++] = value.toByte()
        bytes[position++] = (value shr 8).toByte()
        bytes[position++] = (value shr 16).toByte()
        bytes[position++] = (value shr 24).toByte()
    }

    override fun encodeLong(value: Long) {
        bytes[position++] = value.toByte()
        bytes[position++] = (value shr 8).toByte()
        bytes[position++] = (value shr 16).toByte()
        bytes[position++] = (value shr 24).toByte()
        bytes[position++] = (value shr 32).toByte()
        bytes[position++] = (value shr 40).toByte()
        bytes[position++] = (value shr 48).toByte()
        bytes[position++] = (value shr 56).toByte()
    }

    override fun encodeByteArray(value: ByteArray) {
        value.copyInto(bytes, destinationOffset = position)
        position += value.size
    }

    public companion object : DataEncoder.Factory {

        public override fun allocate(size: Int): DataEncoder = LittleEndianDataEncoder(size)
    }
}

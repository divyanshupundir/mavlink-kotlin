package com.divpundir.mavlink.serialization

private class NonJvmMavDataEncoder(size: Int) : MavDataEncoder {

    override val bytes: ByteArray = ByteArray(size)

    private var position = 0

    override val remaining: Int
        get() = bytes.size - position

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

    override fun encodeByteArray(src: ByteArray, offset: Int, length: Int) {
        for (i in offset until offset + length) {
            bytes[position++] = src[i]
        }
    }
}

public actual fun MavDataEncoder(size: Int): MavDataEncoder = NonJvmMavDataEncoder(size)

package com.divpundir.mavlink.serialization

public actual fun MavDataEncoder(size: Int): MavDataEncoder = NonJvmMavDataEncoder(size)

@OptIn(ExperimentalUnsignedTypes::class)
private class NonJvmMavDataEncoder(size: Int) : MavDataEncoder {

    private val _bytes = UByteArray(size)
    override val bytes: ByteArray = _bytes.asByteArray()

    private var position = 0

    override val remaining: Int
        get() = bytes.size - position

    override fun encodeByte(value: Byte) {
        _bytes[position++] = value.toUByte()
    }

    override fun encodeShort(value: Short) {
        _bytes[position++] = value.toUByte()
        _bytes[position++] = (value.toInt() shr 8).toUByte()
    }

    override fun encodeInt(value: Int) {
        _bytes[position++] = value.toUByte()
        _bytes[position++] = (value shr 8).toUByte()
        _bytes[position++] = (value shr 16).toUByte()
        _bytes[position++] = (value shr 24).toUByte()
    }

    override fun encodeLong(value: Long) {
        _bytes[position++] = value.toUByte()
        _bytes[position++] = (value shr 8).toUByte()
        _bytes[position++] = (value shr 16).toUByte()
        _bytes[position++] = (value shr 24).toUByte()
        _bytes[position++] = (value shr 32).toUByte()
        _bytes[position++] = (value shr 40).toUByte()
        _bytes[position++] = (value shr 48).toUByte()
        _bytes[position++] = (value shr 56).toUByte()
    }

    override fun encodeByteArray(src: ByteArray, offset: Int, length: Int) {
        for (i in offset until offset + length) {
            _bytes[position++] = src[i].toUByte()
        }
    }
}

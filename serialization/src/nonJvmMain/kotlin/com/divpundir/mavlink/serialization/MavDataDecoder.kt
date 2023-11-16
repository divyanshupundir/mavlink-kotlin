package com.divpundir.mavlink.serialization

public actual fun MavDataDecoder(bytes: ByteArray): MavDataDecoder = NonJvmMavDataDecoder(bytes)

@OptIn(ExperimentalUnsignedTypes::class)
private class NonJvmMavDataDecoder(bytes: ByteArray) : MavDataDecoder {

    private val bytes = bytes.toUByteArray()

    private var position = 0

    override val remaining: Int
        get() = bytes.size - position

    override fun decodeByte(): Byte {
        return bytes[position++].toByte()
    }

    override fun decodeShort(): Short {
        val byte1 = bytes[position++]
        val byte2 = bytes[position++]

        return ((byte2.toInt() shl 8) or (byte1.toInt() and 0xFF)).toShort()
    }

    override fun decodeInt(): Int {
        val byte1 = bytes[position++]
        val byte2 = bytes[position++]
        val byte3 = bytes[position++]
        val byte4 = bytes[position++]

        return (byte4.toInt() shl 24) or (byte3.toInt() shl 16) or
            (byte2.toInt() shl 8) or (byte1.toInt() and 0xFF)
    }

    override fun decodeLong(): Long {
        val byte1 = bytes[position++]
        val byte2 = bytes[position++]
        val byte3 = bytes[position++]
        val byte4 = bytes[position++]
        val byte5 = bytes[position++]
        val byte6 = bytes[position++]
        val byte7 = bytes[position++]
        val byte8 = bytes[position++]

        return (byte8.toLong() shl 56) or (byte7.toLong() shl 48) or
            (byte6.toLong() shl 40) or (byte5.toLong() shl 32) or
            (byte4.toLong() shl 24) or (byte3.toLong() shl 16) or
            (byte2.toLong() shl 8) or (byte1.toLong() and 0xFF)
    }

    override fun decodeByteArray(dst: ByteArray, offset: Int, length: Int) {
        for (i in offset until offset + length) {
            dst[i] = bytes[position++].toByte()
        }
    }
}

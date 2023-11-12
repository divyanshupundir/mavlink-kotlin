package com.divpundir.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.ByteOrder

private class JvmMavDataEncoder(
    size: Int
) : MavDataEncoder {

    private val buffer = ByteBuffer.allocate(size).order(ByteOrder.LITTLE_ENDIAN)

    override val bytes: ByteArray
        get() = buffer.array()

    override val remaining: Int
        get() = buffer.remaining()

    override fun encodeByte(value: Byte) {
        buffer.put(value)
    }

    override fun encodeShort(value: Short) {
        buffer.putShort(value)
    }

    override fun encodeInt(value: Int) {
        buffer.putInt(value)
    }

    override fun encodeLong(value: Long) {
        buffer.putLong(value)
    }

    override fun encodeByteArray(src: ByteArray, offset: Int, length: Int) {
        buffer.put(src, offset, length)
    }
}

public actual fun MavDataEncoder(size: Int): MavDataEncoder = JvmMavDataEncoder(size)

package com.divpundir.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.ByteOrder

private class JvmMavDataDecoder(
    bytes: ByteArray
) : MavDataDecoder {

    private val buffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)

    override val remaining: Int
        get() = buffer.remaining()

    override fun decodeByte(): Byte = buffer.get()

    override fun decodeShort(): Short = buffer.getShort()

    override fun decodeInt(): Int = buffer.getInt()

    override fun decodeLong(): Long = buffer.getLong()

    override fun decodeByteArray(dst: ByteArray, offset: Int, length: Int) {
        buffer.get(dst, offset, length)
    }
}

public actual fun MavDataDecoder(bytes: ByteArray): MavDataDecoder = JvmMavDataDecoder(bytes)

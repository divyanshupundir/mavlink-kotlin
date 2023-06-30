package com.divpundir.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.ByteOrder

public class LittleEndianDataDecoder private constructor(
    bytes: ByteArray
) : DataDecoder {

    private val buffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)

    override val remaining: Int
        get() = buffer.remaining()

    override fun decodeByte(): Byte = buffer.get()

    override fun decodeShort(): Short = buffer.getShort()

    override fun decodeInt(): Int = buffer.getInt()

    override fun decodeLong(): Long = buffer.getLong()

    override fun decodeByteArray(dst: ByteArray) {
        buffer.get(dst)
    }

    public companion object : DataDecoder.Factory {

        override fun wrap(bytes: ByteArray): DataDecoder = LittleEndianDataDecoder(bytes)
    }
}

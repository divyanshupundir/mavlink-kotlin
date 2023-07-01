package com.divpundir.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * A [DataEncoder] implementation that writes the primitives according to the Little-Endian byte order.
 */
public class LittleEndianDataEncoder private constructor(
    size: Int
) : DataEncoder {

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

    override fun factory(): DataEncoder.Factory = Companion

    public companion object : DataEncoder.Factory {

        public override fun allocate(size: Int): DataEncoder = LittleEndianDataEncoder(size)
    }
}

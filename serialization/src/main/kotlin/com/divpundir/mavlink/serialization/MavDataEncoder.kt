package com.divpundir.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Writes primitives to a [ByteArray] according to the little-endian byte order.
 */
public class MavDataEncoder private constructor(
    size: Int
) {

    private val buffer = ByteBuffer.allocate(size).order(ByteOrder.LITTLE_ENDIAN)

    /**
     * The [ByteArray] into which the data is written.
     */
    public val bytes: ByteArray
        get() = buffer.array()

    /**
     * The number of bytes remaining to be written.
     */
    public val remaining: Int
        get() = buffer.remaining()

    /**
     * Writes the given [Byte] into the array's current position, and then increments the position.
     */
    public fun encodeByte(value: Byte) {
        buffer.put(value)
    }

    /**
     * Writes the given [Short] into the array's current position, and then increments the position.
     */
    public fun encodeShort(value: Short) {
        buffer.putShort(value)
    }

    /**
     * Writes the given [Int] into the array's current position, and then increments the position.
     */
    public fun encodeInt(value: Int) {
        buffer.putInt(value)
    }

    /**
     * Writes the given [Long] into the array's current position, and then increments the position.
     */
    public fun encodeLong(value: Long) {
        buffer.putLong(value)
    }

    /**
     * Writes [length] number of bytes from [src] into the array with the given [offset], and then increments the
     * position.
     */
    public fun encodeByteArray(src: ByteArray, offset: Int = 0, length: Int = src.size) {
        buffer.put(src, offset, length)
    }

    public companion object {

        /**
         * Creates a new [MavDataEncoder] instance that uses an array of the given [size] for the writing of data.
         */
        public fun allocate(size: Int): MavDataEncoder = MavDataEncoder(size)
    }
}

package com.divpundir.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Reads primitives from a [ByteArray] according to the little-endian byte order.
 */
public class MavDataDecoder private constructor(
    bytes: ByteArray
) {

    private val buffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)

    /**
     * The number of bytes remaining in the array.
     */
    public val remaining: Int
        get() = buffer.remaining()

    /**
     * Reads a [Byte] from the array's current position, and then increments the position.
     */
    public fun decodeByte(): Byte = buffer.get()

    /**
     * Reads a [Short] from the array's current position, and then increments the position.
     */
    public fun decodeShort(): Short = buffer.getShort()

    /**
     * Reads a [Int] from the array's current position, and then increments the position.
     */
    public fun decodeInt(): Int = buffer.getInt()

    /**
     * Reads a [Long] from the array's current position, and then increments the position.
     */
    public fun decodeLong(): Long = buffer.getLong()

    /**
     * Reads [length] number of bytes from the array's current position into [dst] with the given [offset], and then
     * increments the position.
     */
    public fun decodeByteArray(dst: ByteArray, offset: Int = 0, length: Int = dst.size) {
        buffer.get(dst, offset, length)
    }

    public companion object {

        /**
         * Creates a new [MavDataDecoder] instance that uses the given [bytes] for the reading of data.
         */
        public fun wrap(bytes: ByteArray): MavDataDecoder = MavDataDecoder(bytes)
    }
}

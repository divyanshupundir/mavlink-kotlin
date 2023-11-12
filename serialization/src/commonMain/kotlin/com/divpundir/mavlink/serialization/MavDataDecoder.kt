package com.divpundir.mavlink.serialization

/**
 * Reads primitives from a [ByteArray] according to the little-endian byte order.
 */
public interface MavDataDecoder {

    /**
     * The number of bytes remaining in the array.
     */
    public val remaining: Int

    /**
     * Reads a [Byte] from the array's current position, and then increments the position.
     */
    public fun decodeByte(): Byte

    /**
     * Reads a [Short] from the array's current position, and then increments the position.
     */
    public fun decodeShort(): Short

    /**
     * Reads a [Int] from the array's current position, and then increments the position.
     */
    public fun decodeInt(): Int

    /**
     * Reads a [Long] from the array's current position, and then increments the position.
     */
    public fun decodeLong(): Long

    /**
     * Reads [length] number of bytes from the array's current position into [dst] with the given [offset], and then
     * increments the position.
     */
    public fun decodeByteArray(dst: ByteArray, offset: Int = 0, length: Int = dst.size)

    public companion object
}

/**
 * Creates a new [MavDataDecoder] instance that uses the given [bytes] for the reading of data.
 */
public expect fun MavDataDecoder(bytes: ByteArray): MavDataDecoder

package com.divpundir.mavlink.serialization

/**
 * Writes primitives into a [ByteArray].
 */
public interface DataEncoder {

    /**
     * The [ByteArray] into which the data is written.
     */
    public val bytes: ByteArray

    /**
     * The number of bytes remaining to be written.
     */
    public val remaining: Int

    /**
     * Writes the given [Byte] into the array's current position, and then increments the position.
     */
    public fun encodeByte(value: Byte)

    /**
     * Writes the given [Short] into the array's current position, and then increments the position.
     */
    public fun encodeShort(value: Short)

    /**
     * Writes the given [Int] into the array's current position, and then increments the position.
     */
    public fun encodeInt(value: Int)

    /**
     * Writes the given [Long] into the array's current position, and then increments the position.
     */
    public fun encodeLong(value: Long)

    /**
     * Writes [length] number of bytes from [src] into the array with the given [offset], and then increments the
     * position.
     */
    public fun encodeByteArray(src: ByteArray, offset: Int = 0, length: Int = src.size)

    /**
     * Return thee [Factory] used to create this [DataEncoder] instance.
     */
    public fun factory(): Factory

    /**
     * The [DataEncoder] factory.
     */
    public interface Factory {

        /**
         * Creates a new [DataEncoder] instance that uses an array of the given [size] for the writing of data.
         */
        public fun allocate(size: Int): DataEncoder
    }
}

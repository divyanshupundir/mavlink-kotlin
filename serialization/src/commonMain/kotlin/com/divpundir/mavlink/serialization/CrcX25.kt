package com.divpundir.mavlink.serialization

/**
 * X25 hash calculator used for computing the MAVLink frame checksums.
 */
public class CrcX25 {

    private var crc: Int = 0xFFFF

    /**
     * Adds the given string to the hash. The string is encoded as UTF-8.
     */
    public fun accumulate(str: String) {
        accumulate(str.encodeToByteArray())
    }

    /**
     * Adds the given [ByteArray] from the [start] to the [end] indices to the hash.
     */
    public fun accumulate(bytes: ByteArray, start: Int = 0, end: Int = bytes.size) {
        for (i in start until end) {
            accumulate(bytes[i])
        }
    }

    /**
     * Adds the given [Byte] to the hash.
     */
    public fun accumulate(b: Byte) {
        var bb = b.toInt()
        bb = bb xor (crc and 0xFF)
        bb = bb xor (bb shl 4)
        bb = bb and 0xFF
        crc = (crc shr 8) xor (bb shl 8) xor (bb shl 3) xor (bb shr 4)
    }

    /**
     * Returns the current hash value.
     */
    public fun get(): UShort {
        return crc.toUShort()
    }
}

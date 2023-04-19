package com.divpundir.mavlink.serialization

import java.nio.charset.StandardCharsets

public class CrcX25 {

    private var crc: Int = 0xFFFF

    public fun accumulate(str: String) {
        accumulate(str.toByteArray(StandardCharsets.UTF_8))
    }

    public fun accumulate(bytes: ByteArray, offset: Int = 0, length: Int = bytes.size) {
        for (i in offset until length) {
            accumulate(bytes[i])
        }
    }

    public fun accumulate(b: Byte) {
        var bb = b.toInt()
        bb = bb xor (crc and 0xFF)
        bb = bb xor (bb shl 4)
        bb = bb and 0xFF
        crc = (crc shr 8) xor (bb shl 8) xor (bb shl 3) xor (bb shr 4)
    }

    public fun get(): UShort {
        return crc.toUShort()
    }
}

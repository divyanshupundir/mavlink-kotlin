package xyz.urbanmatrix.mavlink.generator

import java.nio.charset.StandardCharsets

internal class CrcX25 {

    private var crc: Int = 0xFFFF

    fun accumulate(str: String) {
        accumulate(str.toByteArray(StandardCharsets.UTF_8))
    }

    fun accumulate(bytes: ByteArray, offset: Int = 0, length: Int = bytes.size) {
        for (i in offset until length) {
            accumulate(bytes[i].toInt())
        }
    }

    fun accumulate(b: Int) {
        var bb = b
        bb = bb xor (crc and 0xFF)
        bb = bb xor ((bb shl 4) and 0xFF)
        crc = (crc shr 8) xor (bb shl 8) xor (bb shl 3) xor (bb shr 4)
    }

    fun get(): Int {
        return crc xor (crc shr 8)
    }
}

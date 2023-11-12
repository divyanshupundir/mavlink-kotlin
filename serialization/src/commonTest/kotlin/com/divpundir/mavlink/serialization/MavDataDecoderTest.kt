package com.divpundir.mavlink.serialization

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MavDataDecoderTest {

    @Test
    fun getRemaining() {
        val bytes = byteArrayOf(
            0x01,
            0x02, 0x03,
            0x04, 0x05, 0x06, 0x07,
            0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F
        )
        val decoder = MavDataDecoder(bytes)

        assertEquals(15, decoder.remaining)
        decoder.decodeByte()
        assertEquals(14, decoder.remaining)
        decoder.decodeShort()
        assertEquals(12, decoder.remaining)
        decoder.decodeInt()
        assertEquals(8, decoder.remaining)
        decoder.decodeLong()
        assertEquals(0, decoder.remaining)
    }

    @Test
    fun decodeByte() {
        val bytes = byteArrayOf(
            0x01,
            0x02
        )
        val decoder = MavDataDecoder(bytes)

        assertEquals(0x01, decoder.decodeByte())
        assertEquals(0x02, decoder.decodeByte())
    }

    @Test
    fun decodeShort() {
        val bytes = byteArrayOf(
            0x01, 0x02,
            0x03, 0x04
        )
        val decoder = MavDataDecoder(bytes)

        assertEquals(0x0201, decoder.decodeShort())
        assertEquals(0x0403, decoder.decodeShort())
    }

    @Test
    fun decodeInt() {
        val bytes = byteArrayOf(
            0x01, 0x02, 0x03, 0x04,
            0x05, 0x06, 0x07, 0x08
        )
        val decoder = MavDataDecoder(bytes)

        assertEquals(0x04030201, decoder.decodeInt())
        assertEquals(0x08070605, decoder.decodeInt())
    }

    @Test
    fun decodeLong() {
        val bytes = byteArrayOf(
            0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
            0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x10
        )
        val decoder = MavDataDecoder(bytes)

        assertEquals(0x0807060504030201, decoder.decodeLong())
        assertEquals(0x100F0E0D0C0B0A09, decoder.decodeLong())
    }

    @Test
    fun decodeByteArray() {
        val bytes = byteArrayOf(0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08)
        val decoder = MavDataDecoder(bytes)

        val dst = ByteArray(8)
        decoder.decodeByteArray(dst)

        assertArrayEquals(bytes, dst)
    }
}

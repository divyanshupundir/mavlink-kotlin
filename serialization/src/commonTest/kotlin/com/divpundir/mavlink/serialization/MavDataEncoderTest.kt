package com.divpundir.mavlink.serialization

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MavDataEncoderTest {

    @Test
    fun getBytes() {
        val bytes = byteArrayOf(
            0x01,
            0x02, 0x03,
            0x04, 0x05, 0x06, 0x07,
            0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F
        )
        val encoder = MavDataEncoder(15)

        encoder.encodeByte(0x01)
        encoder.encodeShort(0x0302)
        encoder.encodeInt(0x07060504)
        encoder.encodeLong(0x0F0E0D0C0B0A0908)

        assertArrayEquals(bytes, encoder.bytes)
    }

    @Test
    fun getRemaining() {
        val encoder = MavDataEncoder(15)

        assertEquals(15, encoder.remaining)
        encoder.encodeByte(0x01)
        assertEquals(14, encoder.remaining)
        encoder.encodeShort(0x0201)
        assertEquals(12, encoder.remaining)
        encoder.encodeInt(0x04030201)
        assertEquals(8, encoder.remaining)
        encoder.encodeLong(0x0807060504030201)
        assertEquals(0, encoder.remaining)
    }

    @Test
    fun encodeByte() {
        val bytes = byteArrayOf(
            0x01,
            0x02
        )
        val encoder = MavDataEncoder(2)

        encoder.encodeByte(0x01)
        encoder.encodeByte(0x02)

        assertArrayEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeShort() {
        val bytes = byteArrayOf(
            0x01, 0x02,
            0x03, 0x04
        )
        val encoder = MavDataEncoder(4)

        encoder.encodeShort(0x0201)
        encoder.encodeShort(0x0403)

        assertArrayEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeInt() {
        val bytes = byteArrayOf(
            0x01, 0x02, 0x03, 0x04,
            0x05, 0x06, 0x07, 0x08
        )
        val encoder = MavDataEncoder(8)

        encoder.encodeInt(0x04030201)
        encoder.encodeInt(0x08070605)

        assertArrayEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeLong() {
        val bytes = byteArrayOf(
            0x01, 0x02, 0x03, 0x04,
            0x05, 0x06, 0x07, 0x08,
            0x09, 0x0A, 0x0B, 0x0C,
            0x0D, 0x0E, 0x0F, 0x10
        )
        val encoder = MavDataEncoder(16)

        encoder.encodeLong(0x0807060504030201)
        encoder.encodeLong(0x100F0E0D0C0B0A09)

        assertArrayEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeByteArray() {
        val bytes = byteArrayOf(0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08)
        val encoder = MavDataEncoder(8)

        encoder.encodeByteArray(bytes)

        assertArrayEquals(bytes, encoder.bytes)
    }
}

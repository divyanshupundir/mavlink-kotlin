package com.divpundir.mavlink.serialization

import kotlin.test.Test
import kotlin.test.assertContentEquals

class SerializationUtilTest {

    @Test
    fun encodeInt8() {
        val bytes = byteArrayOf(
            0xFF.toByte(),
            0x01.toByte(),
        )
        val encoder = MavDataEncoder(2)

        encoder.encodeInt8(0xFF.toByte())
        encoder.encodeInt8(0x01.toByte())

        assertContentEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeUInt8() {
        val bytes = byteArrayOf(
            0xFF.toByte(),
            0x01.toByte(),
        )
        val encoder = MavDataEncoder(2)

        encoder.encodeUInt8(0xFF.toUByte())
        encoder.encodeUInt8(0x01.toUByte())

        assertContentEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeInt16() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(),
            0x01.toByte(), 0x02.toByte()
        )
        val encoder = MavDataEncoder(4)

        encoder.encodeInt16(0xFEFF.toShort())
        encoder.encodeInt16(0x0201.toShort())

        assertContentEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeUInt16() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(),
            0x01.toByte(), 0x02.toByte()
        )
        val encoder = MavDataEncoder(4)

        encoder.encodeUInt16(0xFEFF.toUShort())
        encoder.encodeUInt16(0x0201.toUShort())

        assertContentEquals(bytes, encoder.bytes)
    }

    @Suppress("RemoveRedundantCallsOfConversionMethods")
    @Test
    fun encodeInt32() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(), 0xFD.toByte(), 0xFC.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte()
        )
        val encoder = MavDataEncoder(8)

        encoder.encodeInt32(0xFCFDFEFF.toInt())
        encoder.encodeInt32(0x04030201.toInt())

        assertContentEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeUInt32() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(), 0xFD.toByte(), 0xFC.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte()
        )
        val encoder = MavDataEncoder(8)

        encoder.encodeUInt32(0xFCFDFEFF.toUInt())
        encoder.encodeUInt32(0x04030201.toUInt())

        assertContentEquals(bytes, encoder.bytes)
    }

    @Suppress("RemoveRedundantCallsOfConversionMethods")
    @Test
    fun encodeInt64() {
        val bytes = byteArrayOf(
            0x1F.toByte(), 0x1E.toByte(), 0x1D.toByte(), 0x1C.toByte(),
            0x1B.toByte(), 0x1A.toByte(), 0x19.toByte(), 0x18.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
            0x05.toByte(), 0x06.toByte(), 0x07.toByte(), 0x08.toByte()
        )
        val encoder = MavDataEncoder(16)

        encoder.encodeInt64(0x18191A1B1C1D1E1F.toLong())
        encoder.encodeInt64(0x0807060504030201.toLong())

        assertContentEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeUInt64() {
        val bytes = byteArrayOf(
            0x1F.toByte(), 0x1E.toByte(), 0x1D.toByte(), 0x1C.toByte(),
            0x1B.toByte(), 0x1A.toByte(), 0x19.toByte(), 0x18.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
            0x05.toByte(), 0x06.toByte(), 0x07.toByte(), 0x08.toByte()
        )
        val encoder = MavDataEncoder(16)

        encoder.encodeUInt64(0x18191A1B1C1D1E1F.toULong())
        encoder.encodeUInt64(0x0807060504030201.toULong())

        assertContentEquals(bytes, encoder.bytes)
    }

    @Suppress("RemoveRedundantCallsOfConversionMethods")
    @Test
    fun encodeFloat() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(), 0xFD.toByte(), 0xFC.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
        )
        val encoder = MavDataEncoder(8)

        encoder.encodeFloat(Float.fromBits(0xFCFDFEFF.toInt()))
        encoder.encodeFloat(Float.fromBits(0x04030201.toInt()))

        assertContentEquals(bytes, encoder.bytes)
    }

    @Suppress("RemoveRedundantCallsOfConversionMethods")
    @Test
    fun encodeDouble() {
        val bytes = byteArrayOf(
            0x1F.toByte(), 0x1E.toByte(), 0x1D.toByte(), 0x1C.toByte(),
            0x1B.toByte(), 0x1A.toByte(), 0x19.toByte(), 0x18.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
            0x05.toByte(), 0x06.toByte(), 0x07.toByte(), 0x08.toByte()
        )
        val encoder = MavDataEncoder(16)

        encoder.encodeDouble(Double.fromBits(0x18191A1B1C1D1E1F.toLong()))
        encoder.encodeDouble(Double.fromBits(0x0807060504030201.toLong()))

        assertContentEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeChar() {
        val bytes = byteArrayOf(
            0x41.toByte(),
            0x42.toByte(),
        )
        val encoder = MavDataEncoder(2)

        encoder.encodeChar('A')
        encoder.encodeChar('B')

        assertContentEquals(bytes, encoder.bytes)
    }

    @Test
    fun encodeString() {
        val bytes = byteArrayOf(
            0x41.toByte(), 0x42.toByte(), 0x43.toByte(), 0x44.toByte(),
            0x45.toByte(), 0x46.toByte(), 0x47.toByte(), 0x48.toByte(),
            0x61.toByte(), 0x62.toByte(), 0x63.toByte(), 0x64.toByte(),
            0x65.toByte(), 0x66.toByte(), 0x67.toByte(), 0x68.toByte(),
        )
        val encoder = MavDataEncoder(16)

        encoder.encodeString("ABCDEFGH", 8)
        encoder.encodeString("abcdefgh", 8)

        assertContentEquals(bytes, encoder.bytes)
    }

    @Test
    fun truncateZeros() {
        assertContentEquals(
            byteArrayOf(0x01, 0x02, 0x03, 0x04),
            byteArrayOf(0x01, 0x02, 0x03, 0x04, 0x00, 0x00).truncateZeros()
        )
        assertContentEquals(
            byteArrayOf(0x00, 0x01, 0x02, 0x03, 0x04),
            byteArrayOf(0x00, 0x01, 0x02, 0x03, 0x04).truncateZeros()
        )
    }
}

package com.divpundir.mavlink.serialization

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigInteger

class DeserializationUtilTest {

    @Test
    fun safeDecodeInt8() {
        val bytes = byteArrayOf(
            0xFF.toByte(),
            0x01.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(0xFF.toByte(), decoder.safeDecodeInt8())
        assertEquals(0x02.toByte(), decoder.safeDecodeInt8())
        assertEquals(0x00.toByte(), decoder.safeDecodeInt8())
    }

    @Test
    fun safeDecodeUInt8() {
        val bytes = byteArrayOf(
            0xFF.toByte(),
            0x01.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(0xFF.toUByte(), decoder.safeDecodeUInt8())
        assertEquals(0x02.toUByte(), decoder.safeDecodeUInt8())
        assertEquals(0x00.toUByte(), decoder.safeDecodeUInt8())
    }

    @Test
    fun safeDecodeInt16() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(),
            0x01.toByte(), 0x02.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(0xFEFF.toShort(), decoder.safeDecodeInt16())
        assertEquals(0x0201.toShort(), decoder.safeDecodeInt16())
        assertEquals(0x0000.toShort(), decoder.safeDecodeInt16())
    }

    @Test
    fun safeDecodeUInt16() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(),
            0x01.toByte(), 0x02.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(0xFEFF.toUShort(), decoder.safeDecodeUInt16())
        assertEquals(0x0201.toUShort(), decoder.safeDecodeUInt16())
        assertEquals(0x0000.toUShort(), decoder.safeDecodeUInt16())
    }

    @Suppress("RemoveRedundantCallsOfConversionMethods")
    @Test
    fun safeDecodeInt32() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(), 0xFD.toByte(), 0xFC.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(0xFCFDFEFF.toInt(), decoder.safeDecodeInt32())
        assertEquals(0x04030201.toInt(), decoder.safeDecodeInt32())
        assertEquals(0x00000000.toInt(), decoder.safeDecodeInt32())
    }

    @Test
    fun safeDecodeUInt32() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(), 0xFD.toByte(), 0xFC.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(0xFCFDFEFF.toUInt(), decoder.safeDecodeUInt32())
        assertEquals(0x04030201.toUInt(), decoder.safeDecodeUInt32())
        assertEquals(0x00000000.toUInt(), decoder.safeDecodeUInt32())
    }

    @Suppress("RemoveRedundantCallsOfConversionMethods")
    @Test
    fun safeDecodeInt64() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(), 0xFD.toByte(), 0xFC.toByte(),
            0xFB.toByte(), 0xFA.toByte(), 0xF9.toByte(), 0xF8.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
            0x05.toByte(), 0x06.toByte(), 0x07.toByte(), 0x08.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(
            BigInteger(
                byteArrayOf(
                    0xF8.toByte(), 0xF9.toByte(), 0xFA.toByte(), 0xFB.toByte(),
                    0xFC.toByte(), 0xFD.toByte(), 0xFE.toByte(), 0xFF.toByte(),
                )
            ).toLong(),
            decoder.safeDecodeInt64()
        )
        assertEquals(0x0807060504030201.toLong(), decoder.safeDecodeInt64())
        assertEquals(0x0000000000000000.toLong(), decoder.safeDecodeInt64())
    }

    @Test
    fun safeDecodeUInt64() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(), 0xFD.toByte(), 0xFC.toByte(),
            0xFB.toByte(), 0xFA.toByte(), 0xF9.toByte(), 0xF8.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
            0x05.toByte(), 0x06.toByte(), 0x07.toByte(), 0x08.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(
            BigInteger(
                byteArrayOf(
                    0xF8.toByte(), 0xF9.toByte(), 0xFA.toByte(), 0xFB.toByte(),
                    0xFC.toByte(), 0xFD.toByte(), 0xFE.toByte(), 0xFF.toByte(),
                )
            ).toLong().toULong(),
            decoder.safeDecodeUInt64()
        )
        assertEquals(0x0807060504030201.toULong(), decoder.safeDecodeUInt64())
        assertEquals(0x0000000000000000.toULong(), decoder.safeDecodeUInt64())
    }

    @Suppress("RemoveRedundantCallsOfConversionMethods")
    @Test
    fun safeDecodeFloat() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(), 0xFD.toByte(), 0xFC.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(Float.fromBits(0xFCFDFEFF.toInt()), decoder.safeDecodeFloat())
        assertEquals(Float.fromBits(0x04030201.toInt()), decoder.safeDecodeFloat())
        assertEquals(Float.fromBits(0x00000000.toInt()), decoder.safeDecodeFloat())
    }

    @Suppress("RemoveRedundantCallsOfConversionMethods")
    @Test
    fun safeDecodeDouble() {
        val bytes = byteArrayOf(
            0xFF.toByte(), 0xFE.toByte(), 0xFD.toByte(), 0xFC.toByte(),
            0xFB.toByte(), 0xFA.toByte(), 0xF9.toByte(), 0xF8.toByte(),
            0x01.toByte(), 0x02.toByte(), 0x03.toByte(), 0x04.toByte(),
            0x05.toByte(), 0x06.toByte(), 0x07.toByte(), 0x08.toByte(),
        )
        val decoder = MavDataDecoder.wrap(bytes)


        assertEquals(
            Double.fromBits(
                BigInteger(
                    byteArrayOf(
                        0xF8.toByte(), 0xF9.toByte(), 0xFA.toByte(), 0xFB.toByte(),
                        0xFC.toByte(), 0xFD.toByte(), 0xFE.toByte(), 0xFF.toByte(),
                    )
                ).toLong()
            ),
            decoder.safeDecodeDouble()
        )
        assertEquals(Double.fromBits(0x0807060504030201.toLong()), decoder.safeDecodeDouble())
        assertEquals(Double.fromBits(0x0000000000000000.toLong()), decoder.safeDecodeDouble())
    }

    @Test
    fun safeDecodeChar() {
        val bytes = byteArrayOf(
            0x01.toByte(),
            0x02.toByte(),
        )

        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals(0x01.toChar(), decoder.safeDecodeChar())
        assertEquals(0x02.toChar(), decoder.safeDecodeChar())
    }

    @Test
    fun safeDecodeString() {
        val bytes = byteArrayOf(
            0x41.toByte(), 0x42.toByte(), 0x43.toByte(), 0x44.toByte(),
            0x45.toByte(), 0x46.toByte(), 0x47.toByte(), 0x48.toByte(),
            0x61.toByte(), 0x62.toByte(), 0x63.toByte(), 0x64.toByte(),
            0x65.toByte(), 0x66.toByte(), 0x67.toByte(), 0x68.toByte(),
        )

        val decoder = MavDataDecoder.wrap(bytes)

        assertEquals("ABCDEFGH", decoder.safeDecodeString(8))
        assertEquals("abcdefgh", decoder.safeDecodeString(8))
        assertEquals("", decoder.safeDecodeString(0))
    }
}

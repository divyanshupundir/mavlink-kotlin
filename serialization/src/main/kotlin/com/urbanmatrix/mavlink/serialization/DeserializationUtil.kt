package com.urbanmatrix.mavlink.serialization

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.StandardCharsets


fun ByteBuffer.decodeInt8(): Int = decodeSignedIntegerValue(Byte.SIZE_BYTES).toInt()

fun ByteBuffer.decodeUint8(): Int = decodeUnsignedIntegerValue(Byte.SIZE_BYTES).toInt()

fun ByteBuffer.decodeInt16(): Int = decodeSignedIntegerValue(Short.SIZE_BYTES).toInt()

fun ByteBuffer.decodeUint16(): Int = decodeUnsignedIntegerValue(Short.SIZE_BYTES).toInt()

fun ByteBuffer.decodeInt32(): Int = decodeSignedIntegerValue(Int.SIZE_BYTES).toInt()

fun ByteBuffer.decodeUint32(): Long = decodeUnsignedIntegerValue(Int.SIZE_BYTES)

fun ByteBuffer.decodeInt64(): Long = decodeSignedIntegerValue(Long.SIZE_BYTES)

fun ByteBuffer.decodeUint64(): BigInteger {
    val data = ByteArray(Long.SIZE_BYTES) {
        if (this.hasRemaining()) this.get() else 0.toByte()
    }
    // Invert to big-endian, for BigInteger constructor
    if (this.order() == ByteOrder.LITTLE_ENDIAN) data.reverse()

    return BigInteger(data)
}

fun ByteBuffer.decodeFloat(): Float =
    if (this.remaining() >= Float.SIZE_BYTES) this.float else 0F

fun ByteBuffer.decodeDouble(): Double =
    if (this.remaining() >= Double.SIZE_BYTES) this.double else 0.0

fun ByteBuffer.decodeChar(): Char =
    if (this.remaining() >= Byte.SIZE_BYTES) decodeUnsignedIntegerValue(1).toInt().toChar() else 0.toChar()

fun ByteBuffer.decodeString(length: Int): String {
    val data = ByteArray(length) { if (this.hasRemaining()) this.get() else 0.toByte() }

    for (i in 0 until length) {
        if (data[i] == 0.toByte()) return String(data, 0, i, StandardCharsets.UTF_8)
    }
    return String(data, StandardCharsets.UTF_8)
}

fun ByteBuffer.decodeUint8Array(dataSize: Int): List<Int> = decodeArray(
    dataSize / Byte.SIZE_BYTES,
    ByteBuffer::decodeUint8
)

fun ByteBuffer.decodeInt8Array(dataSize: Int): List<Int> = decodeArray(
    dataSize / Byte.SIZE_BYTES,
    ByteBuffer::decodeInt8
)

fun ByteBuffer.decodeUint16Array(dataSize: Int): List<Int> = decodeArray(
    dataSize / Short.SIZE_BYTES,
    ByteBuffer::decodeUint16
)

fun ByteBuffer.decodeInt16Array(dataSize: Int): List<Int> = decodeArray(
    dataSize / Short.SIZE_BYTES,
    ByteBuffer::decodeInt16
)

fun ByteBuffer.decodeUint32Array(dataSize: Int): List<Long> = decodeArray(
    dataSize / Int.SIZE_BYTES,
    ByteBuffer::decodeUint32
)

fun ByteBuffer.decodeInt32Array(dataSize: Int): List<Int> = decodeArray(
    dataSize / Int.SIZE_BYTES,
    ByteBuffer::decodeInt32
)

fun ByteBuffer.decodeUint64Array(dataSize: Int): List<BigInteger> = decodeArray(
    dataSize / Long.SIZE_BYTES,
    ByteBuffer::decodeUint64
)

fun ByteBuffer.decodeInt64Array(dataSize: Int): List<Long> = decodeArray(
    dataSize / Long.SIZE_BYTES,
    ByteBuffer::decodeInt64
)

fun ByteBuffer.decodeFloatArray(dataSize: Int): List<Float> = decodeArray(
    dataSize / Float.SIZE_BYTES,
    ByteBuffer::decodeFloat
)

fun ByteBuffer.decodeDoubleArray(dataSize: Int): List<Double> = decodeArray(
    dataSize / Double.SIZE_BYTES,
    ByteBuffer::decodeDouble
)

fun ByteBuffer.decodeEnumValue(dataSize: Int): Long = decodeUnsignedIntegerValue(dataSize)

private inline fun <T : Any> ByteBuffer.decodeArray(elementCount: Int, decode: ByteBuffer.() -> T): List<T> =
    List(elementCount) { this.decode() }

private fun ByteBuffer.decodeUnsignedIntegerValue(dataSize: Int): Long {
    val data = ByteArray(dataSize) { if (this.hasRemaining()) this.get() else 0.toByte() }

    if (this.order() == ByteOrder.BIG_ENDIAN) data.reverse()

    var value: Long = 0
    for (i in 0 until dataSize) {
        value = value or ((data[i].toLong() and 0xFF.toLong()) shl (i * Byte.SIZE_BITS))
    }
    return value
}

private fun ByteBuffer.decodeSignedIntegerValue(dataSize: Int): Long {
    var value = decodeUnsignedIntegerValue(dataSize)
    val signBitIndex = dataSize * Byte.SIZE_BITS - 1
    if ((value shr signBitIndex) == 1L) {
        value = value or (-1L shl signBitIndex)
    }
    return value
}

package com.urbanmatrix.mavlink.serialization

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.StandardCharsets

fun ByteBuffer.encodeInt8(value: Int): Unit = encodeIntegerValue(value.toLong(), Byte.SIZE_BYTES)

fun ByteBuffer.encodeUint8(value: Int): Unit = encodeIntegerValue(value.toLong(), Byte.SIZE_BYTES)

fun ByteBuffer.encodeInt16(value: Int): Unit = encodeIntegerValue(value.toLong(), Short.SIZE_BYTES)

fun ByteBuffer.encodeUint16(value: Int): Unit = encodeIntegerValue(value.toLong(), Short.SIZE_BYTES)

fun ByteBuffer.encodeInt32(value: Int): Unit = encodeIntegerValue(value.toLong(), Int.SIZE_BYTES)

fun ByteBuffer.encodeUint32(value: Long): Unit = encodeIntegerValue(value, Int.SIZE_BYTES)

fun ByteBuffer.encodeInt64(value: Long): Unit = encodeIntegerValue(value, Long.SIZE_BYTES)

fun ByteBuffer.encodeUint64(value: BigInteger) {
    val data = value.toByteArray()
    // Invert to little-endian, as BigInteger gives big-endian bytes
    if (this.order() == ByteOrder.LITTLE_ENDIAN) data.reverse()

    for (byte in data) {
        if (this.hasRemaining()) this.put(byte)
    }
}

fun ByteBuffer.encodeFloat(value: Float) {
    if (this.remaining() >= Float.SIZE_BYTES) this.putFloat(value)
}

fun ByteBuffer.encodeDouble(value: Double) {
    if (this.remaining() >= Double.SIZE_BYTES) this.putDouble(value)
}

fun ByteBuffer.encodeChar(value: Char): Unit = encodeIntegerValue(value.code.toLong(), Byte.SIZE_BYTES)

fun ByteBuffer.encodeString(value: String, length: Int) {
    val data = value.toByteArray(charset = StandardCharsets.UTF_8)

    for (i in 0 until length) {
        if (this.hasRemaining()) this.put(if (i < data.size) data[i] else 0.toByte())
    }
}

fun ByteBuffer.encodeUint8Array(arr: List<Int>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Byte.SIZE_BYTES,
    ByteBuffer::encodeUint8
)

fun ByteBuffer.encodeInt8Array(arr: List<Int>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Byte.SIZE_BYTES,
    ByteBuffer::encodeInt8
)

fun ByteBuffer.encodeUint16Array(arr: List<Int>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Short.SIZE_BYTES,
    ByteBuffer::encodeUint16
)

fun ByteBuffer.encodeInt16Array(arr: List<Int>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Short.SIZE_BYTES,
    ByteBuffer::encodeInt16
)

fun ByteBuffer.encodeUint32Array(arr: List<Long>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Int.SIZE_BYTES,
    ByteBuffer::encodeUint32
)

fun ByteBuffer.encodeInt32Array(arr: List<Int>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Int.SIZE_BYTES,
    ByteBuffer::encodeInt32
)

fun ByteBuffer.encodeUint64Array(arr: List<BigInteger>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Long.SIZE_BYTES,
    ByteBuffer::encodeUint64
)

fun ByteBuffer.encodeInt64Array(arr: List<Long>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Long.SIZE_BYTES,
    ByteBuffer::encodeInt64
)

fun ByteBuffer.encodeFloatArray(arr: List<Float>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Float.SIZE_BYTES,
    ByteBuffer::encodeFloat
)

fun ByteBuffer.encodeDoubleArray(arr: List<Double>, dataSize: Int) = encodeArray(
    arr,
    dataSize / Double.SIZE_BYTES,
    ByteBuffer::encodeDouble
)

fun ByteBuffer.encodeEnumValue(value: Long, length: Int): Unit = encodeIntegerValue(value, length)

private inline fun <T : Any> ByteBuffer.encodeArray(arr: List<T>, elementCount: Int, encode: ByteBuffer.(T) -> Unit) {
    for (i in 0 until elementCount) this.encode(arr[i])
}

private fun ByteBuffer.encodeIntegerValue(value: Long, length: Int) {
    for (shift in 0 until length) {
        if (this.hasRemaining()) this.put(((value shr (shift * 8)) and 0xFF).toByte())
    }
}

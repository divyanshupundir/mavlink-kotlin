package xyz.urbanmatrix.mavlink.serialization

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.StandardCharsets

public fun ByteBuffer.encodeInt8(value: Int): Unit = encodeIntegerValue(value.toLong(), Byte.SIZE_BYTES)

public fun ByteBuffer.encodeUint8(value: Int): Unit = encodeIntegerValue(value.toLong(), Byte.SIZE_BYTES)

public fun ByteBuffer.encodeInt16(value: Int): Unit = encodeIntegerValue(value.toLong(), Short.SIZE_BYTES)

public fun ByteBuffer.encodeUint16(value: Int): Unit = encodeIntegerValue(value.toLong(), Short.SIZE_BYTES)

public fun ByteBuffer.encodeInt32(value: Int): Unit = encodeIntegerValue(value.toLong(), Int.SIZE_BYTES)

public fun ByteBuffer.encodeUint32(value: Long): Unit = encodeIntegerValue(value, Int.SIZE_BYTES)

public fun ByteBuffer.encodeInt64(value: Long): Unit = encodeIntegerValue(value, Long.SIZE_BYTES)

public fun ByteBuffer.encodeUint64(value: BigInteger) {
    val valueBytes = value.toByteArray()
    val data = ByteArray(Long.SIZE_BYTES)

    if (valueBytes.size >= Long.SIZE_BYTES) {
        valueBytes.copyInto(data, endIndex = Long.SIZE_BYTES)
    } else {
        valueBytes.copyInto(data, destinationOffset = Long.SIZE_BYTES - valueBytes.size)
    }

    // Invert to little-endian, as BigInteger gives big-endian bytes
    if (this.order() == ByteOrder.LITTLE_ENDIAN) data.reverse()

    for (byte in data) {
        if (this.hasRemaining()) this.put(byte)
    }
}

public fun ByteBuffer.encodeFloat(value: Float) {
    if (this.remaining() >= Float.SIZE_BYTES) this.putFloat(value)
}

public fun ByteBuffer.encodeDouble(value: Double) {
    if (this.remaining() >= Double.SIZE_BYTES) this.putDouble(value)
}

public fun ByteBuffer.encodeChar(value: Char): Unit = encodeIntegerValue(value.code.toLong(), Byte.SIZE_BYTES)

public fun ByteBuffer.encodeString(value: String, length: Int) {
    val data = value.toByteArray(charset = StandardCharsets.UTF_8)

    for (i in 0 until length) {
        if (this.hasRemaining()) this.put(if (i < data.size) data[i] else 0.toByte())
    }
}

public fun ByteBuffer.encodeUint8Array(arr: List<Int>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Byte.SIZE_BYTES,
    0,
    ByteBuffer::encodeUint8
)

public fun ByteBuffer.encodeInt8Array(arr: List<Int>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Byte.SIZE_BYTES,
    0,
    ByteBuffer::encodeInt8
)

public fun ByteBuffer.encodeUint16Array(arr: List<Int>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Short.SIZE_BYTES,
    0,
    ByteBuffer::encodeUint16
)

public fun ByteBuffer.encodeInt16Array(arr: List<Int>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Short.SIZE_BYTES,
    0,
    ByteBuffer::encodeInt16
)

public fun ByteBuffer.encodeUint32Array(arr: List<Long>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Int.SIZE_BYTES,
    0L,
    ByteBuffer::encodeUint32
)

public fun ByteBuffer.encodeInt32Array(arr: List<Int>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Int.SIZE_BYTES,
    0,
    ByteBuffer::encodeInt32
)

public fun ByteBuffer.encodeUint64Array(arr: List<BigInteger>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Long.SIZE_BYTES,
    BigInteger.ZERO,
    ByteBuffer::encodeUint64
)

public fun ByteBuffer.encodeInt64Array(arr: List<Long>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Long.SIZE_BYTES,
    0L,
    ByteBuffer::encodeInt64
)

public fun ByteBuffer.encodeFloatArray(arr: List<Float>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Float.SIZE_BYTES,
    0F,
    ByteBuffer::encodeFloat
)

public fun ByteBuffer.encodeDoubleArray(arr: List<Double>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Double.SIZE_BYTES,
    0.0,
    ByteBuffer::encodeDouble
)

public fun ByteBuffer.encodeEnumValue(value: Long, dataSize: Int): Unit = encodeIntegerValue(value, dataSize)

public fun ByteBuffer.encodeBitmaskValue(value: Long, dataSize: Int): Unit = encodeIntegerValue(value, dataSize)

public inline fun <T : Any> ByteBuffer.encodeArray(
    arr: List<T>,
    elementCount: Int,
    defaultValue: T,
    encode: ByteBuffer.(T) -> Unit
) {
    for (i in 0 until elementCount) this.encode(if (i < arr.size) arr[i] else defaultValue)
}

public fun ByteBuffer.encodeIntegerValue(value: Long, dataSize: Int) {
    for (shift in 0 until dataSize) {
        if (this.hasRemaining()) this.put(((value shr (shift * 8)) and 0xFF).toByte())
    }
}

public fun ByteArray.truncateZeros(): ByteArray {
    for (index in lastIndex downTo 0) {
        if (this[index] != 0.toByte()) {
            return this.copyOfRange(0, index + 1)
        }
    }
    return ByteArray(0)
}

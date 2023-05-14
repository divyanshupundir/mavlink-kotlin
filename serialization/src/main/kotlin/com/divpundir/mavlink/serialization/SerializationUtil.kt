package com.divpundir.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

/**
 * Writes the given [Byte]/Int8 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeInt8(value: Byte) {
    if (this.remaining() >= Byte.SIZE_BYTES) this.put(value)
}

/**
 * Writes the given [UByte]/UInt8 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeUInt8(value: UByte) {
    if (this.remaining() >= UByte.SIZE_BYTES) this.put(value.toByte())
}

/**
 * Writes the given [Short]/Int16 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeInt16(value: Short) {
    if (this.remaining() >= Short.SIZE_BYTES) this.putShort(value)
}

/**
 * Writes the given [UShort]/UInt16 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeUInt16(value: UShort) {
    if (this.remaining() >= UShort.SIZE_BYTES) this.putShort(value.toShort())
}

/**
 * Writes the given [Int]/Int32 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeInt32(value: Int) {
    if (this.remaining() >= Int.SIZE_BYTES) this.putInt(value)
}

/**
 * Writes the given [UInt]/UInt32 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeUInt32(value: UInt) {
    if (this.remaining() >= UInt.SIZE_BYTES) this.putInt(value.toInt())
}

/**
 * Writes the given [Long]/Int64 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeInt64(value: Long) {
    if (this.remaining() >= Long.SIZE_BYTES) this.putLong(value)
}

/**
 * Writes the given [ULong]/UInt64 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeUInt64(value: ULong) {
    if (this.remaining() >= ULong.SIZE_BYTES) this.putLong(value.toLong())
}

/**
 * Writes the given [Float]/Float32 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeFloat(value: Float) {
    if (this.remaining() >= Float.SIZE_BYTES) this.putFloat(value)
}

/**
 * Writes the given [Double]/Float64 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeDouble(value: Double) {
    if (this.remaining() >= Double.SIZE_BYTES) this.putDouble(value)
}

/**
 * Writes the given [Char]/UInt64 to the buffer's current position, and then increments the position. Does nothing if
 * there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeChar(value: Char) {
    if (this.remaining() >= Byte.SIZE_BYTES) this.put(value.code.toByte())
}

/**
 * Writes the given [String] to the buffer's current position, and then increments the position. If there [String] is
 * shorter than the [length] parameter then empty characters are encoded. Does nothing if there is not enough space in
 * the buffer.
 */
public fun ByteBuffer.encodeString(value: String, length: Int) {
    val data = value.toByteArray(charset = StandardCharsets.UTF_8)

    for (i in 0 until length) {
        if (this.hasRemaining()) this.put(if (i < data.size) data[i] else 0)
    }
}

/**
 * Encodes the given [List] of [Byte]/Int8 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeInt8Array(arr: List<Byte>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Byte.SIZE_BYTES, 0, ByteBuffer::encodeInt8)

/**
 * Encodes the given [List] of [UByte]/UInt8 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeUInt8Array(arr: List<UByte>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / UByte.SIZE_BYTES, 0u, ByteBuffer::encodeUInt8)

/**
 * Encodes the given [List] of [Short]/Int16 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeInt16Array(arr: List<Short>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Short.SIZE_BYTES, 0, ByteBuffer::encodeInt16)

/**
 * Encodes the given [List] of [UShort]/UInt16 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeUInt16Array(arr: List<UShort>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / UShort.SIZE_BYTES, 0u, ByteBuffer::encodeUInt16)

/**
 * Encodes the given [List] of [Int]/Int32 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeInt32Array(arr: List<Int>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Int.SIZE_BYTES, 0, ByteBuffer::encodeInt32)

/**
 * Encodes the given [List] of [UInt]/UInt32 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeUInt32Array(arr: List<UInt>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / UInt.SIZE_BYTES, 0u, ByteBuffer::encodeUInt32)

/**
 * Encodes the given [List] of [Long]/Int64 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeInt64Array(arr: List<Long>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Long.SIZE_BYTES, 0L, ByteBuffer::encodeInt64)

/**
 * Encodes the given [List] of [ULong]/UInt64 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeUInt64Array(arr: List<ULong>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / ULong.SIZE_BYTES, 0uL, ByteBuffer::encodeUInt64)

/**
 * Encodes the given [List] of [Float]/Float32 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeFloatArray(arr: List<Float>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Float.SIZE_BYTES, 0F, ByteBuffer::encodeFloat)

/**
 * Encodes the given [List] of [Double]/Float64 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeDoubleArray(arr: List<Double>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Double.SIZE_BYTES, 0.0, ByteBuffer::encodeDouble)

/**
 * Encodes the given [UInt] MAVLink enum value into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeEnumValue(value: UInt, dataSize: Int) {
    when (dataSize) {
        UByte.SIZE_BYTES -> encodeUInt8(value.toUByte())
        UShort.SIZE_BYTES -> encodeUInt16(value.toUShort())
        UInt.SIZE_BYTES -> encodeUInt32(value)
        else -> {}
    }
}

/**
 * Encodes the given [UInt] MAVLink bitmask value into a [ByteArray] of size [dataSize], writes it to the buffer's
 * current position, and then increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeBitmaskValue(value: UInt, dataSize: Int) {
    when (dataSize) {
        UByte.SIZE_BYTES -> encodeUInt8(value.toUByte())
        UShort.SIZE_BYTES -> encodeUInt16(value.toUShort())
        UInt.SIZE_BYTES -> encodeUInt32(value)
        else -> {}
    }
}

/**
 * Encodes the given [Long] into a [ByteArray] of size [dataSize], writes it to the buffer's current position, and then
 * increments the position. Does nothing if there is not enough space in the buffer.
 */
public fun ByteBuffer.encodeIntegerValue(value: Long, dataSize: Int) {
    for (shift in 0 until dataSize) {
        if (this.hasRemaining()) this.put(((value shr (shift * 8)) and 0xFF).toByte())
    }
}

/**
 * Returns a new [ByteArray] with all the trailing zeros removed.
 */
public fun ByteArray.truncateZeros(): ByteArray {
    for (index in lastIndex downTo 0) {
        if (this[index] != 0.toByte()) {
            return this.copyOfRange(0, index + 1)
        }
    }
    return ByteArray(0)
}

private inline fun <T : Any> ByteBuffer.encodeArray(
    arr: List<T>,
    elementCount: Int,
    defaultValue: T,
    encode: ByteBuffer.(T) -> Unit
) {
    for (i in 0 until elementCount) this.encode(if (i < arr.size) arr[i] else defaultValue)
}

package com.divpundir.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.StandardCharsets

/**
 * Reads a [Byte]/Int8 from the buffer's current position, and then increments the position. Returns `0` if there are
 * not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeInt8(): Byte =
    decodePrimitive(Byte.SIZE_BYTES, 0, ByteBuffer::get)

/**
 * Reads a [UByte]/UInt8 from the buffer's current position, and then increments the position. Returns `0u` if there are
 * not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeUInt8(): UByte =
    decodePrimitive(UByte.SIZE_BYTES, 0u, ByteBuffer::getUByte)

/**
 * Reads a [Short]/Int16 from the buffer's current position, and then increments the position. Returns `0` if there are
 * not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeInt16(): Short =
    decodePrimitive(Short.SIZE_BYTES, 0, ByteBuffer::getShort)

/**
 * Reads a [UShort]/UInt16 from the buffer's current position, and then increments the position. Returns `0u` if there
 * are not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeUInt16(): UShort =
    decodePrimitive(UShort.SIZE_BYTES, 0u, ByteBuffer::getUShort)

/**
 * Reads a [Int]/Int32 from the buffer's current position, and then increments the position. Returns `0` if there are
 * not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeInt32(): Int =
    decodePrimitive(Int.SIZE_BYTES, 0, ByteBuffer::getInt)

/**
 * Reads a [UInt]/UInt32 from the buffer's current position, and then increments the position. Returns `0u` if there are
 * not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeUInt32(): UInt =
    decodePrimitive(UInt.SIZE_BYTES, 0u, ByteBuffer::getUInt)

/**
 * Reads a [Long]/Int64 from the buffer's current position, and then increments the position. Returns `0` if there are
 * not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeInt64(): Long =
    decodePrimitive(Long.SIZE_BYTES, 0, ByteBuffer::getLong)

/**
 * Reads a [ULong]/UInt64 from the buffer's current position, and then increments the position. Returns `0u` if there
 * are not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeUInt64(): ULong =
    decodePrimitive(ULong.SIZE_BYTES, 0u, ByteBuffer::getULong)

/**
 * Reads a [Float]/Float32 from the buffer's current position, and then increments the position. Returns `0F` if there
 * are not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeFloat(): Float =
    decodePrimitive(Float.SIZE_BYTES, 0F, ByteBuffer::getFloat)

/**
 * Reads a [Double]/Float64 from the buffer's current position, and then increments the position. Returns `0.0` if there
 * are not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeDouble(): Double =
    decodePrimitive(Double.SIZE_BYTES, 0.0, ByteBuffer::getDouble)

/**
 * Reads a [Char] from the buffer's current position, and then increments the position. Returns `\u0000` if there are
 * not enough bytes in the buffer.
 */
public fun ByteBuffer.decodeChar(): Char =
    if (this.remaining() >= Byte.SIZE_BYTES) get().toInt().toChar() else '\u0000'

/**
 * Reads a [String] of the given [length] from the buffer's current position using the UTF-8 encoding, and then
 * increments the position. If there are not enough bytes in the buffer, the remaining length is ignored.
 */
public fun ByteBuffer.decodeString(length: Int): String {
    val data = ByteArray(length) { if (this.hasRemaining()) this.get() else 0 }

    for (i in 0 until length) {
        if (data[i] == 0.toByte()) return String(data, 0, i, StandardCharsets.UTF_8)
    }
    return String(data, StandardCharsets.UTF_8)
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [Byte]/Int8 values.
 */
public fun ByteBuffer.decodeInt8Array(dataSize: Int): List<Byte> =
    decodeArray(dataSize / Byte.SIZE_BYTES, ByteBuffer::decodeInt8)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [UByte]/UInt8 values.
 */
public fun ByteBuffer.decodeUInt8Array(dataSize: Int): List<UByte> =
    decodeArray(dataSize / UByte.SIZE_BYTES, ByteBuffer::decodeUInt8)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [Short]/Int16 values.
 */
public fun ByteBuffer.decodeInt16Array(dataSize: Int): List<Short> =
    decodeArray(dataSize / Short.SIZE_BYTES, ByteBuffer::decodeInt16)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [UShort]/UInt16 values.
 */
public fun ByteBuffer.decodeUInt16Array(dataSize: Int): List<UShort> =
    decodeArray(dataSize / Short.SIZE_BYTES, ByteBuffer::decodeUInt16)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [Int]/Int32 values.
 */
public fun ByteBuffer.decodeInt32Array(dataSize: Int): List<Int> =
    decodeArray(dataSize / Int.SIZE_BYTES, ByteBuffer::decodeInt32)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [UInt]/UInt32 values.
 */
public fun ByteBuffer.decodeUInt32Array(dataSize: Int): List<UInt> =
    decodeArray(dataSize / Int.SIZE_BYTES, ByteBuffer::decodeUInt32)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [Long]/Int64 values.
 */
public fun ByteBuffer.decodeInt64Array(dataSize: Int): List<Long> =
    decodeArray(dataSize / Long.SIZE_BYTES, ByteBuffer::decodeInt64)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [ULong]/UInt64 values.
 */
public fun ByteBuffer.decodeUInt64Array(dataSize: Int): List<ULong> =
    decodeArray(dataSize / Long.SIZE_BYTES, ByteBuffer::decodeUInt64)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [Float]/Float32 values.
 */
public fun ByteBuffer.decodeFloatArray(dataSize: Int): List<Float> =
    decodeArray(dataSize / Float.SIZE_BYTES, ByteBuffer::decodeFloat)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [Double]/Float64 values.
 */
public fun ByteBuffer.decodeDoubleArray(dataSize: Int): List<Double> =
    decodeArray(dataSize / Double.SIZE_BYTES, ByteBuffer::decodeDouble)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [UInt] representing the MAVLink enum value.
 */
public fun ByteBuffer.decodeEnumValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [UInt] representing the MAVLink bitmask value.
 */
public fun ByteBuffer.decodeBitmaskValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns the
 * unsigned value encoded as a [Long].
 */
public fun ByteBuffer.decodeUnsignedIntegerValue(dataSize: Int): Long {
    val data = ByteArray(dataSize) { if (this.hasRemaining()) this.get() else 0 }

    if (this.order() == ByteOrder.BIG_ENDIAN) data.reverse()

    var value: Long = 0
    for (i in 0 until dataSize) {
        value = value or ((data[i].toLong() and 0xFF.toLong()) shl (i * Byte.SIZE_BITS))
    }
    return value
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns the
 * signed value encoded as a [Long].
 */
public fun ByteBuffer.decodeSignedIntegerValue(dataSize: Int): Long {
    var value = decodeUnsignedIntegerValue(dataSize)
    val signBitIndex = dataSize * Byte.SIZE_BITS - 1
    if ((value shr signBitIndex) == 1L) {
        value = value or (-1L shl signBitIndex)
    }
    return value
}

private inline fun <T : Any> ByteBuffer.decodePrimitive(size: Int, default: T, decode: ByteBuffer.() -> T): T {
    if (!hasRemaining()) {
        return default
    }
    if (remaining() >= size) {
        return this.decode()
    }
    val rem = ByteArray(size) { if (this.hasRemaining()) this.get() else 0 }
    return ByteBuffer.wrap(rem).order(this.order()).decode()
}

private inline fun <T : Any> ByteBuffer.decodeArray(elementCount: Int, decode: ByteBuffer.() -> T): List<T> =
    List(elementCount) { this.decode() }

private fun ByteBuffer.getUByte(): UByte = this.get().toUByte()

private fun ByteBuffer.getUShort(): UShort = this.short.toUShort()

private fun ByteBuffer.getUInt(): UInt = this.int.toUInt()

private fun ByteBuffer.getULong(): ULong = this.long.toULong()

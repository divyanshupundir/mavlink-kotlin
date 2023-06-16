package com.divpundir.mavlink.serialization

import okio.Buffer
import okio.BufferedSource

/**
 * Reads a [Byte]/Int8 from the buffer's current position, and then increments the position. Returns `0` if there are
 * not enough bytes in the buffer.
 */
public fun BufferedSource.decodeInt8(): Byte =
    decodePrimitive(Byte.SIZE_BYTES, 0, BufferedSource::readByte)

/**
 * Reads a [UByte]/UInt8 from the buffer's current position, and then increments the position. Returns `0u` if there are
 * not enough bytes in the buffer.
 */
public fun BufferedSource.decodeUInt8(): UByte =
    decodePrimitive(UByte.SIZE_BYTES, 0u, BufferedSource::readUByte)

/**
 * Reads a [Short]/Int16 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0` if there are not enough bytes in the buffer.
 */
public fun BufferedSource.decodeInt16(): Short =
    decodePrimitive(Short.SIZE_BYTES, 0, BufferedSource::readShortLe)

/**
 * Reads a [UShort]/UInt16 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0u` if there are not enough bytes in the buffer.
 */
public fun BufferedSource.decodeUInt16(): UShort =
    decodePrimitive(UShort.SIZE_BYTES, 0u, BufferedSource::readUShortLe)

/**
 * Reads a [Int]/Int32 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0` if there are not enough bytes in the buffer.
 */
public fun BufferedSource.decodeInt32(): Int =
    decodePrimitive(Int.SIZE_BYTES, 0, BufferedSource::readIntLe)

/**
 * Reads a [UInt]/UInt32 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0u` if there are not enough bytes in the buffer.
 */
public fun BufferedSource.decodeUInt32(): UInt =
    decodePrimitive(UInt.SIZE_BYTES, 0u, BufferedSource::readUIntLe)

/**
 * Reads a [Long]/Int64 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0` if there are not enough bytes in the buffer.
 */
public fun BufferedSource.decodeInt64(): Long =
    decodePrimitive(Long.SIZE_BYTES, 0, BufferedSource::readLongLe)

/**
 * Reads a [ULong]/UInt64 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0u` if there are not enough bytes in the buffer.
 */
public fun BufferedSource.decodeUInt64(): ULong =
    decodePrimitive(ULong.SIZE_BYTES, 0u, BufferedSource::readULongLe)

/**
 * Reads a [Float]/Float32 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0F` if there are not enough bytes in the buffer.
 */
public fun BufferedSource.decodeFloat(): Float =
    decodePrimitive(Float.SIZE_BYTES, 0F, BufferedSource::readFloatLe)

/**
 * Reads a [Double]/Float64 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0.0` if there are not enough bytes in the buffer.
 */
public fun BufferedSource.decodeDouble(): Double =
    decodePrimitive(Double.SIZE_BYTES, 0.0, BufferedSource::readDoubleLe)

/**
 * Reads a [Char] from the buffer's current position, and then increments the position. Returns `\u0000` if there are
 * not enough bytes in the buffer.
 */
public fun BufferedSource.decodeChar(): Char =
    if (this.request(Byte.SIZE_BYTES.toLong())) readByte().toInt().toChar() else '\u0000'

/**
 * Reads a [String] of the given [length] from the buffer's current position using the UTF-8 encoding, and then
 * increments the position. If there are not enough bytes in the buffer, the remaining length is ignored.
 */
public fun BufferedSource.decodeString(length: Int): String {
    val data = ByteArray(length)
    if (this.request(length.toLong())) {
        this.read(data)
    } else {
        this.read(data, 0, this.buffer.size.toInt())
    }

    for (i in 0 until length) {
        if (data[i] == 0.toByte()) return String(data, 0, i, Charsets.UTF_8)
    }
    return String(data, Charsets.UTF_8)
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [Byte]/Int8 values.
 */
public fun BufferedSource.decodeInt8Array(dataSize: Int): List<Byte> =
    decodeArray(dataSize / Byte.SIZE_BYTES, BufferedSource::decodeInt8)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [UByte]/UInt8 values.
 */
public fun BufferedSource.decodeUInt8Array(dataSize: Int): List<UByte> =
    decodeArray(dataSize / UByte.SIZE_BYTES, BufferedSource::decodeUInt8)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Short]/Int16 values.
 */
public fun BufferedSource.decodeInt16Array(dataSize: Int): List<Short> =
    decodeArray(dataSize / Short.SIZE_BYTES, BufferedSource::decodeInt16)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [UShort]/UInt16 values.
 */
public fun BufferedSource.decodeUInt16Array(dataSize: Int): List<UShort> =
    decodeArray(dataSize / Short.SIZE_BYTES, BufferedSource::decodeUInt16)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Int]/Int32 values.
 */
public fun BufferedSource.decodeInt32Array(dataSize: Int): List<Int> =
    decodeArray(dataSize / Int.SIZE_BYTES, BufferedSource::decodeInt32)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [UInt]/UInt32 values.
 */
public fun BufferedSource.decodeUInt32Array(dataSize: Int): List<UInt> =
    decodeArray(dataSize / Int.SIZE_BYTES, BufferedSource::decodeUInt32)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Long]/Int64 values.
 */
public fun BufferedSource.decodeInt64Array(dataSize: Int): List<Long> =
    decodeArray(dataSize / Long.SIZE_BYTES, BufferedSource::decodeInt64)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [ULong]/UInt64 values.
 */
public fun BufferedSource.decodeUInt64Array(dataSize: Int): List<ULong> =
    decodeArray(dataSize / Long.SIZE_BYTES, BufferedSource::decodeUInt64)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Float]/Float32 values.
 */
public fun BufferedSource.decodeFloatArray(dataSize: Int): List<Float> =
    decodeArray(dataSize / Float.SIZE_BYTES, BufferedSource::decodeFloat)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Double]/Float64 values.
 */
public fun BufferedSource.decodeDoubleArray(dataSize: Int): List<Double> =
    decodeArray(dataSize / Double.SIZE_BYTES, BufferedSource::decodeDouble)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * little-endian [UInt] representing the MAVLink enum value.
 */
public fun BufferedSource.decodeEnumValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * little-endian [UInt] representing the MAVLink bitmask value.
 */
public fun BufferedSource.decodeBitmaskValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns the
 * unsigned value encoded as a little-endian [Long].
 */
public fun BufferedSource.decodeUnsignedIntegerValue(dataSize: Int): Long {
    val data = ByteArray(dataSize)
    if (request(dataSize.toLong())) {
        this.read(data)
    } else {
        this.read(data, 0, this.buffer.size.toInt())
    }

    var value: Long = 0
    for (i in 0 until dataSize) {
        value = value or ((data[i].toLong() and 0xFF.toLong()) shl (i * Byte.SIZE_BITS))
    }
    return value
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns the
 * signed value encoded as a little-endian [Long].
 */
public fun BufferedSource.decodeSignedIntegerValue(dataSize: Int): Long {
    var value = decodeUnsignedIntegerValue(dataSize)
    val signBitIndex = dataSize * Byte.SIZE_BITS - 1
    if ((value shr signBitIndex) == 1L) {
        value = value or (-1L shl signBitIndex)
    }
    return value
}

private inline fun <T : Any> BufferedSource.decodePrimitive(size: Int, default: T, decode: BufferedSource.() -> T): T {
    if (this.exhausted()) {
        return default
    }

    if (this.request(size.toLong())) {
        return this.decode()
    }

    val rem = Buffer()
    rem.write(this, this.buffer.size)
    rem.write(ByteArray(size - this.buffer.size.toInt()))

    return rem.decode()
}

private inline fun <T : Any> BufferedSource.decodeArray(elementCount: Int, decode: BufferedSource.() -> T): List<T> =
    List(elementCount) { this.decode() }

private fun BufferedSource.readUByte(): UByte = this.readByte().toUByte()

private fun BufferedSource.readUShortLe(): UShort = this.readShortLe().toUShort()

private fun BufferedSource.readUIntLe(): UInt = this.readIntLe().toUInt()

private fun BufferedSource.readULongLe(): ULong = this.readLongLe().toULong()

private fun BufferedSource.readFloatLe(): Float = Float.fromBits(this.readIntLe())

private fun BufferedSource.readDoubleLe(): Double = Double.fromBits(this.readLongLe())

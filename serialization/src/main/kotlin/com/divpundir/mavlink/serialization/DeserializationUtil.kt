package com.divpundir.mavlink.serialization

import okio.Buffer

/**
 * Reads a [Byte]/Int8 from the buffer's current position, and then increments the position. Returns `0` if there are
 * not enough bytes in the buffer.
 */
public fun Buffer.decodeInt8(): Byte =
    decodePrimitive(Byte.SIZE_BYTES, 0, Buffer::readByte)

/**
 * Reads a [UByte]/UInt8 from the buffer's current position, and then increments the position. Returns `0u` if there are
 * not enough bytes in the buffer.
 */
public fun Buffer.decodeUInt8(): UByte =
    decodePrimitive(UByte.SIZE_BYTES, 0u, Buffer::readUByte)

/**
 * Reads a [Short]/Int16 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0` if there are not enough bytes in the buffer.
 */
public fun Buffer.decodeInt16(): Short =
    decodePrimitive(Short.SIZE_BYTES, 0, Buffer::readShortLe)

/**
 * Reads a [UShort]/UInt16 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0u` if there are not enough bytes in the buffer.
 */
public fun Buffer.decodeUInt16(): UShort =
    decodePrimitive(UShort.SIZE_BYTES, 0u, Buffer::readUShortLe)

/**
 * Reads a [Int]/Int32 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0` if there are not enough bytes in the buffer.
 */
public fun Buffer.decodeInt32(): Int =
    decodePrimitive(Int.SIZE_BYTES, 0, Buffer::readIntLe)

/**
 * Reads a [UInt]/UInt32 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0u` if there are not enough bytes in the buffer.
 */
public fun Buffer.decodeUInt32(): UInt =
    decodePrimitive(UInt.SIZE_BYTES, 0u, Buffer::readUIntLe)

/**
 * Reads a [Long]/Int64 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0` if there are not enough bytes in the buffer.
 */
public fun Buffer.decodeInt64(): Long =
    decodePrimitive(Long.SIZE_BYTES, 0, Buffer::readLongLe)

/**
 * Reads a [ULong]/UInt64 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0u` if there are not enough bytes in the buffer.
 */
public fun Buffer.decodeUInt64(): ULong =
    decodePrimitive(ULong.SIZE_BYTES, 0u, Buffer::readULongLe)

/**
 * Reads a [Float]/Float32 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0F` if there are not enough bytes in the buffer.
 */
public fun Buffer.decodeFloat(): Float =
    decodePrimitive(Float.SIZE_BYTES, 0F, Buffer::readFloatLe)

/**
 * Reads a [Double]/Float64 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0.0` if there are not enough bytes in the buffer.
 */
public fun Buffer.decodeDouble(): Double =
    decodePrimitive(Double.SIZE_BYTES, 0.0, Buffer::readDoubleLe)

/**
 * Reads a [Char] from the buffer's current position, and then increments the position. Returns `\u0000` if there are
 * not enough bytes in the buffer.
 */
public fun Buffer.decodeChar(): Char =
    if (this.size >= Byte.SIZE_BYTES) readByte().toInt().toChar() else '\u0000'

/**
 * Reads a [String] of the given [length] from the buffer's current position using the UTF-8 encoding, and then
 * increments the position. If there are not enough bytes in the buffer, the remaining length is ignored.
 */
public fun Buffer.decodeString(length: Int): String {
    val data = ByteArray(length)
    if (this.size >= length) {
        this.read(data)
    } else {
        this.read(data, 0, this.size.toInt())
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
public fun Buffer.decodeInt8Array(dataSize: Int): List<Byte> =
    decodeArray(dataSize / Byte.SIZE_BYTES, Buffer::decodeInt8)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [UByte]/UInt8 values.
 */
public fun Buffer.decodeUInt8Array(dataSize: Int): List<UByte> =
    decodeArray(dataSize / UByte.SIZE_BYTES, Buffer::decodeUInt8)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Short]/Int16 values.
 */
public fun Buffer.decodeInt16Array(dataSize: Int): List<Short> =
    decodeArray(dataSize / Short.SIZE_BYTES, Buffer::decodeInt16)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [UShort]/UInt16 values.
 */
public fun Buffer.decodeUInt16Array(dataSize: Int): List<UShort> =
    decodeArray(dataSize / Short.SIZE_BYTES, Buffer::decodeUInt16)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Int]/Int32 values.
 */
public fun Buffer.decodeInt32Array(dataSize: Int): List<Int> =
    decodeArray(dataSize / Int.SIZE_BYTES, Buffer::decodeInt32)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [UInt]/UInt32 values.
 */
public fun Buffer.decodeUInt32Array(dataSize: Int): List<UInt> =
    decodeArray(dataSize / Int.SIZE_BYTES, Buffer::decodeUInt32)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Long]/Int64 values.
 */
public fun Buffer.decodeInt64Array(dataSize: Int): List<Long> =
    decodeArray(dataSize / Long.SIZE_BYTES, Buffer::decodeInt64)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [ULong]/UInt64 values.
 */
public fun Buffer.decodeUInt64Array(dataSize: Int): List<ULong> =
    decodeArray(dataSize / Long.SIZE_BYTES, Buffer::decodeUInt64)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Float]/Float32 values.
 */
public fun Buffer.decodeFloatArray(dataSize: Int): List<Float> =
    decodeArray(dataSize / Float.SIZE_BYTES, Buffer::decodeFloat)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Double]/Float64 values.
 */
public fun Buffer.decodeDoubleArray(dataSize: Int): List<Double> =
    decodeArray(dataSize / Double.SIZE_BYTES, Buffer::decodeDouble)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * little-endian [UInt] representing the MAVLink enum value.
 */
public fun Buffer.decodeEnumValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * little-endian [UInt] representing the MAVLink bitmask value.
 */
public fun Buffer.decodeBitmaskValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns the
 * unsigned value encoded as a little-endian [Long].
 */
public fun Buffer.decodeUnsignedIntegerValue(dataSize: Int): Long {
    val data = ByteArray(dataSize)
    if (this.size >= dataSize) {
        this.read(data)
    } else {
        this.read(data, 0, this.size.toInt())
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
public fun Buffer.decodeSignedIntegerValue(dataSize: Int): Long {
    var value = decodeUnsignedIntegerValue(dataSize)
    val signBitIndex = dataSize * Byte.SIZE_BITS - 1
    if ((value shr signBitIndex) == 1L) {
        value = value or (-1L shl signBitIndex)
    }
    return value
}

private inline fun <T : Any> Buffer.decodePrimitive(size: Int, default: T, decode: Buffer.() -> T): T {
    if (this.exhausted()) {
        return default
    }
    if (this.size >= size) {
        return this.decode()
    }

    val rem = Buffer()
    rem.write(this, this.size)
    rem.write(ByteArray(size - this.size.toInt()))

    return rem.decode()
}

private inline fun <T : Any> Buffer.decodeArray(elementCount: Int, decode: Buffer.() -> T): List<T> =
    List(elementCount) { this.decode() }

private fun Buffer.readUByte(): UByte = this.readByte().toUByte()

private fun Buffer.readUShortLe(): UShort = this.readShortLe().toUShort()

private fun Buffer.readUIntLe(): UInt = this.readIntLe().toUInt()

private fun Buffer.readULongLe(): ULong = this.readLongLe().toULong()

private fun Buffer.readFloatLe(): Float = Float.fromBits(this.readIntLe())

private fun Buffer.readDoubleLe(): Double = Double.fromBits(this.readLongLe())

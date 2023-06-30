package com.divpundir.mavlink.serialization

/**
 * Reads a [Byte]/Int8 from the buffer's current position, and then increments the position. Returns `0` if there are
 * not enough bytes in the buffer.
 */
public fun DataDecoder.decodeInt8(): Byte =
    decodePrimitive(Byte.SIZE_BYTES, 0, DataDecoder::decodeByte)

/**
 * Reads a [UByte]/UInt8 from the buffer's current position, and then increments the position. Returns `0u` if there are
 * not enough bytes in the buffer.
 */
public fun DataDecoder.decodeUInt8(): UByte =
    decodePrimitive(UByte.SIZE_BYTES, 0u, DataDecoder::decodeUByte)

/**
 * Reads a [Short]/Int16 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0` if there are not enough bytes in the buffer.
 */
public fun DataDecoder.decodeInt16(): Short =
    decodePrimitive(Short.SIZE_BYTES, 0, DataDecoder::decodeShort)

/**
 * Reads a [UShort]/UInt16 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0u` if there are not enough bytes in the buffer.
 */
public fun DataDecoder.decodeUInt16(): UShort =
    decodePrimitive(UShort.SIZE_BYTES, 0u, DataDecoder::decodeUShort)

/**
 * Reads a [Int]/Int32 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0` if there are not enough bytes in the buffer.
 */
public fun DataDecoder.decodeInt32(): Int =
    decodePrimitive(Int.SIZE_BYTES, 0, DataDecoder::decodeInt)

/**
 * Reads a [UInt]/UInt32 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0u` if there are not enough bytes in the buffer.
 */
public fun DataDecoder.decodeUInt32(): UInt =
    decodePrimitive(UInt.SIZE_BYTES, 0u, DataDecoder::decodeUInt)

/**
 * Reads a [Long]/Int64 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0` if there are not enough bytes in the buffer.
 */
public fun DataDecoder.decodeInt64(): Long =
    decodePrimitive(Long.SIZE_BYTES, 0, DataDecoder::decodeLong)

/**
 * Reads a [ULong]/UInt64 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0u` if there are not enough bytes in the buffer.
 */
public fun DataDecoder.decodeUInt64(): ULong =
    decodePrimitive(ULong.SIZE_BYTES, 0u, DataDecoder::decodeULong)

/**
 * Reads a [Float]/Float32 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0F` if there are not enough bytes in the buffer.
 */
public fun DataDecoder.decodeFloat(): Float =
    decodePrimitive(Float.SIZE_BYTES, 0F) { Float.fromBits(this.decodeInt()) }

/**
 * Reads a [Double]/Float64 from the buffer's current position in little-endian order, and then increments the position.
 * Returns `0.0` if there are not enough bytes in the buffer.
 */
public fun DataDecoder.decodeDouble(): Double =
    decodePrimitive(Double.SIZE_BYTES, 0.0) { Double.fromBits(this.decodeLong()) }

/**
 * Reads a [Char] from the buffer's current position, and then increments the position. Returns `\u0000` if there are
 * not enough bytes in the buffer.
 */
public fun DataDecoder.decodeChar(): Char =
    if (this.remaining >= Byte.SIZE_BYTES) decodeByte().toInt().toChar() else '\u0000'

/**
 * Reads a [String] of the given [length] from the buffer's current position using the UTF-8 encoding, and then
 * increments the position. If there are not enough bytes in the buffer, the remaining length is ignored.
 */
public fun DataDecoder.decodeString(length: Int): String {
    val data = ByteArray(length)
    if (this.remaining >= length) {
        this.decodeByteArray(data)
    } else {
        this.decodeByteArray(data, 0, this.remaining)
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
public fun DataDecoder.decodeInt8Array(dataSize: Int): List<Byte> =
    decodeArray(dataSize / Byte.SIZE_BYTES, DataDecoder::decodeInt8)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded [UByte]/UInt8 values.
 */
public fun DataDecoder.decodeUInt8Array(dataSize: Int): List<UByte> =
    decodeArray(dataSize / UByte.SIZE_BYTES, DataDecoder::decodeUInt8)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Short]/Int16 values.
 */
public fun DataDecoder.decodeInt16Array(dataSize: Int): List<Short> =
    decodeArray(dataSize / Short.SIZE_BYTES, DataDecoder::decodeInt16)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [UShort]/UInt16 values.
 */
public fun DataDecoder.decodeUInt16Array(dataSize: Int): List<UShort> =
    decodeArray(dataSize / Short.SIZE_BYTES, DataDecoder::decodeUInt16)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Int]/Int32 values.
 */
public fun DataDecoder.decodeInt32Array(dataSize: Int): List<Int> =
    decodeArray(dataSize / Int.SIZE_BYTES, DataDecoder::decodeInt32)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [UInt]/UInt32 values.
 */
public fun DataDecoder.decodeUInt32Array(dataSize: Int): List<UInt> =
    decodeArray(dataSize / Int.SIZE_BYTES, DataDecoder::decodeUInt32)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Long]/Int64 values.
 */
public fun DataDecoder.decodeInt64Array(dataSize: Int): List<Long> =
    decodeArray(dataSize / Long.SIZE_BYTES, DataDecoder::decodeInt64)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [ULong]/UInt64 values.
 */
public fun DataDecoder.decodeUInt64Array(dataSize: Int): List<ULong> =
    decodeArray(dataSize / Long.SIZE_BYTES, DataDecoder::decodeUInt64)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Float]/Float32 values.
 */
public fun DataDecoder.decodeFloatArray(dataSize: Int): List<Float> =
    decodeArray(dataSize / Float.SIZE_BYTES, DataDecoder::decodeFloat)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * [List] of the decoded little-endian [Double]/Float64 values.
 */
public fun DataDecoder.decodeDoubleArray(dataSize: Int): List<Double> =
    decodeArray(dataSize / Double.SIZE_BYTES, DataDecoder::decodeDouble)

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * little-endian [UInt] representing the MAVLink enum value.
 */
public fun DataDecoder.decodeEnumValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns a
 * little-endian [UInt] representing the MAVLink bitmask value.
 */
public fun DataDecoder.decodeBitmaskValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the buffer's current position, and then increments the position. Returns the
 * unsigned value encoded as a little-endian [Long].
 */
public fun DataDecoder.decodeUnsignedIntegerValue(dataSize: Int): Long {
    val data = ByteArray(dataSize)
    if (this.remaining >= dataSize) {
        this.decodeByteArray(data)
    } else {
        this.decodeByteArray(data, offset = 0, length = this.remaining)
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
public fun DataDecoder.decodeSignedIntegerValue(dataSize: Int): Long {
    var value = decodeUnsignedIntegerValue(dataSize)
    val signBitIndex = dataSize * Byte.SIZE_BITS - 1
    if ((value shr signBitIndex) == 1L) {
        value = value or (-1L shl signBitIndex)
    }
    return value
}

private inline fun <T : Any> DataDecoder.decodePrimitive(size: Int, default: T, decode: DataDecoder.() -> T): T {
    if (this.remaining == 0) {
        return default
    }

    if (this.remaining >= size) {
        return this.decode()
    }

    val rem = ByteArray(size)
    this.decodeByteArray(rem, offset = 0, length = this.remaining)

    return this.factory().wrap(rem).decode()
}

private inline fun <T : Any> DataDecoder.decodeArray(elementCount: Int, decode: DataDecoder.() -> T): List<T> =
    List(elementCount) { this.decode() }

private fun DataDecoder.decodeUByte(): UByte = this.decodeByte().toUByte()

private fun DataDecoder.decodeUShort(): UShort = this.decodeShort().toUShort()

private fun DataDecoder.decodeUInt(): UInt = this.decodeInt().toUInt()

private fun DataDecoder.decodeULong(): ULong = this.decodeLong().toULong()

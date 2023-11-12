package com.divpundir.mavlink.serialization

/**
 * Reads a [Byte]/Int8 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeInt8(): Byte =
    safeDecodePrimitive(Byte.SIZE_BYTES, 0, MavDataDecoder::decodeByte)

/**
 * Reads a [UByte]/UInt8 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeUInt8(): UByte =
    safeDecodePrimitive(UByte.SIZE_BYTES, 0u, MavDataDecoder::decodeUByte)

/**
 * Reads a [Short]/Int16 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeInt16(): Short =
    safeDecodePrimitive(Short.SIZE_BYTES, 0, MavDataDecoder::decodeShort)

/**
 * Reads a [UShort]/UInt16 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeUInt16(): UShort =
    safeDecodePrimitive(UShort.SIZE_BYTES, 0u, MavDataDecoder::decodeUShort)

/**
 * Reads a [Int]/Int32 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeInt32(): Int =
    safeDecodePrimitive(Int.SIZE_BYTES, 0, MavDataDecoder::decodeInt)

/**
 * Reads a [UInt]/UInt32 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeUInt32(): UInt =
    safeDecodePrimitive(UInt.SIZE_BYTES, 0u, MavDataDecoder::decodeUInt)

/**
 * Reads a [Long]/Int64 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeInt64(): Long =
    safeDecodePrimitive(Long.SIZE_BYTES, 0, MavDataDecoder::decodeLong)

/**
 * Reads a [ULong]/UInt64 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeUInt64(): ULong =
    safeDecodePrimitive(ULong.SIZE_BYTES, 0u, MavDataDecoder::decodeULong)

/**
 * Reads a [Float]/Float32 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeFloat(): Float =
    safeDecodePrimitive(Float.SIZE_BYTES, 0F) { Float.fromBits(this.decodeInt()) }

/**
 * Reads a [Double]/Float64 from the array's current position, and then increments the position. If there are not enough
 * bytes in the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeDouble(): Double =
    safeDecodePrimitive(Double.SIZE_BYTES, 0.0) { Double.fromBits(this.decodeLong()) }

/**
 * Reads a [Char] from the array's current position, and then increments the position. If there are not enough bytes in
 * the array, it assumes that the remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeChar(): Char =
    if (this.remaining >= Byte.SIZE_BYTES) decodeByte().toInt().toChar() else '\u0000'

/**
 * Reads a [String] of the given [length] from the array's current position using the UTF-8 encoding, and then
 * increments the position. If there are not enough bytes in the array, the remaining length is ignored.
 */
public fun MavDataDecoder.safeDecodeString(length: Int): String {
    val data = ByteArray(length)
    if (this.remaining >= length) {
        this.decodeByteArray(data)
    } else {
        this.decodeByteArray(data, 0, this.remaining)
    }

    for (i in 0 until length) {
        if (data[i] == 0.toByte()) return data.decodeToString(0, i)
    }
    return data.decodeToString()
}

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [Byte]/Int8 values. If there are not enough bytes in the array, it assumes that the remaining
 * length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeInt8Array(dataSize: Int): List<Byte> =
    safeDecodeArray(dataSize / Byte.SIZE_BYTES, MavDataDecoder::safeDecodeInt8)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [UByte]/UInt8 values. If there are not enough bytes in the array, it assumes that the remaining
 * length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeUInt8Array(dataSize: Int): List<UByte> =
    safeDecodeArray(dataSize / UByte.SIZE_BYTES, MavDataDecoder::safeDecodeUInt8)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [Short]/Int16 values. If there are not enough bytes in the array, it assumes that the remaining
 * length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeInt16Array(dataSize: Int): List<Short> =
    safeDecodeArray(dataSize / Short.SIZE_BYTES, MavDataDecoder::safeDecodeInt16)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [UShort]/UInt16 values. If there are not enough bytes in the array, it assumes that the
 * remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeUInt16Array(dataSize: Int): List<UShort> =
    safeDecodeArray(dataSize / Short.SIZE_BYTES, MavDataDecoder::safeDecodeUInt16)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [Int]/Int32 values. If there are not enough bytes in the array, it assumes that the remaining
 * length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeInt32Array(dataSize: Int): List<Int> =
    safeDecodeArray(dataSize / Int.SIZE_BYTES, MavDataDecoder::safeDecodeInt32)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [UInt]/UInt32 values. If there are not enough bytes in the array, it assumes that the remaining
 * length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeUInt32Array(dataSize: Int): List<UInt> =
    safeDecodeArray(dataSize / Int.SIZE_BYTES, MavDataDecoder::safeDecodeUInt32)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [Long]/Int64 values. If there are not enough bytes in the array, it assumes that the remaining
 * length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeInt64Array(dataSize: Int): List<Long> =
    safeDecodeArray(dataSize / Long.SIZE_BYTES, MavDataDecoder::safeDecodeInt64)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [ULong]/UInt64 values. If there are not enough bytes in the array, it assumes that the
 * remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeUInt64Array(dataSize: Int): List<ULong> =
    safeDecodeArray(dataSize / Long.SIZE_BYTES, MavDataDecoder::safeDecodeUInt64)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [Float]/Float32 values. If there are not enough bytes in the array, it assumes that the
 * remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeFloatArray(dataSize: Int): List<Float> =
    safeDecodeArray(dataSize / Float.SIZE_BYTES, MavDataDecoder::safeDecodeFloat)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [List] of the decoded [Double]/Float64 values. If there are not enough bytes in the array, it assumes that the
 * remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeDoubleArray(dataSize: Int): List<Double> =
    safeDecodeArray(dataSize / Double.SIZE_BYTES, MavDataDecoder::safeDecodeDouble)

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [UInt] representing the MAVLink enum value. If there are not enough bytes in the array, it assumes that the remaining
 * length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeEnumValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> safeDecodeUInt8().toUInt()
    UShort.SIZE_BYTES -> safeDecodeUInt16().toUInt()
    UInt.SIZE_BYTES -> safeDecodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns a
 * [UInt] representing the MAVLink bitmask value. If there are not enough bytes in the array, it assumes that the
 * remaining length is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeBitmaskValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> safeDecodeUInt8().toUInt()
    UShort.SIZE_BYTES -> safeDecodeUInt16().toUInt()
    UInt.SIZE_BYTES -> safeDecodeUInt32()
    else -> 0u
}

/**
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns the
 * unsigned value encoded as a [Long]. If there are not enough bytes in the array, it assumes that the remaining length
 * is padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeUnsignedInteger(dataSize: Int): Long {
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
 * Reads [dataSize] number of bytes from the array's current position, and then increments the position. Returns the
 * signed value encoded as [Long]. If there are not enough bytes in the array, it assumes that the remaining length is
 * padded with zeroes.
 */
public fun MavDataDecoder.safeDecodeSignedInteger(dataSize: Int): Long {
    var value = safeDecodeUnsignedInteger(dataSize)
    val signBitIndex = dataSize * Byte.SIZE_BITS - 1
    if ((value shr signBitIndex) == 1L) {
        value = value or (-1L shl signBitIndex)
    }
    return value
}

private inline fun <T : Any> MavDataDecoder.safeDecodePrimitive(
    size: Int,
    default: T,
    decode: MavDataDecoder.() -> T
): T {
    if (this.remaining == 0) {
        return default
    }

    if (this.remaining >= size) {
        return this.decode()
    }

    val rem = ByteArray(size)
    this.decodeByteArray(rem, offset = 0, length = this.remaining)

    return MavDataDecoder.wrap(rem).decode()
}

private inline fun <T : Any> MavDataDecoder.safeDecodeArray(
    elementCount: Int,
    decode: MavDataDecoder.() -> T
): List<T> =
    List(elementCount) { this.decode() }

private fun MavDataDecoder.decodeUByte(): UByte = this.decodeByte().toUByte()

private fun MavDataDecoder.decodeUShort(): UShort = this.decodeShort().toUShort()

private fun MavDataDecoder.decodeUInt(): UInt = this.decodeInt().toUInt()

private fun MavDataDecoder.decodeULong(): ULong = this.decodeLong().toULong()

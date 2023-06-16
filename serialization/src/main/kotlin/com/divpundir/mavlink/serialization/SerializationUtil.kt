package com.divpundir.mavlink.serialization

import okio.Buffer

/**
 * Writes the given [Byte]/Int8 to the buffer's current position, and then increments the position.
 */
public fun Buffer.encodeInt8(value: Byte) {
    this.writeByte(value.toInt())
}

/**
 * Writes the given [UByte]/UInt8 to the buffer's current position, and then increments the position.
 */
public fun Buffer.encodeUInt8(value: UByte) {
    this.writeByte(value.toInt())
}

/**
 * Writes the given [Short]/Int16 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun Buffer.encodeInt16(value: Short) {
    this.writeShortLe(value.toInt())
}

/**
 * Writes the given [UShort]/UInt16 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun Buffer.encodeUInt16(value: UShort) {
    this.writeShortLe(value.toInt())
}

/**
 * Writes the given [Int]/Int32 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun Buffer.encodeInt32(value: Int) {
    this.writeIntLe(value)
}

/**
 * Writes the given [UInt]/UInt32 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun Buffer.encodeUInt32(value: UInt) {
    this.writeIntLe(value.toInt())
}

/**
 * Writes the given [Long]/Int64 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun Buffer.encodeInt64(value: Long) {
    this.writeLongLe(value)
}

/**
 * Writes the given [ULong]/UInt64 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun Buffer.encodeUInt64(value: ULong) {
    this.writeLongLe(value.toLong())
}

/**
 * Writes the given [Float]/Float32 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun Buffer.encodeFloat(value: Float) {
    this.writeIntLe(value.toBits())
}

/**
 * Writes the given [Double]/Float64 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun Buffer.encodeDouble(value: Double) {
    this.writeLongLe(value.toBits())
}

/**
 * Writes the given [Char]/UInt64 to the buffer's current position, and then increments the position.
 */
public fun Buffer.encodeChar(value: Char) {
    this.writeByte(value.code)
}

/**
 * Writes the given [String] to the buffer's current position, and then increments the position. If the encoded [String]
 * is shorter than the [length] parameter then the remaining positions are filled with empty characters.
 */
public fun Buffer.encodeString(value: String, length: Int) {
    val data = value.toByteArray(charset = Charsets.UTF_8).copyOf(newSize = length)
    this.write(data)
}

/**
 * Encodes the given [List] of [Byte]/Int8 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeInt8Array(arr: List<Byte>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Byte.SIZE_BYTES, 0, Buffer::encodeInt8)

/**
 * Encodes the given [List] of [UByte]/UInt8 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeUInt8Array(arr: List<UByte>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / UByte.SIZE_BYTES, 0u, Buffer::encodeUInt8)

/**
 * Encodes the given [List] of [Short]/Int16 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeInt16Array(arr: List<Short>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Short.SIZE_BYTES, 0, Buffer::encodeInt16)

/**
 * Encodes the given [List] of [UShort]/UInt16 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeUInt16Array(arr: List<UShort>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / UShort.SIZE_BYTES, 0u, Buffer::encodeUInt16)

/**
 * Encodes the given [List] of [Int]/Int32 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeInt32Array(arr: List<Int>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Int.SIZE_BYTES, 0, Buffer::encodeInt32)

/**
 * Encodes the given [List] of [UInt]/UInt32 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeUInt32Array(arr: List<UInt>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / UInt.SIZE_BYTES, 0u, Buffer::encodeUInt32)

/**
 * Encodes the given [List] of [Long]/Int64 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeInt64Array(arr: List<Long>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Long.SIZE_BYTES, 0L, Buffer::encodeInt64)

/**
 * Encodes the given [List] of [ULong]/UInt64 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeUInt64Array(arr: List<ULong>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / ULong.SIZE_BYTES, 0uL, Buffer::encodeUInt64)

/**
 * Encodes the given [List] of [Float]/Float32 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeFloatArray(arr: List<Float>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Float.SIZE_BYTES, 0F, Buffer::encodeFloat)

/**
 * Encodes the given [List] of [Double]/Float64 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeDoubleArray(arr: List<Double>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Double.SIZE_BYTES, 0.0, Buffer::encodeDouble)

/**
 * Encodes the given [UInt] MAVLink enum value into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeEnumValue(value: UInt, dataSize: Int) {
    when (dataSize) {
        UByte.SIZE_BYTES -> encodeUInt8(value.toUByte())
        UShort.SIZE_BYTES -> encodeUInt16(value.toUShort())
        UInt.SIZE_BYTES -> encodeUInt32(value)
        else -> {}
    }
}

/**
 * Encodes the given [UInt] MAVLink bitmask value into a [ByteArray] of size [dataSize], writes it to the buffer's
 * current position in little-endian order, and then increments the position.
 */
public fun Buffer.encodeBitmaskValue(value: UInt, dataSize: Int) {
    when (dataSize) {
        UByte.SIZE_BYTES -> encodeUInt8(value.toUByte())
        UShort.SIZE_BYTES -> encodeUInt16(value.toUShort())
        UInt.SIZE_BYTES -> encodeUInt32(value)
        else -> {}
    }
}

/**
 * Encodes the given [Long] into a [ByteArray] of size [dataSize], writes it to the buffer's current position in
 * little-endian order, and then increments the position.
 */
public fun Buffer.encodeIntegerValue(value: Long, dataSize: Int) {
    for (shift in 0 until dataSize) {
        this.writeByte(((value shr (shift * 8)) and 0xFF).toInt())
    }
}

/**
 * Returns a new [Buffer] with all the trailing zeros removed.
 */
public fun Buffer.truncateZeros(): Buffer {
    var trailingZeroCount = 0
    for (i in this.size - 1 downTo 0) {
        if (this[i] == 0.toByte()) {
            trailingZeroCount++
        } else {
            break
        }
    }

    val truncatedBuffer = Buffer()
    this.copyTo(truncatedBuffer, offset = 0, byteCount = (this.size - trailingZeroCount))

    return truncatedBuffer
}

private inline fun <T : Any> Buffer.encodeArray(
    arr: List<T>,
    elementCount: Int,
    defaultValue: T,
    encode: Buffer.(T) -> Unit
) {
    for (i in 0 until elementCount) this.encode(if (i < arr.size) arr[i] else defaultValue)
}

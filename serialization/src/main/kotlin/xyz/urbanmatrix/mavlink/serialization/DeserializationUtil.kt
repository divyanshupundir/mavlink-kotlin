package xyz.urbanmatrix.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.StandardCharsets

public fun ByteBuffer.decodeInt8(): Byte =
    decodePrimitive(Byte.SIZE_BYTES, 0, ByteBuffer::get)

public fun ByteBuffer.decodeUInt8(): UByte =
    decodePrimitive(UByte.SIZE_BYTES, 0u, ByteBuffer::getUByte)

public fun ByteBuffer.decodeInt16(): Short =
    decodePrimitive(Short.SIZE_BYTES, 0, ByteBuffer::getShort)

public fun ByteBuffer.decodeUInt16(): UShort =
    decodePrimitive(UShort.SIZE_BYTES, 0u, ByteBuffer::getUShort)

public fun ByteBuffer.decodeInt32(): Int =
    decodePrimitive(Int.SIZE_BYTES, 0, ByteBuffer::getInt)

public fun ByteBuffer.decodeUInt32(): UInt =
    decodePrimitive(UInt.SIZE_BYTES, 0u, ByteBuffer::getUInt)

public fun ByteBuffer.decodeInt64(): Long =
    decodePrimitive(Long.SIZE_BYTES, 0, ByteBuffer::getLong)

public fun ByteBuffer.decodeUInt64(): ULong =
    decodePrimitive(ULong.SIZE_BYTES, 0u, ByteBuffer::getULong)

public fun ByteBuffer.decodeFloat(): Float =
    decodePrimitive(Float.SIZE_BYTES, 0F, ByteBuffer::getFloat)

public fun ByteBuffer.decodeDouble(): Double =
    decodePrimitive(Double.SIZE_BYTES, 0.0, ByteBuffer::getDouble)

public fun ByteBuffer.decodeChar(): Char =
    if (this.remaining() >= Byte.SIZE_BYTES) get().toInt().toChar() else '\u0000'

public fun ByteBuffer.decodeString(length: Int): String {
    val data = ByteArray(length) { if (this.hasRemaining()) this.get() else 0 }

    for (i in 0 until length) {
        if (data[i] == 0.toByte()) return String(data, 0, i, StandardCharsets.UTF_8)
    }
    return String(data, StandardCharsets.UTF_8)
}

public fun ByteBuffer.decodeInt8Array(dataSize: Int): List<Byte> =
    decodeArray(dataSize / Byte.SIZE_BYTES, ByteBuffer::decodeInt8)

public fun ByteBuffer.decodeUInt8Array(dataSize: Int): List<UByte> =
    decodeArray(dataSize / UByte.SIZE_BYTES, ByteBuffer::decodeUInt8)

public fun ByteBuffer.decodeInt16Array(dataSize: Int): List<Short> =
    decodeArray(dataSize / Short.SIZE_BYTES, ByteBuffer::decodeInt16)

public fun ByteBuffer.decodeUInt16Array(dataSize: Int): List<UShort> =
    decodeArray(dataSize / Short.SIZE_BYTES, ByteBuffer::decodeUInt16)

public fun ByteBuffer.decodeInt32Array(dataSize: Int): List<Int> =
    decodeArray(dataSize / Int.SIZE_BYTES, ByteBuffer::decodeInt32)

public fun ByteBuffer.decodeUInt32Array(dataSize: Int): List<UInt> =
    decodeArray(dataSize / Int.SIZE_BYTES, ByteBuffer::decodeUInt32)

public fun ByteBuffer.decodeInt64Array(dataSize: Int): List<Long> =
    decodeArray(dataSize / Long.SIZE_BYTES, ByteBuffer::decodeInt64)

public fun ByteBuffer.decodeUInt64Array(dataSize: Int): List<ULong> =
    decodeArray(dataSize / Long.SIZE_BYTES, ByteBuffer::decodeUInt64)

public fun ByteBuffer.decodeFloatArray(dataSize: Int): List<Float> =
    decodeArray(dataSize / Float.SIZE_BYTES, ByteBuffer::decodeFloat)

public fun ByteBuffer.decodeDoubleArray(dataSize: Int): List<Double> =
    decodeArray(dataSize / Double.SIZE_BYTES, ByteBuffer::decodeDouble)

public fun ByteBuffer.decodeEnumValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

public fun ByteBuffer.decodeBitmaskValue(dataSize: Int): UInt = when (dataSize) {
    UByte.SIZE_BYTES -> decodeUInt8().toUInt()
    UShort.SIZE_BYTES -> decodeUInt16().toUInt()
    UInt.SIZE_BYTES -> decodeUInt32()
    else -> 0u
}

public inline fun <T : Any> ByteBuffer.decodeArray(elementCount: Int, decode: ByteBuffer.() -> T): List<T> =
    List(elementCount) { this.decode() }

public fun ByteBuffer.decodeUnsignedIntegerValue(dataSize: Int): Long {
    val data = ByteArray(dataSize) { if (this.hasRemaining()) this.get() else 0 }

    if (this.order() == ByteOrder.BIG_ENDIAN) data.reverse()

    var value: Long = 0
    for (i in 0 until dataSize) {
        value = value or ((data[i].toLong() and 0xFF.toLong()) shl (i * Byte.SIZE_BITS))
    }
    return value
}

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

private fun ByteBuffer.getUByte(): UByte = this.get().toUByte()

private fun ByteBuffer.getUShort(): UShort = this.short.toUShort()

private fun ByteBuffer.getUInt(): UInt = this.int.toUInt()

private fun ByteBuffer.getULong(): ULong = this.long.toULong()

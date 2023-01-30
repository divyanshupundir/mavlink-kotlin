package xyz.urbanmatrix.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

public fun ByteBuffer.decodeInt8(): Byte =
    if (this.remaining() >= Byte.SIZE_BYTES) this.get() else 0

public fun ByteBuffer.decodeUInt8(): UByte =
    if (this.remaining() >= UByte.SIZE_BYTES) this.get().toUByte() else 0u

public fun ByteBuffer.decodeInt16(): Short =
    if (this.remaining() >= Short.SIZE_BYTES) this.short else 0

public fun ByteBuffer.decodeUInt16(): UShort =
    if (this.remaining() >= UShort.SIZE_BYTES) this.short.toUShort() else 0u

public fun ByteBuffer.decodeInt32(): Int =
    if (this.remaining() >= Int.SIZE_BYTES) this.int else 0

public fun ByteBuffer.decodeUInt32(): UInt =
    if (this.remaining() >= UInt.SIZE_BYTES) this.int.toUInt() else 0u

public fun ByteBuffer.decodeInt64(): Long =
    if (this.remaining() >= Long.SIZE_BYTES) this.long else 0L

public fun ByteBuffer.decodeUInt64(): ULong =
    if (this.remaining() >= ULong.SIZE_BYTES) this.long.toULong() else 0uL

public fun ByteBuffer.decodeFloat(): Float =
    if (this.remaining() >= Float.SIZE_BYTES) this.float else 0F

public fun ByteBuffer.decodeDouble(): Double =
    if (this.remaining() >= Double.SIZE_BYTES) this.double else 0.0

public fun ByteBuffer.decodeChar(): Char =
    if (this.remaining() >= Byte.SIZE_BYTES) get().toInt().toChar() else '\u0000'

public fun ByteBuffer.decodeString(length: Int): String {
    val data = ByteArray(length) { if (this.hasRemaining()) this.get() else 0 }

    for (i in 0 until length) {
        if (data[i] == 0.toByte()) return String(data, 0, i, StandardCharsets.UTF_8)
    }
    return String(data, StandardCharsets.UTF_8)
}

public fun ByteBuffer.decodeInt8Array(dataSize: Int): List<Byte> = decodeArray(
    dataSize / Byte.SIZE_BYTES,
    ByteBuffer::decodeInt8
)

public fun ByteBuffer.decodeUInt8Array(dataSize: Int): List<UByte> = decodeArray(
    dataSize / UByte.SIZE_BYTES,
    ByteBuffer::decodeUInt8
)

public fun ByteBuffer.decodeInt16Array(dataSize: Int): List<Short> = decodeArray(
    dataSize / Short.SIZE_BYTES,
    ByteBuffer::decodeInt16
)

public fun ByteBuffer.decodeUInt16Array(dataSize: Int): List<UShort> = decodeArray(
    dataSize / Short.SIZE_BYTES,
    ByteBuffer::decodeUInt16
)

public fun ByteBuffer.decodeInt32Array(dataSize: Int): List<Int> = decodeArray(
    dataSize / Int.SIZE_BYTES,
    ByteBuffer::decodeInt32
)

public fun ByteBuffer.decodeUInt32Array(dataSize: Int): List<UInt> = decodeArray(
    dataSize / Int.SIZE_BYTES,
    ByteBuffer::decodeUInt32
)

public fun ByteBuffer.decodeInt64Array(dataSize: Int): List<Long> = decodeArray(
    dataSize / Long.SIZE_BYTES,
    ByteBuffer::decodeInt64
)

public fun ByteBuffer.decodeUInt64Array(dataSize: Int): List<ULong> = decodeArray(
    dataSize / Long.SIZE_BYTES,
    ByteBuffer::decodeUInt64
)

public fun ByteBuffer.decodeFloatArray(dataSize: Int): List<Float> = decodeArray(
    dataSize / Float.SIZE_BYTES,
    ByteBuffer::decodeFloat
)

public fun ByteBuffer.decodeDoubleArray(dataSize: Int): List<Double> = decodeArray(
    dataSize / Double.SIZE_BYTES,
    ByteBuffer::decodeDouble
)

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

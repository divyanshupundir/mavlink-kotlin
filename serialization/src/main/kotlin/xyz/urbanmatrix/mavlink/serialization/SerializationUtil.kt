package xyz.urbanmatrix.mavlink.serialization

import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

public fun ByteBuffer.encodeInt8(value: Byte) {
    if (this.remaining() >= Byte.SIZE_BYTES) this.put(value)
}

public fun ByteBuffer.encodeUInt8(value: UByte) {
    if (this.remaining() >= UByte.SIZE_BYTES) this.put(value.toByte())
}

public fun ByteBuffer.encodeInt16(value: Short) {
    if (this.remaining() >= Short.SIZE_BYTES) this.putShort(value)
}

public fun ByteBuffer.encodeUInt16(value: UShort) {
    if (this.remaining() >= UShort.SIZE_BYTES) this.putShort(value.toShort())
}

public fun ByteBuffer.encodeInt32(value: Int) {
    if (this.remaining() >= Int.SIZE_BYTES) this.putInt(value)
}

public fun ByteBuffer.encodeUInt32(value: UInt) {
    if (this.remaining() >= UInt.SIZE_BYTES) this.putInt(value.toInt())
}

public fun ByteBuffer.encodeInt64(value: Long) {
    if (this.remaining() >= Long.SIZE_BYTES) this.putLong(value)
}

public fun ByteBuffer.encodeUInt64(value: ULong) {
    if (this.remaining() >= ULong.SIZE_BYTES) this.putLong(value.toLong())
}

public fun ByteBuffer.encodeFloat(value: Float) {
    if (this.remaining() >= Float.SIZE_BYTES) this.putFloat(value)
}

public fun ByteBuffer.encodeDouble(value: Double) {
    if (this.remaining() >= Double.SIZE_BYTES) this.putDouble(value)
}

public fun ByteBuffer.encodeChar(value: Char) {
    if (this.remaining() >= Byte.SIZE_BYTES) this.put(value.code.toByte())
}

public fun ByteBuffer.encodeString(value: String, length: Int) {
    val data = value.toByteArray(charset = StandardCharsets.UTF_8)

    for (i in 0 until length) {
        if (this.hasRemaining()) this.put(if (i < data.size) data[i] else 0)
    }
}

public fun ByteBuffer.encodeInt8Array(arr: List<Byte>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Byte.SIZE_BYTES,
    0,
    ByteBuffer::encodeInt8
)

public fun ByteBuffer.encodeUInt8Array(arr: List<UByte>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / UByte.SIZE_BYTES,
    0u,
    ByteBuffer::encodeUInt8
)

public fun ByteBuffer.encodeInt16Array(arr: List<Short>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Short.SIZE_BYTES,
    0,
    ByteBuffer::encodeInt16
)

public fun ByteBuffer.encodeUInt16Array(arr: List<UShort>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / UShort.SIZE_BYTES,
    0u,
    ByteBuffer::encodeUInt16
)

public fun ByteBuffer.encodeInt32Array(arr: List<Int>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Int.SIZE_BYTES,
    0,
    ByteBuffer::encodeInt32
)

public fun ByteBuffer.encodeUInt32Array(arr: List<UInt>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Int.SIZE_BYTES,
    0u,
    ByteBuffer::encodeUInt32
)

public fun ByteBuffer.encodeInt64Array(arr: List<Long>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Long.SIZE_BYTES,
    0L,
    ByteBuffer::encodeInt64
)

public fun ByteBuffer.encodeUInt64Array(arr: List<ULong>, dataSize: Int): Unit = encodeArray(
    arr,
    dataSize / Long.SIZE_BYTES,
    0uL,
    ByteBuffer::encodeUInt64
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

public fun ByteBuffer.encodeEnumValue(value: UInt, dataSize: Int) {
    when (dataSize) {
        UByte.SIZE_BYTES -> encodeUInt8(value.toUByte())
        UShort.SIZE_BYTES -> encodeUInt16(value.toUShort())
        UInt.SIZE_BYTES -> encodeUInt32(value)
        else -> {}
    }
}

public fun ByteBuffer.encodeBitmaskValue(value: UInt, dataSize: Int) {
    when (dataSize) {
        UByte.SIZE_BYTES -> encodeUInt8(value.toUByte())
        UShort.SIZE_BYTES -> encodeUInt16(value.toUShort())
        UInt.SIZE_BYTES -> encodeUInt32(value)
        else -> {}
    }
}

public inline fun <T : Any> ByteBuffer.encodeArray(
    arr: List<T>,
    elementCount: Int,
    defaultValue: T,
    encode: ByteBuffer.(T) -> Unit
) {
    for (i in 0 until elementCount) this.encode(if (i < arr.size) arr[i] else defaultValue)
}

public fun ByteArray.truncateZeros(): ByteArray {
    for (index in lastIndex downTo 0) {
        if (this[index] != 0.toByte()) {
            return this.copyOfRange(0, index + 1)
        }
    }
    return ByteArray(0)
}

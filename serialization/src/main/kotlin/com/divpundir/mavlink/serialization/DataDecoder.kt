package com.divpundir.mavlink.serialization

public interface DataDecoder {

    public val remaining: Int

    public fun decodeByte(): Byte

    public fun decodeShort(): Short

    public fun decodeInt(): Int

    public fun decodeLong(): Long

    public fun decodeByteArray(dst: ByteArray)

    public interface Factory {

        public fun wrap(bytes: ByteArray): DataDecoder
    }
}

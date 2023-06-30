package com.divpundir.mavlink.serialization

public interface DataDecoder {

    public val remaining: Int

    public fun decodeByte(): Byte

    public fun decodeShort(): Short

    public fun decodeInt(): Int

    public fun decodeLong(): Long

    public fun decodeByteArray(dst: ByteArray, offset: Int = 0, length: Int = dst.size)

    public fun factory(): Factory

    public interface Factory {

        public fun wrap(bytes: ByteArray): DataDecoder
    }
}

package com.divpundir.mavlink.serialization

public interface DataEncoder {

    public val bytes: ByteArray

    public val remaining: Int

    public fun encodeByte(value: Byte)

    public fun encodeShort(value: Short)

    public fun encodeInt(value: Int)

    public fun encodeLong(value: Long)

    public fun encodeByteArray(src: ByteArray)

    public interface Factory {

        public fun allocate(size: Int): DataEncoder
    }
}

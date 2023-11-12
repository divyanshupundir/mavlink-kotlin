package com.divpundir.mavlink.serialization

private class NonJvmMavDataEncoder(size: Int) : MavDataEncoder {

    override val bytes: ByteArray
        get() = TODO("Not yet implemented")

    override val remaining: Int
        get() = TODO("Not yet implemented")

    override fun encodeByte(value: Byte) {
        TODO("Not yet implemented")
    }

    override fun encodeShort(value: Short) {
        TODO("Not yet implemented")
    }

    override fun encodeInt(value: Int) {
        TODO("Not yet implemented")
    }

    override fun encodeLong(value: Long) {
        TODO("Not yet implemented")
    }

    override fun encodeByteArray(src: ByteArray, offset: Int, length: Int) {
        TODO("Not yet implemented")
    }
}

public actual fun MavDataEncoder(size: Int): MavDataEncoder = NonJvmMavDataEncoder(size)

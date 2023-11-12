package com.divpundir.mavlink.serialization

private class NativeMavDataDecoder(bytes: ByteArray) : MavDataDecoder {

    override val remaining: Int
        get() = TODO("Not yet implemented")

    override fun decodeByte(): Byte {
        TODO("Not yet implemented")
    }

    override fun decodeShort(): Short {
        TODO("Not yet implemented")
    }

    override fun decodeInt(): Int {
        TODO("Not yet implemented")
    }

    override fun decodeLong(): Long {
        TODO("Not yet implemented")
    }

    override fun decodeByteArray(dst: ByteArray, offset: Int, length: Int) {
        TODO("Not yet implemented")
    }
}

public actual fun MavDataDecoder(bytes: ByteArray): MavDataDecoder = NativeMavDataDecoder(bytes)

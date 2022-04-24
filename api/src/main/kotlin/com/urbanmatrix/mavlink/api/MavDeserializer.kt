package com.urbanmatrix.mavlink.api

interface MavDeserializer<T> {
    @Throws(MavlinkDeserializationException::class)
    fun deserialize(messageBytes: ByteArray): T
}

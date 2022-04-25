package com.urbanmatrix.mavlink.api

interface MavDeserializer<T> {
    @Throws(MavDeserializationException::class)
    fun deserialize(messageBytes: ByteArray): T
}

package com.urbanmatrix.mavlink.api

interface MavMessage<T : MavMessage<T>> {

    val instanceMetadata: Metadata<T>

    fun serialize(): ByteArray

    data class Metadata<T : MavMessage<T>>(
        val id: Int,
        val crc: Int,
        val deserializer: MavDeserializer<T>
    )
}

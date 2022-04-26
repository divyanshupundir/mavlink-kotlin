package com.urbanmatrix.mavlink.api

interface MavMessage<T : MavMessage<T>> {

    /**
     * The instance property which returns [Metadata] of this class.
     *
     * The generated messages also have a static classMetadata property,
     * which returns the same object.
     */
    val instanceMetadata: Metadata<T>

    /**
     * Serializes the message to a [ByteArray].
     */
    fun serialize(): ByteArray

    /**
     * Contains the MAVLink metadata for the message and also a [MavDeserializer]
     * object.
     */
    data class Metadata<T : MavMessage<T>>(
        val id: Int,
        val crc: Int,
        val deserializer: MavDeserializer<T>
    )
}

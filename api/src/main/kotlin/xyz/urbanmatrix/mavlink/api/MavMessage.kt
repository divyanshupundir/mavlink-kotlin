package xyz.urbanmatrix.mavlink.api

interface MavMessage<T : MavMessage<T>> {

    /**
     * The instance property which returns [Metadata] of this class.
     *
     * The generated messages also have a static classMetadata property,
     * which returns the same object.
     */
    val instanceMetadata: Metadata<T>

    /**
     * Serializes the message to a [ByteArray] according to MAVLink v1 scheme.
     * Extensions are not serialized.
     */
    fun serializeV1(): ByteArray

    /**
     * Serializes the message to a [ByteArray] according to MAVLink v2 scheme.
     * Extensions are also serialized and payload truncation is applied.
     */
    fun serializeV2(): ByteArray

    /**
     * Contains the MAVLink metadata for the message and also a
     * [MavDeserializer] object.
     */
    data class Metadata<T : MavMessage<T>>(
        val id: Int,
        val crc: Int,
        val deserializer: MavDeserializer<T>
    )
}

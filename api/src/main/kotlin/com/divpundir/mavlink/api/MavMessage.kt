package com.divpundir.mavlink.api

/**
 * A high level MAVLink message.
 *
 * MAVLink messages are defined in XML files and represented as data classes in mavlink-kotlin.
 */
public interface MavMessage<T : MavMessage<T>> {

    /**
     * The instance property which returns [Metadata] of this class.
     *
     * The generated messages also have a static classMetadata property, which returns the same object.
     */
    public val instanceMetadata: Metadata<T>

    /**
     * Serializes the message to a [ByteArray] according to MAVLink v1 scheme. Extensions are not serialized.
     */
    public fun serializeV1(): ByteArray

    /**
     * Serializes the message to a [ByteArray] according to MAVLink v2 scheme. Extensions are also serialized and
     * payload truncation is applied.
     */
    public fun serializeV2(): ByteArray

    /**
     * Contains the MAVLink metadata for the message and also a [MavDeserializer] object.
     */
    public data class Metadata<T : MavMessage<T>>(
        val id: UInt,
        val crcExtra: Byte,
        val deserializer: MavDeserializer<T>
    )

    public interface Companion<T : MavMessage<T>> {
        public val classMetadata: Metadata<T>
    }
}

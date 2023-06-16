package com.divpundir.mavlink.api

import okio.Buffer

/**
 * A high level MAVLink message.
 *
 * MAVLink messages are defined in XML files and represented as data classes in mavlink-kotlin.
 */
public interface MavMessage<T : MavMessage<T>> {

    /**
     * The instance property which returns [MavCompanion] of this class.
     */
    public val instanceCompanion: MavCompanion<T>

    /**
     * Serializes the message to a [Buffer] according to MAVLink v1 scheme. Extensions are not serialized.
     */
    public fun serializeV1(): Buffer

    /**
     * Serializes the message to a [Buffer] according to MAVLink v2 scheme. Extensions are also serialized and payload
     * truncation is applied.
     */
    public fun serializeV2(): Buffer

    /**
     * The companion object for a [MavMessage], which contains the MAVLink metadata and the [MavDeserializer]
     * implementation for the message.
     */
    public interface MavCompanion<T : MavMessage<T>> : MavDeserializer<T> {
        public val id: UInt
        public val crcExtra: Byte
    }
}

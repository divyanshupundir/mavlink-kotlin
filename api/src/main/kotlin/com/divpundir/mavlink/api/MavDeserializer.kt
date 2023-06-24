package com.divpundir.mavlink.api

public fun interface MavDeserializer<T> {

    /**
     * Deserializes the given [bytes] to a MAVLink message. Note that these bytes are not the entire MAVLink frame, but
     * only its payload.
     *
     * @throws MavDeserializationException if the data is corrupt or doesn't correspond to the MAVLink message
     * associated with this [MavDeserializer].
     */
    @Throws(MavDeserializationException::class)
    public fun deserialize(bytes: ByteArray): T
}

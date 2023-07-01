package com.divpundir.mavlink.api

public fun interface MavDeserializer<T> {

    /**
     * Deserializes the given [bytes] to a MAVLink message. Note that these bytes are not the entire MAVLink frame, but
     * only its payload.
     */
    public fun deserialize(bytes: ByteArray): T
}

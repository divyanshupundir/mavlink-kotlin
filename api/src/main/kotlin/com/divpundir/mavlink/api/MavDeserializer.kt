package com.divpundir.mavlink.api

public fun interface MavDeserializer<T> {

    /**
     * Deserializes a [ByteArray] as a MAVLink message. Note that these bytes are not the entire MAVLink frame, but only
     * its payload.
     *
     * @param bytes The MAVLink message in the form of bytes.
     * @throws MavDeserializationException if the data is corrupt or doesn't correspond to the MAVLink message
     * associated with this [MavDeserializer]
     */
    @Throws(MavDeserializationException::class)
    public fun deserialize(bytes: ByteArray): T
}

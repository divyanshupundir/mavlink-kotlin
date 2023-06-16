package com.divpundir.mavlink.api

import okio.Buffer

public fun interface MavDeserializer<T> {

    /**
     * Deserializes the given [buffer] as a MAVLink message. Note that these bytes are not the entire MAVLink frame, but
     * only its payload.
     *
     * @throws MavDeserializationException if the data is corrupt or doesn't correspond to the MAVLink message
     * associated with this [MavDeserializer].
     */
    @Throws(MavDeserializationException::class)
    public fun deserialize(buffer: Buffer): T
}

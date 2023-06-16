package com.divpundir.mavlink.api

import okio.BufferedSource

public fun interface MavDeserializer<T> {

    /**
     * Deserializes the given [source] as a MAVLink message. Note that these bytes are not the entire MAVLink frame, but
     * only its payload.
     *
     * @throws MavDeserializationException if the data is corrupt or doesn't correspond to the MAVLink message
     * associated with this [MavDeserializer].
     */
    @Throws(MavDeserializationException::class)
    public fun deserialize(source: BufferedSource): T
}

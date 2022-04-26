package com.urbanmatrix.mavlink.api

interface MavDeserializer<T> {

    /**
     * Deserializes a [ByteArray] as a MAVLink message.
     *
     * @param messageBytes The MAVLink message in the form of bytes.
     * @throws MavDeserializationException if the data is corrupt or doesn't
     * correspond to the MAVLink message associated with this [MavDeserializer]
     */
    @Throws(MavDeserializationException::class)
    fun deserialize(messageBytes: ByteArray): T
}

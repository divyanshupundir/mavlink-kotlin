package com.urbanmatrix.mavlink.api

/**
 * Serves as an index of a Mavlink dialect.
 */
interface MavDialect {
    /**
     * Resolves the class of a message by its ID.
     *
     * @param messageId The ID of the message to resolve.
     * @return The class of the message of the specified ID.
     */
    fun resolveMetadataOrNull(messageId: Int): MavMessage.Metadata<out MavMessage<*>>?

    /**
     * Checks whether this dialect supports the message of the specified ID.
     *
     * @param messageId The ID of the message to check support for.
     * @return `true` if this dialect supports the message of the specified ID,
     * or `false` otherwise.
     */
    fun supports(messageId: Int): Boolean
}

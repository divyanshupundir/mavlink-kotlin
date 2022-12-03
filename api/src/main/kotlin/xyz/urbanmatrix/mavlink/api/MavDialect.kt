package xyz.urbanmatrix.mavlink.api

public interface MavDialect {
    /**
     * Resolves the metadata of a message by its ID.
     *
     * @param messageId The ID of the message to resolve.
     * @return The metadata of the message of the specified ID.
     */
    public fun resolveMetadataOrNull(messageId: Int): MavMessage.Metadata<out MavMessage<*>>?

    /**
     * Checks whether this dialect supports the message of the specified ID.
     *
     * @param messageId The ID of the message to check support for.
     * @return `true` if this dialect supports the message of the specified ID,
     * or `false` otherwise.
     */
    public fun supports(messageId: Int): Boolean
}

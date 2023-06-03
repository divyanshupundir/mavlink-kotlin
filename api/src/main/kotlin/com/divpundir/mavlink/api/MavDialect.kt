package com.divpundir.mavlink.api

public interface MavDialect {

    /**
     * Searches the dialect and its dependencies for the [MavMessage.MavCompanion] of the given [messageId]. Returns the
     * object if found, null otherwise.
     */
    public fun resolveCompanionOrNull(messageId: UInt): MavMessage.MavCompanion<out MavMessage<*>>?

    /**
     * Checks whether this dialect supports the message of the specified [messageId].
     */
    public fun supports(messageId: UInt): Boolean
}

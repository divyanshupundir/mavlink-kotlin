package com.divpundir.mavlink.api

public abstract class AbstractMavDialect(
    private val dependencies: Set<MavDialect>,
    private val messages: Map<UInt, MavMessage.MavCompanion<out MavMessage<*>>>
) : MavDialect {

    override fun resolveCompanionOrNull(messageId: UInt): MavMessage.MavCompanion<out MavMessage<*>>? {
        if (messages.containsKey(messageId)) {
            return messages[messageId]
        } else {
            for (dependency in dependencies) {
                val result = dependency.resolveCompanionOrNull(messageId)
                if (result != null) {
                    return result
                }
            }
        }
        return null
    }

    override fun supports(messageId: UInt): Boolean {
        if (messages.containsKey(messageId)) {
            return true
        } else {
            for (dependency in dependencies) {
                if (dependency.supports(messageId)) {
                    return true
                }
            }
        }
        return false
    }
}

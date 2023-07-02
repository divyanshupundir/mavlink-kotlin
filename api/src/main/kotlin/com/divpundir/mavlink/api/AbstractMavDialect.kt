package com.divpundir.mavlink.api

import kotlinx.collections.immutable.toPersistentHashMap
import kotlinx.collections.immutable.toPersistentSet

public abstract class AbstractMavDialect(
    dependencies: Set<MavDialect>,
    messages: Map<UInt, MavMessage.MavCompanion<out MavMessage<*>>>
) : MavDialect {

    override val dependencies: Set<MavDialect> = dependencies.toPersistentSet()

    override val messages: Map<UInt, MavMessage.MavCompanion<out MavMessage<*>>> = messages.toPersistentHashMap()

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

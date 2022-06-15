package com.urbanmatrix.mavlink.api

abstract class AbstractMavDialect(
    private val dependencies: Set<MavDialect>,
    private val messages: Map<Int, MavMessage.Metadata<out MavMessage<*>>>
) : MavDialect {

    override fun resolveMetadataOrNull(messageId: Int): MavMessage.Metadata<out MavMessage<*>>? {
        if (messages.containsKey(messageId)) {
            return messages[messageId]
        } else {
            for (dependency in dependencies) {
                val result = dependency.resolveMetadataOrNull(messageId)
                if (result != null) {
                    return result
                }
            }
        }
        return null
    }

    override fun supports(messageId: Int): Boolean {
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

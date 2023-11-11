package com.divpundir.mavlink.api

/**
 * Wrapper class for a [MavBitmask].
 */
public class MavBitmaskValue<E : MavBitmask> private constructor(public val flags: List<E>, public val value: UInt) {

    public companion object {

        public fun <E : MavBitmask> of(flags: List<E>): MavBitmaskValue<E> = MavBitmaskValue(
            flags,
            flags.map { it.value }
                .reduceOrNull { bitmask, value -> bitmask or value }
                ?: 0u
        )

        public fun <E : MavBitmask> of(vararg flags: E): MavBitmaskValue<E> = of(flags.asList())

        public fun <E : MavBitmask> fromValue(value: UInt): MavBitmaskValue<E> = MavBitmaskValue(emptyList(), value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as MavBitmaskValue<*>

        return value == other.value
    }

    override fun hashCode(): Int = value.hashCode()

    override fun toString(): String = "MavBitmaskValue(flags=$flags, value=$value)"
}

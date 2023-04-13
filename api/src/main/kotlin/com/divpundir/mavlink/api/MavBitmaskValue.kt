package com.divpundir.mavlink.api

/**
 * Wrapper class for a [MavBitmask].
 */
public class MavBitmaskValue<E : MavBitmask> private constructor(public val flags: List<E>, public val value: UInt) {

    public companion object {

        @JvmStatic
        public fun <E : MavBitmask> of(flags: List<E>): MavBitmaskValue<E> = MavBitmaskValue(
            flags,
            flags.map { it.value }
                .reduceOrNull { bitmask, value -> bitmask or value }
                ?: 0u
        )

        @JvmStatic
        public fun <E : MavBitmask> of(vararg flags: E): MavBitmaskValue<E> = of(flags.asList())

        @JvmStatic
        public fun <E : MavBitmask> fromValue(value: UInt): MavBitmaskValue<E> = MavBitmaskValue(emptyList(), value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MavBitmaskValue<*>

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "MavBitmaskValue(flags=$flags, value=$value)"
    }
}

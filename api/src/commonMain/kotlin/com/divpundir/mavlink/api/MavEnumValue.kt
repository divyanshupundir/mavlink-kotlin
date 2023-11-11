package com.divpundir.mavlink.api

/**
 * Wrapper class for a [MavEnum].
 */
public class MavEnumValue<E : MavEnum> private constructor(public val entry: E?, public val value: UInt) {

    public companion object {

        public fun <E : MavEnum> of(entry: E): MavEnumValue<E> = MavEnumValue(entry, entry.value)

        public fun <E : MavEnum> fromValue(value: UInt): MavEnumValue<E> = MavEnumValue(null, value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as MavEnumValue<*>

        return value == other.value
    }

    override fun hashCode(): Int = value.hashCode()

    override fun toString(): String = "MavEnumValue(entry=$entry, value=$value)"
}

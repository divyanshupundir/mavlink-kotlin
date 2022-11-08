package xyz.urbanmatrix.mavlink.api

/**
 * Wrapper class for a [MavBitmask].
 */
class MavBitmaskValue<E : MavBitmask> private constructor(val flags: List<E>, val value: Long) {

    companion object {

        @JvmStatic
        fun <E : MavBitmask> of(vararg flags: E) = MavBitmaskValue(
            flags.asList(),
            flags.map { it.value }
                .reduceOrNull { bitmask, value -> bitmask or value }
                ?: 0L
        )

        @JvmStatic
        fun <E : MavBitmask> fromValue(value: Long) = MavBitmaskValue<E>(emptyList(), value)
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

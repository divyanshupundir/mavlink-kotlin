package xyz.urbanmatrix.mavlink.api

/**
 * Wrapper class for a [MavEnum].
 */
class MavEnumValue<E : MavEnum> private constructor(val entry: E?, val value: Long) {

    companion object {

        @JvmStatic
        fun <E : MavEnum> of(entry: E) = MavEnumValue(entry, entry.value)

        @JvmStatic
        fun <E : MavEnum> fromValue(value: Long) = MavEnumValue<E>(null, value)

        @JvmStatic
        fun <E : MavEnum> fromMask(flags: Collection<E>) = fromValue<E>(
            flags.map { it.value }
                .reduceOrNull { bitmask, value -> bitmask or value }
                ?: 0L
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MavEnumValue<*>

        if (entry != other.entry) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = entry?.hashCode() ?: 0
        result = 31 * result + value.hashCode()
        return result
    }

    override fun toString(): String {
        return "MavEnumValue(entry=$entry, value=$value)"
    }
}

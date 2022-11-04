package xyz.urbanmatrix.mavlink.api

/**
 * Wrapper class for a [MavEnum].
 */
data class MavEnumValue<E : MavEnum>(val entry: E?, val value: Long) {

    companion object {

        @JvmStatic
        fun <E : MavEnum> of(entry: E) = MavEnumValue(entry, entry.value)

        @JvmStatic
        fun <E : MavEnum> from(value: Long) = MavEnumValue<E>(null, value)
    }
}

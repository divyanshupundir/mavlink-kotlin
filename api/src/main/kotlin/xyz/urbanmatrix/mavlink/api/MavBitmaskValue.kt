package xyz.urbanmatrix.mavlink.api

data class MavBitmaskValue<E : MavBitmask>(val flags: List<E>, val value: Long) {

    companion object {

        @JvmStatic
        fun <E : MavBitmask> of(vararg flags: E) = MavBitmaskValue(
            flags.asList(),
            flags.map { it.value }
                .reduceOrNull { bitmask, value -> bitmask or value }
                ?: 0L
        )

        @JvmStatic
        fun <E : MavBitmask> from(value: Long) = MavBitmaskValue<E>(emptyList(), value)
    }
}

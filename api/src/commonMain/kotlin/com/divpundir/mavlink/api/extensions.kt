package com.divpundir.mavlink.api

public fun <E : MavEnum> E.wrap(): MavEnumValue<E> = MavEnumValue.of(this)

public fun <E : MavBitmask> E.wrap(): MavBitmaskValue<E> = MavBitmaskValue.of(this)

public fun <E : MavBitmask> List<E>.wrap(): MavBitmaskValue<E> = MavBitmaskValue.of(this)

public infix operator fun <E : MavBitmask> MavBitmaskValue<E>.contains(flag: E): Boolean =
    this.value and flag.value == flag.value

package com.divpundir.mavlink.api

public fun <E : MavEnum> E.wrap(): MavEnumValue<E> = MavEnumValue.of(this)

public fun <E : MavBitmask> E.wrap(): MavBitmaskValue<E> = MavBitmaskValue.of(this)

public fun <E : MavBitmask> List<E>.wrap(): MavBitmaskValue<E> = MavBitmaskValue.of(this)

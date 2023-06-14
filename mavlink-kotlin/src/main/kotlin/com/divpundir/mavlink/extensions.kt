package com.divpundir.mavlink

import com.divpundir.mavlink.api.MavBitmask
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnum
import com.divpundir.mavlink.api.MavEnumValue

public fun <E : MavEnum> E.wrap(): MavEnumValue<E> = MavEnumValue.of(this)

public fun <E : MavBitmask> E.wrap(): MavBitmaskValue<E> = MavBitmaskValue.of(this)

public fun <E : MavBitmask> List<E>.wrap(): MavBitmaskValue<E> = MavBitmaskValue.of(this)

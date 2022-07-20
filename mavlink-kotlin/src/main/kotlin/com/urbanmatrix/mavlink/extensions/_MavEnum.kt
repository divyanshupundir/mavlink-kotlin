package com.urbanmatrix.mavlink.extensions

import com.urbanmatrix.mavlink.api.MavEnum
import com.urbanmatrix.mavlink.api.MavEnumValue

fun <E : MavEnum> E.wrap() = MavEnumValue.of(this)

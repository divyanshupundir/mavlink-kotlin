package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class SpeedType(
  public override val `value`: Long,
) : MavEnum {
  SPEED_TYPE_AIRSPEED(0L),
  SPEED_TYPE_GROUNDSPEED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): SpeedType? = when (v) {
      0L -> SPEED_TYPE_AIRSPEED
      1L -> SPEED_TYPE_GROUNDSPEED
      else -> null
    }
  }
}

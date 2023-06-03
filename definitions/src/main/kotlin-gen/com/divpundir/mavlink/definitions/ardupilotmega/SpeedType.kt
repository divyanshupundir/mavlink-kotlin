package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class SpeedType(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  AIRSPEED(0u),
  @GeneratedMavEnumEntry
  GROUNDSPEED(1u),
  ;

  public companion object : MavEnum.MavCompanion<SpeedType> {
    public override fun getEntryFromValueOrNull(v: UInt): SpeedType? = when (v) {
      0u -> AIRSPEED
      1u -> GROUNDSPEED
      else -> null
    }
  }
}

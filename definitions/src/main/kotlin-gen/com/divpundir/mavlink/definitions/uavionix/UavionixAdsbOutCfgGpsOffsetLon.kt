package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * GPS longitudinal offset encoding
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutCfgGpsOffsetLon(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  NO_DATA(0u),
  @GeneratedMavEnumEntry
  APPLIED_BY_SENSOR(1u),
  ;

  public companion object : MavEnum.Companion<UavionixAdsbOutCfgGpsOffsetLon> {
    public override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutCfgGpsOffsetLon? = when (v)
        {
      0u -> NO_DATA
      1u -> APPLIED_BY_SENSOR
      else -> null
    }
  }
}

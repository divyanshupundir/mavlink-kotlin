package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproCharging(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Charging disabled.
   */
  @GeneratedMavEnumEntry
  DISABLED(0u),
  /**
   * Charging enabled.
   */
  @GeneratedMavEnumEntry
  ENABLED(1u),
  ;

  public companion object : MavEnum.Companion<GoproCharging> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproCharging? = when (v) {
      0u -> DISABLED
      1u -> ENABLED
      else -> null
    }
  }
}

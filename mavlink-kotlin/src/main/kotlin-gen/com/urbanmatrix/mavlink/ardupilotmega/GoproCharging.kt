package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GoproCharging(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Charging disabled.
   */
  GOPRO_CHARGING_DISABLED(0L),
  /**
   * Charging enabled.
   */
  GOPRO_CHARGING_ENABLED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproCharging? = when (v) {
      0L -> GOPRO_CHARGING_DISABLED
      1L -> GOPRO_CHARGING_ENABLED
      else -> null
    }
  }
}

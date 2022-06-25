package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Flags in RALLY_POINT message.
 */
public enum class RallyFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Flag set when requiring favorable winds for landing.
   */
  FAVORABLE_WIND(1L),
  /**
   * Flag set when plane is to immediately descend to break altitude and land without GCS
   * intervention. Flag not set when plane is to loiter at Rally point until commanded to land.
   */
  LAND_IMMEDIATELY(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): RallyFlags? = when (v) {
      1L -> FAVORABLE_WIND
      2L -> LAND_IMMEDIATELY
      else -> null
    }
  }
}

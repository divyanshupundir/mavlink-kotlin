package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * RTK GPS baseline coordinate system, used for RTK corrections
 */
public enum class RtkBaselineCoordinateSystem(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Earth-centered, Earth-fixed
   */
  RTK_BASELINE_COORDINATE_SYSTEM_ECEF(0L),
  /**
   * RTK basestation centered, north, east, down
   */
  RTK_BASELINE_COORDINATE_SYSTEM_NED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): RtkBaselineCoordinateSystem? = when (v) {
      0L -> RTK_BASELINE_COORDINATE_SYSTEM_ECEF
      1L -> RTK_BASELINE_COORDINATE_SYSTEM_NED
      else -> null
    }
  }
}

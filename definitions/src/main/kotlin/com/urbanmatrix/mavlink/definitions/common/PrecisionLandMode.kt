package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Precision land modes (used in MAV_CMD_NAV_LAND).
 */
public enum class PrecisionLandMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Normal (non-precision) landing.
   */
  PRECISION_LAND_MODE_DISABLED(0L),
  /**
   * Use precision landing if beacon detected when land command accepted, otherwise land normally.
   */
  PRECISION_LAND_MODE_OPPORTUNISTIC(1L),
  /**
   * Use precision landing, searching for beacon if not found when land command accepted (land
   * normally if beacon cannot be found).
   */
  PRECISION_LAND_MODE_REQUIRED(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): PrecisionLandMode? = when (v) {
      0L -> PRECISION_LAND_MODE_DISABLED
      1L -> PRECISION_LAND_MODE_OPPORTUNISTIC
      2L -> PRECISION_LAND_MODE_REQUIRED
      else -> null
    }
  }
}

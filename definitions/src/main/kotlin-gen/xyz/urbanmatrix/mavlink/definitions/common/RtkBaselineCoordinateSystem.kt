package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * RTK GPS baseline coordinate system, used for RTK corrections
 */
@GeneratedMavEnum
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

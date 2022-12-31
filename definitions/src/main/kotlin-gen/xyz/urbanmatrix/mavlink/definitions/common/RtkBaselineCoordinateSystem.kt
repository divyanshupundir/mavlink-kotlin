package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
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
  @GeneratedMavEnumEntry
  ECEF(0L),
  /**
   * RTK basestation centered, north, east, down
   */
  @GeneratedMavEnumEntry
  NED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): RtkBaselineCoordinateSystem? = when (v) {
      0L -> ECEF
      1L -> NED
      else -> null
    }
  }
}

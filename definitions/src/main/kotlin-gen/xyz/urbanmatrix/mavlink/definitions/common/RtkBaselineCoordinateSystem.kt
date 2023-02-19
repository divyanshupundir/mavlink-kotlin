package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * RTK GPS baseline coordinate system, used for RTK corrections
 */
@GeneratedMavEnum
public enum class RtkBaselineCoordinateSystem(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Earth-centered, Earth-fixed
   */
  @GeneratedMavEnumEntry
  ECEF(0u),
  /**
   * RTK basestation centered, north, east, down
   */
  @GeneratedMavEnumEntry
  NED(1u),
  ;

  public companion object : MavEnum.Companion<RtkBaselineCoordinateSystem> {
    public override fun getEntryFromValueOrNull(v: UInt): RtkBaselineCoordinateSystem? = when (v) {
      0u -> ECEF
      1u -> NED
      else -> null
    }
  }
}

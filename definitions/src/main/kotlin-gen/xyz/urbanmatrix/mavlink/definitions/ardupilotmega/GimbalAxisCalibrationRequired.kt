package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GimbalAxisCalibrationRequired(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Whether or not this axis requires calibration is unknown at this time.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * This axis requires calibration.
   */
  @GeneratedMavEnumEntry
  TRUE(1L),
  /**
   * This axis does not require calibration.
   */
  @GeneratedMavEnumEntry
  FALSE(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalAxisCalibrationRequired? = when (v) {
      0L -> UNKNOWN
      1L -> TRUE
      2L -> FALSE
      else -> null
    }
  }
}

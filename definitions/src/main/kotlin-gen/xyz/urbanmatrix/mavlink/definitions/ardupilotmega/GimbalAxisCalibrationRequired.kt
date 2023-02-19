package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GimbalAxisCalibrationRequired(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Whether or not this axis requires calibration is unknown at this time.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * This axis requires calibration.
   */
  @GeneratedMavEnumEntry
  TRUE(1u),
  /**
   * This axis does not require calibration.
   */
  @GeneratedMavEnumEntry
  FALSE(2u),
  ;

  public companion object : MavEnum.Companion<GimbalAxisCalibrationRequired> {
    public override fun getEntryFromValueOrNull(v: UInt): GimbalAxisCalibrationRequired? = when (v)
        {
      0u -> UNKNOWN
      1u -> TRUE
      2u -> FALSE
      else -> null
    }
  }
}

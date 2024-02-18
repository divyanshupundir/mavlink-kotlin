package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GimbalAxisCalibrationRequired(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<GimbalAxisCalibrationRequired> {
    override fun getEntryFromValueOrNull(v: UInt): GimbalAxisCalibrationRequired? = when (v) {
      0u -> UNKNOWN
      1u -> TRUE
      2u -> FALSE
      else -> null
    }
  }
}

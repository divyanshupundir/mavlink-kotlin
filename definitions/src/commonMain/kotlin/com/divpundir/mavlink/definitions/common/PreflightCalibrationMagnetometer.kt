package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Action for the magnetometer (param2) of MAV_CMD_PREFLIGHT_CALIBRATION.
 */
@GeneratedMavEnum
public enum class PreflightCalibrationMagnetometer(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No action.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Start magnetometer calibration.
   */
  @GeneratedMavEnumEntry
  START(1u),
  /**
   * Force-accept the existing compass calibration as valid without re-running it. Useful after a parameter reload that cleared calibration validity flags.
   */
  @GeneratedMavEnumEntry
  FORCE_SAVE(76u),
  ;

  public companion object : MavEnum.MavCompanion<PreflightCalibrationMagnetometer> {
    override fun getEntryFromValueOrNull(v: UInt): PreflightCalibrationMagnetometer? = when (v) {
      0u -> NONE
      1u -> START
      76u -> FORCE_SAVE
      else -> null
    }
  }
}

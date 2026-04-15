package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Action for the accelerometer (param5) of MAV_CMD_PREFLIGHT_CALIBRATION.
 */
@GeneratedMavEnum
public enum class PreflightCalibrationAccelerometer(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No action.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Full 6-position accelerometer calibration.
   */
  @GeneratedMavEnumEntry
  FULL(1u),
  /**
   * Board level (trim) calibration.
   */
  @GeneratedMavEnumEntry
  TRIM(2u),
  /**
   * Accelerometer temperature calibration.
   */
  @GeneratedMavEnumEntry
  TEMPERATURE(3u),
  /**
   * Simple accelerometer calibration.
   */
  @GeneratedMavEnumEntry
  SIMPLE(4u),
  /**
   * Force-accept the existing accelerometer calibration as valid without re-running it. Useful after a parameter reload that cleared calibration validity flags.
   */
  @GeneratedMavEnumEntry
  FORCE_SAVE(76u),
  ;

  public companion object : MavEnum.MavCompanion<PreflightCalibrationAccelerometer> {
    override fun getEntryFromValueOrNull(v: UInt): PreflightCalibrationAccelerometer? = when (v) {
      0u -> NONE
      1u -> FULL
      2u -> TRIM
      3u -> TEMPERATURE
      4u -> SIMPLE
      76u -> FORCE_SAVE
      else -> null
    }
  }
}

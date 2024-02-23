package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 *
 *         Actions for reading/writing parameters between persistent and volatile storage when using
 * MAV_CMD_PREFLIGHT_STORAGE.
 *         (Commonly parameters are loaded from persistent storage (flash/EEPROM) into volatile
 * storage (RAM) on startup and written back when they are changed.)
 *       
 */
@GeneratedMavEnum
public enum class PreflightStorageParameterAction(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Read all parameters from persistent storage. Replaces values in volatile storage.
   */
  @GeneratedMavEnumEntry
  PARAM_READ_PERSISTENT(0u),
  /**
   * Write all parameter values to persistent storage (flash/EEPROM)
   */
  @GeneratedMavEnumEntry
  PARAM_WRITE_PERSISTENT(1u),
  /**
   * Reset all user configurable parameters to their default value (including airframe selection,
   * sensor calibration data, safety settings, and so on). Does not reset values that contain operation
   * counters and vehicle computed statistics.
   */
  @GeneratedMavEnumEntry
  PARAM_RESET_CONFIG_DEFAULT(2u),
  /**
   * Reset only sensor calibration parameters to factory defaults (or firmware default if not
   * available)
   */
  @GeneratedMavEnumEntry
  PARAM_RESET_SENSOR_DEFAULT(3u),
  /**
   * Reset all parameters, including operation counters, to default values
   */
  @GeneratedMavEnumEntry
  PARAM_RESET_ALL_DEFAULT(4u),
  ;

  public companion object : MavEnum.MavCompanion<PreflightStorageParameterAction> {
    override fun getEntryFromValueOrNull(v: UInt): PreflightStorageParameterAction? = when (v) {
      0u -> PARAM_READ_PERSISTENT
      1u -> PARAM_WRITE_PERSISTENT
      2u -> PARAM_RESET_CONFIG_DEFAULT
      3u -> PARAM_RESET_SENSOR_DEFAULT
      4u -> PARAM_RESET_ALL_DEFAULT
      else -> null
    }
  }
}

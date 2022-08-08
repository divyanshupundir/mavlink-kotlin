package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

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
  public override val `value`: Long,
) : MavEnum {
  /**
   * Read all parameters from persistent storage. Replaces values in volatile storage.
   */
  PARAM_READ_PERSISTENT(0L),
  /**
   * Write all parameter values to persistent storage (flash/EEPROM)
   */
  PARAM_WRITE_PERSISTENT(1L),
  /**
   * Reset all user configurable parameters to their default value (including airframe selection,
   * sensor calibration data, safety settings, and so on). Does not reset values that contain operation
   * counters and vehicle computed statistics.
   */
  PARAM_RESET_CONFIG_DEFAULT(2L),
  /**
   * Reset only sensor calibration parameters to factory defaults (or firmware default if not
   * available)
   */
  PARAM_RESET_SENSOR_DEFAULT(3L),
  /**
   * Reset all parameters, including operation counters, to default values
   */
  PARAM_RESET_ALL_DEFAULT(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): PreflightStorageParameterAction? = when (v) {
      0L -> PARAM_READ_PERSISTENT
      1L -> PARAM_WRITE_PERSISTENT
      2L -> PARAM_RESET_CONFIG_DEFAULT
      3L -> PARAM_RESET_SENSOR_DEFAULT
      4L -> PARAM_RESET_ALL_DEFAULT
      else -> null
    }
  }
}

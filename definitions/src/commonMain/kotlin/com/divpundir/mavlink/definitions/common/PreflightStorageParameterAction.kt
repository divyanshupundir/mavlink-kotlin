package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 *
 *         Actions for reading/writing parameters between persistent and volatile storage when using MAV_CMD_PREFLIGHT_STORAGE.
 *         (Commonly parameters are loaded from persistent storage (flash/EEPROM) into volatile storage (RAM) on startup and written back when they are changed.)
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
   * Reset parameters to default values (such as sensor calibration, safety settings, and so on). Note that a flight stack may choose not to reset some parameters at their own discretion (such as those that are locked or expected to persist for the vehicle lifetime).
   */
  @GeneratedMavEnumEntry
  PARAM_RESET_FACTORY_DEFAULT(2u),
  /**
   * Reset only sensor calibration parameters to factory defaults (or firmware default if not available)
   */
  @GeneratedMavEnumEntry
  PARAM_RESET_SENSOR_DEFAULT(3u),
  /**
   * Reset all parameters to default values.
   */
  @GeneratedMavEnumEntry
  PARAM_RESET_ALL_DEFAULT(4u),
  ;

  public companion object : MavEnum.MavCompanion<PreflightStorageParameterAction> {
    override fun getEntryFromValueOrNull(v: UInt): PreflightStorageParameterAction? = when (v) {
      0u -> PARAM_READ_PERSISTENT
      1u -> PARAM_WRITE_PERSISTENT
      2u -> PARAM_RESET_FACTORY_DEFAULT
      3u -> PARAM_RESET_SENSOR_DEFAULT
      4u -> PARAM_RESET_ALL_DEFAULT
      else -> null
    }
  }
}

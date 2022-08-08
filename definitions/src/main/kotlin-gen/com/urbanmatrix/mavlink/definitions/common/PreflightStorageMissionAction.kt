package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 *
 *         Actions for reading and writing plan information (mission, rally points, geofence)
 * between persistent and volatile storage when using MAV_CMD_PREFLIGHT_STORAGE.
 *         (Commonly missions are loaded from persistent storage (flash/EEPROM) into volatile
 * storage (RAM) on startup and written back when they are changed.)
 *       
 */
@GeneratedMavEnum
public enum class PreflightStorageMissionAction(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Read current mission data from persistent storage
   */
  MISSION_READ_PERSISTENT(0L),
  /**
   * Write current mission data to persistent storage
   */
  MISSION_WRITE_PERSISTENT(1L),
  /**
   * Erase all mission data stored on the vehicle (both persistent and volatile storage)
   */
  MISSION_RESET_DEFAULT(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): PreflightStorageMissionAction? = when (v) {
      0L -> MISSION_READ_PERSISTENT
      1L -> MISSION_WRITE_PERSISTENT
      2L -> MISSION_RESET_DEFAULT
      else -> null
    }
  }
}

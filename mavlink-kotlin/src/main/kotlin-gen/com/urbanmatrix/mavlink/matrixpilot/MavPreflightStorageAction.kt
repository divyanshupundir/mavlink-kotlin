package com.urbanmatrix.mavlink.matrixpilot

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Action required when performing CMD_PREFLIGHT_STORAGE
 */
public enum class MavPreflightStorageAction(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Read all parameters from storage
   */
  MAV_PFS_CMD_READ_ALL(0L),
  /**
   * Write all parameters to storage
   */
  MAV_PFS_CMD_WRITE_ALL(1L),
  /**
   * Clear all  parameters in storage
   */
  MAV_PFS_CMD_CLEAR_ALL(2L),
  /**
   * Read specific parameters from storage
   */
  MAV_PFS_CMD_READ_SPECIFIC(3L),
  /**
   * Write specific parameters to storage
   */
  MAV_PFS_CMD_WRITE_SPECIFIC(4L),
  /**
   * Clear specific parameters in storage
   */
  MAV_PFS_CMD_CLEAR_SPECIFIC(5L),
  /**
   * do nothing
   */
  MAV_PFS_CMD_DO_NOTHING(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavPreflightStorageAction? = when (v) {
      0L -> MAV_PFS_CMD_READ_ALL
      1L -> MAV_PFS_CMD_WRITE_ALL
      2L -> MAV_PFS_CMD_CLEAR_ALL
      3L -> MAV_PFS_CMD_READ_SPECIFIC
      4L -> MAV_PFS_CMD_WRITE_SPECIFIC
      5L -> MAV_PFS_CMD_CLEAR_SPECIFIC
      6L -> MAV_PFS_CMD_DO_NOTHING
      else -> null
    }
  }
}

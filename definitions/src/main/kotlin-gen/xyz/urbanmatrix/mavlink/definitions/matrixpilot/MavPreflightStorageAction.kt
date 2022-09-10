package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Action required when performing CMD_PREFLIGHT_STORAGE
 */
@GeneratedMavEnum
public enum class MavPreflightStorageAction(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Read all parameters from storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_READ_ALL(0L),
  /**
   * Write all parameters to storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_WRITE_ALL(1L),
  /**
   * Clear all  parameters in storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_CLEAR_ALL(2L),
  /**
   * Read specific parameters from storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_READ_SPECIFIC(3L),
  /**
   * Write specific parameters to storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_WRITE_SPECIFIC(4L),
  /**
   * Clear specific parameters in storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_CLEAR_SPECIFIC(5L),
  /**
   * do nothing
   */
  @GeneratedMavEnumEntry
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

package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Action required when performing CMD_PREFLIGHT_STORAGE
 */
@GeneratedMavEnum
public enum class MavPreflightStorageAction(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Read all parameters from storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_READ_ALL(0u),
  /**
   * Write all parameters to storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_WRITE_ALL(1u),
  /**
   * Clear all  parameters in storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_CLEAR_ALL(2u),
  /**
   * Read specific parameters from storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_READ_SPECIFIC(3u),
  /**
   * Write specific parameters to storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_WRITE_SPECIFIC(4u),
  /**
   * Clear specific parameters in storage
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_CLEAR_SPECIFIC(5u),
  /**
   * do nothing
   */
  @GeneratedMavEnumEntry
  MAV_PFS_CMD_DO_NOTHING(6u),
  ;

  public companion object : MavEnum.Companion<MavPreflightStorageAction> {
    public override fun getEntryFromValueOrNull(v: UInt): MavPreflightStorageAction? = when (v) {
      0u -> MAV_PFS_CMD_READ_ALL
      1u -> MAV_PFS_CMD_WRITE_ALL
      2u -> MAV_PFS_CMD_CLEAR_ALL
      3u -> MAV_PFS_CMD_READ_SPECIFIC
      4u -> MAV_PFS_CMD_WRITE_SPECIFIC
      5u -> MAV_PFS_CMD_CLEAR_SPECIFIC
      6u -> MAV_PFS_CMD_DO_NOTHING
      else -> null
    }
  }
}

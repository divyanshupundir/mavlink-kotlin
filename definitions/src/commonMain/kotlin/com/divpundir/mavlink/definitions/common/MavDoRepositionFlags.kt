package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Bitmap of options for the MAV_CMD_DO_REPOSITION
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavDoRepositionFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * The aircraft should immediately transition into guided. This should not be set for follow me
   * applications
   */
  @GeneratedMavEnumEntry
  CHANGE_MODE(1u),
  /**
   * Yaw relative to the vehicle current heading (if not set, relative to North).
   */
  @GeneratedMavEnumEntry
  RELATIVE_YAW(2u),
  ;

  public companion object : MavBitmask.MavCompanion<MavDoRepositionFlags> {
    override fun getEntryFromValueOrNull(v: UInt): MavDoRepositionFlags? = when (v) {
      1u -> CHANGE_MODE
      2u -> RELATIVE_YAW
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavDoRepositionFlags> = buildList {
      if (v and 1u == 1u) add(CHANGE_MODE)
      if (v and 2u == 2u) add(RELATIVE_YAW)
    }
  }
}

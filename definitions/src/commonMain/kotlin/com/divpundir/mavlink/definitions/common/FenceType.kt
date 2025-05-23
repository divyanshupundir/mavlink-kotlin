package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Fence types to enable or disable when using MAV_CMD_DO_FENCE_ENABLE.
 *         Note that at least one of these flags must be set in MAV_CMD_DO_FENCE_ENABLE.param2.
 *         If none are set, the flight stack will ignore the field and enable/disable its default
 * set of fences (usually all of them).
 *       
 */
@GeneratedMavEnum(bitmask = true)
public enum class FenceType(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Maximum altitude fence
   */
  @GeneratedMavEnumEntry
  ALT_MAX(1u),
  /**
   * Circle fence
   */
  @GeneratedMavEnumEntry
  CIRCLE(2u),
  /**
   * Polygon fence
   */
  @GeneratedMavEnumEntry
  POLYGON(4u),
  /**
   * Minimum altitude fence
   */
  @GeneratedMavEnumEntry
  ALT_MIN(8u),
  ;

  public companion object : MavBitmask.MavCompanion<FenceType> {
    override fun getEntryFromValueOrNull(v: UInt): FenceType? = when (v) {
      1u -> ALT_MAX
      2u -> CIRCLE
      4u -> POLYGON
      8u -> ALT_MIN
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<FenceType> = buildList {
      if (v and 1u == 1u) add(ALT_MAX)
      if (v and 2u == 2u) add(CIRCLE)
      if (v and 4u == 4u) add(POLYGON)
      if (v and 8u == 8u) add(ALT_MIN)
    }
  }
}

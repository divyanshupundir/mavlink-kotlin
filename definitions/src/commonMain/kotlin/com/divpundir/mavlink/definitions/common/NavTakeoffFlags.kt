package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

@GeneratedMavEnum(bitmask = true)
public enum class NavTakeoffFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Accept the command even if the autopilot does not have control over its horizontal position (note that it might not have altitude control either).
   */
  @GeneratedMavEnumEntry
  HORIZONTAL_POSITION_NOT_REQUIRED(1u),
  ;

  public companion object : MavBitmask.MavCompanion<NavTakeoffFlags> {
    override fun getEntryFromValueOrNull(v: UInt): NavTakeoffFlags? = when (v) {
      1u -> HORIZONTAL_POSITION_NOT_REQUIRED
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<NavTakeoffFlags> = buildList {
      if (v and 1u == 1u) add(HORIZONTAL_POSITION_NOT_REQUIRED)
    }
  }
}

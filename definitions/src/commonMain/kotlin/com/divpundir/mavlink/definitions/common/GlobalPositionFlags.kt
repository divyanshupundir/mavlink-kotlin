package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Status flags for GLOBAL_POSITION
 */
@GeneratedMavEnum(bitmask = true)
public enum class GlobalPositionFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Unhealthy sensor/estimator.
   */
  @GeneratedMavEnumEntry
  GLOBAL_POSITION_UNHEALTHY(1u),
  /**
   * True if the data originates from or is consumed by the primary estimator.
   */
  @GeneratedMavEnumEntry
  GLOBAL_POSITION_PRIMARY(2u),
  ;

  public companion object : MavBitmask.MavCompanion<GlobalPositionFlags> {
    override fun getEntryFromValueOrNull(v: UInt): GlobalPositionFlags? = when (v) {
      1u -> GLOBAL_POSITION_UNHEALTHY
      2u -> GLOBAL_POSITION_PRIMARY
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<GlobalPositionFlags> = buildList {
      if (v and 1u == 1u) add(GLOBAL_POSITION_UNHEALTHY)
      if (v and 2u == 2u) add(GLOBAL_POSITION_PRIMARY)
    }
  }
}

package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Gimbal manager capability flags.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavStorm32GimbalManagerCapFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * The gimbal manager supports several profiles.
   */
  @GeneratedMavEnumEntry
  HAS_PROFILES(1u),
  ;

  public companion object : MavBitmask.MavCompanion<MavStorm32GimbalManagerCapFlags> {
    override fun getEntryFromValueOrNull(v: UInt): MavStorm32GimbalManagerCapFlags? = when (v) {
      1u -> HAS_PROFILES
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavStorm32GimbalManagerCapFlags> = buildList {
      if (v and 1u == 1u) add(HAS_PROFILES)
    }
  }
}

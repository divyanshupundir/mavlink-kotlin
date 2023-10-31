package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * RADIO_RC_CHANNELS flags (bitmask).
 */
@GeneratedMavEnum(bitmask = true)
public enum class RadioRcChannelsFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * Failsafe is active.
   */
  @GeneratedMavEnumEntry
  FAILSAFE(1u),
  /**
   * Indicates that the current frame has not been received. Channel values are frozen.
   */
  @GeneratedMavEnumEntry
  FRAME_MISSED(2u),
  ;

  public companion object : MavBitmask.MavCompanion<RadioRcChannelsFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): RadioRcChannelsFlags? = when (v) {
      1u -> FAILSAFE
      2u -> FRAME_MISSED
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<RadioRcChannelsFlags> = buildList {
      if (v and 1u == 1u) add(FAILSAFE)
      if (v and 2u == 2u) add(FRAME_MISSED)
    }
  }
}

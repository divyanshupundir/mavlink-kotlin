package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt
import kotlin.collections.List

/**
 * State flags for ADS-B transponder dynamic report
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbOutDynamicState(
  public override val `value`: UInt,
) : MavBitmask {
  @GeneratedMavEnumEntry
  INTENT_CHANGE(1u),
  @GeneratedMavEnumEntry
  AUTOPILOT_ENABLED(2u),
  @GeneratedMavEnumEntry
  NICBARO_CROSSCHECKED(4u),
  @GeneratedMavEnumEntry
  ON_GROUND(8u),
  @GeneratedMavEnumEntry
  IDENT(16u),
  ;

  public companion object : MavEnum.Companion<UavionixAdsbOutDynamicState>,
      MavBitmask.Companion<UavionixAdsbOutDynamicState> {
    public override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutDynamicState? = when (v) {
      1u -> INTENT_CHANGE
      2u -> AUTOPILOT_ENABLED
      4u -> NICBARO_CROSSCHECKED
      8u -> ON_GROUND
      16u -> IDENT
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<UavionixAdsbOutDynamicState> = buildList {
      if (v and 1u == 1u) add(INTENT_CHANGE)
      if (v and 2u == 2u) add(AUTOPILOT_ENABLED)
      if (v and 4u == 4u) add(NICBARO_CROSSCHECKED)
      if (v and 8u == 8u) add(ON_GROUND)
      if (v and 16u == 16u) add(IDENT)
    }
  }
}

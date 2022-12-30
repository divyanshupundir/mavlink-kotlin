package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * State flags for ADS-B transponder dynamic report
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbOutDynamicState(
  public override val `value`: Long,
) : MavBitmask {
  @GeneratedMavEnumEntry
  INTENT_CHANGE(1L),
  @GeneratedMavEnumEntry
  AUTOPILOT_ENABLED(2L),
  @GeneratedMavEnumEntry
  NICBARO_CROSSCHECKED(4L),
  @GeneratedMavEnumEntry
  ON_GROUND(8L),
  @GeneratedMavEnumEntry
  IDENT(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutDynamicState? = when (v) {
      1L -> INTENT_CHANGE
      2L -> AUTOPILOT_ENABLED
      4L -> NICBARO_CROSSCHECKED
      8L -> ON_GROUND
      16L -> IDENT
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<UavionixAdsbOutDynamicState> = buildList {
      if (v and 1L == 1L) add(INTENT_CHANGE)
      if (v and 2L == 2L) add(AUTOPILOT_ENABLED)
      if (v and 4L == 4L) add(NICBARO_CROSSCHECKED)
      if (v and 8L == 8L) add(ON_GROUND)
      if (v and 16L == 16L) add(IDENT)
    }
  }
}

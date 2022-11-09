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
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_INTENT_CHANGE(1L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_AUTOPILOT_ENABLED(2L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_NICBARO_CROSSCHECKED(4L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_ON_GROUND(8L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_IDENT(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutDynamicState? = when (v) {
      1L -> UAVIONIX_ADSB_OUT_DYNAMIC_STATE_INTENT_CHANGE
      2L -> UAVIONIX_ADSB_OUT_DYNAMIC_STATE_AUTOPILOT_ENABLED
      4L -> UAVIONIX_ADSB_OUT_DYNAMIC_STATE_NICBARO_CROSSCHECKED
      8L -> UAVIONIX_ADSB_OUT_DYNAMIC_STATE_ON_GROUND
      16L -> UAVIONIX_ADSB_OUT_DYNAMIC_STATE_IDENT
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<UavionixAdsbOutDynamicState> = buildList {
      if (v and 1L == 1L) add(UAVIONIX_ADSB_OUT_DYNAMIC_STATE_INTENT_CHANGE)
      if (v and 2L == 2L) add(UAVIONIX_ADSB_OUT_DYNAMIC_STATE_AUTOPILOT_ENABLED)
      if (v and 4L == 4L) add(UAVIONIX_ADSB_OUT_DYNAMIC_STATE_NICBARO_CROSSCHECKED)
      if (v and 8L == 8L) add(UAVIONIX_ADSB_OUT_DYNAMIC_STATE_ON_GROUND)
      if (v and 16L == 16L) add(UAVIONIX_ADSB_OUT_DYNAMIC_STATE_IDENT)
    }
  }
}

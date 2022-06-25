package com.urbanmatrix.mavlink.uAvionix

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * State flags for ADS-B transponder dynamic report
 */
public enum class UavionixAdsbOutDynamicState(
  public override val `value`: Long,
) : MavEnum {
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_INTENT_CHANGE(1L),
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_AUTOPILOT_ENABLED(2L),
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_NICBARO_CROSSCHECKED(4L),
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_ON_GROUND(8L),
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
  }
}

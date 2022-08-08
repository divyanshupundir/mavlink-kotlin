package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * These flags indicate status such as data validity of each data source. Set = data valid
 */
@GeneratedMavEnum
public enum class AdsbFlags(
  public override val `value`: Long,
) : MavEnum {
  ADSB_FLAGS_VALID_COORDS(1L),
  ADSB_FLAGS_VALID_ALTITUDE(2L),
  ADSB_FLAGS_VALID_HEADING(4L),
  ADSB_FLAGS_VALID_VELOCITY(8L),
  ADSB_FLAGS_VALID_CALLSIGN(16L),
  ADSB_FLAGS_VALID_SQUAWK(32L),
  ADSB_FLAGS_SIMULATED(64L),
  ADSB_FLAGS_VERTICAL_VELOCITY_VALID(128L),
  ADSB_FLAGS_BARO_VALID(256L),
  ADSB_FLAGS_SOURCE_UAT(32768L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AdsbFlags? = when (v) {
      1L -> ADSB_FLAGS_VALID_COORDS
      2L -> ADSB_FLAGS_VALID_ALTITUDE
      4L -> ADSB_FLAGS_VALID_HEADING
      8L -> ADSB_FLAGS_VALID_VELOCITY
      16L -> ADSB_FLAGS_VALID_CALLSIGN
      32L -> ADSB_FLAGS_VALID_SQUAWK
      64L -> ADSB_FLAGS_SIMULATED
      128L -> ADSB_FLAGS_VERTICAL_VELOCITY_VALID
      256L -> ADSB_FLAGS_BARO_VALID
      32768L -> ADSB_FLAGS_SOURCE_UAT
      else -> null
    }
  }
}

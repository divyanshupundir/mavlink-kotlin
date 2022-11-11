package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * These flags indicate status such as data validity of each data source. Set = data valid
 */
@GeneratedMavEnum(bitmask = true)
public enum class AdsbFlags(
  public override val `value`: Long,
) : MavBitmask {
  @GeneratedMavEnumEntry
  ADSB_FLAGS_VALID_COORDS(1L),
  @GeneratedMavEnumEntry
  ADSB_FLAGS_VALID_ALTITUDE(2L),
  @GeneratedMavEnumEntry
  ADSB_FLAGS_VALID_HEADING(4L),
  @GeneratedMavEnumEntry
  ADSB_FLAGS_VALID_VELOCITY(8L),
  @GeneratedMavEnumEntry
  ADSB_FLAGS_VALID_CALLSIGN(16L),
  @GeneratedMavEnumEntry
  ADSB_FLAGS_VALID_SQUAWK(32L),
  @GeneratedMavEnumEntry
  ADSB_FLAGS_SIMULATED(64L),
  @GeneratedMavEnumEntry
  ADSB_FLAGS_VERTICAL_VELOCITY_VALID(128L),
  @GeneratedMavEnumEntry
  ADSB_FLAGS_BARO_VALID(256L),
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<AdsbFlags> = buildList {
      if (v and 1L == 1L) add(ADSB_FLAGS_VALID_COORDS)
      if (v and 2L == 2L) add(ADSB_FLAGS_VALID_ALTITUDE)
      if (v and 4L == 4L) add(ADSB_FLAGS_VALID_HEADING)
      if (v and 8L == 8L) add(ADSB_FLAGS_VALID_VELOCITY)
      if (v and 16L == 16L) add(ADSB_FLAGS_VALID_CALLSIGN)
      if (v and 32L == 32L) add(ADSB_FLAGS_VALID_SQUAWK)
      if (v and 64L == 64L) add(ADSB_FLAGS_SIMULATED)
      if (v and 128L == 128L) add(ADSB_FLAGS_VERTICAL_VELOCITY_VALID)
      if (v and 256L == 256L) add(ADSB_FLAGS_BARO_VALID)
      if (v and 32768L == 32768L) add(ADSB_FLAGS_SOURCE_UAT)
    }
  }
}

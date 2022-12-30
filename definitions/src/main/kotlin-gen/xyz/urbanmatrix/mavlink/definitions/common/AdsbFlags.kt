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
  VALID_COORDS(1L),
  @GeneratedMavEnumEntry
  VALID_ALTITUDE(2L),
  @GeneratedMavEnumEntry
  VALID_HEADING(4L),
  @GeneratedMavEnumEntry
  VALID_VELOCITY(8L),
  @GeneratedMavEnumEntry
  VALID_CALLSIGN(16L),
  @GeneratedMavEnumEntry
  VALID_SQUAWK(32L),
  @GeneratedMavEnumEntry
  SIMULATED(64L),
  @GeneratedMavEnumEntry
  VERTICAL_VELOCITY_VALID(128L),
  @GeneratedMavEnumEntry
  BARO_VALID(256L),
  @GeneratedMavEnumEntry
  SOURCE_UAT(32768L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AdsbFlags? = when (v) {
      1L -> VALID_COORDS
      2L -> VALID_ALTITUDE
      4L -> VALID_HEADING
      8L -> VALID_VELOCITY
      16L -> VALID_CALLSIGN
      32L -> VALID_SQUAWK
      64L -> SIMULATED
      128L -> VERTICAL_VELOCITY_VALID
      256L -> BARO_VALID
      32768L -> SOURCE_UAT
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<AdsbFlags> = buildList {
      if (v and 1L == 1L) add(VALID_COORDS)
      if (v and 2L == 2L) add(VALID_ALTITUDE)
      if (v and 4L == 4L) add(VALID_HEADING)
      if (v and 8L == 8L) add(VALID_VELOCITY)
      if (v and 16L == 16L) add(VALID_CALLSIGN)
      if (v and 32L == 32L) add(VALID_SQUAWK)
      if (v and 64L == 64L) add(SIMULATED)
      if (v and 128L == 128L) add(VERTICAL_VELOCITY_VALID)
      if (v and 256L == 256L) add(BARO_VALID)
      if (v and 32768L == 32768L) add(SOURCE_UAT)
    }
  }
}

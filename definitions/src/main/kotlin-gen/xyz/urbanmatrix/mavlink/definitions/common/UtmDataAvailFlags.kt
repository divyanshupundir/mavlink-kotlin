package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Flags for the global position report.
 */
@GeneratedMavEnum(bitmask = true)
public enum class UtmDataAvailFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * The field time contains valid data.
   */
  @GeneratedMavEnumEntry
  TIME_VALID(1L),
  /**
   * The field uas_id contains valid data.
   */
  @GeneratedMavEnumEntry
  UAS_ID_AVAILABLE(2L),
  /**
   * The fields lat, lon and h_acc contain valid data.
   */
  @GeneratedMavEnumEntry
  POSITION_AVAILABLE(4L),
  /**
   * The fields alt and v_acc contain valid data.
   */
  @GeneratedMavEnumEntry
  ALTITUDE_AVAILABLE(8L),
  /**
   * The field relative_alt contains valid data.
   */
  @GeneratedMavEnumEntry
  RELATIVE_ALTITUDE_AVAILABLE(16L),
  /**
   * The fields vx and vy contain valid data.
   */
  @GeneratedMavEnumEntry
  HORIZONTAL_VELO_AVAILABLE(32L),
  /**
   * The field vz contains valid data.
   */
  @GeneratedMavEnumEntry
  VERTICAL_VELO_AVAILABLE(64L),
  /**
   * The fields next_lat, next_lon and next_alt contain valid data.
   */
  @GeneratedMavEnumEntry
  NEXT_WAYPOINT_AVAILABLE(128L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UtmDataAvailFlags? = when (v) {
      1L -> TIME_VALID
      2L -> UAS_ID_AVAILABLE
      4L -> POSITION_AVAILABLE
      8L -> ALTITUDE_AVAILABLE
      16L -> RELATIVE_ALTITUDE_AVAILABLE
      32L -> HORIZONTAL_VELO_AVAILABLE
      64L -> VERTICAL_VELO_AVAILABLE
      128L -> NEXT_WAYPOINT_AVAILABLE
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<UtmDataAvailFlags> = buildList {
      if (v and 1L == 1L) add(TIME_VALID)
      if (v and 2L == 2L) add(UAS_ID_AVAILABLE)
      if (v and 4L == 4L) add(POSITION_AVAILABLE)
      if (v and 8L == 8L) add(ALTITUDE_AVAILABLE)
      if (v and 16L == 16L) add(RELATIVE_ALTITUDE_AVAILABLE)
      if (v and 32L == 32L) add(HORIZONTAL_VELO_AVAILABLE)
      if (v and 64L == 64L) add(VERTICAL_VELO_AVAILABLE)
      if (v and 128L == 128L) add(NEXT_WAYPOINT_AVAILABLE)
    }
  }
}

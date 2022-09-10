package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags for the global position report.
 */
@GeneratedMavEnum
public enum class UtmDataAvailFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The field time contains valid data.
   */
  @GeneratedMavEnumEntry
  UTM_DATA_AVAIL_FLAGS_TIME_VALID(1L),
  /**
   * The field uas_id contains valid data.
   */
  @GeneratedMavEnumEntry
  UTM_DATA_AVAIL_FLAGS_UAS_ID_AVAILABLE(2L),
  /**
   * The fields lat, lon and h_acc contain valid data.
   */
  @GeneratedMavEnumEntry
  UTM_DATA_AVAIL_FLAGS_POSITION_AVAILABLE(4L),
  /**
   * The fields alt and v_acc contain valid data.
   */
  @GeneratedMavEnumEntry
  UTM_DATA_AVAIL_FLAGS_ALTITUDE_AVAILABLE(8L),
  /**
   * The field relative_alt contains valid data.
   */
  @GeneratedMavEnumEntry
  UTM_DATA_AVAIL_FLAGS_RELATIVE_ALTITUDE_AVAILABLE(16L),
  /**
   * The fields vx and vy contain valid data.
   */
  @GeneratedMavEnumEntry
  UTM_DATA_AVAIL_FLAGS_HORIZONTAL_VELO_AVAILABLE(32L),
  /**
   * The field vz contains valid data.
   */
  @GeneratedMavEnumEntry
  UTM_DATA_AVAIL_FLAGS_VERTICAL_VELO_AVAILABLE(64L),
  /**
   * The fields next_lat, next_lon and next_alt contain valid data.
   */
  @GeneratedMavEnumEntry
  UTM_DATA_AVAIL_FLAGS_NEXT_WAYPOINT_AVAILABLE(128L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UtmDataAvailFlags? = when (v) {
      1L -> UTM_DATA_AVAIL_FLAGS_TIME_VALID
      2L -> UTM_DATA_AVAIL_FLAGS_UAS_ID_AVAILABLE
      4L -> UTM_DATA_AVAIL_FLAGS_POSITION_AVAILABLE
      8L -> UTM_DATA_AVAIL_FLAGS_ALTITUDE_AVAILABLE
      16L -> UTM_DATA_AVAIL_FLAGS_RELATIVE_ALTITUDE_AVAILABLE
      32L -> UTM_DATA_AVAIL_FLAGS_HORIZONTAL_VELO_AVAILABLE
      64L -> UTM_DATA_AVAIL_FLAGS_VERTICAL_VELO_AVAILABLE
      128L -> UTM_DATA_AVAIL_FLAGS_NEXT_WAYPOINT_AVAILABLE
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags for the global position report.
 */
@GeneratedMavEnum(bitmask = true)
public enum class UtmDataAvailFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * The field time contains valid data.
   */
  @GeneratedMavEnumEntry
  TIME_VALID(1u),
  /**
   * The field uas_id contains valid data.
   */
  @GeneratedMavEnumEntry
  UAS_ID_AVAILABLE(2u),
  /**
   * The fields lat, lon and h_acc contain valid data.
   */
  @GeneratedMavEnumEntry
  POSITION_AVAILABLE(4u),
  /**
   * The fields alt and v_acc contain valid data.
   */
  @GeneratedMavEnumEntry
  ALTITUDE_AVAILABLE(8u),
  /**
   * The field relative_alt contains valid data.
   */
  @GeneratedMavEnumEntry
  RELATIVE_ALTITUDE_AVAILABLE(16u),
  /**
   * The fields vx and vy contain valid data.
   */
  @GeneratedMavEnumEntry
  HORIZONTAL_VELO_AVAILABLE(32u),
  /**
   * The field vz contains valid data.
   */
  @GeneratedMavEnumEntry
  VERTICAL_VELO_AVAILABLE(64u),
  /**
   * The fields next_lat, next_lon and next_alt contain valid data.
   */
  @GeneratedMavEnumEntry
  NEXT_WAYPOINT_AVAILABLE(128u),
  ;

  public companion object : MavBitmask.MavCompanion<UtmDataAvailFlags> {
    override fun getEntryFromValueOrNull(v: UInt): UtmDataAvailFlags? = when (v) {
      1u -> TIME_VALID
      2u -> UAS_ID_AVAILABLE
      4u -> POSITION_AVAILABLE
      8u -> ALTITUDE_AVAILABLE
      16u -> RELATIVE_ALTITUDE_AVAILABLE
      32u -> HORIZONTAL_VELO_AVAILABLE
      64u -> VERTICAL_VELO_AVAILABLE
      128u -> NEXT_WAYPOINT_AVAILABLE
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<UtmDataAvailFlags> = buildList {
      if (v and 1u == 1u) add(TIME_VALID)
      if (v and 2u == 2u) add(UAS_ID_AVAILABLE)
      if (v and 4u == 4u) add(POSITION_AVAILABLE)
      if (v and 8u == 8u) add(ALTITUDE_AVAILABLE)
      if (v and 16u == 16u) add(RELATIVE_ALTITUDE_AVAILABLE)
      if (v and 32u == 32u) add(HORIZONTAL_VELO_AVAILABLE)
      if (v and 64u == 64u) add(VERTICAL_VELO_AVAILABLE)
      if (v and 128u == 128u) add(NEXT_WAYPOINT_AVAILABLE)
    }
  }
}

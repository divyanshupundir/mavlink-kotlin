package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * These flags indicate status such as data validity of each data source. Set = data valid
 */
@GeneratedMavEnum(bitmask = true)
public enum class AdsbFlags(
  override val `value`: UInt,
) : MavBitmask {
  @GeneratedMavEnumEntry
  VALID_COORDS(1u),
  @GeneratedMavEnumEntry
  VALID_ALTITUDE(2u),
  @GeneratedMavEnumEntry
  VALID_HEADING(4u),
  @GeneratedMavEnumEntry
  VALID_VELOCITY(8u),
  @GeneratedMavEnumEntry
  VALID_CALLSIGN(16u),
  @GeneratedMavEnumEntry
  VALID_SQUAWK(32u),
  @GeneratedMavEnumEntry
  SIMULATED(64u),
  @GeneratedMavEnumEntry
  VERTICAL_VELOCITY_VALID(128u),
  @GeneratedMavEnumEntry
  BARO_VALID(256u),
  @GeneratedMavEnumEntry
  SOURCE_UAT(32_768u),
  ;

  public companion object : MavBitmask.MavCompanion<AdsbFlags> {
    override fun getEntryFromValueOrNull(v: UInt): AdsbFlags? = when (v) {
      1u -> VALID_COORDS
      2u -> VALID_ALTITUDE
      4u -> VALID_HEADING
      8u -> VALID_VELOCITY
      16u -> VALID_CALLSIGN
      32u -> VALID_SQUAWK
      64u -> SIMULATED
      128u -> VERTICAL_VELOCITY_VALID
      256u -> BARO_VALID
      32768u -> SOURCE_UAT
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<AdsbFlags> = buildList {
      if (v and 1u == 1u) add(VALID_COORDS)
      if (v and 2u == 2u) add(VALID_ALTITUDE)
      if (v and 4u == 4u) add(VALID_HEADING)
      if (v and 8u == 8u) add(VALID_VELOCITY)
      if (v and 16u == 16u) add(VALID_CALLSIGN)
      if (v and 32u == 32u) add(VALID_SQUAWK)
      if (v and 64u == 64u) add(SIMULATED)
      if (v and 128u == 128u) add(VERTICAL_VELOCITY_VALID)
      if (v and 256u == 256u) add(BARO_VALID)
      if (v and 32768u == 32768u) add(SOURCE_UAT)
    }
  }
}

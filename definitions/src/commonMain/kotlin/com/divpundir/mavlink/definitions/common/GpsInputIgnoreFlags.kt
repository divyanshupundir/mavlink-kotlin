package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

@GeneratedMavEnum(bitmask = true)
public enum class GpsInputIgnoreFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * ignore altitude field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_ALT(1u),
  /**
   * ignore hdop field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_HDOP(2u),
  /**
   * ignore vdop field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_VDOP(4u),
  /**
   * ignore horizontal velocity field (vn and ve)
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_VEL_HORIZ(8u),
  /**
   * ignore vertical velocity field (vd)
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_VEL_VERT(16u),
  /**
   * ignore speed accuracy field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY(32u),
  /**
   * ignore horizontal accuracy field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY(64u),
  /**
   * ignore vertical accuracy field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_VERTICAL_ACCURACY(128u),
  ;

  public companion object : MavBitmask.MavCompanion<GpsInputIgnoreFlags> {
    override fun getEntryFromValueOrNull(v: UInt): GpsInputIgnoreFlags? = when (v) {
      1u -> GPS_INPUT_IGNORE_FLAG_ALT
      2u -> GPS_INPUT_IGNORE_FLAG_HDOP
      4u -> GPS_INPUT_IGNORE_FLAG_VDOP
      8u -> GPS_INPUT_IGNORE_FLAG_VEL_HORIZ
      16u -> GPS_INPUT_IGNORE_FLAG_VEL_VERT
      32u -> GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY
      64u -> GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY
      128u -> GPS_INPUT_IGNORE_FLAG_VERTICAL_ACCURACY
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<GpsInputIgnoreFlags> = buildList {
      if (v and 1u == 1u) add(GPS_INPUT_IGNORE_FLAG_ALT)
      if (v and 2u == 2u) add(GPS_INPUT_IGNORE_FLAG_HDOP)
      if (v and 4u == 4u) add(GPS_INPUT_IGNORE_FLAG_VDOP)
      if (v and 8u == 8u) add(GPS_INPUT_IGNORE_FLAG_VEL_HORIZ)
      if (v and 16u == 16u) add(GPS_INPUT_IGNORE_FLAG_VEL_VERT)
      if (v and 32u == 32u) add(GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY)
      if (v and 64u == 64u) add(GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY)
      if (v and 128u == 128u) add(GPS_INPUT_IGNORE_FLAG_VERTICAL_ACCURACY)
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

@GeneratedMavEnum(bitmask = true)
public enum class GpsInputIgnoreFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * ignore altitude field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_ALT(1L),
  /**
   * ignore hdop field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_HDOP(2L),
  /**
   * ignore vdop field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_VDOP(4L),
  /**
   * ignore horizontal velocity field (vn and ve)
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_VEL_HORIZ(8L),
  /**
   * ignore vertical velocity field (vd)
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_VEL_VERT(16L),
  /**
   * ignore speed accuracy field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY(32L),
  /**
   * ignore horizontal accuracy field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY(64L),
  /**
   * ignore vertical accuracy field
   */
  @GeneratedMavEnumEntry
  GPS_INPUT_IGNORE_FLAG_VERTICAL_ACCURACY(128L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GpsInputIgnoreFlags? = when (v) {
      1L -> GPS_INPUT_IGNORE_FLAG_ALT
      2L -> GPS_INPUT_IGNORE_FLAG_HDOP
      4L -> GPS_INPUT_IGNORE_FLAG_VDOP
      8L -> GPS_INPUT_IGNORE_FLAG_VEL_HORIZ
      16L -> GPS_INPUT_IGNORE_FLAG_VEL_VERT
      32L -> GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY
      64L -> GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY
      128L -> GPS_INPUT_IGNORE_FLAG_VERTICAL_ACCURACY
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<GpsInputIgnoreFlags> = buildList {
      if (v and 1L == 1L) add(GPS_INPUT_IGNORE_FLAG_ALT)
      if (v and 2L == 2L) add(GPS_INPUT_IGNORE_FLAG_HDOP)
      if (v and 4L == 4L) add(GPS_INPUT_IGNORE_FLAG_VDOP)
      if (v and 8L == 8L) add(GPS_INPUT_IGNORE_FLAG_VEL_HORIZ)
      if (v and 16L == 16L) add(GPS_INPUT_IGNORE_FLAG_VEL_VERT)
      if (v and 32L == 32L) add(GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY)
      if (v and 64L == 64L) add(GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY)
      if (v and 128L == 128L) add(GPS_INPUT_IGNORE_FLAG_VERTICAL_ACCURACY)
    }
  }
}

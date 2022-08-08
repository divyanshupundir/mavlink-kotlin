package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class GpsInputIgnoreFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * ignore altitude field
   */
  GPS_INPUT_IGNORE_FLAG_ALT(1L),
  /**
   * ignore hdop field
   */
  GPS_INPUT_IGNORE_FLAG_HDOP(2L),
  /**
   * ignore vdop field
   */
  GPS_INPUT_IGNORE_FLAG_VDOP(4L),
  /**
   * ignore horizontal velocity field (vn and ve)
   */
  GPS_INPUT_IGNORE_FLAG_VEL_HORIZ(8L),
  /**
   * ignore vertical velocity field (vd)
   */
  GPS_INPUT_IGNORE_FLAG_VEL_VERT(16L),
  /**
   * ignore speed accuracy field
   */
  GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY(32L),
  /**
   * ignore horizontal accuracy field
   */
  GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY(64L),
  /**
   * ignore vertical accuracy field
   */
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
  }
}

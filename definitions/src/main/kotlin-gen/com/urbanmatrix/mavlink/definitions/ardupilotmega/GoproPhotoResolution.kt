package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GoproPhotoResolution(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 5MP Medium.
   */
  GOPRO_PHOTO_RESOLUTION_5MP_MEDIUM(0L),
  /**
   * 7MP Medium.
   */
  GOPRO_PHOTO_RESOLUTION_7MP_MEDIUM(1L),
  /**
   * 7MP Wide.
   */
  GOPRO_PHOTO_RESOLUTION_7MP_WIDE(2L),
  /**
   * 10MP Wide.
   */
  GOPRO_PHOTO_RESOLUTION_10MP_WIDE(3L),
  /**
   * 12MP Wide.
   */
  GOPRO_PHOTO_RESOLUTION_12MP_WIDE(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproPhotoResolution? = when (v) {
      0L -> GOPRO_PHOTO_RESOLUTION_5MP_MEDIUM
      1L -> GOPRO_PHOTO_RESOLUTION_7MP_MEDIUM
      2L -> GOPRO_PHOTO_RESOLUTION_7MP_WIDE
      3L -> GOPRO_PHOTO_RESOLUTION_10MP_WIDE
      4L -> GOPRO_PHOTO_RESOLUTION_12MP_WIDE
      else -> null
    }
  }
}

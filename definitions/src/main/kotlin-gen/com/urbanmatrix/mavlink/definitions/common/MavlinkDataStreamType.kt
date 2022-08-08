package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class MavlinkDataStreamType(
  public override val `value`: Long,
) : MavEnum {
  MAVLINK_DATA_STREAM_IMG_JPEG(0L),
  MAVLINK_DATA_STREAM_IMG_BMP(1L),
  MAVLINK_DATA_STREAM_IMG_RAW8U(2L),
  MAVLINK_DATA_STREAM_IMG_RAW32U(3L),
  MAVLINK_DATA_STREAM_IMG_PGM(4L),
  MAVLINK_DATA_STREAM_IMG_PNG(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavlinkDataStreamType? = when (v) {
      0L -> MAVLINK_DATA_STREAM_IMG_JPEG
      1L -> MAVLINK_DATA_STREAM_IMG_BMP
      2L -> MAVLINK_DATA_STREAM_IMG_RAW8U
      3L -> MAVLINK_DATA_STREAM_IMG_RAW32U
      4L -> MAVLINK_DATA_STREAM_IMG_PGM
      5L -> MAVLINK_DATA_STREAM_IMG_PNG
      else -> null
    }
  }
}

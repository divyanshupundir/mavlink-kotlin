package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavlinkDataStreamType(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_JPEG(0L),
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_BMP(1L),
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_RAW8U(2L),
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_RAW32U(3L),
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_PGM(4L),
  @GeneratedMavEnumEntry
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

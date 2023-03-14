package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavlinkDataStreamType(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_JPEG(0u),
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_BMP(1u),
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_RAW8U(2u),
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_RAW32U(3u),
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_PGM(4u),
  @GeneratedMavEnumEntry
  MAVLINK_DATA_STREAM_IMG_PNG(5u),
  ;

  public companion object : MavEnum.Companion<MavlinkDataStreamType> {
    public override fun getEntryFromValueOrNull(v: UInt): MavlinkDataStreamType? = when (v) {
      0u -> MAVLINK_DATA_STREAM_IMG_JPEG
      1u -> MAVLINK_DATA_STREAM_IMG_BMP
      2u -> MAVLINK_DATA_STREAM_IMG_RAW8U
      3u -> MAVLINK_DATA_STREAM_IMG_RAW32U
      4u -> MAVLINK_DATA_STREAM_IMG_PGM
      5u -> MAVLINK_DATA_STREAM_IMG_PNG
      else -> null
    }
  }
}

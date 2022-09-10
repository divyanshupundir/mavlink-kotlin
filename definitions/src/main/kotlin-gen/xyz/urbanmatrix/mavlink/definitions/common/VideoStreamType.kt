package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Video stream types
 */
@GeneratedMavEnum
public enum class VideoStreamType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Stream is RTSP
   */
  @GeneratedMavEnumEntry
  VIDEO_STREAM_TYPE_RTSP(0L),
  /**
   * Stream is RTP UDP (URI gives the port number)
   */
  @GeneratedMavEnumEntry
  VIDEO_STREAM_TYPE_RTPUDP(1L),
  /**
   * Stream is MPEG on TCP
   */
  @GeneratedMavEnumEntry
  VIDEO_STREAM_TYPE_TCP_MPEG(2L),
  /**
   * Stream is h.264 on MPEG TS (URI gives the port number)
   */
  @GeneratedMavEnumEntry
  VIDEO_STREAM_TYPE_MPEG_TS_H264(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): VideoStreamType? = when (v) {
      0L -> VIDEO_STREAM_TYPE_RTSP
      1L -> VIDEO_STREAM_TYPE_RTPUDP
      2L -> VIDEO_STREAM_TYPE_TCP_MPEG
      3L -> VIDEO_STREAM_TYPE_MPEG_TS_H264
      else -> null
    }
  }
}

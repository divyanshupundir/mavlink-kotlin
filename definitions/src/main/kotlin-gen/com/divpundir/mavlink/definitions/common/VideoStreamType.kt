package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Video stream types
 */
@GeneratedMavEnum
public enum class VideoStreamType(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Stream is RTSP
   */
  @GeneratedMavEnumEntry
  RTSP(0u),
  /**
   * Stream is RTP UDP (URI gives the port number)
   */
  @GeneratedMavEnumEntry
  RTPUDP(1u),
  /**
   * Stream is MPEG on TCP
   */
  @GeneratedMavEnumEntry
  TCP_MPEG(2u),
  /**
   * Stream is h.264 on MPEG TS (URI gives the port number)
   */
  @GeneratedMavEnumEntry
  MPEG_TS_H264(3u),
  ;

  public companion object : MavEnum.Companion<VideoStreamType> {
    public override fun getEntryFromValueOrNull(v: UInt): VideoStreamType? = when (v) {
      0u -> RTSP
      1u -> RTPUDP
      2u -> TCP_MPEG
      3u -> MPEG_TS_H264
      else -> null
    }
  }
}

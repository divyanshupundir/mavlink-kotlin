package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GoproResolution(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 848 x 480 (480p).
   */
  GOPRO_RESOLUTION_480p(0L),
  /**
   * 1280 x 720 (720p).
   */
  GOPRO_RESOLUTION_720p(1L),
  /**
   * 1280 x 960 (960p).
   */
  GOPRO_RESOLUTION_960p(2L),
  /**
   * 1920 x 1080 (1080p).
   */
  GOPRO_RESOLUTION_1080p(3L),
  /**
   * 1920 x 1440 (1440p).
   */
  GOPRO_RESOLUTION_1440p(4L),
  /**
   * 2704 x 1440 (2.7k-17:9).
   */
  GOPRO_RESOLUTION_2_7k_17_9(5L),
  /**
   * 2704 x 1524 (2.7k-16:9).
   */
  GOPRO_RESOLUTION_2_7k_16_9(6L),
  /**
   * 2704 x 2028 (2.7k-4:3).
   */
  GOPRO_RESOLUTION_2_7k_4_3(7L),
  /**
   * 3840 x 2160 (4k-16:9).
   */
  GOPRO_RESOLUTION_4k_16_9(8L),
  /**
   * 4096 x 2160 (4k-17:9).
   */
  GOPRO_RESOLUTION_4k_17_9(9L),
  /**
   * 1280 x 720 (720p-SuperView).
   */
  GOPRO_RESOLUTION_720p_SUPERVIEW(10L),
  /**
   * 1920 x 1080 (1080p-SuperView).
   */
  GOPRO_RESOLUTION_1080p_SUPERVIEW(11L),
  /**
   * 2704 x 1520 (2.7k-SuperView).
   */
  GOPRO_RESOLUTION_2_7k_SUPERVIEW(12L),
  /**
   * 3840 x 2160 (4k-SuperView).
   */
  GOPRO_RESOLUTION_4k_SUPERVIEW(13L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproResolution? = when (v) {
      0L -> GOPRO_RESOLUTION_480p
      1L -> GOPRO_RESOLUTION_720p
      2L -> GOPRO_RESOLUTION_960p
      3L -> GOPRO_RESOLUTION_1080p
      4L -> GOPRO_RESOLUTION_1440p
      5L -> GOPRO_RESOLUTION_2_7k_17_9
      6L -> GOPRO_RESOLUTION_2_7k_16_9
      7L -> GOPRO_RESOLUTION_2_7k_4_3
      8L -> GOPRO_RESOLUTION_4k_16_9
      9L -> GOPRO_RESOLUTION_4k_17_9
      10L -> GOPRO_RESOLUTION_720p_SUPERVIEW
      11L -> GOPRO_RESOLUTION_1080p_SUPERVIEW
      12L -> GOPRO_RESOLUTION_2_7k_SUPERVIEW
      13L -> GOPRO_RESOLUTION_4k_SUPERVIEW
      else -> null
    }
  }
}

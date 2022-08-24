package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproFrameRate(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 12 FPS.
   */
  GOPRO_FRAME_RATE_12(0L),
  /**
   * 15 FPS.
   */
  GOPRO_FRAME_RATE_15(1L),
  /**
   * 24 FPS.
   */
  GOPRO_FRAME_RATE_24(2L),
  /**
   * 25 FPS.
   */
  GOPRO_FRAME_RATE_25(3L),
  /**
   * 30 FPS.
   */
  GOPRO_FRAME_RATE_30(4L),
  /**
   * 48 FPS.
   */
  GOPRO_FRAME_RATE_48(5L),
  /**
   * 50 FPS.
   */
  GOPRO_FRAME_RATE_50(6L),
  /**
   * 60 FPS.
   */
  GOPRO_FRAME_RATE_60(7L),
  /**
   * 80 FPS.
   */
  GOPRO_FRAME_RATE_80(8L),
  /**
   * 90 FPS.
   */
  GOPRO_FRAME_RATE_90(9L),
  /**
   * 100 FPS.
   */
  GOPRO_FRAME_RATE_100(10L),
  /**
   * 120 FPS.
   */
  GOPRO_FRAME_RATE_120(11L),
  /**
   * 240 FPS.
   */
  GOPRO_FRAME_RATE_240(12L),
  /**
   * 12.5 FPS.
   */
  GOPRO_FRAME_RATE_12_5(13L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproFrameRate? = when (v) {
      0L -> GOPRO_FRAME_RATE_12
      1L -> GOPRO_FRAME_RATE_15
      2L -> GOPRO_FRAME_RATE_24
      3L -> GOPRO_FRAME_RATE_25
      4L -> GOPRO_FRAME_RATE_30
      5L -> GOPRO_FRAME_RATE_48
      6L -> GOPRO_FRAME_RATE_50
      7L -> GOPRO_FRAME_RATE_60
      8L -> GOPRO_FRAME_RATE_80
      9L -> GOPRO_FRAME_RATE_90
      10L -> GOPRO_FRAME_RATE_100
      11L -> GOPRO_FRAME_RATE_120
      12L -> GOPRO_FRAME_RATE_240
      13L -> GOPRO_FRAME_RATE_12_5
      else -> null
    }
  }
}

package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GoproCaptureMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Video mode.
   */
  GOPRO_CAPTURE_MODE_VIDEO(0L),
  /**
   * Photo mode.
   */
  GOPRO_CAPTURE_MODE_PHOTO(1L),
  /**
   * Burst mode, Hero 3+ only.
   */
  GOPRO_CAPTURE_MODE_BURST(2L),
  /**
   * Time lapse mode, Hero 3+ only.
   */
  GOPRO_CAPTURE_MODE_TIME_LAPSE(3L),
  /**
   * Multi shot mode, Hero 4 only.
   */
  GOPRO_CAPTURE_MODE_MULTI_SHOT(4L),
  /**
   * Playback mode, Hero 4 only, silver only except when LCD or HDMI is connected to black.
   */
  GOPRO_CAPTURE_MODE_PLAYBACK(5L),
  /**
   * Playback mode, Hero 4 only.
   */
  GOPRO_CAPTURE_MODE_SETUP(6L),
  /**
   * Mode not yet known.
   */
  GOPRO_CAPTURE_MODE_UNKNOWN(255L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproCaptureMode? = when (v) {
      0L -> GOPRO_CAPTURE_MODE_VIDEO
      1L -> GOPRO_CAPTURE_MODE_PHOTO
      2L -> GOPRO_CAPTURE_MODE_BURST
      3L -> GOPRO_CAPTURE_MODE_TIME_LAPSE
      4L -> GOPRO_CAPTURE_MODE_MULTI_SHOT
      5L -> GOPRO_CAPTURE_MODE_PLAYBACK
      6L -> GOPRO_CAPTURE_MODE_SETUP
      255L -> GOPRO_CAPTURE_MODE_UNKNOWN
      else -> null
    }
  }
}

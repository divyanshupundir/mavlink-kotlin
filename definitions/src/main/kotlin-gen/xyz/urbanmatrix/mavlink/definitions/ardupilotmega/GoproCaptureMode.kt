package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproCaptureMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Video mode.
   */
  @GeneratedMavEnumEntry
  VIDEO(0L),
  /**
   * Photo mode.
   */
  @GeneratedMavEnumEntry
  PHOTO(1L),
  /**
   * Burst mode, Hero 3+ only.
   */
  @GeneratedMavEnumEntry
  BURST(2L),
  /**
   * Time lapse mode, Hero 3+ only.
   */
  @GeneratedMavEnumEntry
  TIME_LAPSE(3L),
  /**
   * Multi shot mode, Hero 4 only.
   */
  @GeneratedMavEnumEntry
  MULTI_SHOT(4L),
  /**
   * Playback mode, Hero 4 only, silver only except when LCD or HDMI is connected to black.
   */
  @GeneratedMavEnumEntry
  PLAYBACK(5L),
  /**
   * Playback mode, Hero 4 only.
   */
  @GeneratedMavEnumEntry
  SETUP(6L),
  /**
   * Mode not yet known.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(255L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproCaptureMode? = when (v) {
      0L -> VIDEO
      1L -> PHOTO
      2L -> BURST
      3L -> TIME_LAPSE
      4L -> MULTI_SHOT
      5L -> PLAYBACK
      6L -> SETUP
      255L -> UNKNOWN
      else -> null
    }
  }
}

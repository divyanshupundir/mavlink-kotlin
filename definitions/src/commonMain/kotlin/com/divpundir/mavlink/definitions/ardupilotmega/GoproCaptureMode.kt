package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproCaptureMode(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Video mode.
   */
  @GeneratedMavEnumEntry
  VIDEO(0u),
  /**
   * Photo mode.
   */
  @GeneratedMavEnumEntry
  PHOTO(1u),
  /**
   * Burst mode, Hero 3+ only.
   */
  @GeneratedMavEnumEntry
  BURST(2u),
  /**
   * Time lapse mode, Hero 3+ only.
   */
  @GeneratedMavEnumEntry
  TIME_LAPSE(3u),
  /**
   * Multi shot mode, Hero 4 only.
   */
  @GeneratedMavEnumEntry
  MULTI_SHOT(4u),
  /**
   * Playback mode, Hero 4 only, silver only except when LCD or HDMI is connected to black.
   */
  @GeneratedMavEnumEntry
  PLAYBACK(5u),
  /**
   * Playback mode, Hero 4 only.
   */
  @GeneratedMavEnumEntry
  SETUP(6u),
  /**
   * Mode not yet known.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(255u),
  ;

  public companion object : MavEnum.MavCompanion<GoproCaptureMode> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproCaptureMode? = when (v) {
      0u -> VIDEO
      1u -> PHOTO
      2u -> BURST
      3u -> TIME_LAPSE
      4u -> MULTI_SHOT
      5u -> PLAYBACK
      6u -> SETUP
      255u -> UNKNOWN
      else -> null
    }
  }
}

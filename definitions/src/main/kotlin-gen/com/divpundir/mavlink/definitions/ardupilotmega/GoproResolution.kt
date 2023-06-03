package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproResolution(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * 848 x 480 (480p).
   */
  @GeneratedMavEnumEntry
  _480p(0u),
  /**
   * 1280 x 720 (720p).
   */
  @GeneratedMavEnumEntry
  _720p(1u),
  /**
   * 1280 x 960 (960p).
   */
  @GeneratedMavEnumEntry
  _960p(2u),
  /**
   * 1920 x 1080 (1080p).
   */
  @GeneratedMavEnumEntry
  _1080p(3u),
  /**
   * 1920 x 1440 (1440p).
   */
  @GeneratedMavEnumEntry
  _1440p(4u),
  /**
   * 2704 x 1440 (2.7k-17:9).
   */
  @GeneratedMavEnumEntry
  _2_7k_17_9(5u),
  /**
   * 2704 x 1524 (2.7k-16:9).
   */
  @GeneratedMavEnumEntry
  _2_7k_16_9(6u),
  /**
   * 2704 x 2028 (2.7k-4:3).
   */
  @GeneratedMavEnumEntry
  _2_7k_4_3(7u),
  /**
   * 3840 x 2160 (4k-16:9).
   */
  @GeneratedMavEnumEntry
  _4k_16_9(8u),
  /**
   * 4096 x 2160 (4k-17:9).
   */
  @GeneratedMavEnumEntry
  _4k_17_9(9u),
  /**
   * 1280 x 720 (720p-SuperView).
   */
  @GeneratedMavEnumEntry
  _720p_SUPERVIEW(10u),
  /**
   * 1920 x 1080 (1080p-SuperView).
   */
  @GeneratedMavEnumEntry
  _1080p_SUPERVIEW(11u),
  /**
   * 2704 x 1520 (2.7k-SuperView).
   */
  @GeneratedMavEnumEntry
  _2_7k_SUPERVIEW(12u),
  /**
   * 3840 x 2160 (4k-SuperView).
   */
  @GeneratedMavEnumEntry
  _4k_SUPERVIEW(13u),
  ;

  public companion object : MavEnum.MavCompanion<GoproResolution> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproResolution? = when (v) {
      0u -> _480p
      1u -> _720p
      2u -> _960p
      3u -> _1080p
      4u -> _1440p
      5u -> _2_7k_17_9
      6u -> _2_7k_16_9
      7u -> _2_7k_4_3
      8u -> _4k_16_9
      9u -> _4k_17_9
      10u -> _720p_SUPERVIEW
      11u -> _1080p_SUPERVIEW
      12u -> _2_7k_SUPERVIEW
      13u -> _4k_SUPERVIEW
      else -> null
    }
  }
}

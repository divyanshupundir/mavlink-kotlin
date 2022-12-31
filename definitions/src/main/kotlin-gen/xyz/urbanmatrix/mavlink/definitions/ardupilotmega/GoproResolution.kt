package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproResolution(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 848 x 480 (480p).
   */
  @GeneratedMavEnumEntry
  _480p(0L),
  /**
   * 1280 x 720 (720p).
   */
  @GeneratedMavEnumEntry
  _720p(1L),
  /**
   * 1280 x 960 (960p).
   */
  @GeneratedMavEnumEntry
  _960p(2L),
  /**
   * 1920 x 1080 (1080p).
   */
  @GeneratedMavEnumEntry
  _1080p(3L),
  /**
   * 1920 x 1440 (1440p).
   */
  @GeneratedMavEnumEntry
  _1440p(4L),
  /**
   * 2704 x 1440 (2.7k-17:9).
   */
  @GeneratedMavEnumEntry
  _2_7k_17_9(5L),
  /**
   * 2704 x 1524 (2.7k-16:9).
   */
  @GeneratedMavEnumEntry
  _2_7k_16_9(6L),
  /**
   * 2704 x 2028 (2.7k-4:3).
   */
  @GeneratedMavEnumEntry
  _2_7k_4_3(7L),
  /**
   * 3840 x 2160 (4k-16:9).
   */
  @GeneratedMavEnumEntry
  _4k_16_9(8L),
  /**
   * 4096 x 2160 (4k-17:9).
   */
  @GeneratedMavEnumEntry
  _4k_17_9(9L),
  /**
   * 1280 x 720 (720p-SuperView).
   */
  @GeneratedMavEnumEntry
  _720p_SUPERVIEW(10L),
  /**
   * 1920 x 1080 (1080p-SuperView).
   */
  @GeneratedMavEnumEntry
  _1080p_SUPERVIEW(11L),
  /**
   * 2704 x 1520 (2.7k-SuperView).
   */
  @GeneratedMavEnumEntry
  _2_7k_SUPERVIEW(12L),
  /**
   * 3840 x 2160 (4k-SuperView).
   */
  @GeneratedMavEnumEntry
  _4k_SUPERVIEW(13L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproResolution? = when (v) {
      0L -> _480p
      1L -> _720p
      2L -> _960p
      3L -> _1080p
      4L -> _1440p
      5L -> _2_7k_17_9
      6L -> _2_7k_16_9
      7L -> _2_7k_4_3
      8L -> _4k_16_9
      9L -> _4k_17_9
      10L -> _720p_SUPERVIEW
      11L -> _1080p_SUPERVIEW
      12L -> _2_7k_SUPERVIEW
      13L -> _4k_SUPERVIEW
      else -> null
    }
  }
}

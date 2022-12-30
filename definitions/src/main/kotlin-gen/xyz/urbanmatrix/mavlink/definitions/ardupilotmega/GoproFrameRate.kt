package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproFrameRate(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 12 FPS.
   */
  @GeneratedMavEnumEntry
  _12(0L),
  /**
   * 15 FPS.
   */
  @GeneratedMavEnumEntry
  _15(1L),
  /**
   * 24 FPS.
   */
  @GeneratedMavEnumEntry
  _24(2L),
  /**
   * 25 FPS.
   */
  @GeneratedMavEnumEntry
  _25(3L),
  /**
   * 30 FPS.
   */
  @GeneratedMavEnumEntry
  _30(4L),
  /**
   * 48 FPS.
   */
  @GeneratedMavEnumEntry
  _48(5L),
  /**
   * 50 FPS.
   */
  @GeneratedMavEnumEntry
  _50(6L),
  /**
   * 60 FPS.
   */
  @GeneratedMavEnumEntry
  _60(7L),
  /**
   * 80 FPS.
   */
  @GeneratedMavEnumEntry
  _80(8L),
  /**
   * 90 FPS.
   */
  @GeneratedMavEnumEntry
  _90(9L),
  /**
   * 100 FPS.
   */
  @GeneratedMavEnumEntry
  _100(10L),
  /**
   * 120 FPS.
   */
  @GeneratedMavEnumEntry
  _120(11L),
  /**
   * 240 FPS.
   */
  @GeneratedMavEnumEntry
  _240(12L),
  /**
   * 12.5 FPS.
   */
  @GeneratedMavEnumEntry
  _12_5(13L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproFrameRate? = when (v) {
      0L -> _12
      1L -> _15
      2L -> _24
      3L -> _25
      4L -> _30
      5L -> _48
      6L -> _50
      7L -> _60
      8L -> _80
      9L -> _90
      10L -> _100
      11L -> _120
      12L -> _240
      13L -> _12_5
      else -> null
    }
  }
}

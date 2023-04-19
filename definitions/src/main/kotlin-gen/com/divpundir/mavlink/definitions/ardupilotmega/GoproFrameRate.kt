package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproFrameRate(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * 12 FPS.
   */
  @GeneratedMavEnumEntry
  _12(0u),
  /**
   * 15 FPS.
   */
  @GeneratedMavEnumEntry
  _15(1u),
  /**
   * 24 FPS.
   */
  @GeneratedMavEnumEntry
  _24(2u),
  /**
   * 25 FPS.
   */
  @GeneratedMavEnumEntry
  _25(3u),
  /**
   * 30 FPS.
   */
  @GeneratedMavEnumEntry
  _30(4u),
  /**
   * 48 FPS.
   */
  @GeneratedMavEnumEntry
  _48(5u),
  /**
   * 50 FPS.
   */
  @GeneratedMavEnumEntry
  _50(6u),
  /**
   * 60 FPS.
   */
  @GeneratedMavEnumEntry
  _60(7u),
  /**
   * 80 FPS.
   */
  @GeneratedMavEnumEntry
  _80(8u),
  /**
   * 90 FPS.
   */
  @GeneratedMavEnumEntry
  _90(9u),
  /**
   * 100 FPS.
   */
  @GeneratedMavEnumEntry
  _100(10u),
  /**
   * 120 FPS.
   */
  @GeneratedMavEnumEntry
  _120(11u),
  /**
   * 240 FPS.
   */
  @GeneratedMavEnumEntry
  _240(12u),
  /**
   * 12.5 FPS.
   */
  @GeneratedMavEnumEntry
  _12_5(13u),
  ;

  public companion object : MavEnum.Companion<GoproFrameRate> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproFrameRate? = when (v) {
      0u -> _12
      1u -> _15
      2u -> _24
      3u -> _25
      4u -> _30
      5u -> _48
      6u -> _50
      7u -> _60
      8u -> _80
      9u -> _90
      10u -> _100
      11u -> _120
      12u -> _240
      13u -> _12_5
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproBurstRate(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * 3 Shots / 1 Second.
   */
  @GeneratedMavEnumEntry
  _3_IN_1_SECOND(0u),
  /**
   * 5 Shots / 1 Second.
   */
  @GeneratedMavEnumEntry
  _5_IN_1_SECOND(1u),
  /**
   * 10 Shots / 1 Second.
   */
  @GeneratedMavEnumEntry
  _10_IN_1_SECOND(2u),
  /**
   * 10 Shots / 2 Second.
   */
  @GeneratedMavEnumEntry
  _10_IN_2_SECOND(3u),
  /**
   * 10 Shots / 3 Second (Hero 4 Only).
   */
  @GeneratedMavEnumEntry
  _10_IN_3_SECOND(4u),
  /**
   * 30 Shots / 1 Second.
   */
  @GeneratedMavEnumEntry
  _30_IN_1_SECOND(5u),
  /**
   * 30 Shots / 2 Second.
   */
  @GeneratedMavEnumEntry
  _30_IN_2_SECOND(6u),
  /**
   * 30 Shots / 3 Second.
   */
  @GeneratedMavEnumEntry
  _30_IN_3_SECOND(7u),
  /**
   * 30 Shots / 6 Second.
   */
  @GeneratedMavEnumEntry
  _30_IN_6_SECOND(8u),
  ;

  public companion object : MavEnum.Companion<GoproBurstRate> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproBurstRate? = when (v) {
      0u -> _3_IN_1_SECOND
      1u -> _5_IN_1_SECOND
      2u -> _10_IN_1_SECOND
      3u -> _10_IN_2_SECOND
      4u -> _10_IN_3_SECOND
      5u -> _30_IN_1_SECOND
      6u -> _30_IN_2_SECOND
      7u -> _30_IN_3_SECOND
      8u -> _30_IN_6_SECOND
      else -> null
    }
  }
}

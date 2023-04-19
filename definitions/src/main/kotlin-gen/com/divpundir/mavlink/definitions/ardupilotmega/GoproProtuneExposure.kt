package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproProtuneExposure(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * -5.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  NEG_5_0(0u),
  /**
   * -4.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  NEG_4_5(1u),
  /**
   * -4.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  NEG_4_0(2u),
  /**
   * -3.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  NEG_3_5(3u),
  /**
   * -3.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  NEG_3_0(4u),
  /**
   * -2.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  NEG_2_5(5u),
  /**
   * -2.0 EV.
   */
  @GeneratedMavEnumEntry
  NEG_2_0(6u),
  /**
   * -1.5 EV.
   */
  @GeneratedMavEnumEntry
  NEG_1_5(7u),
  /**
   * -1.0 EV.
   */
  @GeneratedMavEnumEntry
  NEG_1_0(8u),
  /**
   * -0.5 EV.
   */
  @GeneratedMavEnumEntry
  NEG_0_5(9u),
  /**
   * 0.0 EV.
   */
  @GeneratedMavEnumEntry
  ZERO(10u),
  /**
   * +0.5 EV.
   */
  @GeneratedMavEnumEntry
  POS_0_5(11u),
  /**
   * +1.0 EV.
   */
  @GeneratedMavEnumEntry
  POS_1_0(12u),
  /**
   * +1.5 EV.
   */
  @GeneratedMavEnumEntry
  POS_1_5(13u),
  /**
   * +2.0 EV.
   */
  @GeneratedMavEnumEntry
  POS_2_0(14u),
  /**
   * +2.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  POS_2_5(15u),
  /**
   * +3.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  POS_3_0(16u),
  /**
   * +3.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  POS_3_5(17u),
  /**
   * +4.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  POS_4_0(18u),
  /**
   * +4.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  POS_4_5(19u),
  /**
   * +5.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  POS_5_0(20u),
  ;

  public companion object : MavEnum.Companion<GoproProtuneExposure> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproProtuneExposure? = when (v) {
      0u -> NEG_5_0
      1u -> NEG_4_5
      2u -> NEG_4_0
      3u -> NEG_3_5
      4u -> NEG_3_0
      5u -> NEG_2_5
      6u -> NEG_2_0
      7u -> NEG_1_5
      8u -> NEG_1_0
      9u -> NEG_0_5
      10u -> ZERO
      11u -> POS_0_5
      12u -> POS_1_0
      13u -> POS_1_5
      14u -> POS_2_0
      15u -> POS_2_5
      16u -> POS_3_0
      17u -> POS_3_5
      18u -> POS_4_0
      19u -> POS_4_5
      20u -> POS_5_0
      else -> null
    }
  }
}

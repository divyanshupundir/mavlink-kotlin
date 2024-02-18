package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidTimeAcc(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The timestamp accuracy is unknown.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * The timestamp accuracy is smaller than or equal to 0.1 second.
   */
  @GeneratedMavEnumEntry
  _0_1_SECOND(1u),
  /**
   * The timestamp accuracy is smaller than or equal to 0.2 second.
   */
  @GeneratedMavEnumEntry
  _0_2_SECOND(2u),
  /**
   * The timestamp accuracy is smaller than or equal to 0.3 second.
   */
  @GeneratedMavEnumEntry
  _0_3_SECOND(3u),
  /**
   * The timestamp accuracy is smaller than or equal to 0.4 second.
   */
  @GeneratedMavEnumEntry
  _0_4_SECOND(4u),
  /**
   * The timestamp accuracy is smaller than or equal to 0.5 second.
   */
  @GeneratedMavEnumEntry
  _0_5_SECOND(5u),
  /**
   * The timestamp accuracy is smaller than or equal to 0.6 second.
   */
  @GeneratedMavEnumEntry
  _0_6_SECOND(6u),
  /**
   * The timestamp accuracy is smaller than or equal to 0.7 second.
   */
  @GeneratedMavEnumEntry
  _0_7_SECOND(7u),
  /**
   * The timestamp accuracy is smaller than or equal to 0.8 second.
   */
  @GeneratedMavEnumEntry
  _0_8_SECOND(8u),
  /**
   * The timestamp accuracy is smaller than or equal to 0.9 second.
   */
  @GeneratedMavEnumEntry
  _0_9_SECOND(9u),
  /**
   * The timestamp accuracy is smaller than or equal to 1.0 second.
   */
  @GeneratedMavEnumEntry
  _1_0_SECOND(10u),
  /**
   * The timestamp accuracy is smaller than or equal to 1.1 second.
   */
  @GeneratedMavEnumEntry
  _1_1_SECOND(11u),
  /**
   * The timestamp accuracy is smaller than or equal to 1.2 second.
   */
  @GeneratedMavEnumEntry
  _1_2_SECOND(12u),
  /**
   * The timestamp accuracy is smaller than or equal to 1.3 second.
   */
  @GeneratedMavEnumEntry
  _1_3_SECOND(13u),
  /**
   * The timestamp accuracy is smaller than or equal to 1.4 second.
   */
  @GeneratedMavEnumEntry
  _1_4_SECOND(14u),
  /**
   * The timestamp accuracy is smaller than or equal to 1.5 second.
   */
  @GeneratedMavEnumEntry
  _1_5_SECOND(15u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidTimeAcc> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidTimeAcc? = when (v) {
      0u -> UNKNOWN
      1u -> _0_1_SECOND
      2u -> _0_2_SECOND
      3u -> _0_3_SECOND
      4u -> _0_4_SECOND
      5u -> _0_5_SECOND
      6u -> _0_6_SECOND
      7u -> _0_7_SECOND
      8u -> _0_8_SECOND
      9u -> _0_9_SECOND
      10u -> _1_0_SECOND
      11u -> _1_1_SECOND
      12u -> _1_2_SECOND
      13u -> _1_3_SECOND
      14u -> _1_4_SECOND
      15u -> _1_5_SECOND
      else -> null
    }
  }
}

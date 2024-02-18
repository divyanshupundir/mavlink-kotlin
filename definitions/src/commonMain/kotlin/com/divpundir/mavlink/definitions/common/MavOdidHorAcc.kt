package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidHorAcc(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The horizontal accuracy is unknown.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * The horizontal accuracy is smaller than 10 Nautical Miles. 18.52 km.
   */
  @GeneratedMavEnumEntry
  _10NM(1u),
  /**
   * The horizontal accuracy is smaller than 4 Nautical Miles. 7.408 km.
   */
  @GeneratedMavEnumEntry
  _4NM(2u),
  /**
   * The horizontal accuracy is smaller than 2 Nautical Miles. 3.704 km.
   */
  @GeneratedMavEnumEntry
  _2NM(3u),
  /**
   * The horizontal accuracy is smaller than 1 Nautical Miles. 1.852 km.
   */
  @GeneratedMavEnumEntry
  _1NM(4u),
  /**
   * The horizontal accuracy is smaller than 0.5 Nautical Miles. 926 m.
   */
  @GeneratedMavEnumEntry
  _0_5NM(5u),
  /**
   * The horizontal accuracy is smaller than 0.3 Nautical Miles. 555.6 m.
   */
  @GeneratedMavEnumEntry
  _0_3NM(6u),
  /**
   * The horizontal accuracy is smaller than 0.1 Nautical Miles. 185.2 m.
   */
  @GeneratedMavEnumEntry
  _0_1NM(7u),
  /**
   * The horizontal accuracy is smaller than 0.05 Nautical Miles. 92.6 m.
   */
  @GeneratedMavEnumEntry
  _0_05NM(8u),
  /**
   * The horizontal accuracy is smaller than 30 meter.
   */
  @GeneratedMavEnumEntry
  _30_METER(9u),
  /**
   * The horizontal accuracy is smaller than 10 meter.
   */
  @GeneratedMavEnumEntry
  _10_METER(10u),
  /**
   * The horizontal accuracy is smaller than 3 meter.
   */
  @GeneratedMavEnumEntry
  _3_METER(11u),
  /**
   * The horizontal accuracy is smaller than 1 meter.
   */
  @GeneratedMavEnumEntry
  _1_METER(12u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidHorAcc> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidHorAcc? = when (v) {
      0u -> UNKNOWN
      1u -> _10NM
      2u -> _4NM
      3u -> _2NM
      4u -> _1NM
      5u -> _0_5NM
      6u -> _0_3NM
      7u -> _0_1NM
      8u -> _0_05NM
      9u -> _30_METER
      10u -> _10_METER
      11u -> _3_METER
      12u -> _1_METER
      else -> null
    }
  }
}

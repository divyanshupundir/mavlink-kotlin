package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidHorAcc(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The horizontal accuracy is unknown.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * The horizontal accuracy is smaller than 10 Nautical Miles. 18.52 km.
   */
  @GeneratedMavEnumEntry
  _10NM(1L),
  /**
   * The horizontal accuracy is smaller than 4 Nautical Miles. 7.408 km.
   */
  @GeneratedMavEnumEntry
  _4NM(2L),
  /**
   * The horizontal accuracy is smaller than 2 Nautical Miles. 3.704 km.
   */
  @GeneratedMavEnumEntry
  _2NM(3L),
  /**
   * The horizontal accuracy is smaller than 1 Nautical Miles. 1.852 km.
   */
  @GeneratedMavEnumEntry
  _1NM(4L),
  /**
   * The horizontal accuracy is smaller than 0.5 Nautical Miles. 926 m.
   */
  @GeneratedMavEnumEntry
  _0_5NM(5L),
  /**
   * The horizontal accuracy is smaller than 0.3 Nautical Miles. 555.6 m.
   */
  @GeneratedMavEnumEntry
  _0_3NM(6L),
  /**
   * The horizontal accuracy is smaller than 0.1 Nautical Miles. 185.2 m.
   */
  @GeneratedMavEnumEntry
  _0_1NM(7L),
  /**
   * The horizontal accuracy is smaller than 0.05 Nautical Miles. 92.6 m.
   */
  @GeneratedMavEnumEntry
  _0_05NM(8L),
  /**
   * The horizontal accuracy is smaller than 30 meter.
   */
  @GeneratedMavEnumEntry
  _30_METER(9L),
  /**
   * The horizontal accuracy is smaller than 10 meter.
   */
  @GeneratedMavEnumEntry
  _10_METER(10L),
  /**
   * The horizontal accuracy is smaller than 3 meter.
   */
  @GeneratedMavEnumEntry
  _3_METER(11L),
  /**
   * The horizontal accuracy is smaller than 1 meter.
   */
  @GeneratedMavEnumEntry
  _1_METER(12L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidHorAcc? = when (v) {
      0L -> UNKNOWN
      1L -> _10NM
      2L -> _4NM
      3L -> _2NM
      4L -> _1NM
      5L -> _0_5NM
      6L -> _0_3NM
      7L -> _0_1NM
      8L -> _0_05NM
      9L -> _30_METER
      10L -> _10_METER
      11L -> _3_METER
      12L -> _1_METER
      else -> null
    }
  }
}

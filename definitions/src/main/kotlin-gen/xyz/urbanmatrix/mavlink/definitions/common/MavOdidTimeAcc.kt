package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidTimeAcc(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The timestamp accuracy is unknown.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.1 second.
   */
  @GeneratedMavEnumEntry
  _0_1_SECOND(1L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.2 second.
   */
  @GeneratedMavEnumEntry
  _0_2_SECOND(2L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.3 second.
   */
  @GeneratedMavEnumEntry
  _0_3_SECOND(3L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.4 second.
   */
  @GeneratedMavEnumEntry
  _0_4_SECOND(4L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.5 second.
   */
  @GeneratedMavEnumEntry
  _0_5_SECOND(5L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.6 second.
   */
  @GeneratedMavEnumEntry
  _0_6_SECOND(6L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.7 second.
   */
  @GeneratedMavEnumEntry
  _0_7_SECOND(7L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.8 second.
   */
  @GeneratedMavEnumEntry
  _0_8_SECOND(8L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.9 second.
   */
  @GeneratedMavEnumEntry
  _0_9_SECOND(9L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.0 second.
   */
  @GeneratedMavEnumEntry
  _1_0_SECOND(10L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.1 second.
   */
  @GeneratedMavEnumEntry
  _1_1_SECOND(11L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.2 second.
   */
  @GeneratedMavEnumEntry
  _1_2_SECOND(12L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.3 second.
   */
  @GeneratedMavEnumEntry
  _1_3_SECOND(13L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.4 second.
   */
  @GeneratedMavEnumEntry
  _1_4_SECOND(14L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.5 second.
   */
  @GeneratedMavEnumEntry
  _1_5_SECOND(15L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidTimeAcc? = when (v) {
      0L -> UNKNOWN
      1L -> _0_1_SECOND
      2L -> _0_2_SECOND
      3L -> _0_3_SECOND
      4L -> _0_4_SECOND
      5L -> _0_5_SECOND
      6L -> _0_6_SECOND
      7L -> _0_7_SECOND
      8L -> _0_8_SECOND
      9L -> _0_9_SECOND
      10L -> _1_0_SECOND
      11L -> _1_1_SECOND
      12L -> _1_2_SECOND
      13L -> _1_3_SECOND
      14L -> _1_4_SECOND
      15L -> _1_5_SECOND
      else -> null
    }
  }
}

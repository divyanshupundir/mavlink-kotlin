package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidVerAcc(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The vertical accuracy is unknown.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * The vertical accuracy is smaller than 150 meter.
   */
  @GeneratedMavEnumEntry
  _150_METER(1L),
  /**
   * The vertical accuracy is smaller than 45 meter.
   */
  @GeneratedMavEnumEntry
  _45_METER(2L),
  /**
   * The vertical accuracy is smaller than 25 meter.
   */
  @GeneratedMavEnumEntry
  _25_METER(3L),
  /**
   * The vertical accuracy is smaller than 10 meter.
   */
  @GeneratedMavEnumEntry
  _10_METER(4L),
  /**
   * The vertical accuracy is smaller than 3 meter.
   */
  @GeneratedMavEnumEntry
  _3_METER(5L),
  /**
   * The vertical accuracy is smaller than 1 meter.
   */
  @GeneratedMavEnumEntry
  _1_METER(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidVerAcc? = when (v) {
      0L -> UNKNOWN
      1L -> _150_METER
      2L -> _45_METER
      3L -> _25_METER
      4L -> _10_METER
      5L -> _3_METER
      6L -> _1_METER
      else -> null
    }
  }
}

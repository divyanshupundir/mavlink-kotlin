package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidVerAcc(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The vertical accuracy is unknown.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * The vertical accuracy is smaller than 150 meter.
   */
  @GeneratedMavEnumEntry
  _150_METER(1u),
  /**
   * The vertical accuracy is smaller than 45 meter.
   */
  @GeneratedMavEnumEntry
  _45_METER(2u),
  /**
   * The vertical accuracy is smaller than 25 meter.
   */
  @GeneratedMavEnumEntry
  _25_METER(3u),
  /**
   * The vertical accuracy is smaller than 10 meter.
   */
  @GeneratedMavEnumEntry
  _10_METER(4u),
  /**
   * The vertical accuracy is smaller than 3 meter.
   */
  @GeneratedMavEnumEntry
  _3_METER(5u),
  /**
   * The vertical accuracy is smaller than 1 meter.
   */
  @GeneratedMavEnumEntry
  _1_METER(6u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidVerAcc> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidVerAcc? = when (v) {
      0u -> UNKNOWN
      1u -> _150_METER
      2u -> _45_METER
      3u -> _25_METER
      4u -> _10_METER
      5u -> _3_METER
      6u -> _1_METER
      else -> null
    }
  }
}

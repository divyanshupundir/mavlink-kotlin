package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidSpeedAcc(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The speed accuracy is unknown.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * The speed accuracy is smaller than 10 meters per second.
   */
  @GeneratedMavEnumEntry
  _10_METERS_PER_SECOND(1u),
  /**
   * The speed accuracy is smaller than 3 meters per second.
   */
  @GeneratedMavEnumEntry
  _3_METERS_PER_SECOND(2u),
  /**
   * The speed accuracy is smaller than 1 meters per second.
   */
  @GeneratedMavEnumEntry
  _1_METERS_PER_SECOND(3u),
  /**
   * The speed accuracy is smaller than 0.3 meters per second.
   */
  @GeneratedMavEnumEntry
  _0_3_METERS_PER_SECOND(4u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidSpeedAcc> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidSpeedAcc? = when (v) {
      0u -> UNKNOWN
      1u -> _10_METERS_PER_SECOND
      2u -> _3_METERS_PER_SECOND
      3u -> _1_METERS_PER_SECOND
      4u -> _0_3_METERS_PER_SECOND
      else -> null
    }
  }
}

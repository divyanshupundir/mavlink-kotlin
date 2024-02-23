package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Speed setpoint types used in MAV_CMD_DO_CHANGE_SPEED
 */
@GeneratedMavEnum
public enum class SpeedType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Airspeed
   */
  @GeneratedMavEnumEntry
  AIRSPEED(0u),
  /**
   * Groundspeed
   */
  @GeneratedMavEnumEntry
  GROUNDSPEED(1u),
  /**
   * Climb speed
   */
  @GeneratedMavEnumEntry
  CLIMB_SPEED(2u),
  /**
   * Descent speed
   */
  @GeneratedMavEnumEntry
  DESCENT_SPEED(3u),
  ;

  public companion object : MavEnum.MavCompanion<SpeedType> {
    override fun getEntryFromValueOrNull(v: UInt): SpeedType? = when (v) {
      0u -> AIRSPEED
      1u -> GROUNDSPEED
      2u -> CLIMB_SPEED
      3u -> DESCENT_SPEED
      else -> null
    }
  }
}

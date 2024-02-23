package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Defines how throttle value is represented in MAV_CMD_DO_MOTOR_TEST.
 */
@GeneratedMavEnum
public enum class MotorTestThrottleType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Throttle as a percentage (0 ~ 100)
   */
  @GeneratedMavEnumEntry
  MOTOR_TEST_THROTTLE_PERCENT(0u),
  /**
   * Throttle as an absolute PWM value (normally in range of 1000~2000).
   */
  @GeneratedMavEnumEntry
  MOTOR_TEST_THROTTLE_PWM(1u),
  /**
   * Throttle pass-through from pilot's transmitter.
   */
  @GeneratedMavEnumEntry
  MOTOR_TEST_THROTTLE_PILOT(2u),
  /**
   * Per-motor compass calibration test.
   */
  @GeneratedMavEnumEntry
  MOTOR_TEST_COMPASS_CAL(3u),
  ;

  public companion object : MavEnum.MavCompanion<MotorTestThrottleType> {
    override fun getEntryFromValueOrNull(v: UInt): MotorTestThrottleType? = when (v) {
      0u -> MOTOR_TEST_THROTTLE_PERCENT
      1u -> MOTOR_TEST_THROTTLE_PWM
      2u -> MOTOR_TEST_THROTTLE_PILOT
      3u -> MOTOR_TEST_COMPASS_CAL
      else -> null
    }
  }
}

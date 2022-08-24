package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Defines how throttle value is represented in MAV_CMD_DO_MOTOR_TEST.
 */
@GeneratedMavEnum
public enum class MotorTestThrottleType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Throttle as a percentage (0 ~ 100)
   */
  MOTOR_TEST_THROTTLE_PERCENT(0L),
  /**
   * Throttle as an absolute PWM value (normally in range of 1000~2000).
   */
  MOTOR_TEST_THROTTLE_PWM(1L),
  /**
   * Throttle pass-through from pilot's transmitter.
   */
  MOTOR_TEST_THROTTLE_PILOT(2L),
  /**
   * Per-motor compass calibration test.
   */
  MOTOR_TEST_COMPASS_CAL(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MotorTestThrottleType? = when (v) {
      0L -> MOTOR_TEST_THROTTLE_PERCENT
      1L -> MOTOR_TEST_THROTTLE_PWM
      2L -> MOTOR_TEST_THROTTLE_PILOT
      3L -> MOTOR_TEST_COMPASS_CAL
      else -> null
    }
  }
}

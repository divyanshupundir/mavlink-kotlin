package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Sequence that motors are tested when using MAV_CMD_DO_MOTOR_TEST.
 */
public enum class MotorTestOrder(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Default autopilot motor test method.
   */
  MOTOR_TEST_ORDER_DEFAULT(0L),
  /**
   * Motor numbers are specified as their index in a predefined vehicle-specific sequence.
   */
  MOTOR_TEST_ORDER_SEQUENCE(1L),
  /**
   * Motor numbers are specified as the output as labeled on the board.
   */
  MOTOR_TEST_ORDER_BOARD(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MotorTestOrder? = when (v) {
      0L -> MOTOR_TEST_ORDER_DEFAULT
      1L -> MOTOR_TEST_ORDER_SEQUENCE
      2L -> MOTOR_TEST_ORDER_BOARD
      else -> null
    }
  }
}

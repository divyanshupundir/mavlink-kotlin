package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Sequence that motors are tested when using MAV_CMD_DO_MOTOR_TEST.
 */
@GeneratedMavEnum
public enum class MotorTestOrder(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Default autopilot motor test method.
   */
  @GeneratedMavEnumEntry
  DEFAULT(0L),
  /**
   * Motor numbers are specified as their index in a predefined vehicle-specific sequence.
   */
  @GeneratedMavEnumEntry
  SEQUENCE(1L),
  /**
   * Motor numbers are specified as the output as labeled on the board.
   */
  @GeneratedMavEnumEntry
  BOARD(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MotorTestOrder? = when (v) {
      0L -> DEFAULT
      1L -> SEQUENCE
      2L -> BOARD
      else -> null
    }
  }
}

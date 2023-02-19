package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Sequence that motors are tested when using MAV_CMD_DO_MOTOR_TEST.
 */
@GeneratedMavEnum
public enum class MotorTestOrder(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Default autopilot motor test method.
   */
  @GeneratedMavEnumEntry
  DEFAULT(0u),
  /**
   * Motor numbers are specified as their index in a predefined vehicle-specific sequence.
   */
  @GeneratedMavEnumEntry
  SEQUENCE(1u),
  /**
   * Motor numbers are specified as the output as labeled on the board.
   */
  @GeneratedMavEnumEntry
  BOARD(2u),
  ;

  public companion object : MavEnum.Companion<MotorTestOrder> {
    public override fun getEntryFromValueOrNull(v: UInt): MotorTestOrder? = when (v) {
      0u -> DEFAULT
      1u -> SEQUENCE
      2u -> BOARD
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Sequence that motors are tested when using MAV_CMD_DO_MOTOR_TEST.
 */
@GeneratedMavEnum
public enum class MotorTestOrder(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<MotorTestOrder> {
    override fun getEntryFromValueOrNull(v: UInt): MotorTestOrder? = when (v) {
      0u -> DEFAULT
      1u -> SEQUENCE
      2u -> BOARD
      else -> null
    }
  }
}

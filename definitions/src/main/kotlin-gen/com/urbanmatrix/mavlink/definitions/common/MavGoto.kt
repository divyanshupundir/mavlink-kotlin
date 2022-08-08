package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Actions that may be specified in MAV_CMD_OVERRIDE_GOTO to override mission execution.
 */
@GeneratedMavEnum
public enum class MavGoto(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Hold at the current position.
   */
  MAV_GOTO_DO_HOLD(0L),
  /**
   * Continue with the next item in mission execution.
   */
  MAV_GOTO_DO_CONTINUE(1L),
  /**
   * Hold at the current position of the system
   */
  MAV_GOTO_HOLD_AT_CURRENT_POSITION(2L),
  /**
   * Hold at the position specified in the parameters of the DO_HOLD action
   */
  MAV_GOTO_HOLD_AT_SPECIFIED_POSITION(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavGoto? = when (v) {
      0L -> MAV_GOTO_DO_HOLD
      1L -> MAV_GOTO_DO_CONTINUE
      2L -> MAV_GOTO_HOLD_AT_CURRENT_POSITION
      3L -> MAV_GOTO_HOLD_AT_SPECIFIED_POSITION
      else -> null
    }
  }
}

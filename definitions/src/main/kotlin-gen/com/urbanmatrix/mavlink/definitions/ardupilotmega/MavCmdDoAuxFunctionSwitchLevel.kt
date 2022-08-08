package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class MavCmdDoAuxFunctionSwitchLevel(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Switch Low.
   */
  MAV_CMD_DO_AUX_FUNCTION_SWITCH_LEVEL_LOW(0L),
  /**
   * Switch Middle.
   */
  MAV_CMD_DO_AUX_FUNCTION_SWITCH_LEVEL_MIDDLE(1L),
  /**
   * Switch High.
   */
  MAV_CMD_DO_AUX_FUNCTION_SWITCH_LEVEL_HIGH(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCmdDoAuxFunctionSwitchLevel? = when (v) {
      0L -> MAV_CMD_DO_AUX_FUNCTION_SWITCH_LEVEL_LOW
      1L -> MAV_CMD_DO_AUX_FUNCTION_SWITCH_LEVEL_MIDDLE
      2L -> MAV_CMD_DO_AUX_FUNCTION_SWITCH_LEVEL_HIGH
      else -> null
    }
  }
}

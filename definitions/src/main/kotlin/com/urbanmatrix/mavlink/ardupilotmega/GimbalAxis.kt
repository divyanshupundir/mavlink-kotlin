package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GimbalAxis(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Gimbal yaw axis.
   */
  GIMBAL_AXIS_YAW(0L),
  /**
   * Gimbal pitch axis.
   */
  GIMBAL_AXIS_PITCH(1L),
  /**
   * Gimbal roll axis.
   */
  GIMBAL_AXIS_ROLL(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalAxis? = when (v) {
      0L -> GIMBAL_AXIS_YAW
      1L -> GIMBAL_AXIS_PITCH
      2L -> GIMBAL_AXIS_ROLL
      else -> null
    }
  }
}

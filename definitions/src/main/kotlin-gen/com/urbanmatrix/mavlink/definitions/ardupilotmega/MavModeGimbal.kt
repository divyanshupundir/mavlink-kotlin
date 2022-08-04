package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavModeGimbal(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Gimbal is powered on but has not started initializing yet.
   */
  MAV_MODE_GIMBAL_UNINITIALIZED(0L),
  /**
   * Gimbal is currently running calibration on the pitch axis.
   */
  MAV_MODE_GIMBAL_CALIBRATING_PITCH(1L),
  /**
   * Gimbal is currently running calibration on the roll axis.
   */
  MAV_MODE_GIMBAL_CALIBRATING_ROLL(2L),
  /**
   * Gimbal is currently running calibration on the yaw axis.
   */
  MAV_MODE_GIMBAL_CALIBRATING_YAW(3L),
  /**
   * Gimbal has finished calibrating and initializing, but is relaxed pending reception of first
   * rate command from copter.
   */
  MAV_MODE_GIMBAL_INITIALIZED(4L),
  /**
   * Gimbal is actively stabilizing.
   */
  MAV_MODE_GIMBAL_ACTIVE(5L),
  /**
   * Gimbal is relaxed because it missed more than 10 expected rate command messages in a row.
   * Gimbal will move back to active mode when it receives a new rate command.
   */
  MAV_MODE_GIMBAL_RATE_CMD_TIMEOUT(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavModeGimbal? = when (v) {
      0L -> MAV_MODE_GIMBAL_UNINITIALIZED
      1L -> MAV_MODE_GIMBAL_CALIBRATING_PITCH
      2L -> MAV_MODE_GIMBAL_CALIBRATING_ROLL
      3L -> MAV_MODE_GIMBAL_CALIBRATING_YAW
      4L -> MAV_MODE_GIMBAL_INITIALIZED
      5L -> MAV_MODE_GIMBAL_ACTIVE
      6L -> MAV_MODE_GIMBAL_RATE_CMD_TIMEOUT
      else -> null
    }
  }
}

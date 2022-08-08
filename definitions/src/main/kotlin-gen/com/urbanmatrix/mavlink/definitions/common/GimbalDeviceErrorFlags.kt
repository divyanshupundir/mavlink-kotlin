package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Gimbal device (low level) error flags (bitmap, 0 means no error)
 */
@GeneratedMavEnum
public enum class GimbalDeviceErrorFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Gimbal device is limited by hardware roll limit.
   */
  GIMBAL_DEVICE_ERROR_FLAGS_AT_ROLL_LIMIT(1L),
  /**
   * Gimbal device is limited by hardware pitch limit.
   */
  GIMBAL_DEVICE_ERROR_FLAGS_AT_PITCH_LIMIT(2L),
  /**
   * Gimbal device is limited by hardware yaw limit.
   */
  GIMBAL_DEVICE_ERROR_FLAGS_AT_YAW_LIMIT(4L),
  /**
   * There is an error with the gimbal encoders.
   */
  GIMBAL_DEVICE_ERROR_FLAGS_ENCODER_ERROR(8L),
  /**
   * There is an error with the gimbal power source.
   */
  GIMBAL_DEVICE_ERROR_FLAGS_POWER_ERROR(16L),
  /**
   * There is an error with the gimbal motor's.
   */
  GIMBAL_DEVICE_ERROR_FLAGS_MOTOR_ERROR(32L),
  /**
   * There is an error with the gimbal's software.
   */
  GIMBAL_DEVICE_ERROR_FLAGS_SOFTWARE_ERROR(64L),
  /**
   * There is an error with the gimbal's communication.
   */
  GIMBAL_DEVICE_ERROR_FLAGS_COMMS_ERROR(128L),
  /**
   * Gimbal is currently calibrating.
   */
  GIMBAL_DEVICE_ERROR_FLAGS_CALIBRATION_RUNNING(256L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalDeviceErrorFlags? = when (v) {
      1L -> GIMBAL_DEVICE_ERROR_FLAGS_AT_ROLL_LIMIT
      2L -> GIMBAL_DEVICE_ERROR_FLAGS_AT_PITCH_LIMIT
      4L -> GIMBAL_DEVICE_ERROR_FLAGS_AT_YAW_LIMIT
      8L -> GIMBAL_DEVICE_ERROR_FLAGS_ENCODER_ERROR
      16L -> GIMBAL_DEVICE_ERROR_FLAGS_POWER_ERROR
      32L -> GIMBAL_DEVICE_ERROR_FLAGS_MOTOR_ERROR
      64L -> GIMBAL_DEVICE_ERROR_FLAGS_SOFTWARE_ERROR
      128L -> GIMBAL_DEVICE_ERROR_FLAGS_COMMS_ERROR
      256L -> GIMBAL_DEVICE_ERROR_FLAGS_CALIBRATION_RUNNING
      else -> null
    }
  }
}

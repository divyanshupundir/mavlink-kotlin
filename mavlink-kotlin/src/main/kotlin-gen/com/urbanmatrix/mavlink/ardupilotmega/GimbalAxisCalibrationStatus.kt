package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GimbalAxisCalibrationStatus(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Axis calibration is in progress.
   */
  GIMBAL_AXIS_CALIBRATION_STATUS_IN_PROGRESS(0L),
  /**
   * Axis calibration succeeded.
   */
  GIMBAL_AXIS_CALIBRATION_STATUS_SUCCEEDED(1L),
  /**
   * Axis calibration failed.
   */
  GIMBAL_AXIS_CALIBRATION_STATUS_FAILED(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalAxisCalibrationStatus? = when (v) {
      0L -> GIMBAL_AXIS_CALIBRATION_STATUS_IN_PROGRESS
      1L -> GIMBAL_AXIS_CALIBRATION_STATUS_SUCCEEDED
      2L -> GIMBAL_AXIS_CALIBRATION_STATUS_FAILED
      else -> null
    }
  }
}

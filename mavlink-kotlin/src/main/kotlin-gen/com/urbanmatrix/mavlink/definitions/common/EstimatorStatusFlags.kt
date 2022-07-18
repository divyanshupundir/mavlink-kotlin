package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Flags in ESTIMATOR_STATUS message
 */
public enum class EstimatorStatusFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * True if the attitude estimate is good
   */
  ESTIMATOR_ATTITUDE(1L),
  /**
   * True if the horizontal velocity estimate is good
   */
  ESTIMATOR_VELOCITY_HORIZ(2L),
  /**
   * True if the  vertical velocity estimate is good
   */
  ESTIMATOR_VELOCITY_VERT(4L),
  /**
   * True if the horizontal position (relative) estimate is good
   */
  ESTIMATOR_POS_HORIZ_REL(8L),
  /**
   * True if the horizontal position (absolute) estimate is good
   */
  ESTIMATOR_POS_HORIZ_ABS(16L),
  /**
   * True if the vertical position (absolute) estimate is good
   */
  ESTIMATOR_POS_VERT_ABS(32L),
  /**
   * True if the vertical position (above ground) estimate is good
   */
  ESTIMATOR_POS_VERT_AGL(64L),
  /**
   * True if the EKF is in a constant position mode and is not using external measurements (eg GPS
   * or optical flow)
   */
  ESTIMATOR_CONST_POS_MODE(128L),
  /**
   * True if the EKF has sufficient data to enter a mode that will provide a (relative) position
   * estimate
   */
  ESTIMATOR_PRED_POS_HORIZ_REL(256L),
  /**
   * True if the EKF has sufficient data to enter a mode that will provide a (absolute) position
   * estimate
   */
  ESTIMATOR_PRED_POS_HORIZ_ABS(512L),
  /**
   * True if the EKF has detected a GPS glitch
   */
  ESTIMATOR_GPS_GLITCH(1024L),
  /**
   * True if the EKF has detected bad accelerometer data
   */
  ESTIMATOR_ACCEL_ERROR(2048L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): EstimatorStatusFlags? = when (v) {
      1L -> ESTIMATOR_ATTITUDE
      2L -> ESTIMATOR_VELOCITY_HORIZ
      4L -> ESTIMATOR_VELOCITY_VERT
      8L -> ESTIMATOR_POS_HORIZ_REL
      16L -> ESTIMATOR_POS_HORIZ_ABS
      32L -> ESTIMATOR_POS_VERT_ABS
      64L -> ESTIMATOR_POS_VERT_AGL
      128L -> ESTIMATOR_CONST_POS_MODE
      256L -> ESTIMATOR_PRED_POS_HORIZ_REL
      512L -> ESTIMATOR_PRED_POS_HORIZ_ABS
      1024L -> ESTIMATOR_GPS_GLITCH
      2048L -> ESTIMATOR_ACCEL_ERROR
      else -> null
    }
  }
}

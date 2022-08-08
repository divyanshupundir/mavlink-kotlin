package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Enumeration of estimator types
 */
@GeneratedMavEnum
public enum class MavEstimatorType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Unknown type of the estimator.
   */
  MAV_ESTIMATOR_TYPE_UNKNOWN(0L),
  /**
   * This is a naive estimator without any real covariance feedback.
   */
  MAV_ESTIMATOR_TYPE_NAIVE(1L),
  /**
   * Computer vision based estimate. Might be up to scale.
   */
  MAV_ESTIMATOR_TYPE_VISION(2L),
  /**
   * Visual-inertial estimate.
   */
  MAV_ESTIMATOR_TYPE_VIO(3L),
  /**
   * Plain GPS estimate.
   */
  MAV_ESTIMATOR_TYPE_GPS(4L),
  /**
   * Estimator integrating GPS and inertial sensing.
   */
  MAV_ESTIMATOR_TYPE_GPS_INS(5L),
  /**
   * Estimate from external motion capturing system.
   */
  MAV_ESTIMATOR_TYPE_MOCAP(6L),
  /**
   * Estimator based on lidar sensor input.
   */
  MAV_ESTIMATOR_TYPE_LIDAR(7L),
  /**
   * Estimator on autopilot.
   */
  MAV_ESTIMATOR_TYPE_AUTOPILOT(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavEstimatorType? = when (v) {
      0L -> MAV_ESTIMATOR_TYPE_UNKNOWN
      1L -> MAV_ESTIMATOR_TYPE_NAIVE
      2L -> MAV_ESTIMATOR_TYPE_VISION
      3L -> MAV_ESTIMATOR_TYPE_VIO
      4L -> MAV_ESTIMATOR_TYPE_GPS
      5L -> MAV_ESTIMATOR_TYPE_GPS_INS
      6L -> MAV_ESTIMATOR_TYPE_MOCAP
      7L -> MAV_ESTIMATOR_TYPE_LIDAR
      8L -> MAV_ESTIMATOR_TYPE_AUTOPILOT
      else -> null
    }
  }
}

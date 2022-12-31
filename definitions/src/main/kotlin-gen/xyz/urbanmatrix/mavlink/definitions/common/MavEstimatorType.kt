package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * This is a naive estimator without any real covariance feedback.
   */
  @GeneratedMavEnumEntry
  NAIVE(1L),
  /**
   * Computer vision based estimate. Might be up to scale.
   */
  @GeneratedMavEnumEntry
  VISION(2L),
  /**
   * Visual-inertial estimate.
   */
  @GeneratedMavEnumEntry
  VIO(3L),
  /**
   * Plain GPS estimate.
   */
  @GeneratedMavEnumEntry
  GPS(4L),
  /**
   * Estimator integrating GPS and inertial sensing.
   */
  @GeneratedMavEnumEntry
  GPS_INS(5L),
  /**
   * Estimate from external motion capturing system.
   */
  @GeneratedMavEnumEntry
  MOCAP(6L),
  /**
   * Estimator based on lidar sensor input.
   */
  @GeneratedMavEnumEntry
  LIDAR(7L),
  /**
   * Estimator on autopilot.
   */
  @GeneratedMavEnumEntry
  AUTOPILOT(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavEstimatorType? = when (v) {
      0L -> UNKNOWN
      1L -> NAIVE
      2L -> VISION
      3L -> VIO
      4L -> GPS
      5L -> GPS_INS
      6L -> MOCAP
      7L -> LIDAR
      8L -> AUTOPILOT
      else -> null
    }
  }
}

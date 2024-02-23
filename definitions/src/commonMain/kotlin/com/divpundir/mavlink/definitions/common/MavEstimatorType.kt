package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Enumeration of estimator types
 */
@GeneratedMavEnum
public enum class MavEstimatorType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Unknown type of the estimator.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * This is a naive estimator without any real covariance feedback.
   */
  @GeneratedMavEnumEntry
  NAIVE(1u),
  /**
   * Computer vision based estimate. Might be up to scale.
   */
  @GeneratedMavEnumEntry
  VISION(2u),
  /**
   * Visual-inertial estimate.
   */
  @GeneratedMavEnumEntry
  VIO(3u),
  /**
   * Plain GPS estimate.
   */
  @GeneratedMavEnumEntry
  GPS(4u),
  /**
   * Estimator integrating GPS and inertial sensing.
   */
  @GeneratedMavEnumEntry
  GPS_INS(5u),
  /**
   * Estimate from external motion capturing system.
   */
  @GeneratedMavEnumEntry
  MOCAP(6u),
  /**
   * Estimator based on lidar sensor input.
   */
  @GeneratedMavEnumEntry
  LIDAR(7u),
  /**
   * Estimator on autopilot.
   */
  @GeneratedMavEnumEntry
  AUTOPILOT(8u),
  ;

  public companion object : MavEnum.MavCompanion<MavEstimatorType> {
    override fun getEntryFromValueOrNull(v: UInt): MavEstimatorType? = when (v) {
      0u -> UNKNOWN
      1u -> NAIVE
      2u -> VISION
      3u -> VIO
      4u -> GPS
      5u -> GPS_INS
      6u -> MOCAP
      7u -> LIDAR
      8u -> AUTOPILOT
      else -> null
    }
  }
}

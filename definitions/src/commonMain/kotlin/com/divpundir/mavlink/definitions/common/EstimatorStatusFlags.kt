package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags in ESTIMATOR_STATUS message
 */
@GeneratedMavEnum(bitmask = true)
public enum class EstimatorStatusFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * True if the attitude estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_ATTITUDE(1u),
  /**
   * True if the horizontal velocity estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_VELOCITY_HORIZ(2u),
  /**
   * True if the  vertical velocity estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_VELOCITY_VERT(4u),
  /**
   * True if the horizontal position (relative) estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_POS_HORIZ_REL(8u),
  /**
   * True if the horizontal position (absolute) estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_POS_HORIZ_ABS(16u),
  /**
   * True if the vertical position (absolute) estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_POS_VERT_ABS(32u),
  /**
   * True if the vertical position (above ground) estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_POS_VERT_AGL(64u),
  /**
   * True if the EKF is in a constant position mode and is not using external measurements (eg GPS
   * or optical flow)
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_CONST_POS_MODE(128u),
  /**
   * True if the EKF has sufficient data to enter a mode that will provide a (relative) position
   * estimate
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_PRED_POS_HORIZ_REL(256u),
  /**
   * True if the EKF has sufficient data to enter a mode that will provide a (absolute) position
   * estimate
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_PRED_POS_HORIZ_ABS(512u),
  /**
   * True if the EKF has detected a GPS glitch
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_GPS_GLITCH(1_024u),
  /**
   * True if the EKF has detected bad accelerometer data
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_ACCEL_ERROR(2_048u),
  ;

  public companion object : MavBitmask.MavCompanion<EstimatorStatusFlags> {
    override fun getEntryFromValueOrNull(v: UInt): EstimatorStatusFlags? = when (v) {
      1u -> ESTIMATOR_ATTITUDE
      2u -> ESTIMATOR_VELOCITY_HORIZ
      4u -> ESTIMATOR_VELOCITY_VERT
      8u -> ESTIMATOR_POS_HORIZ_REL
      16u -> ESTIMATOR_POS_HORIZ_ABS
      32u -> ESTIMATOR_POS_VERT_ABS
      64u -> ESTIMATOR_POS_VERT_AGL
      128u -> ESTIMATOR_CONST_POS_MODE
      256u -> ESTIMATOR_PRED_POS_HORIZ_REL
      512u -> ESTIMATOR_PRED_POS_HORIZ_ABS
      1024u -> ESTIMATOR_GPS_GLITCH
      2048u -> ESTIMATOR_ACCEL_ERROR
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<EstimatorStatusFlags> = buildList {
      if (v and 1u == 1u) add(ESTIMATOR_ATTITUDE)
      if (v and 2u == 2u) add(ESTIMATOR_VELOCITY_HORIZ)
      if (v and 4u == 4u) add(ESTIMATOR_VELOCITY_VERT)
      if (v and 8u == 8u) add(ESTIMATOR_POS_HORIZ_REL)
      if (v and 16u == 16u) add(ESTIMATOR_POS_HORIZ_ABS)
      if (v and 32u == 32u) add(ESTIMATOR_POS_VERT_ABS)
      if (v and 64u == 64u) add(ESTIMATOR_POS_VERT_AGL)
      if (v and 128u == 128u) add(ESTIMATOR_CONST_POS_MODE)
      if (v and 256u == 256u) add(ESTIMATOR_PRED_POS_HORIZ_REL)
      if (v and 512u == 512u) add(ESTIMATOR_PRED_POS_HORIZ_ABS)
      if (v and 1024u == 1024u) add(ESTIMATOR_GPS_GLITCH)
      if (v and 2048u == 2048u) add(ESTIMATOR_ACCEL_ERROR)
    }
  }
}

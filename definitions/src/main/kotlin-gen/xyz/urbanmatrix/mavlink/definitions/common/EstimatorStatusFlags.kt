package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Flags in ESTIMATOR_STATUS message
 */
@GeneratedMavEnum(bitmask = true)
public enum class EstimatorStatusFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * True if the attitude estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_ATTITUDE(1L),
  /**
   * True if the horizontal velocity estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_VELOCITY_HORIZ(2L),
  /**
   * True if the  vertical velocity estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_VELOCITY_VERT(4L),
  /**
   * True if the horizontal position (relative) estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_POS_HORIZ_REL(8L),
  /**
   * True if the horizontal position (absolute) estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_POS_HORIZ_ABS(16L),
  /**
   * True if the vertical position (absolute) estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_POS_VERT_ABS(32L),
  /**
   * True if the vertical position (above ground) estimate is good
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_POS_VERT_AGL(64L),
  /**
   * True if the EKF is in a constant position mode and is not using external measurements (eg GPS
   * or optical flow)
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_CONST_POS_MODE(128L),
  /**
   * True if the EKF has sufficient data to enter a mode that will provide a (relative) position
   * estimate
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_PRED_POS_HORIZ_REL(256L),
  /**
   * True if the EKF has sufficient data to enter a mode that will provide a (absolute) position
   * estimate
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_PRED_POS_HORIZ_ABS(512L),
  /**
   * True if the EKF has detected a GPS glitch
   */
  @GeneratedMavEnumEntry
  ESTIMATOR_GPS_GLITCH(1024L),
  /**
   * True if the EKF has detected bad accelerometer data
   */
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<EstimatorStatusFlags> = buildList {
      if (v and 1L == 1L) add(ESTIMATOR_ATTITUDE)
      if (v and 2L == 2L) add(ESTIMATOR_VELOCITY_HORIZ)
      if (v and 4L == 4L) add(ESTIMATOR_VELOCITY_VERT)
      if (v and 8L == 8L) add(ESTIMATOR_POS_HORIZ_REL)
      if (v and 16L == 16L) add(ESTIMATOR_POS_HORIZ_ABS)
      if (v and 32L == 32L) add(ESTIMATOR_POS_VERT_ABS)
      if (v and 64L == 64L) add(ESTIMATOR_POS_VERT_AGL)
      if (v and 128L == 128L) add(ESTIMATOR_CONST_POS_MODE)
      if (v and 256L == 256L) add(ESTIMATOR_PRED_POS_HORIZ_REL)
      if (v and 512L == 512L) add(ESTIMATOR_PRED_POS_HORIZ_ABS)
      if (v and 1024L == 1024L) add(ESTIMATOR_GPS_GLITCH)
      if (v and 2048L == 2048L) add(ESTIMATOR_ACCEL_ERROR)
    }
  }
}

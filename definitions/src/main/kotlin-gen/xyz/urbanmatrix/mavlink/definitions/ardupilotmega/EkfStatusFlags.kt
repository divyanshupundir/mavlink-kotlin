package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags in EKF_STATUS message.
 */
@GeneratedMavEnum
public enum class EkfStatusFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Set if EKF's attitude estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_ATTITUDE(1L),
  /**
   * Set if EKF's horizontal velocity estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_VELOCITY_HORIZ(2L),
  /**
   * Set if EKF's vertical velocity estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_VELOCITY_VERT(4L),
  /**
   * Set if EKF's horizontal position (relative) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_POS_HORIZ_REL(8L),
  /**
   * Set if EKF's horizontal position (absolute) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_POS_HORIZ_ABS(16L),
  /**
   * Set if EKF's vertical position (absolute) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_POS_VERT_ABS(32L),
  /**
   * Set if EKF's vertical position (above ground) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_POS_VERT_AGL(64L),
  /**
   * EKF is in constant position mode and does not know it's absolute or relative position.
   */
  @GeneratedMavEnumEntry
  EKF_CONST_POS_MODE(128L),
  /**
   * Set if EKF's predicted horizontal position (relative) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_PRED_POS_HORIZ_REL(256L),
  /**
   * Set if EKF's predicted horizontal position (absolute) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_PRED_POS_HORIZ_ABS(512L),
  /**
   * Set if EKF has never been healthy.
   */
  @GeneratedMavEnumEntry
  EKF_UNINITIALIZED(1024L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): EkfStatusFlags? = when (v) {
      1L -> EKF_ATTITUDE
      2L -> EKF_VELOCITY_HORIZ
      4L -> EKF_VELOCITY_VERT
      8L -> EKF_POS_HORIZ_REL
      16L -> EKF_POS_HORIZ_ABS
      32L -> EKF_POS_VERT_ABS
      64L -> EKF_POS_VERT_AGL
      128L -> EKF_CONST_POS_MODE
      256L -> EKF_PRED_POS_HORIZ_REL
      512L -> EKF_PRED_POS_HORIZ_ABS
      1024L -> EKF_UNINITIALIZED
      else -> null
    }
  }
}

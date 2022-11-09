package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Flags in EKF_STATUS message.
 */
@GeneratedMavEnum(bitmask = true)
public enum class EkfStatusFlags(
  public override val `value`: Long,
) : MavBitmask {
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

    public fun getFlagsFromValue(v: Long): List<EkfStatusFlags> = buildList {
      if (v and 1L == 1L) add(EKF_ATTITUDE)
      if (v and 2L == 2L) add(EKF_VELOCITY_HORIZ)
      if (v and 4L == 4L) add(EKF_VELOCITY_VERT)
      if (v and 8L == 8L) add(EKF_POS_HORIZ_REL)
      if (v and 16L == 16L) add(EKF_POS_HORIZ_ABS)
      if (v and 32L == 32L) add(EKF_POS_VERT_ABS)
      if (v and 64L == 64L) add(EKF_POS_VERT_AGL)
      if (v and 128L == 128L) add(EKF_CONST_POS_MODE)
      if (v and 256L == 256L) add(EKF_PRED_POS_HORIZ_REL)
      if (v and 512L == 512L) add(EKF_PRED_POS_HORIZ_ABS)
      if (v and 1024L == 1024L) add(EKF_UNINITIALIZED)
    }
  }
}

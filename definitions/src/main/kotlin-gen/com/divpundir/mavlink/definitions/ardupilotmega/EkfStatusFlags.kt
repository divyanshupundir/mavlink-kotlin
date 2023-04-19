package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags in EKF_STATUS message.
 */
@GeneratedMavEnum(bitmask = true)
public enum class EkfStatusFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * Set if EKF's attitude estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_ATTITUDE(1u),
  /**
   * Set if EKF's horizontal velocity estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_VELOCITY_HORIZ(2u),
  /**
   * Set if EKF's vertical velocity estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_VELOCITY_VERT(4u),
  /**
   * Set if EKF's horizontal position (relative) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_POS_HORIZ_REL(8u),
  /**
   * Set if EKF's horizontal position (absolute) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_POS_HORIZ_ABS(16u),
  /**
   * Set if EKF's vertical position (absolute) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_POS_VERT_ABS(32u),
  /**
   * Set if EKF's vertical position (above ground) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_POS_VERT_AGL(64u),
  /**
   * EKF is in constant position mode and does not know it's absolute or relative position.
   */
  @GeneratedMavEnumEntry
  EKF_CONST_POS_MODE(128u),
  /**
   * Set if EKF's predicted horizontal position (relative) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_PRED_POS_HORIZ_REL(256u),
  /**
   * Set if EKF's predicted horizontal position (absolute) estimate is good.
   */
  @GeneratedMavEnumEntry
  EKF_PRED_POS_HORIZ_ABS(512u),
  /**
   * Set if EKF has never been healthy.
   */
  @GeneratedMavEnumEntry
  EKF_UNINITIALIZED(1024u),
  ;

  public companion object : MavEnum.Companion<EkfStatusFlags>, MavBitmask.Companion<EkfStatusFlags>
      {
    public override fun getEntryFromValueOrNull(v: UInt): EkfStatusFlags? = when (v) {
      1u -> EKF_ATTITUDE
      2u -> EKF_VELOCITY_HORIZ
      4u -> EKF_VELOCITY_VERT
      8u -> EKF_POS_HORIZ_REL
      16u -> EKF_POS_HORIZ_ABS
      32u -> EKF_POS_VERT_ABS
      64u -> EKF_POS_VERT_AGL
      128u -> EKF_CONST_POS_MODE
      256u -> EKF_PRED_POS_HORIZ_REL
      512u -> EKF_PRED_POS_HORIZ_ABS
      1024u -> EKF_UNINITIALIZED
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<EkfStatusFlags> = buildList {
      if (v and 1u == 1u) add(EKF_ATTITUDE)
      if (v and 2u == 2u) add(EKF_VELOCITY_HORIZ)
      if (v and 4u == 4u) add(EKF_VELOCITY_VERT)
      if (v and 8u == 8u) add(EKF_POS_HORIZ_REL)
      if (v and 16u == 16u) add(EKF_POS_HORIZ_ABS)
      if (v and 32u == 32u) add(EKF_POS_VERT_ABS)
      if (v and 64u == 64u) add(EKF_POS_VERT_AGL)
      if (v and 128u == 128u) add(EKF_CONST_POS_MODE)
      if (v and 256u == 256u) add(EKF_PRED_POS_HORIZ_REL)
      if (v and 512u == 512u) add(EKF_PRED_POS_HORIZ_ABS)
      if (v and 1024u == 1024u) add(EKF_UNINITIALIZED)
    }
  }
}

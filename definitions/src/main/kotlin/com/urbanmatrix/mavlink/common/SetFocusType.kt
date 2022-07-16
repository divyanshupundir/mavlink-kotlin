package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Focus types for MAV_CMD_SET_CAMERA_FOCUS
 */
public enum class SetFocusType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Focus one step increment (-1 for focusing in, 1 for focusing out towards infinity).
   */
  FOCUS_TYPE_STEP(0L),
  /**
   * Continuous focus up/down until stopped (-1 for focusing in, 1 for focusing out towards
   * infinity, 0 to stop focusing)
   */
  FOCUS_TYPE_CONTINUOUS(1L),
  /**
   * Focus value as proportion of full camera focus range (a value between 0.0 and 100.0)
   */
  FOCUS_TYPE_RANGE(2L),
  /**
   * Focus value in metres. Note that there is no message to get the valid focus range of the
   * camera, so this can type can only be used for cameras where the range is known (implying that this
   * cannot reliably be used in a GCS for an arbitrary camera).
   */
  FOCUS_TYPE_METERS(3L),
  /**
   * Focus automatically.
   */
  FOCUS_TYPE_AUTO(4L),
  /**
   * Single auto focus. Mainly used for still pictures. Usually abbreviated as AF-S.
   */
  FOCUS_TYPE_AUTO_SINGLE(5L),
  /**
   * Continuous auto focus. Mainly used for dynamic scenes. Abbreviated as AF-C.
   */
  FOCUS_TYPE_AUTO_CONTINUOUS(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): SetFocusType? = when (v) {
      0L -> FOCUS_TYPE_STEP
      1L -> FOCUS_TYPE_CONTINUOUS
      2L -> FOCUS_TYPE_RANGE
      3L -> FOCUS_TYPE_METERS
      4L -> FOCUS_TYPE_AUTO
      5L -> FOCUS_TYPE_AUTO_SINGLE
      6L -> FOCUS_TYPE_AUTO_CONTINUOUS
      else -> null
    }
  }
}

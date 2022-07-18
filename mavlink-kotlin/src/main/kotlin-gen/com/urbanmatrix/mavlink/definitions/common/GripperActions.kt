package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Gripper actions.
 */
public enum class GripperActions(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Gripper release cargo.
   */
  GRIPPER_ACTION_RELEASE(0L),
  /**
   * Gripper grab onto cargo.
   */
  GRIPPER_ACTION_GRAB(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GripperActions? = when (v) {
      0L -> GRIPPER_ACTION_RELEASE
      1L -> GRIPPER_ACTION_GRAB
      else -> null
    }
  }
}

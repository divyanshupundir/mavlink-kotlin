package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Gripper actions.
 */
@GeneratedMavEnum
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

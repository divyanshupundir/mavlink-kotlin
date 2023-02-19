package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Gripper actions.
 */
@GeneratedMavEnum
public enum class GripperActions(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Gripper release cargo.
   */
  @GeneratedMavEnumEntry
  GRIPPER_ACTION_RELEASE(0u),
  /**
   * Gripper grab onto cargo.
   */
  @GeneratedMavEnumEntry
  GRIPPER_ACTION_GRAB(1u),
  ;

  public companion object : MavEnum.Companion<GripperActions> {
    public override fun getEntryFromValueOrNull(v: UInt): GripperActions? = when (v) {
      0u -> GRIPPER_ACTION_RELEASE
      1u -> GRIPPER_ACTION_GRAB
      else -> null
    }
  }
}

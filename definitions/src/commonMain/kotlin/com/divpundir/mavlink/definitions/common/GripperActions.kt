package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Gripper actions.
 */
@GeneratedMavEnum
public enum class GripperActions(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<GripperActions> {
    override fun getEntryFromValueOrNull(v: UInt): GripperActions? = when (v) {
      0u -> GRIPPER_ACTION_RELEASE
      1u -> GRIPPER_ACTION_GRAB
      else -> null
    }
  }
}

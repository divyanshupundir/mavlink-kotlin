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
   * Gripper commence open. Often used to release cargo.
   */
  @GeneratedMavEnumEntry
  GRIPPER_ACTION_OPEN(0u),
  /**
   * Gripper commence close. Often used to grab onto cargo.
   */
  @GeneratedMavEnumEntry
  GRIPPER_ACTION_CLOSE(1u),
  /**
   * Gripper stop (maintain current grip position).
   */
  @GeneratedMavEnumEntry
  GRIPPER_ACTION_STOP(2u),
  ;

  public companion object : MavEnum.MavCompanion<GripperActions> {
    override fun getEntryFromValueOrNull(v: UInt): GripperActions? = when (v) {
      0u -> GRIPPER_ACTION_OPEN
      1u -> GRIPPER_ACTION_CLOSE
      2u -> GRIPPER_ACTION_STOP
      else -> null
    }
  }
}

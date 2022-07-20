package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Yaw behaviour during orbit flight.
 */
public enum class OrbitYawBehaviour(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Vehicle front points to the center (default).
   */
  ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TO_CIRCLE_CENTER(0L),
  /**
   * Vehicle front holds heading when message received.
   */
  ORBIT_YAW_BEHAVIOUR_HOLD_INITIAL_HEADING(1L),
  /**
   * Yaw uncontrolled.
   */
  ORBIT_YAW_BEHAVIOUR_UNCONTROLLED(2L),
  /**
   * Vehicle front follows flight path (tangential to circle).
   */
  ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TANGENT_TO_CIRCLE(3L),
  /**
   * Yaw controlled by RC input.
   */
  ORBIT_YAW_BEHAVIOUR_RC_CONTROLLED(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): OrbitYawBehaviour? = when (v) {
      0L -> ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TO_CIRCLE_CENTER
      1L -> ORBIT_YAW_BEHAVIOUR_HOLD_INITIAL_HEADING
      2L -> ORBIT_YAW_BEHAVIOUR_UNCONTROLLED
      3L -> ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TANGENT_TO_CIRCLE
      4L -> ORBIT_YAW_BEHAVIOUR_RC_CONTROLLED
      else -> null
    }
  }
}

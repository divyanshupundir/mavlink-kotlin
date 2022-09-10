package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Yaw behaviour during orbit flight.
 */
@GeneratedMavEnum
public enum class OrbitYawBehaviour(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Vehicle front points to the center (default).
   */
  @GeneratedMavEnumEntry
  ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TO_CIRCLE_CENTER(0L),
  /**
   * Vehicle front holds heading when message received.
   */
  @GeneratedMavEnumEntry
  ORBIT_YAW_BEHAVIOUR_HOLD_INITIAL_HEADING(1L),
  /**
   * Yaw uncontrolled.
   */
  @GeneratedMavEnumEntry
  ORBIT_YAW_BEHAVIOUR_UNCONTROLLED(2L),
  /**
   * Vehicle front follows flight path (tangential to circle).
   */
  @GeneratedMavEnumEntry
  ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TANGENT_TO_CIRCLE(3L),
  /**
   * Yaw controlled by RC input.
   */
  @GeneratedMavEnumEntry
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

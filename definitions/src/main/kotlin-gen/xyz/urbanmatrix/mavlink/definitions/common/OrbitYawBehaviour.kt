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
  HOLD_FRONT_TO_CIRCLE_CENTER(0L),
  /**
   * Vehicle front holds heading when message received.
   */
  @GeneratedMavEnumEntry
  HOLD_INITIAL_HEADING(1L),
  /**
   * Yaw uncontrolled.
   */
  @GeneratedMavEnumEntry
  UNCONTROLLED(2L),
  /**
   * Vehicle front follows flight path (tangential to circle).
   */
  @GeneratedMavEnumEntry
  HOLD_FRONT_TANGENT_TO_CIRCLE(3L),
  /**
   * Yaw controlled by RC input.
   */
  @GeneratedMavEnumEntry
  RC_CONTROLLED(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): OrbitYawBehaviour? = when (v) {
      0L -> HOLD_FRONT_TO_CIRCLE_CENTER
      1L -> HOLD_INITIAL_HEADING
      2L -> UNCONTROLLED
      3L -> HOLD_FRONT_TANGENT_TO_CIRCLE
      4L -> RC_CONTROLLED
      else -> null
    }
  }
}

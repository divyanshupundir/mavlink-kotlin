package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Yaw behaviour during orbit flight.
 */
@GeneratedMavEnum
public enum class OrbitYawBehaviour(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Vehicle front points to the center (default).
   */
  @GeneratedMavEnumEntry
  HOLD_FRONT_TO_CIRCLE_CENTER(0u),
  /**
   * Vehicle front holds heading when message received.
   */
  @GeneratedMavEnumEntry
  HOLD_INITIAL_HEADING(1u),
  /**
   * Yaw uncontrolled.
   */
  @GeneratedMavEnumEntry
  UNCONTROLLED(2u),
  /**
   * Vehicle front follows flight path (tangential to circle).
   */
  @GeneratedMavEnumEntry
  HOLD_FRONT_TANGENT_TO_CIRCLE(3u),
  /**
   * Yaw controlled by RC input.
   */
  @GeneratedMavEnumEntry
  RC_CONTROLLED(4u),
  ;

  public companion object : MavEnum.Companion<OrbitYawBehaviour> {
    public override fun getEntryFromValueOrNull(v: UInt): OrbitYawBehaviour? = when (v) {
      0u -> HOLD_FRONT_TO_CIRCLE_CENTER
      1u -> HOLD_INITIAL_HEADING
      2u -> UNCONTROLLED
      3u -> HOLD_FRONT_TANGENT_TO_CIRCLE
      4u -> RC_CONTROLLED
      else -> null
    }
  }
}

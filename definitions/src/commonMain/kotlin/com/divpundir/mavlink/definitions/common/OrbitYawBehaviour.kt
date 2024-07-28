package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Yaw behaviour during orbit flight.
 */
@GeneratedMavEnum
public enum class OrbitYawBehaviour(
  override val `value`: UInt,
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
  /**
   * Vehicle uses current yaw behaviour (unchanged). The vehicle-default yaw behaviour is used if
   * this value is specified when orbit is first commanded.
   */
  @GeneratedMavEnumEntry
  UNCHANGED(5u),
  ;

  public companion object : MavEnum.MavCompanion<OrbitYawBehaviour> {
    override fun getEntryFromValueOrNull(v: UInt): OrbitYawBehaviour? = when (v) {
      0u -> HOLD_FRONT_TO_CIRCLE_CENTER
      1u -> HOLD_INITIAL_HEADING
      2u -> UNCONTROLLED
      3u -> HOLD_FRONT_TANGENT_TO_CIRCLE
      4u -> RC_CONTROLLED
      5u -> UNCHANGED
      else -> null
    }
  }
}

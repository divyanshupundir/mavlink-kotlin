package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Direction of VTOL transition
 */
public enum class VtolTransitionHeading(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Respect the heading configuration of the vehicle.
   */
  VTOL_TRANSITION_HEADING_VEHICLE_DEFAULT(0L),
  /**
   * Use the heading pointing towards the next waypoint.
   */
  VTOL_TRANSITION_HEADING_NEXT_WAYPOINT(1L),
  /**
   * Use the heading on takeoff (while sitting on the ground).
   */
  VTOL_TRANSITION_HEADING_TAKEOFF(2L),
  /**
   * Use the specified heading in parameter 4.
   */
  VTOL_TRANSITION_HEADING_SPECIFIED(3L),
  /**
   * Use the current heading when reaching takeoff altitude (potentially facing the wind when
   * weather-vaning is active).
   */
  VTOL_TRANSITION_HEADING_ANY(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): VtolTransitionHeading? = when (v) {
      0L -> VTOL_TRANSITION_HEADING_VEHICLE_DEFAULT
      1L -> VTOL_TRANSITION_HEADING_NEXT_WAYPOINT
      2L -> VTOL_TRANSITION_HEADING_TAKEOFF
      3L -> VTOL_TRANSITION_HEADING_SPECIFIED
      4L -> VTOL_TRANSITION_HEADING_ANY
      else -> null
    }
  }
}

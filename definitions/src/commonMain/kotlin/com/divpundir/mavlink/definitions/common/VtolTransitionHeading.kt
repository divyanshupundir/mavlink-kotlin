package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Direction of VTOL transition
 */
@GeneratedMavEnum
public enum class VtolTransitionHeading(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Respect the heading configuration of the vehicle.
   */
  @GeneratedMavEnumEntry
  VEHICLE_DEFAULT(0u),
  /**
   * Use the heading pointing towards the next waypoint.
   */
  @GeneratedMavEnumEntry
  NEXT_WAYPOINT(1u),
  /**
   * Use the heading on takeoff (while sitting on the ground).
   */
  @GeneratedMavEnumEntry
  TAKEOFF(2u),
  /**
   * Use the specified heading in parameter 4.
   */
  @GeneratedMavEnumEntry
  SPECIFIED(3u),
  /**
   * Use the current heading when reaching takeoff altitude (potentially facing the wind when
   * weather-vaning is active).
   */
  @GeneratedMavEnumEntry
  ANY(4u),
  ;

  public companion object : MavEnum.MavCompanion<VtolTransitionHeading> {
    override fun getEntryFromValueOrNull(v: UInt): VtolTransitionHeading? = when (v) {
      0u -> VEHICLE_DEFAULT
      1u -> NEXT_WAYPOINT
      2u -> TAKEOFF
      3u -> SPECIFIED
      4u -> ANY
      else -> null
    }
  }
}

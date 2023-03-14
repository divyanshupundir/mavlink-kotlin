package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Direction of VTOL transition
 */
@GeneratedMavEnum
public enum class VtolTransitionHeading(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<VtolTransitionHeading> {
    public override fun getEntryFromValueOrNull(v: UInt): VtolTransitionHeading? = when (v) {
      0u -> VEHICLE_DEFAULT
      1u -> NEXT_WAYPOINT
      2u -> TAKEOFF
      3u -> SPECIFIED
      4u -> ANY
      else -> null
    }
  }
}

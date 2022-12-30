package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Direction of VTOL transition
 */
@GeneratedMavEnum
public enum class VtolTransitionHeading(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Respect the heading configuration of the vehicle.
   */
  @GeneratedMavEnumEntry
  VEHICLE_DEFAULT(0L),
  /**
   * Use the heading pointing towards the next waypoint.
   */
  @GeneratedMavEnumEntry
  NEXT_WAYPOINT(1L),
  /**
   * Use the heading on takeoff (while sitting on the ground).
   */
  @GeneratedMavEnumEntry
  TAKEOFF(2L),
  /**
   * Use the specified heading in parameter 4.
   */
  @GeneratedMavEnumEntry
  SPECIFIED(3L),
  /**
   * Use the current heading when reaching takeoff altitude (potentially facing the wind when
   * weather-vaning is active).
   */
  @GeneratedMavEnumEntry
  ANY(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): VtolTransitionHeading? = when (v) {
      0L -> VEHICLE_DEFAULT
      1L -> NEXT_WAYPOINT
      2L -> TAKEOFF
      3L -> SPECIFIED
      4L -> ANY
      else -> null
    }
  }
}

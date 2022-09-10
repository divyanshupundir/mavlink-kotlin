package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidUaType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No UA (Unmanned Aircraft) type defined.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_NONE(0L),
  /**
   * Aeroplane/Airplane. Fixed wing.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_AEROPLANE(1L),
  /**
   * Helicopter or multirotor.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_HELICOPTER_OR_MULTIROTOR(2L),
  /**
   * Gyroplane.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_GYROPLANE(3L),
  /**
   * VTOL (Vertical Take-Off and Landing). Fixed wing aircraft that can take off vertically.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_HYBRID_LIFT(4L),
  /**
   * Ornithopter.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_ORNITHOPTER(5L),
  /**
   * Glider.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_GLIDER(6L),
  /**
   * Kite.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_KITE(7L),
  /**
   * Free Balloon.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_FREE_BALLOON(8L),
  /**
   * Captive Balloon.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_CAPTIVE_BALLOON(9L),
  /**
   * Airship. E.g. a blimp.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_AIRSHIP(10L),
  /**
   * Free Fall/Parachute (unpowered).
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_FREE_FALL_PARACHUTE(11L),
  /**
   * Rocket.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_ROCKET(12L),
  /**
   * Tethered powered aircraft.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_TETHERED_POWERED_AIRCRAFT(13L),
  /**
   * Ground Obstacle.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_GROUND_OBSTACLE(14L),
  /**
   * Other type of aircraft not listed earlier.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_UA_TYPE_OTHER(15L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidUaType? = when (v) {
      0L -> MAV_ODID_UA_TYPE_NONE
      1L -> MAV_ODID_UA_TYPE_AEROPLANE
      2L -> MAV_ODID_UA_TYPE_HELICOPTER_OR_MULTIROTOR
      3L -> MAV_ODID_UA_TYPE_GYROPLANE
      4L -> MAV_ODID_UA_TYPE_HYBRID_LIFT
      5L -> MAV_ODID_UA_TYPE_ORNITHOPTER
      6L -> MAV_ODID_UA_TYPE_GLIDER
      7L -> MAV_ODID_UA_TYPE_KITE
      8L -> MAV_ODID_UA_TYPE_FREE_BALLOON
      9L -> MAV_ODID_UA_TYPE_CAPTIVE_BALLOON
      10L -> MAV_ODID_UA_TYPE_AIRSHIP
      11L -> MAV_ODID_UA_TYPE_FREE_FALL_PARACHUTE
      12L -> MAV_ODID_UA_TYPE_ROCKET
      13L -> MAV_ODID_UA_TYPE_TETHERED_POWERED_AIRCRAFT
      14L -> MAV_ODID_UA_TYPE_GROUND_OBSTACLE
      15L -> MAV_ODID_UA_TYPE_OTHER
      else -> null
    }
  }
}

package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavOdidUaType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No UA (Unmanned Aircraft) type defined.
   */
  MAV_ODID_UA_TYPE_NONE(0L),
  /**
   * Aeroplane/Airplane. Fixed wing.
   */
  MAV_ODID_UA_TYPE_AEROPLANE(1L),
  /**
   * Helicopter or multirotor.
   */
  MAV_ODID_UA_TYPE_HELICOPTER_OR_MULTIROTOR(2L),
  /**
   * Gyroplane.
   */
  MAV_ODID_UA_TYPE_GYROPLANE(3L),
  /**
   * VTOL (Vertical Take-Off and Landing). Fixed wing aircraft that can take off vertically.
   */
  MAV_ODID_UA_TYPE_HYBRID_LIFT(4L),
  /**
   * Ornithopter.
   */
  MAV_ODID_UA_TYPE_ORNITHOPTER(5L),
  /**
   * Glider.
   */
  MAV_ODID_UA_TYPE_GLIDER(6L),
  /**
   * Kite.
   */
  MAV_ODID_UA_TYPE_KITE(7L),
  /**
   * Free Balloon.
   */
  MAV_ODID_UA_TYPE_FREE_BALLOON(8L),
  /**
   * Captive Balloon.
   */
  MAV_ODID_UA_TYPE_CAPTIVE_BALLOON(9L),
  /**
   * Airship. E.g. a blimp.
   */
  MAV_ODID_UA_TYPE_AIRSHIP(10L),
  /**
   * Free Fall/Parachute (unpowered).
   */
  MAV_ODID_UA_TYPE_FREE_FALL_PARACHUTE(11L),
  /**
   * Rocket.
   */
  MAV_ODID_UA_TYPE_ROCKET(12L),
  /**
   * Tethered powered aircraft.
   */
  MAV_ODID_UA_TYPE_TETHERED_POWERED_AIRCRAFT(13L),
  /**
   * Ground Obstacle.
   */
  MAV_ODID_UA_TYPE_GROUND_OBSTACLE(14L),
  /**
   * Other type of aircraft not listed earlier.
   */
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

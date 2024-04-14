package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * MAVLINK component type reported in HEARTBEAT message. Flight controllers must report the type of
 * the vehicle on which they are mounted (e.g. MAV_TYPE_OCTOROTOR). All other components must report a
 * value appropriate for their type (e.g. a camera must use MAV_TYPE_CAMERA).
 */
@GeneratedMavEnum
public enum class MavType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Generic micro air vehicle
   */
  @GeneratedMavEnumEntry
  GENERIC(0u),
  /**
   * Fixed wing aircraft.
   */
  @GeneratedMavEnumEntry
  FIXED_WING(1u),
  /**
   * Quadrotor
   */
  @GeneratedMavEnumEntry
  QUADROTOR(2u),
  /**
   * Coaxial helicopter
   */
  @GeneratedMavEnumEntry
  COAXIAL(3u),
  /**
   * Normal helicopter with tail rotor.
   */
  @GeneratedMavEnumEntry
  HELICOPTER(4u),
  /**
   * Ground installation
   */
  @GeneratedMavEnumEntry
  ANTENNA_TRACKER(5u),
  /**
   * Operator control unit / ground control station
   */
  @GeneratedMavEnumEntry
  GCS(6u),
  /**
   * Airship, controlled
   */
  @GeneratedMavEnumEntry
  AIRSHIP(7u),
  /**
   * Free balloon, uncontrolled
   */
  @GeneratedMavEnumEntry
  FREE_BALLOON(8u),
  /**
   * Rocket
   */
  @GeneratedMavEnumEntry
  ROCKET(9u),
  /**
   * Ground rover
   */
  @GeneratedMavEnumEntry
  GROUND_ROVER(10u),
  /**
   * Surface vessel, boat, ship
   */
  @GeneratedMavEnumEntry
  SURFACE_BOAT(11u),
  /**
   * Submarine
   */
  @GeneratedMavEnumEntry
  SUBMARINE(12u),
  /**
   * Hexarotor
   */
  @GeneratedMavEnumEntry
  HEXAROTOR(13u),
  /**
   * Octorotor
   */
  @GeneratedMavEnumEntry
  OCTOROTOR(14u),
  /**
   * Tricopter
   */
  @GeneratedMavEnumEntry
  TRICOPTER(15u),
  /**
   * Flapping wing
   */
  @GeneratedMavEnumEntry
  FLAPPING_WING(16u),
  /**
   * Kite
   */
  @GeneratedMavEnumEntry
  KITE(17u),
  /**
   * Onboard companion controller
   */
  @GeneratedMavEnumEntry
  ONBOARD_CONTROLLER(18u),
  /**
   * Two-rotor Tailsitter VTOL that additionally uses control surfaces in vertical operation. Note,
   * value previously named MAV_TYPE_VTOL_DUOROTOR.
   */
  @GeneratedMavEnumEntry
  VTOL_TAILSITTER_DUOROTOR(19u),
  /**
   * Quad-rotor Tailsitter VTOL using a V-shaped quad config in vertical operation. Note: value
   * previously named MAV_TYPE_VTOL_QUADROTOR.
   */
  @GeneratedMavEnumEntry
  VTOL_TAILSITTER_QUADROTOR(20u),
  /**
   * Tiltrotor VTOL. Fuselage and wings stay (nominally) horizontal in all flight phases. It able to
   * tilt (some) rotors to provide thrust in cruise flight.
   */
  @GeneratedMavEnumEntry
  VTOL_TILTROTOR(21u),
  /**
   * VTOL with separate fixed rotors for hover and cruise flight. Fuselage and wings stay
   * (nominally) horizontal in all flight phases.
   */
  @GeneratedMavEnumEntry
  VTOL_FIXEDROTOR(22u),
  /**
   * Tailsitter VTOL. Fuselage and wings orientation changes depending on flight phase: vertical for
   * hover, horizontal for cruise. Use more specific VTOL MAV_TYPE_VTOL_TAILSITTER_DUOROTOR or
   * MAV_TYPE_VTOL_TAILSITTER_QUADROTOR if appropriate.
   */
  @GeneratedMavEnumEntry
  VTOL_TAILSITTER(23u),
  /**
   * Tiltwing VTOL. Fuselage stays horizontal in all flight phases. The whole wing, along with any
   * attached engine, can tilt between vertical and horizontal mode.
   */
  @GeneratedMavEnumEntry
  VTOL_TILTWING(24u),
  /**
   * VTOL reserved 5
   */
  @GeneratedMavEnumEntry
  VTOL_RESERVED5(25u),
  /**
   * Gimbal
   */
  @GeneratedMavEnumEntry
  GIMBAL(26u),
  /**
   * ADSB system
   */
  @GeneratedMavEnumEntry
  ADSB(27u),
  /**
   * Steerable, nonrigid airfoil
   */
  @GeneratedMavEnumEntry
  PARAFOIL(28u),
  /**
   * Dodecarotor
   */
  @GeneratedMavEnumEntry
  DODECAROTOR(29u),
  /**
   * Camera
   */
  @GeneratedMavEnumEntry
  CAMERA(30u),
  /**
   * Charging station
   */
  @GeneratedMavEnumEntry
  CHARGING_STATION(31u),
  /**
   * FLARM collision avoidance system
   */
  @GeneratedMavEnumEntry
  FLARM(32u),
  /**
   * Servo
   */
  @GeneratedMavEnumEntry
  SERVO(33u),
  /**
   * Open Drone ID. See https://mavlink.io/en/services/opendroneid.html.
   */
  @GeneratedMavEnumEntry
  ODID(34u),
  /**
   * Decarotor
   */
  @GeneratedMavEnumEntry
  DECAROTOR(35u),
  /**
   * Battery
   */
  @GeneratedMavEnumEntry
  BATTERY(36u),
  /**
   * Parachute
   */
  @GeneratedMavEnumEntry
  PARACHUTE(37u),
  /**
   * Log
   */
  @GeneratedMavEnumEntry
  LOG(38u),
  /**
   * OSD
   */
  @GeneratedMavEnumEntry
  OSD(39u),
  /**
   * IMU
   */
  @GeneratedMavEnumEntry
  IMU(40u),
  /**
   * GPS
   */
  @GeneratedMavEnumEntry
  GPS(41u),
  /**
   * Winch
   */
  @GeneratedMavEnumEntry
  WINCH(42u),
  /**
   * Generic multirotor that does not fit into a specific type or whose type is unknown
   */
  @GeneratedMavEnumEntry
  GENERIC_MULTIROTOR(43u),
  /**
   * Illuminator. An illuminator is a light source that is used for lighting up dark areas external
   * to the sytstem: e.g. a torch or searchlight (as opposed to a light source for illuminating the
   * system itself, e.g. an indicator light).
   */
  @GeneratedMavEnumEntry
  ILLUMINATOR(44u),
  ;

  public companion object : MavEnum.MavCompanion<MavType> {
    override fun getEntryFromValueOrNull(v: UInt): MavType? = when (v) {
      0u -> GENERIC
      1u -> FIXED_WING
      2u -> QUADROTOR
      3u -> COAXIAL
      4u -> HELICOPTER
      5u -> ANTENNA_TRACKER
      6u -> GCS
      7u -> AIRSHIP
      8u -> FREE_BALLOON
      9u -> ROCKET
      10u -> GROUND_ROVER
      11u -> SURFACE_BOAT
      12u -> SUBMARINE
      13u -> HEXAROTOR
      14u -> OCTOROTOR
      15u -> TRICOPTER
      16u -> FLAPPING_WING
      17u -> KITE
      18u -> ONBOARD_CONTROLLER
      19u -> VTOL_TAILSITTER_DUOROTOR
      20u -> VTOL_TAILSITTER_QUADROTOR
      21u -> VTOL_TILTROTOR
      22u -> VTOL_FIXEDROTOR
      23u -> VTOL_TAILSITTER
      24u -> VTOL_TILTWING
      25u -> VTOL_RESERVED5
      26u -> GIMBAL
      27u -> ADSB
      28u -> PARAFOIL
      29u -> DODECAROTOR
      30u -> CAMERA
      31u -> CHARGING_STATION
      32u -> FLARM
      33u -> SERVO
      34u -> ODID
      35u -> DECAROTOR
      36u -> BATTERY
      37u -> PARACHUTE
      38u -> LOG
      39u -> OSD
      40u -> IMU
      41u -> GPS
      42u -> WINCH
      43u -> GENERIC_MULTIROTOR
      44u -> ILLUMINATOR
      else -> null
    }
  }
}

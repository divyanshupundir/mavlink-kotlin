package xyz.urbanmatrix.mavlink.definitions.minimal

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * MAVLINK component type reported in HEARTBEAT message. Flight controllers must report the type of
 * the vehicle on which they are mounted (e.g. MAV_TYPE_OCTOROTOR). All other components must report a
 * value appropriate for their type (e.g. a camera must use MAV_TYPE_CAMERA).
 */
@GeneratedMavEnum
public enum class MavType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Generic micro air vehicle
   */
  @GeneratedMavEnumEntry
  GENERIC(0L),
  /**
   * Fixed wing aircraft.
   */
  @GeneratedMavEnumEntry
  FIXED_WING(1L),
  /**
   * Quadrotor
   */
  @GeneratedMavEnumEntry
  QUADROTOR(2L),
  /**
   * Coaxial helicopter
   */
  @GeneratedMavEnumEntry
  COAXIAL(3L),
  /**
   * Normal helicopter with tail rotor.
   */
  @GeneratedMavEnumEntry
  HELICOPTER(4L),
  /**
   * Ground installation
   */
  @GeneratedMavEnumEntry
  ANTENNA_TRACKER(5L),
  /**
   * Operator control unit / ground control station
   */
  @GeneratedMavEnumEntry
  GCS(6L),
  /**
   * Airship, controlled
   */
  @GeneratedMavEnumEntry
  AIRSHIP(7L),
  /**
   * Free balloon, uncontrolled
   */
  @GeneratedMavEnumEntry
  FREE_BALLOON(8L),
  /**
   * Rocket
   */
  @GeneratedMavEnumEntry
  ROCKET(9L),
  /**
   * Ground rover
   */
  @GeneratedMavEnumEntry
  GROUND_ROVER(10L),
  /**
   * Surface vessel, boat, ship
   */
  @GeneratedMavEnumEntry
  SURFACE_BOAT(11L),
  /**
   * Submarine
   */
  @GeneratedMavEnumEntry
  SUBMARINE(12L),
  /**
   * Hexarotor
   */
  @GeneratedMavEnumEntry
  HEXAROTOR(13L),
  /**
   * Octorotor
   */
  @GeneratedMavEnumEntry
  OCTOROTOR(14L),
  /**
   * Tricopter
   */
  @GeneratedMavEnumEntry
  TRICOPTER(15L),
  /**
   * Flapping wing
   */
  @GeneratedMavEnumEntry
  FLAPPING_WING(16L),
  /**
   * Kite
   */
  @GeneratedMavEnumEntry
  KITE(17L),
  /**
   * Onboard companion controller
   */
  @GeneratedMavEnumEntry
  ONBOARD_CONTROLLER(18L),
  /**
   * Two-rotor Tailsitter VTOL that additionally uses control surfaces in vertical operation. Note,
   * value previously named MAV_TYPE_VTOL_DUOROTOR.
   */
  @GeneratedMavEnumEntry
  VTOL_TAILSITTER_DUOROTOR(19L),
  /**
   * Quad-rotor Tailsitter VTOL using a V-shaped quad config in vertical operation. Note: value
   * previously named MAV_TYPE_VTOL_QUADROTOR.
   */
  @GeneratedMavEnumEntry
  VTOL_TAILSITTER_QUADROTOR(20L),
  /**
   * Tiltrotor VTOL. Fuselage and wings stay (nominally) horizontal in all flight phases. It able to
   * tilt (some) rotors to provide thrust in cruise flight.
   */
  @GeneratedMavEnumEntry
  VTOL_TILTROTOR(21L),
  /**
   * VTOL with separate fixed rotors for hover and cruise flight. Fuselage and wings stay
   * (nominally) horizontal in all flight phases.
   */
  @GeneratedMavEnumEntry
  VTOL_FIXEDROTOR(22L),
  /**
   * Tailsitter VTOL. Fuselage and wings orientation changes depending on flight phase: vertical for
   * hover, horizontal for cruise. Use more specific VTOL MAV_TYPE_VTOL_DUOROTOR or
   * MAV_TYPE_VTOL_QUADROTOR if appropriate.
   */
  @GeneratedMavEnumEntry
  VTOL_TAILSITTER(23L),
  /**
   * VTOL reserved 4
   */
  @GeneratedMavEnumEntry
  VTOL_RESERVED4(24L),
  /**
   * VTOL reserved 5
   */
  @GeneratedMavEnumEntry
  VTOL_RESERVED5(25L),
  /**
   * Gimbal
   */
  @GeneratedMavEnumEntry
  GIMBAL(26L),
  /**
   * ADSB system
   */
  @GeneratedMavEnumEntry
  ADSB(27L),
  /**
   * Steerable, nonrigid airfoil
   */
  @GeneratedMavEnumEntry
  PARAFOIL(28L),
  /**
   * Dodecarotor
   */
  @GeneratedMavEnumEntry
  DODECAROTOR(29L),
  /**
   * Camera
   */
  @GeneratedMavEnumEntry
  CAMERA(30L),
  /**
   * Charging station
   */
  @GeneratedMavEnumEntry
  CHARGING_STATION(31L),
  /**
   * FLARM collision avoidance system
   */
  @GeneratedMavEnumEntry
  FLARM(32L),
  /**
   * Servo
   */
  @GeneratedMavEnumEntry
  SERVO(33L),
  /**
   * Open Drone ID. See https://mavlink.io/en/services/opendroneid.html.
   */
  @GeneratedMavEnumEntry
  ODID(34L),
  /**
   * Decarotor
   */
  @GeneratedMavEnumEntry
  DECAROTOR(35L),
  /**
   * Battery
   */
  @GeneratedMavEnumEntry
  BATTERY(36L),
  /**
   * Parachute
   */
  @GeneratedMavEnumEntry
  PARACHUTE(37L),
  /**
   * Log
   */
  @GeneratedMavEnumEntry
  LOG(38L),
  /**
   * OSD
   */
  @GeneratedMavEnumEntry
  OSD(39L),
  /**
   * IMU
   */
  @GeneratedMavEnumEntry
  IMU(40L),
  /**
   * GPS
   */
  @GeneratedMavEnumEntry
  GPS(41L),
  /**
   * Winch
   */
  @GeneratedMavEnumEntry
  WINCH(42L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavType? = when (v) {
      0L -> GENERIC
      1L -> FIXED_WING
      2L -> QUADROTOR
      3L -> COAXIAL
      4L -> HELICOPTER
      5L -> ANTENNA_TRACKER
      6L -> GCS
      7L -> AIRSHIP
      8L -> FREE_BALLOON
      9L -> ROCKET
      10L -> GROUND_ROVER
      11L -> SURFACE_BOAT
      12L -> SUBMARINE
      13L -> HEXAROTOR
      14L -> OCTOROTOR
      15L -> TRICOPTER
      16L -> FLAPPING_WING
      17L -> KITE
      18L -> ONBOARD_CONTROLLER
      19L -> VTOL_TAILSITTER_DUOROTOR
      20L -> VTOL_TAILSITTER_QUADROTOR
      21L -> VTOL_TILTROTOR
      22L -> VTOL_FIXEDROTOR
      23L -> VTOL_TAILSITTER
      24L -> VTOL_RESERVED4
      25L -> VTOL_RESERVED5
      26L -> GIMBAL
      27L -> ADSB
      28L -> PARAFOIL
      29L -> DODECAROTOR
      30L -> CAMERA
      31L -> CHARGING_STATION
      32L -> FLARM
      33L -> SERVO
      34L -> ODID
      35L -> DECAROTOR
      36L -> BATTERY
      37L -> PARACHUTE
      38L -> LOG
      39L -> OSD
      40L -> IMU
      41L -> GPS
      42L -> WINCH
      else -> null
    }
  }
}

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
  NONE(0L),
  /**
   * Aeroplane/Airplane. Fixed wing.
   */
  @GeneratedMavEnumEntry
  AEROPLANE(1L),
  /**
   * Helicopter or multirotor.
   */
  @GeneratedMavEnumEntry
  HELICOPTER_OR_MULTIROTOR(2L),
  /**
   * Gyroplane.
   */
  @GeneratedMavEnumEntry
  GYROPLANE(3L),
  /**
   * VTOL (Vertical Take-Off and Landing). Fixed wing aircraft that can take off vertically.
   */
  @GeneratedMavEnumEntry
  HYBRID_LIFT(4L),
  /**
   * Ornithopter.
   */
  @GeneratedMavEnumEntry
  ORNITHOPTER(5L),
  /**
   * Glider.
   */
  @GeneratedMavEnumEntry
  GLIDER(6L),
  /**
   * Kite.
   */
  @GeneratedMavEnumEntry
  KITE(7L),
  /**
   * Free Balloon.
   */
  @GeneratedMavEnumEntry
  FREE_BALLOON(8L),
  /**
   * Captive Balloon.
   */
  @GeneratedMavEnumEntry
  CAPTIVE_BALLOON(9L),
  /**
   * Airship. E.g. a blimp.
   */
  @GeneratedMavEnumEntry
  AIRSHIP(10L),
  /**
   * Free Fall/Parachute (unpowered).
   */
  @GeneratedMavEnumEntry
  FREE_FALL_PARACHUTE(11L),
  /**
   * Rocket.
   */
  @GeneratedMavEnumEntry
  ROCKET(12L),
  /**
   * Tethered powered aircraft.
   */
  @GeneratedMavEnumEntry
  TETHERED_POWERED_AIRCRAFT(13L),
  /**
   * Ground Obstacle.
   */
  @GeneratedMavEnumEntry
  GROUND_OBSTACLE(14L),
  /**
   * Other type of aircraft not listed earlier.
   */
  @GeneratedMavEnumEntry
  OTHER(15L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidUaType? = when (v) {
      0L -> NONE
      1L -> AEROPLANE
      2L -> HELICOPTER_OR_MULTIROTOR
      3L -> GYROPLANE
      4L -> HYBRID_LIFT
      5L -> ORNITHOPTER
      6L -> GLIDER
      7L -> KITE
      8L -> FREE_BALLOON
      9L -> CAPTIVE_BALLOON
      10L -> AIRSHIP
      11L -> FREE_FALL_PARACHUTE
      12L -> ROCKET
      13L -> TETHERED_POWERED_AIRCRAFT
      14L -> GROUND_OBSTACLE
      15L -> OTHER
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidUaType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No UA (Unmanned Aircraft) type defined.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Aeroplane/Airplane. Fixed wing.
   */
  @GeneratedMavEnumEntry
  AEROPLANE(1u),
  /**
   * Helicopter or multirotor.
   */
  @GeneratedMavEnumEntry
  HELICOPTER_OR_MULTIROTOR(2u),
  /**
   * Gyroplane.
   */
  @GeneratedMavEnumEntry
  GYROPLANE(3u),
  /**
   * VTOL (Vertical Take-Off and Landing). Fixed wing aircraft that can take off vertically.
   */
  @GeneratedMavEnumEntry
  HYBRID_LIFT(4u),
  /**
   * Ornithopter.
   */
  @GeneratedMavEnumEntry
  ORNITHOPTER(5u),
  /**
   * Glider.
   */
  @GeneratedMavEnumEntry
  GLIDER(6u),
  /**
   * Kite.
   */
  @GeneratedMavEnumEntry
  KITE(7u),
  /**
   * Free Balloon.
   */
  @GeneratedMavEnumEntry
  FREE_BALLOON(8u),
  /**
   * Captive Balloon.
   */
  @GeneratedMavEnumEntry
  CAPTIVE_BALLOON(9u),
  /**
   * Airship. E.g. a blimp.
   */
  @GeneratedMavEnumEntry
  AIRSHIP(10u),
  /**
   * Free Fall/Parachute (unpowered).
   */
  @GeneratedMavEnumEntry
  FREE_FALL_PARACHUTE(11u),
  /**
   * Rocket.
   */
  @GeneratedMavEnumEntry
  ROCKET(12u),
  /**
   * Tethered powered aircraft.
   */
  @GeneratedMavEnumEntry
  TETHERED_POWERED_AIRCRAFT(13u),
  /**
   * Ground Obstacle.
   */
  @GeneratedMavEnumEntry
  GROUND_OBSTACLE(14u),
  /**
   * Other type of aircraft not listed earlier.
   */
  @GeneratedMavEnumEntry
  OTHER(15u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidUaType> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidUaType? = when (v) {
      0u -> NONE
      1u -> AEROPLANE
      2u -> HELICOPTER_OR_MULTIROTOR
      3u -> GYROPLANE
      4u -> HYBRID_LIFT
      5u -> ORNITHOPTER
      6u -> GLIDER
      7u -> KITE
      8u -> FREE_BALLOON
      9u -> CAPTIVE_BALLOON
      10u -> AIRSHIP
      11u -> FREE_FALL_PARACHUTE
      12u -> ROCKET
      13u -> TETHERED_POWERED_AIRCRAFT
      14u -> GROUND_OBSTACLE
      15u -> OTHER
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * A mapping of copter flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class CopterMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * STABILIZE
   */
  @GeneratedMavEnumEntry
  STABILIZE(0u),
  /**
   * ACRO
   */
  @GeneratedMavEnumEntry
  ACRO(1u),
  /**
   * ALT HOLD
   */
  @GeneratedMavEnumEntry
  ALT_HOLD(2u),
  /**
   * AUTO
   */
  @GeneratedMavEnumEntry
  AUTO(3u),
  /**
   * GUIDED
   */
  @GeneratedMavEnumEntry
  GUIDED(4u),
  /**
   * LOITER
   */
  @GeneratedMavEnumEntry
  LOITER(5u),
  /**
   * RTL
   */
  @GeneratedMavEnumEntry
  RTL(6u),
  /**
   * CIRCLE
   */
  @GeneratedMavEnumEntry
  CIRCLE(7u),
  /**
   * LAND
   */
  @GeneratedMavEnumEntry
  LAND(9u),
  /**
   * DRIFT
   */
  @GeneratedMavEnumEntry
  DRIFT(11u),
  /**
   * SPORT
   */
  @GeneratedMavEnumEntry
  SPORT(13u),
  /**
   * FLIP
   */
  @GeneratedMavEnumEntry
  FLIP(14u),
  /**
   * AUTOTUNE
   */
  @GeneratedMavEnumEntry
  AUTOTUNE(15u),
  /**
   * POSHOLD
   */
  @GeneratedMavEnumEntry
  POSHOLD(16u),
  /**
   * BRAKE
   */
  @GeneratedMavEnumEntry
  BRAKE(17u),
  /**
   * THROW
   */
  @GeneratedMavEnumEntry
  THROW(18u),
  /**
   * AVOID ADSB
   */
  @GeneratedMavEnumEntry
  AVOID_ADSB(19u),
  /**
   * GUIDED NOGPS
   */
  @GeneratedMavEnumEntry
  GUIDED_NOGPS(20u),
  /**
   * SMARTRTL
   */
  @GeneratedMavEnumEntry
  SMART_RTL(21u),
  /**
   * FLOWHOLD
   */
  @GeneratedMavEnumEntry
  FLOWHOLD(22u),
  /**
   * FOLLOW
   */
  @GeneratedMavEnumEntry
  FOLLOW(23u),
  /**
   * ZIGZAG
   */
  @GeneratedMavEnumEntry
  ZIGZAG(24u),
  /**
   * SYSTEMID
   */
  @GeneratedMavEnumEntry
  SYSTEMID(25u),
  /**
   * AUTOROTATE
   */
  @GeneratedMavEnumEntry
  AUTOROTATE(26u),
  /**
   * AUTO RTL
   */
  @GeneratedMavEnumEntry
  AUTO_RTL(27u),
  /**
   * TURTLE
   */
  @GeneratedMavEnumEntry
  TURTLE(28u),
  /**
   * RATE_ACRO
   */
  @GeneratedMavEnumEntry
  RATE_ACRO(29u),
  ;

  public companion object : MavEnum.MavCompanion<CopterMode> {
    override fun getEntryFromValueOrNull(v: UInt): CopterMode? = when (v) {
      0u -> STABILIZE
      1u -> ACRO
      2u -> ALT_HOLD
      3u -> AUTO
      4u -> GUIDED
      5u -> LOITER
      6u -> RTL
      7u -> CIRCLE
      9u -> LAND
      11u -> DRIFT
      13u -> SPORT
      14u -> FLIP
      15u -> AUTOTUNE
      16u -> POSHOLD
      17u -> BRAKE
      18u -> THROW
      19u -> AVOID_ADSB
      20u -> GUIDED_NOGPS
      21u -> SMART_RTL
      22u -> FLOWHOLD
      23u -> FOLLOW
      24u -> ZIGZAG
      25u -> SYSTEMID
      26u -> AUTOROTATE
      27u -> AUTO_RTL
      28u -> TURTLE
      29u -> RATE_ACRO
      else -> null
    }
  }
}

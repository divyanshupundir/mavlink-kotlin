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
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  STABILIZE(0u),
  @GeneratedMavEnumEntry
  ACRO(1u),
  @GeneratedMavEnumEntry
  ALT_HOLD(2u),
  @GeneratedMavEnumEntry
  AUTO(3u),
  @GeneratedMavEnumEntry
  GUIDED(4u),
  @GeneratedMavEnumEntry
  LOITER(5u),
  @GeneratedMavEnumEntry
  RTL(6u),
  @GeneratedMavEnumEntry
  CIRCLE(7u),
  @GeneratedMavEnumEntry
  LAND(9u),
  @GeneratedMavEnumEntry
  DRIFT(11u),
  @GeneratedMavEnumEntry
  SPORT(13u),
  @GeneratedMavEnumEntry
  FLIP(14u),
  @GeneratedMavEnumEntry
  AUTOTUNE(15u),
  @GeneratedMavEnumEntry
  POSHOLD(16u),
  @GeneratedMavEnumEntry
  BRAKE(17u),
  @GeneratedMavEnumEntry
  THROW(18u),
  @GeneratedMavEnumEntry
  AVOID_ADSB(19u),
  @GeneratedMavEnumEntry
  GUIDED_NOGPS(20u),
  @GeneratedMavEnumEntry
  SMART_RTL(21u),
  @GeneratedMavEnumEntry
  FLOWHOLD(22u),
  @GeneratedMavEnumEntry
  FOLLOW(23u),
  @GeneratedMavEnumEntry
  ZIGZAG(24u),
  @GeneratedMavEnumEntry
  SYSTEMID(25u),
  @GeneratedMavEnumEntry
  AUTOROTATE(26u),
  @GeneratedMavEnumEntry
  AUTO_RTL(27u),
  ;

  public companion object : MavEnum.Companion<CopterMode> {
    public override fun getEntryFromValueOrNull(v: UInt): CopterMode? = when (v) {
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
      else -> null
    }
  }
}

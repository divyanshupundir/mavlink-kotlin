package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * A mapping of copter flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class CopterMode(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  STABILIZE(0L),
  @GeneratedMavEnumEntry
  ACRO(1L),
  @GeneratedMavEnumEntry
  ALT_HOLD(2L),
  @GeneratedMavEnumEntry
  AUTO(3L),
  @GeneratedMavEnumEntry
  GUIDED(4L),
  @GeneratedMavEnumEntry
  LOITER(5L),
  @GeneratedMavEnumEntry
  RTL(6L),
  @GeneratedMavEnumEntry
  CIRCLE(7L),
  @GeneratedMavEnumEntry
  LAND(9L),
  @GeneratedMavEnumEntry
  DRIFT(11L),
  @GeneratedMavEnumEntry
  SPORT(13L),
  @GeneratedMavEnumEntry
  FLIP(14L),
  @GeneratedMavEnumEntry
  AUTOTUNE(15L),
  @GeneratedMavEnumEntry
  POSHOLD(16L),
  @GeneratedMavEnumEntry
  BRAKE(17L),
  @GeneratedMavEnumEntry
  THROW(18L),
  @GeneratedMavEnumEntry
  AVOID_ADSB(19L),
  @GeneratedMavEnumEntry
  GUIDED_NOGPS(20L),
  @GeneratedMavEnumEntry
  SMART_RTL(21L),
  @GeneratedMavEnumEntry
  FLOWHOLD(22L),
  @GeneratedMavEnumEntry
  FOLLOW(23L),
  @GeneratedMavEnumEntry
  ZIGZAG(24L),
  @GeneratedMavEnumEntry
  SYSTEMID(25L),
  @GeneratedMavEnumEntry
  AUTOROTATE(26L),
  @GeneratedMavEnumEntry
  AUTO_RTL(27L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CopterMode? = when (v) {
      0L -> STABILIZE
      1L -> ACRO
      2L -> ALT_HOLD
      3L -> AUTO
      4L -> GUIDED
      5L -> LOITER
      6L -> RTL
      7L -> CIRCLE
      9L -> LAND
      11L -> DRIFT
      13L -> SPORT
      14L -> FLIP
      15L -> AUTOTUNE
      16L -> POSHOLD
      17L -> BRAKE
      18L -> THROW
      19L -> AVOID_ADSB
      20L -> GUIDED_NOGPS
      21L -> SMART_RTL
      22L -> FLOWHOLD
      23L -> FOLLOW
      24L -> ZIGZAG
      25L -> SYSTEMID
      26L -> AUTOROTATE
      27L -> AUTO_RTL
      else -> null
    }
  }
}

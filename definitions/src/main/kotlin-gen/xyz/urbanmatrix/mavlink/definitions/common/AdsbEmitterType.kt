package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * ADSB classification for the type of vehicle emitting the transponder signal
 */
@GeneratedMavEnum
public enum class AdsbEmitterType(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  NO_INFO(0L),
  @GeneratedMavEnumEntry
  LIGHT(1L),
  @GeneratedMavEnumEntry
  SMALL(2L),
  @GeneratedMavEnumEntry
  LARGE(3L),
  @GeneratedMavEnumEntry
  HIGH_VORTEX_LARGE(4L),
  @GeneratedMavEnumEntry
  HEAVY(5L),
  @GeneratedMavEnumEntry
  HIGHLY_MANUV(6L),
  @GeneratedMavEnumEntry
  ROTOCRAFT(7L),
  @GeneratedMavEnumEntry
  UNASSIGNED(8L),
  @GeneratedMavEnumEntry
  GLIDER(9L),
  @GeneratedMavEnumEntry
  LIGHTER_AIR(10L),
  @GeneratedMavEnumEntry
  PARACHUTE(11L),
  @GeneratedMavEnumEntry
  ULTRA_LIGHT(12L),
  @GeneratedMavEnumEntry
  UNASSIGNED2(13L),
  @GeneratedMavEnumEntry
  UAV(14L),
  @GeneratedMavEnumEntry
  SPACE(15L),
  @GeneratedMavEnumEntry
  UNASSGINED3(16L),
  @GeneratedMavEnumEntry
  EMERGENCY_SURFACE(17L),
  @GeneratedMavEnumEntry
  SERVICE_SURFACE(18L),
  @GeneratedMavEnumEntry
  POINT_OBSTACLE(19L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AdsbEmitterType? = when (v) {
      0L -> NO_INFO
      1L -> LIGHT
      2L -> SMALL
      3L -> LARGE
      4L -> HIGH_VORTEX_LARGE
      5L -> HEAVY
      6L -> HIGHLY_MANUV
      7L -> ROTOCRAFT
      8L -> UNASSIGNED
      9L -> GLIDER
      10L -> LIGHTER_AIR
      11L -> PARACHUTE
      12L -> ULTRA_LIGHT
      13L -> UNASSIGNED2
      14L -> UAV
      15L -> SPACE
      16L -> UNASSGINED3
      17L -> EMERGENCY_SURFACE
      18L -> SERVICE_SURFACE
      19L -> POINT_OBSTACLE
      else -> null
    }
  }
}

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
  ADSB_EMITTER_TYPE_NO_INFO(0L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_LIGHT(1L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_SMALL(2L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_LARGE(3L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_HIGH_VORTEX_LARGE(4L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_HEAVY(5L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_HIGHLY_MANUV(6L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_ROTOCRAFT(7L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_UNASSIGNED(8L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_GLIDER(9L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_LIGHTER_AIR(10L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_PARACHUTE(11L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_ULTRA_LIGHT(12L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_UNASSIGNED2(13L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_UAV(14L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_SPACE(15L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_UNASSGINED3(16L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_EMERGENCY_SURFACE(17L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_SERVICE_SURFACE(18L),
  @GeneratedMavEnumEntry
  ADSB_EMITTER_TYPE_POINT_OBSTACLE(19L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AdsbEmitterType? = when (v) {
      0L -> ADSB_EMITTER_TYPE_NO_INFO
      1L -> ADSB_EMITTER_TYPE_LIGHT
      2L -> ADSB_EMITTER_TYPE_SMALL
      3L -> ADSB_EMITTER_TYPE_LARGE
      4L -> ADSB_EMITTER_TYPE_HIGH_VORTEX_LARGE
      5L -> ADSB_EMITTER_TYPE_HEAVY
      6L -> ADSB_EMITTER_TYPE_HIGHLY_MANUV
      7L -> ADSB_EMITTER_TYPE_ROTOCRAFT
      8L -> ADSB_EMITTER_TYPE_UNASSIGNED
      9L -> ADSB_EMITTER_TYPE_GLIDER
      10L -> ADSB_EMITTER_TYPE_LIGHTER_AIR
      11L -> ADSB_EMITTER_TYPE_PARACHUTE
      12L -> ADSB_EMITTER_TYPE_ULTRA_LIGHT
      13L -> ADSB_EMITTER_TYPE_UNASSIGNED2
      14L -> ADSB_EMITTER_TYPE_UAV
      15L -> ADSB_EMITTER_TYPE_SPACE
      16L -> ADSB_EMITTER_TYPE_UNASSGINED3
      17L -> ADSB_EMITTER_TYPE_EMERGENCY_SURFACE
      18L -> ADSB_EMITTER_TYPE_SERVICE_SURFACE
      19L -> ADSB_EMITTER_TYPE_POINT_OBSTACLE
      else -> null
    }
  }
}

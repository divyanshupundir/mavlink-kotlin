package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * ADSB classification for the type of vehicle emitting the transponder signal
 */
@GeneratedMavEnum
public enum class AdsbEmitterType(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  NO_INFO(0u),
  @GeneratedMavEnumEntry
  LIGHT(1u),
  @GeneratedMavEnumEntry
  SMALL(2u),
  @GeneratedMavEnumEntry
  LARGE(3u),
  @GeneratedMavEnumEntry
  HIGH_VORTEX_LARGE(4u),
  @GeneratedMavEnumEntry
  HEAVY(5u),
  @GeneratedMavEnumEntry
  HIGHLY_MANUV(6u),
  @GeneratedMavEnumEntry
  ROTOCRAFT(7u),
  @GeneratedMavEnumEntry
  UNASSIGNED(8u),
  @GeneratedMavEnumEntry
  GLIDER(9u),
  @GeneratedMavEnumEntry
  LIGHTER_AIR(10u),
  @GeneratedMavEnumEntry
  PARACHUTE(11u),
  @GeneratedMavEnumEntry
  ULTRA_LIGHT(12u),
  @GeneratedMavEnumEntry
  UNASSIGNED2(13u),
  @GeneratedMavEnumEntry
  UAV(14u),
  @GeneratedMavEnumEntry
  SPACE(15u),
  @GeneratedMavEnumEntry
  UNASSGINED3(16u),
  @GeneratedMavEnumEntry
  EMERGENCY_SURFACE(17u),
  @GeneratedMavEnumEntry
  SERVICE_SURFACE(18u),
  @GeneratedMavEnumEntry
  POINT_OBSTACLE(19u),
  ;

  public companion object : MavEnum.MavCompanion<AdsbEmitterType> {
    override fun getEntryFromValueOrNull(v: UInt): AdsbEmitterType? = when (v) {
      0u -> NO_INFO
      1u -> LIGHT
      2u -> SMALL
      3u -> LARGE
      4u -> HIGH_VORTEX_LARGE
      5u -> HEAVY
      6u -> HIGHLY_MANUV
      7u -> ROTOCRAFT
      8u -> UNASSIGNED
      9u -> GLIDER
      10u -> LIGHTER_AIR
      11u -> PARACHUTE
      12u -> ULTRA_LIGHT
      13u -> UNASSIGNED2
      14u -> UAV
      15u -> SPACE
      16u -> UNASSGINED3
      17u -> EMERGENCY_SURFACE
      18u -> SERVICE_SURFACE
      19u -> POINT_OBSTACLE
      else -> null
    }
  }
}

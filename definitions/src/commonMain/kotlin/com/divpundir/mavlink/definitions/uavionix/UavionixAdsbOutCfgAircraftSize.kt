package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Definitions for aircraft size
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutCfgAircraftSize(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  NO_DATA(0u),
  @GeneratedMavEnumEntry
  L15M_W23M(1u),
  @GeneratedMavEnumEntry
  L25M_W28P5M(2u),
  @GeneratedMavEnumEntry
  L25_34M(3u),
  @GeneratedMavEnumEntry
  L35_33M(4u),
  @GeneratedMavEnumEntry
  L35_38M(5u),
  @GeneratedMavEnumEntry
  L45_39P5M(6u),
  @GeneratedMavEnumEntry
  L45_45M(7u),
  @GeneratedMavEnumEntry
  L55_45M(8u),
  @GeneratedMavEnumEntry
  L55_52M(9u),
  @GeneratedMavEnumEntry
  L65_59P5M(10u),
  @GeneratedMavEnumEntry
  L65_67M(11u),
  @GeneratedMavEnumEntry
  L75_W72P5M(12u),
  @GeneratedMavEnumEntry
  L75_W80M(13u),
  @GeneratedMavEnumEntry
  L85_W80M(14u),
  @GeneratedMavEnumEntry
  L85_W90M(15u),
  ;

  public companion object : MavEnum.MavCompanion<UavionixAdsbOutCfgAircraftSize> {
    override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutCfgAircraftSize? = when (v) {
      0u -> NO_DATA
      1u -> L15M_W23M
      2u -> L25M_W28P5M
      3u -> L25_34M
      4u -> L35_33M
      5u -> L35_38M
      6u -> L45_39P5M
      7u -> L45_45M
      8u -> L55_45M
      9u -> L55_52M
      10u -> L65_59P5M
      11u -> L65_67M
      12u -> L75_W72P5M
      13u -> L75_W80M
      14u -> L85_W80M
      15u -> L85_W90M
      else -> null
    }
  }
}

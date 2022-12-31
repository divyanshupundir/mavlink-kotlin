package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Definitions for aircraft size
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutCfgAircraftSize(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  NO_DATA(0L),
  @GeneratedMavEnumEntry
  L15M_W23M(1L),
  @GeneratedMavEnumEntry
  L25M_W28P5M(2L),
  @GeneratedMavEnumEntry
  L25_34M(3L),
  @GeneratedMavEnumEntry
  L35_33M(4L),
  @GeneratedMavEnumEntry
  L35_38M(5L),
  @GeneratedMavEnumEntry
  L45_39P5M(6L),
  @GeneratedMavEnumEntry
  L45_45M(7L),
  @GeneratedMavEnumEntry
  L55_45M(8L),
  @GeneratedMavEnumEntry
  L55_52M(9L),
  @GeneratedMavEnumEntry
  L65_59P5M(10L),
  @GeneratedMavEnumEntry
  L65_67M(11L),
  @GeneratedMavEnumEntry
  L75_W72P5M(12L),
  @GeneratedMavEnumEntry
  L75_W80M(13L),
  @GeneratedMavEnumEntry
  L85_W80M(14L),
  @GeneratedMavEnumEntry
  L85_W90M(15L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutCfgAircraftSize? = when (v) {
      0L -> NO_DATA
      1L -> L15M_W23M
      2L -> L25M_W28P5M
      3L -> L25_34M
      4L -> L35_33M
      5L -> L35_38M
      6L -> L45_39P5M
      7L -> L45_45M
      8L -> L55_45M
      9L -> L55_52M
      10L -> L65_59P5M
      11L -> L65_67M
      12L -> L75_W72P5M
      13L -> L75_W80M
      14L -> L85_W80M
      15L -> L85_W90M
      else -> null
    }
  }
}

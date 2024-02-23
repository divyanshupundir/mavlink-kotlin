package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Type of GPS fix
 */
@GeneratedMavEnum
public enum class GpsFixType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No GPS connected
   */
  @GeneratedMavEnumEntry
  NO_GPS(0u),
  /**
   * No position information, GPS is connected
   */
  @GeneratedMavEnumEntry
  NO_FIX(1u),
  /**
   * 2D position
   */
  @GeneratedMavEnumEntry
  _2D_FIX(2u),
  /**
   * 3D position
   */
  @GeneratedMavEnumEntry
  _3D_FIX(3u),
  /**
   * DGPS/SBAS aided 3D position
   */
  @GeneratedMavEnumEntry
  DGPS(4u),
  /**
   * RTK float, 3D position
   */
  @GeneratedMavEnumEntry
  RTK_FLOAT(5u),
  /**
   * RTK Fixed, 3D position
   */
  @GeneratedMavEnumEntry
  RTK_FIXED(6u),
  /**
   * Static fixed, typically used for base stations
   */
  @GeneratedMavEnumEntry
  STATIC(7u),
  /**
   * PPP, 3D position.
   */
  @GeneratedMavEnumEntry
  PPP(8u),
  ;

  public companion object : MavEnum.MavCompanion<GpsFixType> {
    override fun getEntryFromValueOrNull(v: UInt): GpsFixType? = when (v) {
      0u -> NO_GPS
      1u -> NO_FIX
      2u -> _2D_FIX
      3u -> _3D_FIX
      4u -> DGPS
      5u -> RTK_FLOAT
      6u -> RTK_FIXED
      7u -> STATIC
      8u -> PPP
      else -> null
    }
  }
}

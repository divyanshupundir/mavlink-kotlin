package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Type of GPS fix
 */
@GeneratedMavEnum
public enum class GpsFixType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No GPS connected
   */
  @GeneratedMavEnumEntry
  NO_GPS(0L),
  /**
   * No position information, GPS is connected
   */
  @GeneratedMavEnumEntry
  NO_FIX(1L),
  /**
   * 2D position
   */
  @GeneratedMavEnumEntry
  _2D_FIX(2L),
  /**
   * 3D position
   */
  @GeneratedMavEnumEntry
  _3D_FIX(3L),
  /**
   * DGPS/SBAS aided 3D position
   */
  @GeneratedMavEnumEntry
  DGPS(4L),
  /**
   * RTK float, 3D position
   */
  @GeneratedMavEnumEntry
  RTK_FLOAT(5L),
  /**
   * RTK Fixed, 3D position
   */
  @GeneratedMavEnumEntry
  RTK_FIXED(6L),
  /**
   * Static fixed, typically used for base stations
   */
  @GeneratedMavEnumEntry
  STATIC(7L),
  /**
   * PPP, 3D position.
   */
  @GeneratedMavEnumEntry
  PPP(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GpsFixType? = when (v) {
      0L -> NO_GPS
      1L -> NO_FIX
      2L -> _2D_FIX
      3L -> _3D_FIX
      4L -> DGPS
      5L -> RTK_FLOAT
      6L -> RTK_FIXED
      7L -> STATIC
      8L -> PPP
      else -> null
    }
  }
}

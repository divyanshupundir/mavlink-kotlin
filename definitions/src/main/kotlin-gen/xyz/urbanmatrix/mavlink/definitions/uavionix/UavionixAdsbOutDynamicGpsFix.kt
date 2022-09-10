package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Status for ADS-B transponder dynamic input
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutDynamicGpsFix(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_NONE_0(0L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_NONE_1(1L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_2D(2L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_3D(3L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_DGPS(4L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_RTK(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutDynamicGpsFix? = when (v) {
      0L -> UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_NONE_0
      1L -> UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_NONE_1
      2L -> UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_2D
      3L -> UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_3D
      4L -> UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_DGPS
      5L -> UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_RTK
      else -> null
    }
  }
}

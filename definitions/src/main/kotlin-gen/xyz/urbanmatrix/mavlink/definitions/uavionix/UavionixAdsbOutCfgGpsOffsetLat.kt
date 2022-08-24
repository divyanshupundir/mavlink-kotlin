package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * GPS lataral offset encoding
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutCfgGpsOffsetLat(
  public override val `value`: Long,
) : MavEnum {
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_NO_DATA(0L),
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_2M(1L),
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_4M(2L),
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_6M(3L),
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_0M(4L),
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_2M(5L),
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_4M(6L),
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_6M(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutCfgGpsOffsetLat? = when (v) {
      0L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_NO_DATA
      1L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_2M
      2L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_4M
      3L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_6M
      4L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_0M
      5L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_2M
      6L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_4M
      7L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_6M
      else -> null
    }
  }
}

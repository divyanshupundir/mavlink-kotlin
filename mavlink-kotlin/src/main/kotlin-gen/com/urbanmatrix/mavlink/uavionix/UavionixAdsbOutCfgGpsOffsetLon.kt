package com.urbanmatrix.mavlink.uavionix

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * GPS longitudinal offset encoding
 */
public enum class UavionixAdsbOutCfgGpsOffsetLon(
  public override val `value`: Long,
) : MavEnum {
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LON_NO_DATA(0L),
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LON_APPLIED_BY_SENSOR(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutCfgGpsOffsetLon? = when (v) {
      0L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LON_NO_DATA
      1L -> UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LON_APPLIED_BY_SENSOR
      else -> null
    }
  }
}

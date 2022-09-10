package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * GPS longitudinal offset encoding
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutCfgGpsOffsetLon(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LON_NO_DATA(0L),
  @GeneratedMavEnumEntry
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

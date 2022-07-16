package com.urbanmatrix.mavlink.definitions.uavionix

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Status flags for ADS-B transponder dynamic output
 */
public enum class UavionixAdsbRfHealth(
  public override val `value`: Long,
) : MavEnum {
  UAVIONIX_ADSB_RF_HEALTH_INITIALIZING(0L),
  UAVIONIX_ADSB_RF_HEALTH_OK(1L),
  UAVIONIX_ADSB_RF_HEALTH_FAIL_TX(2L),
  UAVIONIX_ADSB_RF_HEALTH_FAIL_RX(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbRfHealth? = when (v) {
      0L -> UAVIONIX_ADSB_RF_HEALTH_INITIALIZING
      1L -> UAVIONIX_ADSB_RF_HEALTH_OK
      2L -> UAVIONIX_ADSB_RF_HEALTH_FAIL_TX
      16L -> UAVIONIX_ADSB_RF_HEALTH_FAIL_RX
      else -> null
    }
  }
}

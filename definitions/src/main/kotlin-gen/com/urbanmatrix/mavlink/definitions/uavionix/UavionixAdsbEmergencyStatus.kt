package com.urbanmatrix.mavlink.definitions.uavionix

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Emergency status encoding
 */
@GeneratedMavEnum
public enum class UavionixAdsbEmergencyStatus(
  public override val `value`: Long,
) : MavEnum {
  UAVIONIX_ADSB_OUT_NO_EMERGENCY(0L),
  UAVIONIX_ADSB_OUT_GENERAL_EMERGENCY(1L),
  UAVIONIX_ADSB_OUT_LIFEGUARD_EMERGENCY(2L),
  UAVIONIX_ADSB_OUT_MINIMUM_FUEL_EMERGENCY(3L),
  UAVIONIX_ADSB_OUT_NO_COMM_EMERGENCY(4L),
  UAVIONIX_ADSB_OUT_UNLAWFUL_INTERFERANCE_EMERGENCY(5L),
  UAVIONIX_ADSB_OUT_DOWNED_AIRCRAFT_EMERGENCY(6L),
  UAVIONIX_ADSB_OUT_RESERVED(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbEmergencyStatus? = when (v) {
      0L -> UAVIONIX_ADSB_OUT_NO_EMERGENCY
      1L -> UAVIONIX_ADSB_OUT_GENERAL_EMERGENCY
      2L -> UAVIONIX_ADSB_OUT_LIFEGUARD_EMERGENCY
      3L -> UAVIONIX_ADSB_OUT_MINIMUM_FUEL_EMERGENCY
      4L -> UAVIONIX_ADSB_OUT_NO_COMM_EMERGENCY
      5L -> UAVIONIX_ADSB_OUT_UNLAWFUL_INTERFERANCE_EMERGENCY
      6L -> UAVIONIX_ADSB_OUT_DOWNED_AIRCRAFT_EMERGENCY
      7L -> UAVIONIX_ADSB_OUT_RESERVED
      else -> null
    }
  }
}

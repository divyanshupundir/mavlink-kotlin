package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Emergency status encoding
 */
@GeneratedMavEnum
public enum class UavionixAdsbEmergencyStatus(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_NO_EMERGENCY(0u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_GENERAL_EMERGENCY(1u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_LIFEGUARD_EMERGENCY(2u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_MINIMUM_FUEL_EMERGENCY(3u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_NO_COMM_EMERGENCY(4u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_UNLAWFUL_INTERFERANCE_EMERGENCY(5u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_DOWNED_AIRCRAFT_EMERGENCY(6u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_OUT_RESERVED(7u),
  ;

  public companion object : MavEnum.MavCompanion<UavionixAdsbEmergencyStatus> {
    public override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbEmergencyStatus? = when (v) {
      0u -> UAVIONIX_ADSB_OUT_NO_EMERGENCY
      1u -> UAVIONIX_ADSB_OUT_GENERAL_EMERGENCY
      2u -> UAVIONIX_ADSB_OUT_LIFEGUARD_EMERGENCY
      3u -> UAVIONIX_ADSB_OUT_MINIMUM_FUEL_EMERGENCY
      4u -> UAVIONIX_ADSB_OUT_NO_COMM_EMERGENCY
      5u -> UAVIONIX_ADSB_OUT_UNLAWFUL_INTERFERANCE_EMERGENCY
      6u -> UAVIONIX_ADSB_OUT_DOWNED_AIRCRAFT_EMERGENCY
      7u -> UAVIONIX_ADSB_OUT_RESERVED
      else -> null
    }
  }
}

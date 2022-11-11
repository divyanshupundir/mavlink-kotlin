package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Status flags for ADS-B transponder dynamic output
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbRfHealth(
  public override val `value`: Long,
) : MavBitmask {
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_RF_HEALTH_INITIALIZING(0L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_RF_HEALTH_OK(1L),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_RF_HEALTH_FAIL_TX(2L),
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<UavionixAdsbRfHealth> = buildList {
      if (v and 0L == 0L) add(UAVIONIX_ADSB_RF_HEALTH_INITIALIZING)
      if (v and 1L == 1L) add(UAVIONIX_ADSB_RF_HEALTH_OK)
      if (v and 2L == 2L) add(UAVIONIX_ADSB_RF_HEALTH_FAIL_TX)
      if (v and 16L == 16L) add(UAVIONIX_ADSB_RF_HEALTH_FAIL_RX)
    }
  }
}

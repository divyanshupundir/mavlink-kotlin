package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Transceiver RF control flags for ADS-B transponder dynamic reports
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutRfSelect(
  public override val `value`: Long,
) : MavEnum {
  UAVIONIX_ADSB_OUT_RF_SELECT_STANDBY(0L),
  UAVIONIX_ADSB_OUT_RF_SELECT_RX_ENABLED(1L),
  UAVIONIX_ADSB_OUT_RF_SELECT_TX_ENABLED(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutRfSelect? = when (v) {
      0L -> UAVIONIX_ADSB_OUT_RF_SELECT_STANDBY
      1L -> UAVIONIX_ADSB_OUT_RF_SELECT_RX_ENABLED
      2L -> UAVIONIX_ADSB_OUT_RF_SELECT_TX_ENABLED
      else -> null
    }
  }
}

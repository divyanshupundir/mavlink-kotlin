package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Cellular network radio type
 */
public enum class CellularNetworkRadioType(
  public override val `value`: Long,
) : MavEnum {
  CELLULAR_NETWORK_RADIO_TYPE_NONE(0L),
  CELLULAR_NETWORK_RADIO_TYPE_GSM(1L),
  CELLULAR_NETWORK_RADIO_TYPE_CDMA(2L),
  CELLULAR_NETWORK_RADIO_TYPE_WCDMA(3L),
  CELLULAR_NETWORK_RADIO_TYPE_LTE(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CellularNetworkRadioType? = when (v) {
      0L -> CELLULAR_NETWORK_RADIO_TYPE_NONE
      1L -> CELLULAR_NETWORK_RADIO_TYPE_GSM
      2L -> CELLULAR_NETWORK_RADIO_TYPE_CDMA
      3L -> CELLULAR_NETWORK_RADIO_TYPE_WCDMA
      4L -> CELLULAR_NETWORK_RADIO_TYPE_LTE
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Cellular network radio type
 */
@GeneratedMavEnum
public enum class CellularNetworkRadioType(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  CELLULAR_NETWORK_RADIO_TYPE_NONE(0L),
  @GeneratedMavEnumEntry
  CELLULAR_NETWORK_RADIO_TYPE_GSM(1L),
  @GeneratedMavEnumEntry
  CELLULAR_NETWORK_RADIO_TYPE_CDMA(2L),
  @GeneratedMavEnumEntry
  CELLULAR_NETWORK_RADIO_TYPE_WCDMA(3L),
  @GeneratedMavEnumEntry
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

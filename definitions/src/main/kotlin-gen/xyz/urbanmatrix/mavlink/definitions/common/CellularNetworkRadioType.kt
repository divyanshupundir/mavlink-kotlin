package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Cellular network radio type
 */
@GeneratedMavEnum
public enum class CellularNetworkRadioType(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  NONE(0u),
  @GeneratedMavEnumEntry
  GSM(1u),
  @GeneratedMavEnumEntry
  CDMA(2u),
  @GeneratedMavEnumEntry
  WCDMA(3u),
  @GeneratedMavEnumEntry
  LTE(4u),
  ;

  public companion object : MavEnum.Companion<CellularNetworkRadioType> {
    public override fun getEntryFromValueOrNull(v: UInt): CellularNetworkRadioType? = when (v) {
      0u -> NONE
      1u -> GSM
      2u -> CDMA
      3u -> WCDMA
      4u -> LTE
      else -> null
    }
  }
}

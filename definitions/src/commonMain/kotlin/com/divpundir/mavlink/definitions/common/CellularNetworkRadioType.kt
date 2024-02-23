package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Cellular network radio type
 */
@GeneratedMavEnum
public enum class CellularNetworkRadioType(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<CellularNetworkRadioType> {
    override fun getEntryFromValueOrNull(v: UInt): CellularNetworkRadioType? = when (v) {
      0u -> NONE
      1u -> GSM
      2u -> CDMA
      3u -> WCDMA
      4u -> LTE
      else -> null
    }
  }
}

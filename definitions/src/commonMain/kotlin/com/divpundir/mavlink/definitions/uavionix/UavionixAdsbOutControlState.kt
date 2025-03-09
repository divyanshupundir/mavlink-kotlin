package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * State flags for ADS-B transponder dynamic report
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutControlState(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  EXTERNAL_BARO_CROSSCHECKED(1u),
  @GeneratedMavEnumEntry
  ON_GROUND(4u),
  @GeneratedMavEnumEntry
  IDENT_BUTTON_ACTIVE(8u),
  @GeneratedMavEnumEntry
  MODE_A_ENABLED(16u),
  @GeneratedMavEnumEntry
  MODE_C_ENABLED(32u),
  @GeneratedMavEnumEntry
  MODE_S_ENABLED(64u),
  @GeneratedMavEnumEntry
  _1090ES_TX_ENABLED(128u),
  ;

  public companion object : MavEnum.MavCompanion<UavionixAdsbOutControlState> {
    override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutControlState? = when (v) {
      1u -> EXTERNAL_BARO_CROSSCHECKED
      4u -> ON_GROUND
      8u -> IDENT_BUTTON_ACTIVE
      16u -> MODE_A_ENABLED
      32u -> MODE_C_ENABLED
      64u -> MODE_S_ENABLED
      128u -> _1090ES_TX_ENABLED
      else -> null
    }
  }
}

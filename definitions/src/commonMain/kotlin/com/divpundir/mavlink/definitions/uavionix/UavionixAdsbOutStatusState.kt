package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * State flags for ADS-B transponder status report
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutStatusState(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  ON_GROUND(1u),
  @GeneratedMavEnumEntry
  INTERROGATED_SINCE_LAST(2u),
  @GeneratedMavEnumEntry
  XBIT_ENABLED(4u),
  @GeneratedMavEnumEntry
  IDENT_ACTIVE(8u),
  @GeneratedMavEnumEntry
  MODE_A_ENABLED(16u),
  @GeneratedMavEnumEntry
  MODE_C_ENABLED(32u),
  @GeneratedMavEnumEntry
  MODE_S_ENABLED(64u),
  @GeneratedMavEnumEntry
  _1090ES_TX_ENABLED(128u),
  ;

  public companion object : MavEnum.MavCompanion<UavionixAdsbOutStatusState> {
    override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutStatusState? = when (v) {
      1u -> ON_GROUND
      2u -> INTERROGATED_SINCE_LAST
      4u -> XBIT_ENABLED
      8u -> IDENT_ACTIVE
      16u -> MODE_A_ENABLED
      32u -> MODE_C_ENABLED
      64u -> MODE_S_ENABLED
      128u -> _1090ES_TX_ENABLED
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * State flags for ADS-B transponder status report
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbOutStatusState(
  override val `value`: UInt,
) : MavBitmask {
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

  public companion object : MavBitmask.MavCompanion<UavionixAdsbOutStatusState> {
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

    override fun getFlagsFromValue(v: UInt): List<UavionixAdsbOutStatusState> = buildList {
      if (v and 1u == 1u) add(ON_GROUND)
      if (v and 2u == 2u) add(INTERROGATED_SINCE_LAST)
      if (v and 4u == 4u) add(XBIT_ENABLED)
      if (v and 8u == 8u) add(IDENT_ACTIVE)
      if (v and 16u == 16u) add(MODE_A_ENABLED)
      if (v and 32u == 32u) add(MODE_C_ENABLED)
      if (v and 64u == 64u) add(MODE_S_ENABLED)
      if (v and 128u == 128u) add(_1090ES_TX_ENABLED)
    }
  }
}

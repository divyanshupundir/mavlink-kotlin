package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * State flags for ADS-B transponder dynamic report
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbOutControlState(
  override val `value`: UInt,
) : MavBitmask {
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

  public companion object : MavBitmask.MavCompanion<UavionixAdsbOutControlState> {
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

    override fun getFlagsFromValue(v: UInt): List<UavionixAdsbOutControlState> = buildList {
      if (v and 1u == 1u) add(EXTERNAL_BARO_CROSSCHECKED)
      if (v and 4u == 4u) add(ON_GROUND)
      if (v and 8u == 8u) add(IDENT_BUTTON_ACTIVE)
      if (v and 16u == 16u) add(MODE_A_ENABLED)
      if (v and 32u == 32u) add(MODE_C_ENABLED)
      if (v and 64u == 64u) add(MODE_S_ENABLED)
      if (v and 128u == 128u) add(_1090ES_TX_ENABLED)
    }
  }
}

package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * RADIO_LINK_STATS flags (bitmask).
 *
 */
@GeneratedMavEnum(bitmask = true)
public enum class RadioLinkStatsFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Rssi are in negative dBm. Values 0..254 corresponds to 0..-254 dBm.
   */
  @GeneratedMavEnumEntry
  RSSI_DBM(1u),
  ;

  public companion object : MavBitmask.MavCompanion<RadioLinkStatsFlags> {
    override fun getEntryFromValueOrNull(v: UInt): RadioLinkStatsFlags? = when (v) {
      1u -> RSSI_DBM
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<RadioLinkStatsFlags> = buildList {
      if (v and 1u == 1u) add(RSSI_DBM)
    }
  }
}

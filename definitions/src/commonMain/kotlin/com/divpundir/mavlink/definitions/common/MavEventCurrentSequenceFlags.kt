package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags for CURRENT_EVENT_SEQUENCE.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavEventCurrentSequenceFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * A sequence reset has happened (e.g. vehicle reboot).
   */
  @GeneratedMavEnumEntry
  RESET(1u),
  ;

  public companion object : MavBitmask.MavCompanion<MavEventCurrentSequenceFlags> {
    override fun getEntryFromValueOrNull(v: UInt): MavEventCurrentSequenceFlags? = when (v) {
      1u -> RESET
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavEventCurrentSequenceFlags> = buildList {
      if (v and 1u == 1u) add(RESET)
    }
  }
}

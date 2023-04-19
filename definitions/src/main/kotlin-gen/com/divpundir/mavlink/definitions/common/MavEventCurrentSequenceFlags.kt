package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Flags for CURRENT_EVENT_SEQUENCE.
 */
@GeneratedMavEnum
public enum class MavEventCurrentSequenceFlags(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * A sequence reset has happened (e.g. vehicle reboot).
   */
  @GeneratedMavEnumEntry
  RESET(1u),
  ;

  public companion object : MavEnum.Companion<MavEventCurrentSequenceFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): MavEventCurrentSequenceFlags? = when (v) {
      1u -> RESET
      else -> null
    }
  }
}

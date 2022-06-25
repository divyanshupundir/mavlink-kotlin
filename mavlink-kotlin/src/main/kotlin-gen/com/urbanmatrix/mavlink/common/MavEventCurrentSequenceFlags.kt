package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Flags for CURRENT_EVENT_SEQUENCE.
 */
public enum class MavEventCurrentSequenceFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * A sequence reset has happened (e.g. vehicle reboot).
   */
  MAV_EVENT_CURRENT_SEQUENCE_FLAGS_RESET(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavEventCurrentSequenceFlags? = when (v) {
      1L -> MAV_EVENT_CURRENT_SEQUENCE_FLAGS_RESET
      else -> null
    }
  }
}

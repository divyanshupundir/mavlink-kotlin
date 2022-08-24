package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags for CURRENT_EVENT_SEQUENCE.
 */
@GeneratedMavEnum
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

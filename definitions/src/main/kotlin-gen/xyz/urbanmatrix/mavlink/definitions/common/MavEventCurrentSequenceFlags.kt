package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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

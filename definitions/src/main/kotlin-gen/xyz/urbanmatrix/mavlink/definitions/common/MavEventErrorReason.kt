package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Reason for an event error response.
 */
@GeneratedMavEnum
public enum class MavEventErrorReason(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * The requested event is not available (anymore).
   */
  @GeneratedMavEnumEntry
  UNAVAILABLE(0u),
  ;

  public companion object : MavEnum.Companion<MavEventErrorReason> {
    public override fun getEntryFromValueOrNull(v: UInt): MavEventErrorReason? = when (v) {
      0u -> UNAVAILABLE
      else -> null
    }
  }
}

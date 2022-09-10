package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Reason for an event error response.
 */
@GeneratedMavEnum
public enum class MavEventErrorReason(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The requested event is not available (anymore).
   */
  @GeneratedMavEnumEntry
  MAV_EVENT_ERROR_REASON_UNAVAILABLE(0L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavEventErrorReason? = when (v) {
      0L -> MAV_EVENT_ERROR_REASON_UNAVAILABLE
      else -> null
    }
  }
}

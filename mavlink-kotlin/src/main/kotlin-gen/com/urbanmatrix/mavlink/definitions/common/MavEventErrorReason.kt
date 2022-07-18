package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Reason for an event error response.
 */
public enum class MavEventErrorReason(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The requested event is not available (anymore).
   */
  MAV_EVENT_ERROR_REASON_UNAVAILABLE(0L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavEventErrorReason? = when (v) {
      0L -> MAV_EVENT_ERROR_REASON_UNAVAILABLE
      else -> null
    }
  }
}

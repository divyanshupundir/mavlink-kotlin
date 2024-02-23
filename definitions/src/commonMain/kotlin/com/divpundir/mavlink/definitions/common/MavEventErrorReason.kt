package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Reason for an event error response.
 */
@GeneratedMavEnum
public enum class MavEventErrorReason(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The requested event is not available (anymore).
   */
  @GeneratedMavEnumEntry
  UNAVAILABLE(0u),
  ;

  public companion object : MavEnum.MavCompanion<MavEventErrorReason> {
    override fun getEntryFromValueOrNull(v: UInt): MavEventErrorReason? = when (v) {
      0u -> UNAVAILABLE
      else -> null
    }
  }
}

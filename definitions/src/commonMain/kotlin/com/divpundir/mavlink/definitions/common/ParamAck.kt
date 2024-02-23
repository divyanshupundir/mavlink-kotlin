package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Result from PARAM_EXT_SET message (or a PARAM_SET within a transaction).
 */
@GeneratedMavEnum
public enum class ParamAck(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Parameter value ACCEPTED and SET
   */
  @GeneratedMavEnumEntry
  ACCEPTED(0u),
  /**
   * Parameter value UNKNOWN/UNSUPPORTED
   */
  @GeneratedMavEnumEntry
  VALUE_UNSUPPORTED(1u),
  /**
   * Parameter failed to set
   */
  @GeneratedMavEnumEntry
  FAILED(2u),
  /**
   * Parameter value received but not yet set/accepted. A subsequent PARAM_ACK_TRANSACTION or
   * PARAM_EXT_ACK with the final result will follow once operation is completed. This is returned
   * immediately for parameters that take longer to set, indicating that the the parameter was received
   * and does not need to be resent.
   */
  @GeneratedMavEnumEntry
  IN_PROGRESS(3u),
  ;

  public companion object : MavEnum.MavCompanion<ParamAck> {
    override fun getEntryFromValueOrNull(v: UInt): ParamAck? = when (v) {
      0u -> ACCEPTED
      1u -> VALUE_UNSUPPORTED
      2u -> FAILED
      3u -> IN_PROGRESS
      else -> null
    }
  }
}

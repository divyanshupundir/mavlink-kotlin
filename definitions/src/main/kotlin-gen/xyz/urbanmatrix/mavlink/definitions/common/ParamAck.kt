package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Result from PARAM_EXT_SET message (or a PARAM_SET within a transaction).
 */
@GeneratedMavEnum
public enum class ParamAck(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Parameter value ACCEPTED and SET
   */
  @GeneratedMavEnumEntry
  PARAM_ACK_ACCEPTED(0L),
  /**
   * Parameter value UNKNOWN/UNSUPPORTED
   */
  @GeneratedMavEnumEntry
  PARAM_ACK_VALUE_UNSUPPORTED(1L),
  /**
   * Parameter failed to set
   */
  @GeneratedMavEnumEntry
  PARAM_ACK_FAILED(2L),
  /**
   * Parameter value received but not yet set/accepted. A subsequent PARAM_ACK_TRANSACTION or
   * PARAM_EXT_ACK with the final result will follow once operation is completed. This is returned
   * immediately for parameters that take longer to set, indicating taht the the parameter was recieved
   * and does not need to be resent.
   */
  @GeneratedMavEnumEntry
  PARAM_ACK_IN_PROGRESS(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): ParamAck? = when (v) {
      0L -> PARAM_ACK_ACCEPTED
      1L -> PARAM_ACK_VALUE_UNSUPPORTED
      2L -> PARAM_ACK_FAILED
      3L -> PARAM_ACK_IN_PROGRESS
      else -> null
    }
  }
}

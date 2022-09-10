package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Possible responses from a CELLULAR_CONFIG message.
 */
@GeneratedMavEnum
public enum class CellularConfigResponse(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Changes accepted.
   */
  @GeneratedMavEnumEntry
  CELLULAR_CONFIG_RESPONSE_ACCEPTED(0L),
  /**
   * Invalid APN.
   */
  @GeneratedMavEnumEntry
  CELLULAR_CONFIG_RESPONSE_APN_ERROR(1L),
  /**
   * Invalid PIN.
   */
  @GeneratedMavEnumEntry
  CELLULAR_CONFIG_RESPONSE_PIN_ERROR(2L),
  /**
   * Changes rejected.
   */
  @GeneratedMavEnumEntry
  CELLULAR_CONFIG_RESPONSE_REJECTED(3L),
  /**
   * PUK is required to unblock SIM card.
   */
  @GeneratedMavEnumEntry
  CELLULAR_CONFIG_BLOCKED_PUK_REQUIRED(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CellularConfigResponse? = when (v) {
      0L -> CELLULAR_CONFIG_RESPONSE_ACCEPTED
      1L -> CELLULAR_CONFIG_RESPONSE_APN_ERROR
      2L -> CELLULAR_CONFIG_RESPONSE_PIN_ERROR
      3L -> CELLULAR_CONFIG_RESPONSE_REJECTED
      4L -> CELLULAR_CONFIG_BLOCKED_PUK_REQUIRED
      else -> null
    }
  }
}

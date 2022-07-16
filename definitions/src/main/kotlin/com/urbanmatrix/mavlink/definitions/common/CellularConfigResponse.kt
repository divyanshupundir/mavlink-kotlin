package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Possible responses from a CELLULAR_CONFIG message.
 */
public enum class CellularConfigResponse(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Changes accepted.
   */
  CELLULAR_CONFIG_RESPONSE_ACCEPTED(0L),
  /**
   * Invalid APN.
   */
  CELLULAR_CONFIG_RESPONSE_APN_ERROR(1L),
  /**
   * Invalid PIN.
   */
  CELLULAR_CONFIG_RESPONSE_PIN_ERROR(2L),
  /**
   * Changes rejected.
   */
  CELLULAR_CONFIG_RESPONSE_REJECTED(3L),
  /**
   * PUK is required to unblock SIM card.
   */
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

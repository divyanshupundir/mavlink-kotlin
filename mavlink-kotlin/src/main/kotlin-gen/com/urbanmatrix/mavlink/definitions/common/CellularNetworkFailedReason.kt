package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * These flags are used to diagnose the failure state of CELLULAR_STATUS
 */
public enum class CellularNetworkFailedReason(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No error
   */
  CELLULAR_NETWORK_FAILED_REASON_NONE(0L),
  /**
   * Error state is unknown
   */
  CELLULAR_NETWORK_FAILED_REASON_UNKNOWN(1L),
  /**
   * SIM is required for the modem but missing
   */
  CELLULAR_NETWORK_FAILED_REASON_SIM_MISSING(2L),
  /**
   * SIM is available, but not usuable for connection
   */
  CELLULAR_NETWORK_FAILED_REASON_SIM_ERROR(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CellularNetworkFailedReason? = when (v) {
      0L -> CELLULAR_NETWORK_FAILED_REASON_NONE
      1L -> CELLULAR_NETWORK_FAILED_REASON_UNKNOWN
      2L -> CELLULAR_NETWORK_FAILED_REASON_SIM_MISSING
      3L -> CELLULAR_NETWORK_FAILED_REASON_SIM_ERROR
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * These flags are used to diagnose the failure state of CELLULAR_STATUS
 */
@GeneratedMavEnum
public enum class CellularNetworkFailedReason(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No error
   */
  @GeneratedMavEnumEntry
  NONE(0L),
  /**
   * Error state is unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(1L),
  /**
   * SIM is required for the modem but missing
   */
  @GeneratedMavEnumEntry
  SIM_MISSING(2L),
  /**
   * SIM is available, but not usuable for connection
   */
  @GeneratedMavEnumEntry
  SIM_ERROR(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CellularNetworkFailedReason? = when (v) {
      0L -> NONE
      1L -> UNKNOWN
      2L -> SIM_MISSING
      3L -> SIM_ERROR
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * These flags are used to diagnose the failure state of CELLULAR_STATUS
 */
@GeneratedMavEnum
public enum class CellularNetworkFailedReason(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * No error
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Error state is unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(1u),
  /**
   * SIM is required for the modem but missing
   */
  @GeneratedMavEnumEntry
  SIM_MISSING(2u),
  /**
   * SIM is available, but not usuable for connection
   */
  @GeneratedMavEnumEntry
  SIM_ERROR(3u),
  ;

  public companion object : MavEnum.Companion<CellularNetworkFailedReason> {
    public override fun getEntryFromValueOrNull(v: UInt): CellularNetworkFailedReason? = when (v) {
      0u -> NONE
      1u -> UNKNOWN
      2u -> SIM_MISSING
      3u -> SIM_ERROR
      else -> null
    }
  }
}

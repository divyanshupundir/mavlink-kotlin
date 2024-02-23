package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * These flags are used to diagnose the failure state of CELLULAR_STATUS
 */
@GeneratedMavEnum
public enum class CellularNetworkFailedReason(
  override val `value`: UInt,
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
   * SIM is available, but not usable for connection
   */
  @GeneratedMavEnumEntry
  SIM_ERROR(3u),
  ;

  public companion object : MavEnum.MavCompanion<CellularNetworkFailedReason> {
    override fun getEntryFromValueOrNull(v: UInt): CellularNetworkFailedReason? = when (v) {
      0u -> NONE
      1u -> UNKNOWN
      2u -> SIM_MISSING
      3u -> SIM_ERROR
      else -> null
    }
  }
}

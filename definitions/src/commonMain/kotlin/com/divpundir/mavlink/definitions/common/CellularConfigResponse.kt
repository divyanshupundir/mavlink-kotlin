package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Possible responses from a CELLULAR_CONFIG message.
 */
@GeneratedMavEnum
public enum class CellularConfigResponse(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Changes accepted.
   */
  @GeneratedMavEnumEntry
  ACCEPTED(0u),
  /**
   * Invalid APN.
   */
  @GeneratedMavEnumEntry
  APN_ERROR(1u),
  /**
   * Invalid PIN.
   */
  @GeneratedMavEnumEntry
  PIN_ERROR(2u),
  /**
   * Changes rejected.
   */
  @GeneratedMavEnumEntry
  REJECTED(3u),
  /**
   * PUK is required to unblock SIM card.
   */
  @GeneratedMavEnumEntry
  CELLULAR_CONFIG_BLOCKED_PUK_REQUIRED(4u),
  ;

  public companion object : MavEnum.MavCompanion<CellularConfigResponse> {
    override fun getEntryFromValueOrNull(v: UInt): CellularConfigResponse? = when (v) {
      0u -> ACCEPTED
      1u -> APN_ERROR
      2u -> PIN_ERROR
      3u -> REJECTED
      4u -> CELLULAR_CONFIG_BLOCKED_PUK_REQUIRED
      else -> null
    }
  }
}

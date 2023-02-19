package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Possible responses from a CELLULAR_CONFIG message.
 */
@GeneratedMavEnum
public enum class CellularConfigResponse(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<CellularConfigResponse> {
    public override fun getEntryFromValueOrNull(v: UInt): CellularConfigResponse? = when (v) {
      0u -> ACCEPTED
      1u -> APN_ERROR
      2u -> PIN_ERROR
      3u -> REJECTED
      4u -> CELLULAR_CONFIG_BLOCKED_PUK_REQUIRED
      else -> null
    }
  }
}

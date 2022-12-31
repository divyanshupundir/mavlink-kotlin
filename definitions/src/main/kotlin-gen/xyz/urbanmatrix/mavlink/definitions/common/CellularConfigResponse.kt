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
  ACCEPTED(0L),
  /**
   * Invalid APN.
   */
  @GeneratedMavEnumEntry
  APN_ERROR(1L),
  /**
   * Invalid PIN.
   */
  @GeneratedMavEnumEntry
  PIN_ERROR(2L),
  /**
   * Changes rejected.
   */
  @GeneratedMavEnumEntry
  REJECTED(3L),
  /**
   * PUK is required to unblock SIM card.
   */
  @GeneratedMavEnumEntry
  CELLULAR_CONFIG_BLOCKED_PUK_REQUIRED(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CellularConfigResponse? = when (v) {
      0L -> ACCEPTED
      1L -> APN_ERROR
      2L -> PIN_ERROR
      3L -> REJECTED
      4L -> CELLULAR_CONFIG_BLOCKED_PUK_REQUIRED
      else -> null
    }
  }
}

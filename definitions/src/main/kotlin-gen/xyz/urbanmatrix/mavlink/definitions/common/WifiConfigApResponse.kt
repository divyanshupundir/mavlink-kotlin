package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Possible responses from a WIFI_CONFIG_AP message.
 */
@GeneratedMavEnum
public enum class WifiConfigApResponse(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Undefined response. Likely an indicative of a system that doesn't support this request.
   */
  @GeneratedMavEnumEntry
  UNDEFINED(0L),
  /**
   * Changes accepted.
   */
  @GeneratedMavEnumEntry
  ACCEPTED(1L),
  /**
   * Changes rejected.
   */
  @GeneratedMavEnumEntry
  REJECTED(2L),
  /**
   * Invalid Mode.
   */
  @GeneratedMavEnumEntry
  MODE_ERROR(3L),
  /**
   * Invalid SSID.
   */
  @GeneratedMavEnumEntry
  SSID_ERROR(4L),
  /**
   * Invalid Password.
   */
  @GeneratedMavEnumEntry
  PASSWORD_ERROR(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): WifiConfigApResponse? = when (v) {
      0L -> UNDEFINED
      1L -> ACCEPTED
      2L -> REJECTED
      3L -> MODE_ERROR
      4L -> SSID_ERROR
      5L -> PASSWORD_ERROR
      else -> null
    }
  }
}

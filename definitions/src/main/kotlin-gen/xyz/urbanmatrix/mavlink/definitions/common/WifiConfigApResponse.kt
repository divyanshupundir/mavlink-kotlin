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
  WIFI_CONFIG_AP_RESPONSE_UNDEFINED(0L),
  /**
   * Changes accepted.
   */
  @GeneratedMavEnumEntry
  WIFI_CONFIG_AP_RESPONSE_ACCEPTED(1L),
  /**
   * Changes rejected.
   */
  @GeneratedMavEnumEntry
  WIFI_CONFIG_AP_RESPONSE_REJECTED(2L),
  /**
   * Invalid Mode.
   */
  @GeneratedMavEnumEntry
  WIFI_CONFIG_AP_RESPONSE_MODE_ERROR(3L),
  /**
   * Invalid SSID.
   */
  @GeneratedMavEnumEntry
  WIFI_CONFIG_AP_RESPONSE_SSID_ERROR(4L),
  /**
   * Invalid Password.
   */
  @GeneratedMavEnumEntry
  WIFI_CONFIG_AP_RESPONSE_PASSWORD_ERROR(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): WifiConfigApResponse? = when (v) {
      0L -> WIFI_CONFIG_AP_RESPONSE_UNDEFINED
      1L -> WIFI_CONFIG_AP_RESPONSE_ACCEPTED
      2L -> WIFI_CONFIG_AP_RESPONSE_REJECTED
      3L -> WIFI_CONFIG_AP_RESPONSE_MODE_ERROR
      4L -> WIFI_CONFIG_AP_RESPONSE_SSID_ERROR
      5L -> WIFI_CONFIG_AP_RESPONSE_PASSWORD_ERROR
      else -> null
    }
  }
}

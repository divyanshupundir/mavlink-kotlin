package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * WiFi Mode.
 */
@GeneratedMavEnum
public enum class WifiConfigApMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * WiFi mode is undefined.
   */
  @GeneratedMavEnumEntry
  WIFI_CONFIG_AP_MODE_UNDEFINED(0L),
  /**
   * WiFi configured as an access point.
   */
  @GeneratedMavEnumEntry
  WIFI_CONFIG_AP_MODE_AP(1L),
  /**
   * WiFi configured as a station connected to an existing local WiFi network.
   */
  @GeneratedMavEnumEntry
  WIFI_CONFIG_AP_MODE_STATION(2L),
  /**
   * WiFi disabled.
   */
  @GeneratedMavEnumEntry
  WIFI_CONFIG_AP_MODE_DISABLED(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): WifiConfigApMode? = when (v) {
      0L -> WIFI_CONFIG_AP_MODE_UNDEFINED
      1L -> WIFI_CONFIG_AP_MODE_AP
      2L -> WIFI_CONFIG_AP_MODE_STATION
      3L -> WIFI_CONFIG_AP_MODE_DISABLED
      else -> null
    }
  }
}

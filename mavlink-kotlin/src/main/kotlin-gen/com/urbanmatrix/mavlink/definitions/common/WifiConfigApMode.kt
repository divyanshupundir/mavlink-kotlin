package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * WiFi Mode.
 */
public enum class WifiConfigApMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * WiFi mode is undefined.
   */
  WIFI_CONFIG_AP_MODE_UNDEFINED(0L),
  /**
   * WiFi configured as an access point.
   */
  WIFI_CONFIG_AP_MODE_AP(1L),
  /**
   * WiFi configured as a station connected to an existing local WiFi network.
   */
  WIFI_CONFIG_AP_MODE_STATION(2L),
  /**
   * WiFi disabled.
   */
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

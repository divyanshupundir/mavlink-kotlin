package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * WiFi Mode.
 */
@GeneratedMavEnum
public enum class WifiConfigApMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * WiFi mode is undefined.
   */
  @GeneratedMavEnumEntry
  UNDEFINED(0u),
  /**
   * WiFi configured as an access point.
   */
  @GeneratedMavEnumEntry
  AP(1u),
  /**
   * WiFi configured as a station connected to an existing local WiFi network.
   */
  @GeneratedMavEnumEntry
  STATION(2u),
  /**
   * WiFi disabled.
   */
  @GeneratedMavEnumEntry
  DISABLED(3u),
  ;

  public companion object : MavEnum.MavCompanion<WifiConfigApMode> {
    override fun getEntryFromValueOrNull(v: UInt): WifiConfigApMode? = when (v) {
      0u -> UNDEFINED
      1u -> AP
      2u -> STATION
      3u -> DISABLED
      else -> null
    }
  }
}

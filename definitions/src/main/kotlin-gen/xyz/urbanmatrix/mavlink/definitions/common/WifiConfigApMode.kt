package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * WiFi Mode.
 */
@GeneratedMavEnum
public enum class WifiConfigApMode(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<WifiConfigApMode> {
    public override fun getEntryFromValueOrNull(v: UInt): WifiConfigApMode? = when (v) {
      0u -> UNDEFINED
      1u -> AP
      2u -> STATION
      3u -> DISABLED
      else -> null
    }
  }
}

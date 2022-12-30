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
  UNDEFINED(0L),
  /**
   * WiFi configured as an access point.
   */
  @GeneratedMavEnumEntry
  AP(1L),
  /**
   * WiFi configured as a station connected to an existing local WiFi network.
   */
  @GeneratedMavEnumEntry
  STATION(2L),
  /**
   * WiFi disabled.
   */
  @GeneratedMavEnumEntry
  DISABLED(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): WifiConfigApMode? = when (v) {
      0L -> UNDEFINED
      1L -> AP
      2L -> STATION
      3L -> DISABLED
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Possible responses from a WIFI_CONFIG_AP message.
 */
@GeneratedMavEnum
public enum class WifiConfigApResponse(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Undefined response. Likely an indicative of a system that doesn't support this request.
   */
  @GeneratedMavEnumEntry
  UNDEFINED(0u),
  /**
   * Changes accepted.
   */
  @GeneratedMavEnumEntry
  ACCEPTED(1u),
  /**
   * Changes rejected.
   */
  @GeneratedMavEnumEntry
  REJECTED(2u),
  /**
   * Invalid Mode.
   */
  @GeneratedMavEnumEntry
  MODE_ERROR(3u),
  /**
   * Invalid SSID.
   */
  @GeneratedMavEnumEntry
  SSID_ERROR(4u),
  /**
   * Invalid Password.
   */
  @GeneratedMavEnumEntry
  PASSWORD_ERROR(5u),
  ;

  public companion object : MavEnum.MavCompanion<WifiConfigApResponse> {
    override fun getEntryFromValueOrNull(v: UInt): WifiConfigApResponse? = when (v) {
      0u -> UNDEFINED
      1u -> ACCEPTED
      2u -> REJECTED
      3u -> MODE_ERROR
      4u -> SSID_ERROR
      5u -> PASSWORD_ERROR
      else -> null
    }
  }
}

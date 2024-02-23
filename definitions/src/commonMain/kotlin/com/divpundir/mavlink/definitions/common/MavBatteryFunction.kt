package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Enumeration of battery functions
 */
@GeneratedMavEnum
public enum class MavBatteryFunction(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Battery function is unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Battery supports all flight systems
   */
  @GeneratedMavEnumEntry
  ALL(1u),
  /**
   * Battery for the propulsion system
   */
  @GeneratedMavEnumEntry
  PROPULSION(2u),
  /**
   * Avionics battery
   */
  @GeneratedMavEnumEntry
  AVIONICS(3u),
  /**
   * Payload battery
   */
  @GeneratedMavEnumEntry
  PAYLOAD(4u),
  ;

  public companion object : MavEnum.MavCompanion<MavBatteryFunction> {
    override fun getEntryFromValueOrNull(v: UInt): MavBatteryFunction? = when (v) {
      0u -> UNKNOWN
      1u -> ALL
      2u -> PROPULSION
      3u -> AVIONICS
      4u -> PAYLOAD
      else -> null
    }
  }
}

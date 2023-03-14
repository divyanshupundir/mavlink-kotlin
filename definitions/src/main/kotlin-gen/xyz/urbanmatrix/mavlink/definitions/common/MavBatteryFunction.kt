package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of battery functions
 */
@GeneratedMavEnum
public enum class MavBatteryFunction(
  public override val `value`: UInt,
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
  MAV_BATTERY_TYPE_PAYLOAD(4u),
  ;

  public companion object : MavEnum.Companion<MavBatteryFunction> {
    public override fun getEntryFromValueOrNull(v: UInt): MavBatteryFunction? = when (v) {
      0u -> UNKNOWN
      1u -> ALL
      2u -> PROPULSION
      3u -> AVIONICS
      4u -> MAV_BATTERY_TYPE_PAYLOAD
      else -> null
    }
  }
}

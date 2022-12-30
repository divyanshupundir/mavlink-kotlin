package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of battery functions
 */
@GeneratedMavEnum
public enum class MavBatteryFunction(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Battery function is unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * Battery supports all flight systems
   */
  @GeneratedMavEnumEntry
  ALL(1L),
  /**
   * Battery for the propulsion system
   */
  @GeneratedMavEnumEntry
  PROPULSION(2L),
  /**
   * Avionics battery
   */
  @GeneratedMavEnumEntry
  AVIONICS(3L),
  /**
   * Payload battery
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_TYPE_PAYLOAD(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryFunction? = when (v) {
      0L -> UNKNOWN
      1L -> ALL
      2L -> PROPULSION
      3L -> AVIONICS
      4L -> MAV_BATTERY_TYPE_PAYLOAD
      else -> null
    }
  }
}

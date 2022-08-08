package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

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
  MAV_BATTERY_FUNCTION_UNKNOWN(0L),
  /**
   * Battery supports all flight systems
   */
  MAV_BATTERY_FUNCTION_ALL(1L),
  /**
   * Battery for the propulsion system
   */
  MAV_BATTERY_FUNCTION_PROPULSION(2L),
  /**
   * Avionics battery
   */
  MAV_BATTERY_FUNCTION_AVIONICS(3L),
  /**
   * Payload battery
   */
  MAV_BATTERY_TYPE_PAYLOAD(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryFunction? = when (v) {
      0L -> MAV_BATTERY_FUNCTION_UNKNOWN
      1L -> MAV_BATTERY_FUNCTION_ALL
      2L -> MAV_BATTERY_FUNCTION_PROPULSION
      3L -> MAV_BATTERY_FUNCTION_AVIONICS
      4L -> MAV_BATTERY_TYPE_PAYLOAD
      else -> null
    }
  }
}

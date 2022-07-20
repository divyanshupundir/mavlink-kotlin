package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Enumeration of battery types
 */
public enum class MavBatteryType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Not specified.
   */
  MAV_BATTERY_TYPE_UNKNOWN(0L),
  /**
   * Lithium polymer battery
   */
  MAV_BATTERY_TYPE_LIPO(1L),
  /**
   * Lithium-iron-phosphate battery
   */
  MAV_BATTERY_TYPE_LIFE(2L),
  /**
   * Lithium-ION battery
   */
  MAV_BATTERY_TYPE_LION(3L),
  /**
   * Nickel metal hydride battery
   */
  MAV_BATTERY_TYPE_NIMH(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryType? = when (v) {
      0L -> MAV_BATTERY_TYPE_UNKNOWN
      1L -> MAV_BATTERY_TYPE_LIPO
      2L -> MAV_BATTERY_TYPE_LIFE
      3L -> MAV_BATTERY_TYPE_LION
      4L -> MAV_BATTERY_TYPE_NIMH
      else -> null
    }
  }
}

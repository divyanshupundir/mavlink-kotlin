package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Smart battery supply status/fault flags (bitmask) for health indication. The battery must also
 * report either MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY if any of these
 * are set.
 */
public enum class MavBatteryFault(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Battery has deep discharged.
   */
  MAV_BATTERY_FAULT_DEEP_DISCHARGE(1L),
  /**
   * Voltage spikes.
   */
  MAV_BATTERY_FAULT_SPIKES(2L),
  /**
   * One or more cells have failed. Battery should also report MAV_BATTERY_CHARGE_STATE_FAILE (and
   * should not be used).
   */
  MAV_BATTERY_FAULT_CELL_FAIL(4L),
  /**
   * Over-current fault.
   */
  MAV_BATTERY_FAULT_OVER_CURRENT(8L),
  /**
   * Over-temperature fault.
   */
  MAV_BATTERY_FAULT_OVER_TEMPERATURE(16L),
  /**
   * Under-temperature fault.
   */
  MAV_BATTERY_FAULT_UNDER_TEMPERATURE(32L),
  /**
   * Vehicle voltage is not compatible with this battery (batteries on same power rail should have
   * similar voltage).
   */
  MAV_BATTERY_FAULT_INCOMPATIBLE_VOLTAGE(64L),
  /**
   * Battery firmware is not compatible with current autopilot firmware.
   */
  MAV_BATTERY_FAULT_INCOMPATIBLE_FIRMWARE(128L),
  /**
   * Battery is not compatible due to cell configuration (e.g. 5s1p when vehicle requires 6s).
   */
  BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION(256L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryFault? = when (v) {
      1L -> MAV_BATTERY_FAULT_DEEP_DISCHARGE
      2L -> MAV_BATTERY_FAULT_SPIKES
      4L -> MAV_BATTERY_FAULT_CELL_FAIL
      8L -> MAV_BATTERY_FAULT_OVER_CURRENT
      16L -> MAV_BATTERY_FAULT_OVER_TEMPERATURE
      32L -> MAV_BATTERY_FAULT_UNDER_TEMPERATURE
      64L -> MAV_BATTERY_FAULT_INCOMPATIBLE_VOLTAGE
      128L -> MAV_BATTERY_FAULT_INCOMPATIBLE_FIRMWARE
      256L -> BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION
      else -> null
    }
  }
}

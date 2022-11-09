package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Smart battery supply status/fault flags (bitmask) for health indication. The battery must also
 * report either MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY if any of these
 * are set.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavBatteryFault(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Battery has deep discharged.
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_FAULT_DEEP_DISCHARGE(1L),
  /**
   * Voltage spikes.
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_FAULT_SPIKES(2L),
  /**
   * One or more cells have failed. Battery should also report MAV_BATTERY_CHARGE_STATE_FAILE (and
   * should not be used).
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_FAULT_CELL_FAIL(4L),
  /**
   * Over-current fault.
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_FAULT_OVER_CURRENT(8L),
  /**
   * Over-temperature fault.
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_FAULT_OVER_TEMPERATURE(16L),
  /**
   * Under-temperature fault.
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_FAULT_UNDER_TEMPERATURE(32L),
  /**
   * Vehicle voltage is not compatible with this battery (batteries on same power rail should have
   * similar voltage).
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_FAULT_INCOMPATIBLE_VOLTAGE(64L),
  /**
   * Battery firmware is not compatible with current autopilot firmware.
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_FAULT_INCOMPATIBLE_FIRMWARE(128L),
  /**
   * Battery is not compatible due to cell configuration (e.g. 5s1p when vehicle requires 6s).
   */
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<MavBatteryFault> = buildList {
      if (v and 1L == 1L) add(MAV_BATTERY_FAULT_DEEP_DISCHARGE)
      if (v and 2L == 2L) add(MAV_BATTERY_FAULT_SPIKES)
      if (v and 4L == 4L) add(MAV_BATTERY_FAULT_CELL_FAIL)
      if (v and 8L == 8L) add(MAV_BATTERY_FAULT_OVER_CURRENT)
      if (v and 16L == 16L) add(MAV_BATTERY_FAULT_OVER_TEMPERATURE)
      if (v and 32L == 32L) add(MAV_BATTERY_FAULT_UNDER_TEMPERATURE)
      if (v and 64L == 64L) add(MAV_BATTERY_FAULT_INCOMPATIBLE_VOLTAGE)
      if (v and 128L == 128L) add(MAV_BATTERY_FAULT_INCOMPATIBLE_FIRMWARE)
      if (v and 256L == 256L) add(BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION)
    }
  }
}

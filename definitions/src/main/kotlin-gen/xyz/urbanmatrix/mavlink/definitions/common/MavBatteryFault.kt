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
  DEEP_DISCHARGE(1L),
  /**
   * Voltage spikes.
   */
  @GeneratedMavEnumEntry
  SPIKES(2L),
  /**
   * One or more cells have failed. Battery should also report MAV_BATTERY_CHARGE_STATE_FAILE (and
   * should not be used).
   */
  @GeneratedMavEnumEntry
  CELL_FAIL(4L),
  /**
   * Over-current fault.
   */
  @GeneratedMavEnumEntry
  OVER_CURRENT(8L),
  /**
   * Over-temperature fault.
   */
  @GeneratedMavEnumEntry
  OVER_TEMPERATURE(16L),
  /**
   * Under-temperature fault.
   */
  @GeneratedMavEnumEntry
  UNDER_TEMPERATURE(32L),
  /**
   * Vehicle voltage is not compatible with this battery (batteries on same power rail should have
   * similar voltage).
   */
  @GeneratedMavEnumEntry
  INCOMPATIBLE_VOLTAGE(64L),
  /**
   * Battery firmware is not compatible with current autopilot firmware.
   */
  @GeneratedMavEnumEntry
  INCOMPATIBLE_FIRMWARE(128L),
  /**
   * Battery is not compatible due to cell configuration (e.g. 5s1p when vehicle requires 6s).
   */
  @GeneratedMavEnumEntry
  BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION(256L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryFault? = when (v) {
      1L -> DEEP_DISCHARGE
      2L -> SPIKES
      4L -> CELL_FAIL
      8L -> OVER_CURRENT
      16L -> OVER_TEMPERATURE
      32L -> UNDER_TEMPERATURE
      64L -> INCOMPATIBLE_VOLTAGE
      128L -> INCOMPATIBLE_FIRMWARE
      256L -> BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<MavBatteryFault> = buildList {
      if (v and 1L == 1L) add(DEEP_DISCHARGE)
      if (v and 2L == 2L) add(SPIKES)
      if (v and 4L == 4L) add(CELL_FAIL)
      if (v and 8L == 8L) add(OVER_CURRENT)
      if (v and 16L == 16L) add(OVER_TEMPERATURE)
      if (v and 32L == 32L) add(UNDER_TEMPERATURE)
      if (v and 64L == 64L) add(INCOMPATIBLE_VOLTAGE)
      if (v and 128L == 128L) add(INCOMPATIBLE_FIRMWARE)
      if (v and 256L == 256L) add(BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION)
    }
  }
}

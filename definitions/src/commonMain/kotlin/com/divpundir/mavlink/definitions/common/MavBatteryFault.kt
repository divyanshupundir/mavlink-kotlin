package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Smart battery supply status/fault flags (bitmask) for health indication. The battery must also
 * report either MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY if any of these
 * are set.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavBatteryFault(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Battery has deep discharged.
   */
  @GeneratedMavEnumEntry
  DEEP_DISCHARGE(1u),
  /**
   * Voltage spikes.
   */
  @GeneratedMavEnumEntry
  SPIKES(2u),
  /**
   * One or more cells have failed. Battery should also report MAV_BATTERY_CHARGE_STATE_FAILE (and
   * should not be used).
   */
  @GeneratedMavEnumEntry
  CELL_FAIL(4u),
  /**
   * Over-current fault.
   */
  @GeneratedMavEnumEntry
  OVER_CURRENT(8u),
  /**
   * Over-temperature fault.
   */
  @GeneratedMavEnumEntry
  OVER_TEMPERATURE(16u),
  /**
   * Under-temperature fault.
   */
  @GeneratedMavEnumEntry
  UNDER_TEMPERATURE(32u),
  /**
   * Vehicle voltage is not compatible with this battery (batteries on same power rail should have
   * similar voltage).
   */
  @GeneratedMavEnumEntry
  INCOMPATIBLE_VOLTAGE(64u),
  /**
   * Battery firmware is not compatible with current autopilot firmware.
   */
  @GeneratedMavEnumEntry
  INCOMPATIBLE_FIRMWARE(128u),
  /**
   * Battery is not compatible due to cell configuration (e.g. 5s1p when vehicle requires 6s).
   */
  @GeneratedMavEnumEntry
  BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION(256u),
  ;

  public companion object : MavBitmask.MavCompanion<MavBatteryFault> {
    override fun getEntryFromValueOrNull(v: UInt): MavBatteryFault? = when (v) {
      1u -> DEEP_DISCHARGE
      2u -> SPIKES
      4u -> CELL_FAIL
      8u -> OVER_CURRENT
      16u -> OVER_TEMPERATURE
      32u -> UNDER_TEMPERATURE
      64u -> INCOMPATIBLE_VOLTAGE
      128u -> INCOMPATIBLE_FIRMWARE
      256u -> BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavBatteryFault> = buildList {
      if (v and 1u == 1u) add(DEEP_DISCHARGE)
      if (v and 2u == 2u) add(SPIKES)
      if (v and 4u == 4u) add(CELL_FAIL)
      if (v and 8u == 8u) add(OVER_CURRENT)
      if (v and 16u == 16u) add(OVER_TEMPERATURE)
      if (v and 32u == 32u) add(UNDER_TEMPERATURE)
      if (v and 64u == 64u) add(INCOMPATIBLE_VOLTAGE)
      if (v and 128u == 128u) add(INCOMPATIBLE_FIRMWARE)
      if (v and 256u == 256u) add(BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION)
    }
  }
}

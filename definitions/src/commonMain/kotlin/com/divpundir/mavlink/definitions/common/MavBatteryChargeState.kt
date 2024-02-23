package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Enumeration for battery charge states.
 */
@GeneratedMavEnum
public enum class MavBatteryChargeState(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Low battery state is not provided
   */
  @GeneratedMavEnumEntry
  UNDEFINED(0u),
  /**
   * Battery is not in low state. Normal operation.
   */
  @GeneratedMavEnumEntry
  OK(1u),
  /**
   * Battery state is low, warn and monitor close.
   */
  @GeneratedMavEnumEntry
  LOW(2u),
  /**
   * Battery state is critical, return or abort immediately.
   */
  @GeneratedMavEnumEntry
  CRITICAL(3u),
  /**
   * Battery state is too low for ordinary abort sequence. Perform fastest possible emergency stop
   * to prevent damage.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(4u),
  /**
   * Battery failed, damage unavoidable. Possible causes (faults) are listed in MAV_BATTERY_FAULT.
   */
  @GeneratedMavEnumEntry
  FAILED(5u),
  /**
   * Battery is diagnosed to be defective or an error occurred, usage is discouraged / prohibited.
   * Possible causes (faults) are listed in MAV_BATTERY_FAULT.
   */
  @GeneratedMavEnumEntry
  UNHEALTHY(6u),
  /**
   * Battery is charging.
   */
  @GeneratedMavEnumEntry
  CHARGING(7u),
  ;

  public companion object : MavEnum.MavCompanion<MavBatteryChargeState> {
    override fun getEntryFromValueOrNull(v: UInt): MavBatteryChargeState? = when (v) {
      0u -> UNDEFINED
      1u -> OK
      2u -> LOW
      3u -> CRITICAL
      4u -> EMERGENCY
      5u -> FAILED
      6u -> UNHEALTHY
      7u -> CHARGING
      else -> null
    }
  }
}

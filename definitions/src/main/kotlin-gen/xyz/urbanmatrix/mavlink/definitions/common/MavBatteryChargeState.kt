package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration for battery charge states.
 */
@GeneratedMavEnum
public enum class MavBatteryChargeState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Low battery state is not provided
   */
  @GeneratedMavEnumEntry
  UNDEFINED(0L),
  /**
   * Battery is not in low state. Normal operation.
   */
  @GeneratedMavEnumEntry
  OK(1L),
  /**
   * Battery state is low, warn and monitor close.
   */
  @GeneratedMavEnumEntry
  LOW(2L),
  /**
   * Battery state is critical, return or abort immediately.
   */
  @GeneratedMavEnumEntry
  CRITICAL(3L),
  /**
   * Battery state is too low for ordinary abort sequence. Perform fastest possible emergency stop
   * to prevent damage.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(4L),
  /**
   * Battery failed, damage unavoidable. Possible causes (faults) are listed in MAV_BATTERY_FAULT.
   */
  @GeneratedMavEnumEntry
  FAILED(5L),
  /**
   * Battery is diagnosed to be defective or an error occurred, usage is discouraged / prohibited.
   * Possible causes (faults) are listed in MAV_BATTERY_FAULT.
   */
  @GeneratedMavEnumEntry
  UNHEALTHY(6L),
  /**
   * Battery is charging.
   */
  @GeneratedMavEnumEntry
  CHARGING(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryChargeState? = when (v) {
      0L -> UNDEFINED
      1L -> OK
      2L -> LOW
      3L -> CRITICAL
      4L -> EMERGENCY
      5L -> FAILED
      6L -> UNHEALTHY
      7L -> CHARGING
      else -> null
    }
  }
}

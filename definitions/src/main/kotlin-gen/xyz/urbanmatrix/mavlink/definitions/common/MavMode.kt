package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * These defines are predefined OR-combined mode flags. There is no need to use values from this
 * enum, but it
 *                simplifies the use of the mode flags. Note that manual input is enabled in all
 * modes as a safety override.
 */
@GeneratedMavEnum
public enum class MavMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * System is not ready to fly, booting, calibrating, etc. No flag is set.
   */
  @GeneratedMavEnumEntry
  PREFLIGHT(0L),
  /**
   * System is allowed to be active, under assisted RC control.
   */
  @GeneratedMavEnumEntry
  STABILIZE_DISARMED(80L),
  /**
   * System is allowed to be active, under assisted RC control.
   */
  @GeneratedMavEnumEntry
  STABILIZE_ARMED(208L),
  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   */
  @GeneratedMavEnumEntry
  MANUAL_DISARMED(64L),
  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   */
  @GeneratedMavEnumEntry
  MANUAL_ARMED(192L),
  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   */
  @GeneratedMavEnumEntry
  GUIDED_DISARMED(88L),
  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   */
  @GeneratedMavEnumEntry
  GUIDED_ARMED(216L),
  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is
   * decided onboard and not pre-programmed by waypoints)
   */
  @GeneratedMavEnumEntry
  AUTO_DISARMED(92L),
  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is
   * decided onboard and not pre-programmed by waypoints)
   */
  @GeneratedMavEnumEntry
  AUTO_ARMED(220L),
  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for
   * developers only.
   */
  @GeneratedMavEnumEntry
  TEST_DISARMED(66L),
  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for
   * developers only.
   */
  @GeneratedMavEnumEntry
  TEST_ARMED(194L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavMode? = when (v) {
      0L -> PREFLIGHT
      80L -> STABILIZE_DISARMED
      208L -> STABILIZE_ARMED
      64L -> MANUAL_DISARMED
      192L -> MANUAL_ARMED
      88L -> GUIDED_DISARMED
      216L -> GUIDED_ARMED
      92L -> AUTO_DISARMED
      220L -> AUTO_ARMED
      66L -> TEST_DISARMED
      194L -> TEST_ARMED
      else -> null
    }
  }
}

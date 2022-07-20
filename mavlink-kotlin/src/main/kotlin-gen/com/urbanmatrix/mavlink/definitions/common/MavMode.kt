package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * These defines are predefined OR-combined mode flags. There is no need to use values from this
 * enum, but it
 *                simplifies the use of the mode flags. Note that manual input is enabled in all
 * modes as a safety override.
 */
public enum class MavMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * System is not ready to fly, booting, calibrating, etc. No flag is set.
   */
  MAV_MODE_PREFLIGHT(0L),
  /**
   * System is allowed to be active, under assisted RC control.
   */
  MAV_MODE_STABILIZE_DISARMED(80L),
  /**
   * System is allowed to be active, under assisted RC control.
   */
  MAV_MODE_STABILIZE_ARMED(208L),
  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   */
  MAV_MODE_MANUAL_DISARMED(64L),
  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   */
  MAV_MODE_MANUAL_ARMED(192L),
  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   */
  MAV_MODE_GUIDED_DISARMED(88L),
  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   */
  MAV_MODE_GUIDED_ARMED(216L),
  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is
   * decided onboard and not pre-programmed by waypoints)
   */
  MAV_MODE_AUTO_DISARMED(92L),
  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is
   * decided onboard and not pre-programmed by waypoints)
   */
  MAV_MODE_AUTO_ARMED(220L),
  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for
   * developers only.
   */
  MAV_MODE_TEST_DISARMED(66L),
  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for
   * developers only.
   */
  MAV_MODE_TEST_ARMED(194L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavMode? = when (v) {
      0L -> MAV_MODE_PREFLIGHT
      80L -> MAV_MODE_STABILIZE_DISARMED
      208L -> MAV_MODE_STABILIZE_ARMED
      64L -> MAV_MODE_MANUAL_DISARMED
      192L -> MAV_MODE_MANUAL_ARMED
      88L -> MAV_MODE_GUIDED_DISARMED
      216L -> MAV_MODE_GUIDED_ARMED
      92L -> MAV_MODE_AUTO_DISARMED
      220L -> MAV_MODE_AUTO_ARMED
      66L -> MAV_MODE_TEST_DISARMED
      194L -> MAV_MODE_TEST_ARMED
      else -> null
    }
  }
}

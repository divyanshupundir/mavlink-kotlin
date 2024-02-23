package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * These defines are predefined OR-combined mode flags. There is no need to use values from this
 * enum, but it
 *                simplifies the use of the mode flags. Note that manual input is enabled in all
 * modes as a safety override.
 */
@GeneratedMavEnum
public enum class MavMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * System is not ready to fly, booting, calibrating, etc. No flag is set.
   */
  @GeneratedMavEnumEntry
  PREFLIGHT(0u),
  /**
   * System is allowed to be active, under assisted RC control.
   */
  @GeneratedMavEnumEntry
  STABILIZE_DISARMED(80u),
  /**
   * System is allowed to be active, under assisted RC control.
   */
  @GeneratedMavEnumEntry
  STABILIZE_ARMED(208u),
  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   */
  @GeneratedMavEnumEntry
  MANUAL_DISARMED(64u),
  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   */
  @GeneratedMavEnumEntry
  MANUAL_ARMED(192u),
  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   */
  @GeneratedMavEnumEntry
  GUIDED_DISARMED(88u),
  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   */
  @GeneratedMavEnumEntry
  GUIDED_ARMED(216u),
  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is
   * decided onboard and not pre-programmed by waypoints)
   */
  @GeneratedMavEnumEntry
  AUTO_DISARMED(92u),
  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is
   * decided onboard and not pre-programmed by waypoints)
   */
  @GeneratedMavEnumEntry
  AUTO_ARMED(220u),
  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for
   * developers only.
   */
  @GeneratedMavEnumEntry
  TEST_DISARMED(66u),
  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for
   * developers only.
   */
  @GeneratedMavEnumEntry
  TEST_ARMED(194u),
  ;

  public companion object : MavEnum.MavCompanion<MavMode> {
    override fun getEntryFromValueOrNull(v: UInt): MavMode? = when (v) {
      0u -> PREFLIGHT
      80u -> STABILIZE_DISARMED
      208u -> STABILIZE_ARMED
      64u -> MANUAL_DISARMED
      192u -> MANUAL_ARMED
      88u -> GUIDED_DISARMED
      216u -> GUIDED_ARMED
      92u -> AUTO_DISARMED
      220u -> AUTO_ARMED
      66u -> TEST_DISARMED
      194u -> TEST_ARMED
      else -> null
    }
  }
}

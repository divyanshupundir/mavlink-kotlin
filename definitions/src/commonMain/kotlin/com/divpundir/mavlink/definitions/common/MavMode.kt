package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.Deprecated
import kotlin.UInt

/**
 * Predefined OR-combined MAV_MODE_FLAG values. These can simplify using the flags when setting
 * modes. Note that manual input is enabled in all modes as a safety override.
 */
@Deprecated(message =
    "Using MAV_MODE to set modes is less predictable than using standard modes (MAV_STANDARD_MODE) or custom modes (MAV_MODE_FLAG_CUSTOM_MODE_ENABLED).")
@GeneratedMavEnum
public enum class MavMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for
   * developers only (MAV_MODE_FLAG_SAFETY_ARMED, MAV_MODE_FLAG_MANUAL_INPUT_ENABLED,
   * MAV_MODE_FLAG_TEST_ENABLED)
   */
  @GeneratedMavEnumEntry
  TEST_ARMED(194u),
  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for
   * developers only. (MAV_MODE_FLAG_MANUAL_INPUT_ENABLED, MAV_MODE_FLAG_TEST_ENABLED).
   */
  @GeneratedMavEnumEntry
  TEST_DISARMED(66u),
  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is
   * decided onboard and not pre-programmed by waypoints). (MAV_MODE_FLAG_SAFETY_ARMED,
   * MAV_MODE_FLAG_MANUAL_INPUT_ENABLED, MAV_MODE_FLAG_STABILIZE_ENABLED,
   * MAV_MODE_FLAG_GUIDED_ENABLED,MAV_MODE_FLAG_AUTO_ENABLED).
   */
  @GeneratedMavEnumEntry
  AUTO_ARMED(220u),
  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is
   * decided onboard and not pre-programmed by waypoints). (MAV_MODE_FLAG_SAFETY_ARMED,
   * MAV_MODE_FLAG_STABILIZE_ENABLED, MAV_MODE_FLAG_GUIDED_ENABLED, MAV_MODE_FLAG_AUTO_ENABLED).
   */
  @GeneratedMavEnumEntry
  AUTO_DISARMED(92u),
  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   * (MAV_MODE_FLAG_SAFETY_ARMED, MAV_MODE_FLAG_MANUAL_INPUT_ENABLED, MAV_MODE_FLAG_STABILIZE_ENABLED,
   * MAV_MODE_FLAG_GUIDED_ENABLED)
   */
  @GeneratedMavEnumEntry
  GUIDED_ARMED(216u),
  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   * (MAV_MODE_FLAG_SAFETY_ARMED, MAV_MODE_FLAG_STABILIZE_ENABLED, MAV_MODE_FLAG_GUIDED_ENABLED)
   */
  @GeneratedMavEnumEntry
  GUIDED_DISARMED(88u),
  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   * (MAV_MODE_FLAG_SAFETY_ARMED, MAV_MODE_FLAG_MANUAL_INPUT_ENABLED)
   */
  @GeneratedMavEnumEntry
  MANUAL_ARMED(192u),
  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   * (MAV_MODE_FLAG_MANUAL_INPUT_ENABLED)
   */
  @GeneratedMavEnumEntry
  MANUAL_DISARMED(64u),
  /**
   * System is allowed to be active, under assisted RC control (MAV_MODE_FLAG_SAFETY_ARMED,
   * MAV_MODE_FLAG_MANUAL_INPUT_ENABLED, MAV_MODE_FLAG_STABILIZE_ENABLED)
   */
  @GeneratedMavEnumEntry
  STABILIZE_ARMED(208u),
  /**
   * System is allowed to be active, under assisted RC control (MAV_MODE_FLAG_SAFETY_ARMED,
   * MAV_MODE_FLAG_STABILIZE_ENABLED)
   */
  @GeneratedMavEnumEntry
  STABILIZE_DISARMED(80u),
  /**
   * System is not ready to fly, booting, calibrating, etc. No flag is set.
   */
  @GeneratedMavEnumEntry
  PREFLIGHT(0u),
  ;

  public companion object : MavEnum.MavCompanion<MavMode> {
    override fun getEntryFromValueOrNull(v: UInt): MavMode? = when (v) {
      194u -> TEST_ARMED
      66u -> TEST_DISARMED
      220u -> AUTO_ARMED
      92u -> AUTO_DISARMED
      216u -> GUIDED_ARMED
      88u -> GUIDED_DISARMED
      192u -> MANUAL_ARMED
      64u -> MANUAL_DISARMED
      208u -> STABILIZE_ARMED
      80u -> STABILIZE_DISARMED
      0u -> PREFLIGHT
      else -> null
    }
  }
}

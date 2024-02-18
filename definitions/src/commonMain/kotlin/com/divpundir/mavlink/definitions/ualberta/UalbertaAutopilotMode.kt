package com.divpundir.mavlink.definitions.ualberta

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Available autopilot modes for ualberta uav
 *
 */
@GeneratedMavEnum
public enum class UalbertaAutopilotMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Raw input pulse widts sent to output
   */
  @GeneratedMavEnumEntry
  MODE_MANUAL_DIRECT(1u),
  /**
   * Inputs are normalized using calibration, the converted back to raw pulse widths for output
   */
  @GeneratedMavEnumEntry
  MODE_MANUAL_SCALED(2u),
  @GeneratedMavEnumEntry
  MODE_AUTO_PID_ATT(3u),
  @GeneratedMavEnumEntry
  MODE_AUTO_PID_VEL(4u),
  @GeneratedMavEnumEntry
  MODE_AUTO_PID_POS(5u),
  ;

  public companion object : MavEnum.MavCompanion<UalbertaAutopilotMode> {
    override fun getEntryFromValueOrNull(v: UInt): UalbertaAutopilotMode? = when (v) {
      1u -> MODE_MANUAL_DIRECT
      2u -> MODE_MANUAL_SCALED
      3u -> MODE_AUTO_PID_ATT
      4u -> MODE_AUTO_PID_VEL
      5u -> MODE_AUTO_PID_POS
      else -> null
    }
  }
}

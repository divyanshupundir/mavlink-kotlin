package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Specifies the conditions under which the MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN command should be
 * accepted.
 */
@GeneratedMavEnum
public enum class RebootShutdownConditions(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Reboot/Shutdown only if allowed by safety checks, such as being landed.
   */
  @GeneratedMavEnumEntry
  SAFETY_INTERLOCKED(0u),
  /**
   * Force reboot/shutdown of the autopilot/component regardless of system state.
   */
  @GeneratedMavEnumEntry
  FORCE(20_190_226u),
  ;

  public companion object : MavEnum.MavCompanion<RebootShutdownConditions> {
    override fun getEntryFromValueOrNull(v: UInt): RebootShutdownConditions? = when (v) {
      0u -> SAFETY_INTERLOCKED
      20190226u -> FORCE
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Reboot/shutdown action for selected component in MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN.
 */
@GeneratedMavEnum
public enum class RebootShutdownAction(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Do nothing.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Reboot component.
   */
  @GeneratedMavEnumEntry
  REBOOT(1u),
  /**
   * Shutdown component.
   */
  @GeneratedMavEnumEntry
  SHUTDOWN(2u),
  /**
   * Reboot component and keep it in the bootloader until upgraded.
   */
  @GeneratedMavEnumEntry
  REBOOT_TO_BOOTLOADER(3u),
  /**
   * Power on component. Do nothing if component is already powered (ACK command with
   * MAV_RESULT_ACCEPTED).
   */
  @GeneratedMavEnumEntry
  POWER_ON(4u),
  ;

  public companion object : MavEnum.MavCompanion<RebootShutdownAction> {
    override fun getEntryFromValueOrNull(v: UInt): RebootShutdownAction? = when (v) {
      0u -> NONE
      1u -> REBOOT
      2u -> SHUTDOWN
      3u -> REBOOT_TO_BOOTLOADER
      4u -> POWER_ON
      else -> null
    }
  }
}

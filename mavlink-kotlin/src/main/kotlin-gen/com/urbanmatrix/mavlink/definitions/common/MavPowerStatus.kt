package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Power supply status flags (bitmask)
 */
public enum class MavPowerStatus(
  public override val `value`: Long,
) : MavEnum {
  /**
   * main brick power supply valid
   */
  MAV_POWER_STATUS_BRICK_VALID(1L),
  /**
   * main servo power supply valid for FMU
   */
  MAV_POWER_STATUS_SERVO_VALID(2L),
  /**
   * USB power is connected
   */
  MAV_POWER_STATUS_USB_CONNECTED(4L),
  /**
   * peripheral supply is in over-current state
   */
  MAV_POWER_STATUS_PERIPH_OVERCURRENT(8L),
  /**
   * hi-power peripheral supply is in over-current state
   */
  MAV_POWER_STATUS_PERIPH_HIPOWER_OVERCURRENT(16L),
  /**
   * Power status has changed since boot
   */
  MAV_POWER_STATUS_CHANGED(32L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavPowerStatus? = when (v) {
      1L -> MAV_POWER_STATUS_BRICK_VALID
      2L -> MAV_POWER_STATUS_SERVO_VALID
      4L -> MAV_POWER_STATUS_USB_CONNECTED
      8L -> MAV_POWER_STATUS_PERIPH_OVERCURRENT
      16L -> MAV_POWER_STATUS_PERIPH_HIPOWER_OVERCURRENT
      32L -> MAV_POWER_STATUS_CHANGED
      else -> null
    }
  }
}

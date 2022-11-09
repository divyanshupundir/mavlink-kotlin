package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Power supply status flags (bitmask)
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavPowerStatus(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * main brick power supply valid
   */
  @GeneratedMavEnumEntry
  MAV_POWER_STATUS_BRICK_VALID(1L),
  /**
   * main servo power supply valid for FMU
   */
  @GeneratedMavEnumEntry
  MAV_POWER_STATUS_SERVO_VALID(2L),
  /**
   * USB power is connected
   */
  @GeneratedMavEnumEntry
  MAV_POWER_STATUS_USB_CONNECTED(4L),
  /**
   * peripheral supply is in over-current state
   */
  @GeneratedMavEnumEntry
  MAV_POWER_STATUS_PERIPH_OVERCURRENT(8L),
  /**
   * hi-power peripheral supply is in over-current state
   */
  @GeneratedMavEnumEntry
  MAV_POWER_STATUS_PERIPH_HIPOWER_OVERCURRENT(16L),
  /**
   * Power status has changed since boot
   */
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<MavPowerStatus> = buildList {
      if (v and 1L == 1L) add(MAV_POWER_STATUS_BRICK_VALID)
      if (v and 2L == 2L) add(MAV_POWER_STATUS_SERVO_VALID)
      if (v and 4L == 4L) add(MAV_POWER_STATUS_USB_CONNECTED)
      if (v and 8L == 8L) add(MAV_POWER_STATUS_PERIPH_OVERCURRENT)
      if (v and 16L == 16L) add(MAV_POWER_STATUS_PERIPH_HIPOWER_OVERCURRENT)
      if (v and 32L == 32L) add(MAV_POWER_STATUS_CHANGED)
    }
  }
}

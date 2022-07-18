package com.urbanmatrix.mavlink.definitions.minimal

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Uninitialized system, state is unknown.
   */
  MAV_STATE_UNINIT(0L),
  /**
   * System is booting up.
   */
  MAV_STATE_BOOT(1L),
  /**
   * System is calibrating and not flight-ready.
   */
  MAV_STATE_CALIBRATING(2L),
  /**
   * System is grounded and on standby. It can be launched any time.
   */
  MAV_STATE_STANDBY(3L),
  /**
   * System is active and might be already airborne. Motors are engaged.
   */
  MAV_STATE_ACTIVE(4L),
  /**
   * System is in a non-normal flight mode. It can however still navigate.
   */
  MAV_STATE_CRITICAL(5L),
  /**
   * System is in a non-normal flight mode. It lost control over parts or over the whole airframe.
   * It is in mayday and going down.
   */
  MAV_STATE_EMERGENCY(6L),
  /**
   * System just initialized its power-down sequence, will shut down now.
   */
  MAV_STATE_POWEROFF(7L),
  /**
   * System is terminating itself.
   */
  MAV_STATE_FLIGHT_TERMINATION(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavState? = when (v) {
      0L -> MAV_STATE_UNINIT
      1L -> MAV_STATE_BOOT
      2L -> MAV_STATE_CALIBRATING
      3L -> MAV_STATE_STANDBY
      4L -> MAV_STATE_ACTIVE
      5L -> MAV_STATE_CRITICAL
      6L -> MAV_STATE_EMERGENCY
      7L -> MAV_STATE_POWEROFF
      8L -> MAV_STATE_FLIGHT_TERMINATION
      else -> null
    }
  }
}

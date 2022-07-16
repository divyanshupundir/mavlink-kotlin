package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message in the extended
 * fields.
 */
public enum class MavSysStatusSensorExtended(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 0x01 Recovery system (parachute, balloon, retracts etc)
   */
  MAV_SYS_STATUS_RECOVERY_SYSTEM(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavSysStatusSensorExtended? = when (v) {
      1L -> MAV_SYS_STATUS_RECOVERY_SYSTEM
      else -> null
    }
  }
}

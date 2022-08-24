package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message in the extended
 * fields.
 */
@GeneratedMavEnum
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

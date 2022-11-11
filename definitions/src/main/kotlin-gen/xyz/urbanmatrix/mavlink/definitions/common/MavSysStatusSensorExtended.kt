package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message in the extended
 * fields.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavSysStatusSensorExtended(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * 0x01 Recovery system (parachute, balloon, retracts etc)
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_RECOVERY_SYSTEM(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavSysStatusSensorExtended? = when (v) {
      1L -> MAV_SYS_STATUS_RECOVERY_SYSTEM
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<MavSysStatusSensorExtended> = buildList {
      if (v and 1L == 1L) add(MAV_SYS_STATUS_RECOVERY_SYSTEM)
    }
  }
}

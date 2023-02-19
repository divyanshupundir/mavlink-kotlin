package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message in the extended
 * fields.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavSysStatusSensorExtended(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * 0x01 Recovery system (parachute, balloon, retracts etc)
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_RECOVERY_SYSTEM(1u),
  ;

  public companion object : MavEnum.Companion<MavSysStatusSensorExtended>,
      MavBitmask.Companion<MavSysStatusSensorExtended> {
    public override fun getEntryFromValueOrNull(v: UInt): MavSysStatusSensorExtended? = when (v) {
      1u -> MAV_SYS_STATUS_RECOVERY_SYSTEM
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<MavSysStatusSensorExtended> = buildList {
      if (v and 1u == 1u) add(MAV_SYS_STATUS_RECOVERY_SYSTEM)
    }
  }
}

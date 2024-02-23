package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message in the extended
 * fields.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavSysStatusSensorExtended(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * 0x01 Recovery system (parachute, balloon, retracts etc)
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_RECOVERY_SYSTEM(1u),
  ;

  public companion object : MavBitmask.MavCompanion<MavSysStatusSensorExtended> {
    override fun getEntryFromValueOrNull(v: UInt): MavSysStatusSensorExtended? = when (v) {
      1u -> MAV_SYS_STATUS_RECOVERY_SYSTEM
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavSysStatusSensorExtended> = buildList {
      if (v and 1u == 1u) add(MAV_SYS_STATUS_RECOVERY_SYSTEM)
    }
  }
}

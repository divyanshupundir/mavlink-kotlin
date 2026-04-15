package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message in the extended fields.
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
  /**
   * 0x02 Leak detection
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_LEAK(2u),
  ;

  public companion object : MavBitmask.MavCompanion<MavSysStatusSensorExtended> {
    override fun getEntryFromValueOrNull(v: UInt): MavSysStatusSensorExtended? = when (v) {
      1u -> MAV_SYS_STATUS_RECOVERY_SYSTEM
      2u -> MAV_SYS_STATUS_SENSOR_LEAK
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavSysStatusSensorExtended> = buildList {
      if (v and 1u == 1u) add(MAV_SYS_STATUS_RECOVERY_SYSTEM)
      if (v and 2u == 2u) add(MAV_SYS_STATUS_SENSOR_LEAK)
    }
  }
}

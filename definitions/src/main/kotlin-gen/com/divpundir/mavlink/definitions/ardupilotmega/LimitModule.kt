package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

@GeneratedMavEnum(bitmask = true)
public enum class LimitModule(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * Pre-initialization.
   */
  @GeneratedMavEnumEntry
  LIMIT_GPSLOCK(1u),
  /**
   * Disabled.
   */
  @GeneratedMavEnumEntry
  LIMIT_GEOFENCE(2u),
  /**
   * Checking limits.
   */
  @GeneratedMavEnumEntry
  LIMIT_ALTITUDE(4u),
  ;

  public companion object : MavBitmask.MavCompanion<LimitModule> {
    public override fun getEntryFromValueOrNull(v: UInt): LimitModule? = when (v) {
      1u -> LIMIT_GPSLOCK
      2u -> LIMIT_GEOFENCE
      4u -> LIMIT_ALTITUDE
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<LimitModule> = buildList {
      if (v and 1u == 1u) add(LIMIT_GPSLOCK)
      if (v and 2u == 2u) add(LIMIT_GEOFENCE)
      if (v and 4u == 4u) add(LIMIT_ALTITUDE)
    }
  }
}

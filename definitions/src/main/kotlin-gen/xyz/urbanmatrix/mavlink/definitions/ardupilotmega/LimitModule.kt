package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

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

  public companion object : MavEnum.Companion<LimitModule>, MavBitmask.Companion<LimitModule> {
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

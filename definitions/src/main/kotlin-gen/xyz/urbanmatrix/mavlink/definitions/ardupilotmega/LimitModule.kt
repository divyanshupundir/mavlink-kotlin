package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

@GeneratedMavEnum(bitmask = true)
public enum class LimitModule(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Pre-initialization.
   */
  @GeneratedMavEnumEntry
  LIMIT_GPSLOCK(1L),
  /**
   * Disabled.
   */
  @GeneratedMavEnumEntry
  LIMIT_GEOFENCE(2L),
  /**
   * Checking limits.
   */
  @GeneratedMavEnumEntry
  LIMIT_ALTITUDE(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): LimitModule? = when (v) {
      1L -> LIMIT_GPSLOCK
      2L -> LIMIT_GEOFENCE
      4L -> LIMIT_ALTITUDE
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<LimitModule> = buildList {
      if (v and 1L == 1L) add(LIMIT_GPSLOCK)
      if (v and 2L == 2L) add(LIMIT_GEOFENCE)
      if (v and 4L == 4L) add(LIMIT_ALTITUDE)
    }
  }
}

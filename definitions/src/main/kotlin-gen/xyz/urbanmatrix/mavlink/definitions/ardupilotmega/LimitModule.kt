package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class LimitModule(
  public override val `value`: Long,
) : MavEnum {
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
  }
}

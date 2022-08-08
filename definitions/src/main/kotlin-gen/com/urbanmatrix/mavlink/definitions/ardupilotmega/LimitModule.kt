package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class LimitModule(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Pre-initialization.
   */
  LIMIT_GPSLOCK(1L),
  /**
   * Disabled.
   */
  LIMIT_GEOFENCE(2L),
  /**
   * Checking limits.
   */
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

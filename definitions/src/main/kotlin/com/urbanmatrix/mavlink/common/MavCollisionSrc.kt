package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Source of information about this collision.
 */
public enum class MavCollisionSrc(
  public override val `value`: Long,
) : MavEnum {
  /**
   * ID field references ADSB_VEHICLE packets
   */
  MAV_COLLISION_SRC_ADSB(0L),
  /**
   * ID field references MAVLink SRC ID
   */
  MAV_COLLISION_SRC_MAVLINK_GPS_GLOBAL_INT(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCollisionSrc? = when (v) {
      0L -> MAV_COLLISION_SRC_ADSB
      1L -> MAV_COLLISION_SRC_MAVLINK_GPS_GLOBAL_INT
      else -> null
    }
  }
}

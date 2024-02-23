package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Source of information about this collision.
 */
@GeneratedMavEnum
public enum class MavCollisionSrc(
  override val `value`: UInt,
) : MavEnum {
  /**
   * ID field references ADSB_VEHICLE packets
   */
  @GeneratedMavEnumEntry
  ADSB(0u),
  /**
   * ID field references MAVLink SRC ID
   */
  @GeneratedMavEnumEntry
  MAVLINK_GPS_GLOBAL_INT(1u),
  ;

  public companion object : MavEnum.MavCompanion<MavCollisionSrc> {
    override fun getEntryFromValueOrNull(v: UInt): MavCollisionSrc? = when (v) {
      0u -> ADSB
      1u -> MAVLINK_GPS_GLOBAL_INT
      else -> null
    }
  }
}

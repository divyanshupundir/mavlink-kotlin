package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * The ROI (region of interest) for the vehicle. This can be
 *                 be used by the vehicle for camera/vehicle attitude alignment (see
 *                 MAV_CMD_NAV_ROI).
 */
@GeneratedMavEnum
public enum class MavRoi(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No region of interest.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Point toward next waypoint, with optional pitch/roll/yaw offset.
   */
  @GeneratedMavEnumEntry
  WPNEXT(1u),
  /**
   * Point toward given waypoint.
   */
  @GeneratedMavEnumEntry
  WPINDEX(2u),
  /**
   * Point toward fixed location.
   */
  @GeneratedMavEnumEntry
  LOCATION(3u),
  /**
   * Point toward of given id.
   */
  @GeneratedMavEnumEntry
  TARGET(4u),
  ;

  public companion object : MavEnum.MavCompanion<MavRoi> {
    override fun getEntryFromValueOrNull(v: UInt): MavRoi? = when (v) {
      0u -> NONE
      1u -> WPNEXT
      2u -> WPINDEX
      3u -> LOCATION
      4u -> TARGET
      else -> null
    }
  }
}

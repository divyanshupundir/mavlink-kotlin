package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.Deprecated
import kotlin.UInt

/**
 * The ROI (region of interest) for the vehicle. This can be
 *                 be used by the vehicle for camera/vehicle attitude alignment (see
 *                 MAV_CMD_NAV_ROI).
 */
@Deprecated(message = "")
@GeneratedMavEnum
public enum class MavRoi(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Point toward of given id.
   */
  @GeneratedMavEnumEntry
  TARGET(4u),
  /**
   * Point toward fixed location.
   */
  @GeneratedMavEnumEntry
  LOCATION(3u),
  /**
   * Point toward given waypoint.
   */
  @GeneratedMavEnumEntry
  WPINDEX(2u),
  /**
   * Point toward next waypoint, with optional pitch/roll/yaw offset.
   */
  @GeneratedMavEnumEntry
  WPNEXT(1u),
  /**
   * No region of interest.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  ;

  public companion object : MavEnum.MavCompanion<MavRoi> {
    override fun getEntryFromValueOrNull(v: UInt): MavRoi? = when (v) {
      4u -> TARGET
      3u -> LOCATION
      2u -> WPINDEX
      1u -> WPNEXT
      0u -> NONE
      else -> null
    }
  }
}

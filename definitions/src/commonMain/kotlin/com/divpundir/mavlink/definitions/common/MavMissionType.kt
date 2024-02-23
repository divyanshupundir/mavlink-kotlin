package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Type of mission items being requested/sent in mission protocol.
 */
@GeneratedMavEnum
public enum class MavMissionType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Items are mission commands for main mission.
   */
  @GeneratedMavEnumEntry
  MISSION(0u),
  /**
   * Specifies GeoFence area(s). Items are MAV_CMD_NAV_FENCE_ GeoFence items.
   */
  @GeneratedMavEnumEntry
  FENCE(1u),
  /**
   * Specifies the rally points for the vehicle. Rally points are alternative RTL points. Items are
   * MAV_CMD_NAV_RALLY_POINT rally point items.
   */
  @GeneratedMavEnumEntry
  RALLY(2u),
  /**
   * Only used in MISSION_CLEAR_ALL to clear all mission types.
   */
  @GeneratedMavEnumEntry
  ALL(255u),
  ;

  public companion object : MavEnum.MavCompanion<MavMissionType> {
    override fun getEntryFromValueOrNull(v: UInt): MavMissionType? = when (v) {
      0u -> MISSION
      1u -> FENCE
      2u -> RALLY
      255u -> ALL
      else -> null
    }
  }
}

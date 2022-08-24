package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Type of mission items being requested/sent in mission protocol.
 */
@GeneratedMavEnum
public enum class MavMissionType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Items are mission commands for main mission.
   */
  MAV_MISSION_TYPE_MISSION(0L),
  /**
   * Specifies GeoFence area(s). Items are MAV_CMD_NAV_FENCE_ GeoFence items.
   */
  MAV_MISSION_TYPE_FENCE(1L),
  /**
   * Specifies the rally points for the vehicle. Rally points are alternative RTL points. Items are
   * MAV_CMD_NAV_RALLY_POINT rally point items.
   */
  MAV_MISSION_TYPE_RALLY(2L),
  /**
   * Only used in MISSION_CLEAR_ALL to clear all mission types.
   */
  MAV_MISSION_TYPE_ALL(255L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavMissionType? = when (v) {
      0L -> MAV_MISSION_TYPE_MISSION
      1L -> MAV_MISSION_TYPE_FENCE
      2L -> MAV_MISSION_TYPE_RALLY
      255L -> MAV_MISSION_TYPE_ALL
      else -> null
    }
  }
}

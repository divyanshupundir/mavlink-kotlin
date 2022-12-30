package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
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
  @GeneratedMavEnumEntry
  MISSION(0L),
  /**
   * Specifies GeoFence area(s). Items are MAV_CMD_NAV_FENCE_ GeoFence items.
   */
  @GeneratedMavEnumEntry
  FENCE(1L),
  /**
   * Specifies the rally points for the vehicle. Rally points are alternative RTL points. Items are
   * MAV_CMD_NAV_RALLY_POINT rally point items.
   */
  @GeneratedMavEnumEntry
  RALLY(2L),
  /**
   * Only used in MISSION_CLEAR_ALL to clear all mission types.
   */
  @GeneratedMavEnumEntry
  ALL(255L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavMissionType? = when (v) {
      0L -> MISSION
      1L -> FENCE
      2L -> RALLY
      255L -> ALL
      else -> null
    }
  }
}

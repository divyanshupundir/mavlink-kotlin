package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of landed detector states
 */
@GeneratedMavEnum
public enum class MavLandedState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * MAV landed state is unknown
   */
  @GeneratedMavEnumEntry
  MAV_LANDED_STATE_UNDEFINED(0L),
  /**
   * MAV is landed (on ground)
   */
  @GeneratedMavEnumEntry
  MAV_LANDED_STATE_ON_GROUND(1L),
  /**
   * MAV is in air
   */
  @GeneratedMavEnumEntry
  MAV_LANDED_STATE_IN_AIR(2L),
  /**
   * MAV currently taking off
   */
  @GeneratedMavEnumEntry
  MAV_LANDED_STATE_TAKEOFF(3L),
  /**
   * MAV currently landing
   */
  @GeneratedMavEnumEntry
  MAV_LANDED_STATE_LANDING(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavLandedState? = when (v) {
      0L -> MAV_LANDED_STATE_UNDEFINED
      1L -> MAV_LANDED_STATE_ON_GROUND
      2L -> MAV_LANDED_STATE_IN_AIR
      3L -> MAV_LANDED_STATE_TAKEOFF
      4L -> MAV_LANDED_STATE_LANDING
      else -> null
    }
  }
}

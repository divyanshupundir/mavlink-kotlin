package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Enumeration of landed detector states
 */
public enum class MavLandedState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * MAV landed state is unknown
   */
  MAV_LANDED_STATE_UNDEFINED(0L),
  /**
   * MAV is landed (on ground)
   */
  MAV_LANDED_STATE_ON_GROUND(1L),
  /**
   * MAV is in air
   */
  MAV_LANDED_STATE_IN_AIR(2L),
  /**
   * MAV currently taking off
   */
  MAV_LANDED_STATE_TAKEOFF(3L),
  /**
   * MAV currently landing
   */
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

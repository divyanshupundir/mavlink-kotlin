package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Enumeration of VTOL states
 */
public enum class MavVtolState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * MAV is not configured as VTOL
   */
  MAV_VTOL_STATE_UNDEFINED(0L),
  /**
   * VTOL is in transition from multicopter to fixed-wing
   */
  MAV_VTOL_STATE_TRANSITION_TO_FW(1L),
  /**
   * VTOL is in transition from fixed-wing to multicopter
   */
  MAV_VTOL_STATE_TRANSITION_TO_MC(2L),
  /**
   * VTOL is in multicopter state
   */
  MAV_VTOL_STATE_MC(3L),
  /**
   * VTOL is in fixed-wing state
   */
  MAV_VTOL_STATE_FW(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavVtolState? = when (v) {
      0L -> MAV_VTOL_STATE_UNDEFINED
      1L -> MAV_VTOL_STATE_TRANSITION_TO_FW
      2L -> MAV_VTOL_STATE_TRANSITION_TO_MC
      3L -> MAV_VTOL_STATE_MC
      4L -> MAV_VTOL_STATE_FW
      else -> null
    }
  }
}

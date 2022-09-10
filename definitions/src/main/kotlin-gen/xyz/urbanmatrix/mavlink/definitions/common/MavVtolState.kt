package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of VTOL states
 */
@GeneratedMavEnum
public enum class MavVtolState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * MAV is not configured as VTOL
   */
  @GeneratedMavEnumEntry
  MAV_VTOL_STATE_UNDEFINED(0L),
  /**
   * VTOL is in transition from multicopter to fixed-wing
   */
  @GeneratedMavEnumEntry
  MAV_VTOL_STATE_TRANSITION_TO_FW(1L),
  /**
   * VTOL is in transition from fixed-wing to multicopter
   */
  @GeneratedMavEnumEntry
  MAV_VTOL_STATE_TRANSITION_TO_MC(2L),
  /**
   * VTOL is in multicopter state
   */
  @GeneratedMavEnumEntry
  MAV_VTOL_STATE_MC(3L),
  /**
   * VTOL is in fixed-wing state
   */
  @GeneratedMavEnumEntry
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

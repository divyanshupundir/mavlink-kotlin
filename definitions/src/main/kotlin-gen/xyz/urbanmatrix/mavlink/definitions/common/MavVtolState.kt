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
  UNDEFINED(0L),
  /**
   * VTOL is in transition from multicopter to fixed-wing
   */
  @GeneratedMavEnumEntry
  TRANSITION_TO_FW(1L),
  /**
   * VTOL is in transition from fixed-wing to multicopter
   */
  @GeneratedMavEnumEntry
  TRANSITION_TO_MC(2L),
  /**
   * VTOL is in multicopter state
   */
  @GeneratedMavEnumEntry
  MC(3L),
  /**
   * VTOL is in fixed-wing state
   */
  @GeneratedMavEnumEntry
  FW(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavVtolState? = when (v) {
      0L -> UNDEFINED
      1L -> TRANSITION_TO_FW
      2L -> TRANSITION_TO_MC
      3L -> MC
      4L -> FW
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of VTOL states
 */
@GeneratedMavEnum
public enum class MavVtolState(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * MAV is not configured as VTOL
   */
  @GeneratedMavEnumEntry
  UNDEFINED(0u),
  /**
   * VTOL is in transition from multicopter to fixed-wing
   */
  @GeneratedMavEnumEntry
  TRANSITION_TO_FW(1u),
  /**
   * VTOL is in transition from fixed-wing to multicopter
   */
  @GeneratedMavEnumEntry
  TRANSITION_TO_MC(2u),
  /**
   * VTOL is in multicopter state
   */
  @GeneratedMavEnumEntry
  MC(3u),
  /**
   * VTOL is in fixed-wing state
   */
  @GeneratedMavEnumEntry
  FW(4u),
  ;

  public companion object : MavEnum.Companion<MavVtolState> {
    public override fun getEntryFromValueOrNull(v: UInt): MavVtolState? = when (v) {
      0u -> UNDEFINED
      1u -> TRANSITION_TO_FW
      2u -> TRANSITION_TO_MC
      3u -> MC
      4u -> FW
      else -> null
    }
  }
}

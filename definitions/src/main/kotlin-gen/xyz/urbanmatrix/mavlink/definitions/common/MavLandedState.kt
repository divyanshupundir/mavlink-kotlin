package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of landed detector states
 */
@GeneratedMavEnum
public enum class MavLandedState(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * MAV landed state is unknown
   */
  @GeneratedMavEnumEntry
  UNDEFINED(0u),
  /**
   * MAV is landed (on ground)
   */
  @GeneratedMavEnumEntry
  ON_GROUND(1u),
  /**
   * MAV is in air
   */
  @GeneratedMavEnumEntry
  IN_AIR(2u),
  /**
   * MAV currently taking off
   */
  @GeneratedMavEnumEntry
  TAKEOFF(3u),
  /**
   * MAV currently landing
   */
  @GeneratedMavEnumEntry
  LANDING(4u),
  ;

  public companion object : MavEnum.Companion<MavLandedState> {
    public override fun getEntryFromValueOrNull(v: UInt): MavLandedState? = when (v) {
      0u -> UNDEFINED
      1u -> ON_GROUND
      2u -> IN_AIR
      3u -> TAKEOFF
      4u -> LANDING
      else -> null
    }
  }
}

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
  UNDEFINED(0L),
  /**
   * MAV is landed (on ground)
   */
  @GeneratedMavEnumEntry
  ON_GROUND(1L),
  /**
   * MAV is in air
   */
  @GeneratedMavEnumEntry
  IN_AIR(2L),
  /**
   * MAV currently taking off
   */
  @GeneratedMavEnumEntry
  TAKEOFF(3L),
  /**
   * MAV currently landing
   */
  @GeneratedMavEnumEntry
  LANDING(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavLandedState? = when (v) {
      0L -> UNDEFINED
      1L -> ON_GROUND
      2L -> IN_AIR
      3L -> TAKEOFF
      4L -> LANDING
      else -> null
    }
  }
}

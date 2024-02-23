package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Enumeration of landed detector states
 */
@GeneratedMavEnum
public enum class MavLandedState(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<MavLandedState> {
    override fun getEntryFromValueOrNull(v: UInt): MavLandedState? = when (v) {
      0u -> UNDEFINED
      1u -> ON_GROUND
      2u -> IN_AIR
      3u -> TAKEOFF
      4u -> LANDING
      else -> null
    }
  }
}

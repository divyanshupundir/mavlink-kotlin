package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Airborne status of UAS.
 */
@GeneratedMavEnum
public enum class UtmFlightState(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The flight state can't be determined.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(1u),
  /**
   * UAS on ground.
   */
  @GeneratedMavEnumEntry
  GROUND(2u),
  /**
   * UAS airborne.
   */
  @GeneratedMavEnumEntry
  AIRBORNE(3u),
  /**
   * UAS is in an emergency flight state.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(16u),
  /**
   * UAS has no active controls.
   */
  @GeneratedMavEnumEntry
  NOCTRL(32u),
  ;

  public companion object : MavEnum.MavCompanion<UtmFlightState> {
    override fun getEntryFromValueOrNull(v: UInt): UtmFlightState? = when (v) {
      1u -> UNKNOWN
      2u -> GROUND
      3u -> AIRBORNE
      16u -> EMERGENCY
      32u -> NOCTRL
      else -> null
    }
  }
}

package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Airborne status of UAS.
 */
@GeneratedMavEnum
public enum class UtmFlightState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The flight state can't be determined.
   */
  UTM_FLIGHT_STATE_UNKNOWN(1L),
  /**
   * UAS on ground.
   */
  UTM_FLIGHT_STATE_GROUND(2L),
  /**
   * UAS airborne.
   */
  UTM_FLIGHT_STATE_AIRBORNE(3L),
  /**
   * UAS is in an emergency flight state.
   */
  UTM_FLIGHT_STATE_EMERGENCY(16L),
  /**
   * UAS has no active controls.
   */
  UTM_FLIGHT_STATE_NOCTRL(32L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UtmFlightState? = when (v) {
      1L -> UTM_FLIGHT_STATE_UNKNOWN
      2L -> UTM_FLIGHT_STATE_GROUND
      3L -> UTM_FLIGHT_STATE_AIRBORNE
      16L -> UTM_FLIGHT_STATE_EMERGENCY
      32L -> UTM_FLIGHT_STATE_NOCTRL
      else -> null
    }
  }
}

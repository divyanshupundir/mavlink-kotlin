package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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
  @GeneratedMavEnumEntry
  UNKNOWN(1L),
  /**
   * UAS on ground.
   */
  @GeneratedMavEnumEntry
  GROUND(2L),
  /**
   * UAS airborne.
   */
  @GeneratedMavEnumEntry
  AIRBORNE(3L),
  /**
   * UAS is in an emergency flight state.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(16L),
  /**
   * UAS has no active controls.
   */
  @GeneratedMavEnumEntry
  NOCTRL(32L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UtmFlightState? = when (v) {
      1L -> UNKNOWN
      2L -> GROUND
      3L -> AIRBORNE
      16L -> EMERGENCY
      32L -> NOCTRL
      else -> null
    }
  }
}

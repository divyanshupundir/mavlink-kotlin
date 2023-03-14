package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Airborne status of UAS.
 */
@GeneratedMavEnum
public enum class UtmFlightState(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<UtmFlightState> {
    public override fun getEntryFromValueOrNull(v: UInt): UtmFlightState? = when (v) {
      1u -> UNKNOWN
      2u -> GROUND
      3u -> AIRBORNE
      16u -> EMERGENCY
      32u -> NOCTRL
      else -> null
    }
  }
}

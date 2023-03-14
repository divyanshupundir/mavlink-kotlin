package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidOperatorLocationType(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * The location/altitude of the operator is the same as the take-off location.
   */
  @GeneratedMavEnumEntry
  TAKEOFF(0u),
  /**
   * The location/altitude of the operator is dynamic. E.g. based on live GNSS data.
   */
  @GeneratedMavEnumEntry
  LIVE_GNSS(1u),
  /**
   * The location/altitude of the operator are fixed values.
   */
  @GeneratedMavEnumEntry
  FIXED(2u),
  ;

  public companion object : MavEnum.Companion<MavOdidOperatorLocationType> {
    public override fun getEntryFromValueOrNull(v: UInt): MavOdidOperatorLocationType? = when (v) {
      0u -> TAKEOFF
      1u -> LIVE_GNSS
      2u -> FIXED
      else -> null
    }
  }
}

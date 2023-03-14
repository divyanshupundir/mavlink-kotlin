package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidHeightRef(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * The height field is relative to the take-off location.
   */
  @GeneratedMavEnumEntry
  OVER_TAKEOFF(0u),
  /**
   * The height field is relative to ground.
   */
  @GeneratedMavEnumEntry
  OVER_GROUND(1u),
  ;

  public companion object : MavEnum.Companion<MavOdidHeightRef> {
    public override fun getEntryFromValueOrNull(v: UInt): MavOdidHeightRef? = when (v) {
      0u -> OVER_TAKEOFF
      1u -> OVER_GROUND
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidHeightRef(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The height field is relative to the take-off location.
   */
  @GeneratedMavEnumEntry
  OVER_TAKEOFF(0L),
  /**
   * The height field is relative to ground.
   */
  @GeneratedMavEnumEntry
  OVER_GROUND(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidHeightRef? = when (v) {
      0L -> OVER_TAKEOFF
      1L -> OVER_GROUND
      else -> null
    }
  }
}

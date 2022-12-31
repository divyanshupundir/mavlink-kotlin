package xyz.urbanmatrix.mavlink.definitions.icarous

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class IcarousFmsState(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  IDLE(0L),
  @GeneratedMavEnumEntry
  TAKEOFF(1L),
  @GeneratedMavEnumEntry
  CLIMB(2L),
  @GeneratedMavEnumEntry
  CRUISE(3L),
  @GeneratedMavEnumEntry
  APPROACH(4L),
  @GeneratedMavEnumEntry
  LAND(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): IcarousFmsState? = when (v) {
      0L -> IDLE
      1L -> TAKEOFF
      2L -> CLIMB
      3L -> CRUISE
      4L -> APPROACH
      5L -> LAND
      else -> null
    }
  }
}

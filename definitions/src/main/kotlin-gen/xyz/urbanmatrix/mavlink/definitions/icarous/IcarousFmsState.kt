package xyz.urbanmatrix.mavlink.definitions.icarous

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class IcarousFmsState(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  IDLE(0u),
  @GeneratedMavEnumEntry
  TAKEOFF(1u),
  @GeneratedMavEnumEntry
  CLIMB(2u),
  @GeneratedMavEnumEntry
  CRUISE(3u),
  @GeneratedMavEnumEntry
  APPROACH(4u),
  @GeneratedMavEnumEntry
  LAND(5u),
  ;

  public companion object : MavEnum.Companion<IcarousFmsState> {
    public override fun getEntryFromValueOrNull(v: UInt): IcarousFmsState? = when (v) {
      0u -> IDLE
      1u -> TAKEOFF
      2u -> CLIMB
      3u -> CRUISE
      4u -> APPROACH
      5u -> LAND
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.icarous

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class IcarousFmsState(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<IcarousFmsState> {
    override fun getEntryFromValueOrNull(v: UInt): IcarousFmsState? = when (v) {
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

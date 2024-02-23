package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidHeightRef(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<MavOdidHeightRef> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidHeightRef? = when (v) {
      0u -> OVER_TAKEOFF
      1u -> OVER_GROUND
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproProtuneColour(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Auto.
   */
  @GeneratedMavEnumEntry
  STANDARD(0u),
  /**
   * Neutral.
   */
  @GeneratedMavEnumEntry
  NEUTRAL(1u),
  ;

  public companion object : MavEnum.MavCompanion<GoproProtuneColour> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproProtuneColour? = when (v) {
      0u -> STANDARD
      1u -> NEUTRAL
      else -> null
    }
  }
}

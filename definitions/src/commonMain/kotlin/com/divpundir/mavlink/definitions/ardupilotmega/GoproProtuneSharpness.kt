package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproProtuneSharpness(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Low Sharpness.
   */
  @GeneratedMavEnumEntry
  LOW(0u),
  /**
   * Medium Sharpness.
   */
  @GeneratedMavEnumEntry
  MEDIUM(1u),
  /**
   * High Sharpness.
   */
  @GeneratedMavEnumEntry
  HIGH(2u),
  ;

  public companion object : MavEnum.MavCompanion<GoproProtuneSharpness> {
    override fun getEntryFromValueOrNull(v: UInt): GoproProtuneSharpness? = when (v) {
      0u -> LOW
      1u -> MEDIUM
      2u -> HIGH
      else -> null
    }
  }
}

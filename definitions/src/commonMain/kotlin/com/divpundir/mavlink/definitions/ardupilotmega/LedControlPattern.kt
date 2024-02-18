package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class LedControlPattern(
  override val `value`: UInt,
) : MavEnum {
  /**
   * LED patterns off (return control to regular vehicle control).
   */
  @GeneratedMavEnumEntry
  OFF(0u),
  /**
   * LEDs show pattern during firmware update.
   */
  @GeneratedMavEnumEntry
  FIRMWAREUPDATE(1u),
  /**
   * Custom Pattern using custom bytes fields.
   */
  @GeneratedMavEnumEntry
  CUSTOM(255u),
  ;

  public companion object : MavEnum.MavCompanion<LedControlPattern> {
    override fun getEntryFromValueOrNull(v: UInt): LedControlPattern? = when (v) {
      0u -> OFF
      1u -> FIRMWAREUPDATE
      255u -> CUSTOM
      else -> null
    }
  }
}

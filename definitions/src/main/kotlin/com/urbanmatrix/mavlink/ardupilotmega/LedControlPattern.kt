package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class LedControlPattern(
  public override val `value`: Long,
) : MavEnum {
  /**
   * LED patterns off (return control to regular vehicle control).
   */
  LED_CONTROL_PATTERN_OFF(0L),
  /**
   * LEDs show pattern during firmware update.
   */
  LED_CONTROL_PATTERN_FIRMWAREUPDATE(1L),
  /**
   * Custom Pattern using custom bytes fields.
   */
  LED_CONTROL_PATTERN_CUSTOM(255L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): LedControlPattern? = when (v) {
      0L -> LED_CONTROL_PATTERN_OFF
      1L -> LED_CONTROL_PATTERN_FIRMWAREUPDATE
      255L -> LED_CONTROL_PATTERN_CUSTOM
      else -> null
    }
  }
}

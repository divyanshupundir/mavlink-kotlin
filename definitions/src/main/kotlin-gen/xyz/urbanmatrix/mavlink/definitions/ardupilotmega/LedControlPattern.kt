package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class LedControlPattern(
  public override val `value`: Long,
) : MavEnum {
  /**
   * LED patterns off (return control to regular vehicle control).
   */
  @GeneratedMavEnumEntry
  OFF(0L),
  /**
   * LEDs show pattern during firmware update.
   */
  @GeneratedMavEnumEntry
  FIRMWAREUPDATE(1L),
  /**
   * Custom Pattern using custom bytes fields.
   */
  @GeneratedMavEnumEntry
  CUSTOM(255L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): LedControlPattern? = when (v) {
      0L -> OFF
      1L -> FIRMWAREUPDATE
      255L -> CUSTOM
      else -> null
    }
  }
}

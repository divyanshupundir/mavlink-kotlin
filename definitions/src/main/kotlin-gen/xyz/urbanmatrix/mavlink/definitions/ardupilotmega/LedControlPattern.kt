package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class LedControlPattern(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<LedControlPattern> {
    public override fun getEntryFromValueOrNull(v: UInt): LedControlPattern? = when (v) {
      0u -> OFF
      1u -> FIRMWAREUPDATE
      255u -> CUSTOM
      else -> null
    }
  }
}

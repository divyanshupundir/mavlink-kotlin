package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproProtuneSharpness(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<GoproProtuneSharpness> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproProtuneSharpness? = when (v) {
      0u -> LOW
      1u -> MEDIUM
      2u -> HIGH
      else -> null
    }
  }
}

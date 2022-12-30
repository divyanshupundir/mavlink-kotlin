package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproProtuneSharpness(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Low Sharpness.
   */
  @GeneratedMavEnumEntry
  LOW(0L),
  /**
   * Medium Sharpness.
   */
  @GeneratedMavEnumEntry
  MEDIUM(1L),
  /**
   * High Sharpness.
   */
  @GeneratedMavEnumEntry
  HIGH(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproProtuneSharpness? = when (v) {
      0L -> LOW
      1L -> MEDIUM
      2L -> HIGH
      else -> null
    }
  }
}

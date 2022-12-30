package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproProtuneColour(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Auto.
   */
  @GeneratedMavEnumEntry
  STANDARD(0L),
  /**
   * Neutral.
   */
  @GeneratedMavEnumEntry
  NEUTRAL(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproProtuneColour? = when (v) {
      0L -> STANDARD
      1L -> NEUTRAL
      else -> null
    }
  }
}

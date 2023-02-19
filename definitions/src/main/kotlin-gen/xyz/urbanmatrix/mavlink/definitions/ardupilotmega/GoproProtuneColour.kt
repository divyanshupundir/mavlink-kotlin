package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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

  public companion object : MavEnum.Companion<GoproProtuneColour> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproProtuneColour? = when (v) {
      0u -> STANDARD
      1u -> NEUTRAL
      else -> null
    }
  }
}

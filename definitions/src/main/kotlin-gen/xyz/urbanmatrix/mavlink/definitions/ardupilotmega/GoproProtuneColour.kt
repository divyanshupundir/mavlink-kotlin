package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproProtuneColour(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Auto.
   */
  GOPRO_PROTUNE_COLOUR_STANDARD(0L),
  /**
   * Neutral.
   */
  GOPRO_PROTUNE_COLOUR_NEUTRAL(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproProtuneColour? = when (v) {
      0L -> GOPRO_PROTUNE_COLOUR_STANDARD
      1L -> GOPRO_PROTUNE_COLOUR_NEUTRAL
      else -> null
    }
  }
}

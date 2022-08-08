package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

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

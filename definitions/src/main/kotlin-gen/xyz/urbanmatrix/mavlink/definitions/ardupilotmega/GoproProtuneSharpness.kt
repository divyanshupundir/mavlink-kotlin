package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproProtuneSharpness(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Low Sharpness.
   */
  GOPRO_PROTUNE_SHARPNESS_LOW(0L),
  /**
   * Medium Sharpness.
   */
  GOPRO_PROTUNE_SHARPNESS_MEDIUM(1L),
  /**
   * High Sharpness.
   */
  GOPRO_PROTUNE_SHARPNESS_HIGH(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproProtuneSharpness? = when (v) {
      0L -> GOPRO_PROTUNE_SHARPNESS_LOW
      1L -> GOPRO_PROTUNE_SHARPNESS_MEDIUM
      2L -> GOPRO_PROTUNE_SHARPNESS_HIGH
      else -> null
    }
  }
}

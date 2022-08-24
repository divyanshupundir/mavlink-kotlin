package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproModel(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Unknown gopro model.
   */
  GOPRO_MODEL_UNKNOWN(0L),
  /**
   * Hero 3+ Silver (HeroBus not supported by GoPro).
   */
  GOPRO_MODEL_HERO_3_PLUS_SILVER(1L),
  /**
   * Hero 3+ Black.
   */
  GOPRO_MODEL_HERO_3_PLUS_BLACK(2L),
  /**
   * Hero 4 Silver.
   */
  GOPRO_MODEL_HERO_4_SILVER(3L),
  /**
   * Hero 4 Black.
   */
  GOPRO_MODEL_HERO_4_BLACK(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproModel? = when (v) {
      0L -> GOPRO_MODEL_UNKNOWN
      1L -> GOPRO_MODEL_HERO_3_PLUS_SILVER
      2L -> GOPRO_MODEL_HERO_3_PLUS_BLACK
      3L -> GOPRO_MODEL_HERO_4_SILVER
      4L -> GOPRO_MODEL_HERO_4_BLACK
      else -> null
    }
  }
}

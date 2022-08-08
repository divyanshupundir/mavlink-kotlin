package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class GoproProtuneGain(
  public override val `value`: Long,
) : MavEnum {
  /**
   * ISO 400.
   */
  GOPRO_PROTUNE_GAIN_400(0L),
  /**
   * ISO 800 (Only Hero 4).
   */
  GOPRO_PROTUNE_GAIN_800(1L),
  /**
   * ISO 1600.
   */
  GOPRO_PROTUNE_GAIN_1600(2L),
  /**
   * ISO 3200 (Only Hero 4).
   */
  GOPRO_PROTUNE_GAIN_3200(3L),
  /**
   * ISO 6400.
   */
  GOPRO_PROTUNE_GAIN_6400(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproProtuneGain? = when (v) {
      0L -> GOPRO_PROTUNE_GAIN_400
      1L -> GOPRO_PROTUNE_GAIN_800
      2L -> GOPRO_PROTUNE_GAIN_1600
      3L -> GOPRO_PROTUNE_GAIN_3200
      4L -> GOPRO_PROTUNE_GAIN_6400
      else -> null
    }
  }
}

package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GoproProtuneWhiteBalance(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Auto.
   */
  GOPRO_PROTUNE_WHITE_BALANCE_AUTO(0L),
  /**
   * 3000K.
   */
  GOPRO_PROTUNE_WHITE_BALANCE_3000K(1L),
  /**
   * 5500K.
   */
  GOPRO_PROTUNE_WHITE_BALANCE_5500K(2L),
  /**
   * 6500K.
   */
  GOPRO_PROTUNE_WHITE_BALANCE_6500K(3L),
  /**
   * Camera Raw.
   */
  GOPRO_PROTUNE_WHITE_BALANCE_RAW(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproProtuneWhiteBalance? = when (v) {
      0L -> GOPRO_PROTUNE_WHITE_BALANCE_AUTO
      1L -> GOPRO_PROTUNE_WHITE_BALANCE_3000K
      2L -> GOPRO_PROTUNE_WHITE_BALANCE_5500K
      3L -> GOPRO_PROTUNE_WHITE_BALANCE_6500K
      4L -> GOPRO_PROTUNE_WHITE_BALANCE_RAW
      else -> null
    }
  }
}

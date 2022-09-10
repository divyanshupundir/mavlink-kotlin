package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproProtuneWhiteBalance(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Auto.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_WHITE_BALANCE_AUTO(0L),
  /**
   * 3000K.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_WHITE_BALANCE_3000K(1L),
  /**
   * 5500K.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_WHITE_BALANCE_5500K(2L),
  /**
   * 6500K.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_WHITE_BALANCE_6500K(3L),
  /**
   * Camera Raw.
   */
  @GeneratedMavEnumEntry
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

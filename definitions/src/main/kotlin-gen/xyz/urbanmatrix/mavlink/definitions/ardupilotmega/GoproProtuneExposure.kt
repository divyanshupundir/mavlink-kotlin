package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproProtuneExposure(
  public override val `value`: Long,
) : MavEnum {
  /**
   * -5.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_5_0(0L),
  /**
   * -4.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_4_5(1L),
  /**
   * -4.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_4_0(2L),
  /**
   * -3.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_3_5(3L),
  /**
   * -3.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_3_0(4L),
  /**
   * -2.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_2_5(5L),
  /**
   * -2.0 EV.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_2_0(6L),
  /**
   * -1.5 EV.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_1_5(7L),
  /**
   * -1.0 EV.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_1_0(8L),
  /**
   * -0.5 EV.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_NEG_0_5(9L),
  /**
   * 0.0 EV.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_ZERO(10L),
  /**
   * +0.5 EV.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_0_5(11L),
  /**
   * +1.0 EV.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_1_0(12L),
  /**
   * +1.5 EV.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_1_5(13L),
  /**
   * +2.0 EV.
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_2_0(14L),
  /**
   * +2.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_2_5(15L),
  /**
   * +3.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_3_0(16L),
  /**
   * +3.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_3_5(17L),
  /**
   * +4.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_4_0(18L),
  /**
   * +4.5 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_4_5(19L),
  /**
   * +5.0 EV (Hero 3+ Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_PROTUNE_EXPOSURE_POS_5_0(20L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproProtuneExposure? = when (v) {
      0L -> GOPRO_PROTUNE_EXPOSURE_NEG_5_0
      1L -> GOPRO_PROTUNE_EXPOSURE_NEG_4_5
      2L -> GOPRO_PROTUNE_EXPOSURE_NEG_4_0
      3L -> GOPRO_PROTUNE_EXPOSURE_NEG_3_5
      4L -> GOPRO_PROTUNE_EXPOSURE_NEG_3_0
      5L -> GOPRO_PROTUNE_EXPOSURE_NEG_2_5
      6L -> GOPRO_PROTUNE_EXPOSURE_NEG_2_0
      7L -> GOPRO_PROTUNE_EXPOSURE_NEG_1_5
      8L -> GOPRO_PROTUNE_EXPOSURE_NEG_1_0
      9L -> GOPRO_PROTUNE_EXPOSURE_NEG_0_5
      10L -> GOPRO_PROTUNE_EXPOSURE_ZERO
      11L -> GOPRO_PROTUNE_EXPOSURE_POS_0_5
      12L -> GOPRO_PROTUNE_EXPOSURE_POS_1_0
      13L -> GOPRO_PROTUNE_EXPOSURE_POS_1_5
      14L -> GOPRO_PROTUNE_EXPOSURE_POS_2_0
      15L -> GOPRO_PROTUNE_EXPOSURE_POS_2_5
      16L -> GOPRO_PROTUNE_EXPOSURE_POS_3_0
      17L -> GOPRO_PROTUNE_EXPOSURE_POS_3_5
      18L -> GOPRO_PROTUNE_EXPOSURE_POS_4_0
      19L -> GOPRO_PROTUNE_EXPOSURE_POS_4_5
      20L -> GOPRO_PROTUNE_EXPOSURE_POS_5_0
      else -> null
    }
  }
}

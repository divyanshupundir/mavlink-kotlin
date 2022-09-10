package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproBurstRate(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 3 Shots / 1 Second.
   */
  @GeneratedMavEnumEntry
  GOPRO_BURST_RATE_3_IN_1_SECOND(0L),
  /**
   * 5 Shots / 1 Second.
   */
  @GeneratedMavEnumEntry
  GOPRO_BURST_RATE_5_IN_1_SECOND(1L),
  /**
   * 10 Shots / 1 Second.
   */
  @GeneratedMavEnumEntry
  GOPRO_BURST_RATE_10_IN_1_SECOND(2L),
  /**
   * 10 Shots / 2 Second.
   */
  @GeneratedMavEnumEntry
  GOPRO_BURST_RATE_10_IN_2_SECOND(3L),
  /**
   * 10 Shots / 3 Second (Hero 4 Only).
   */
  @GeneratedMavEnumEntry
  GOPRO_BURST_RATE_10_IN_3_SECOND(4L),
  /**
   * 30 Shots / 1 Second.
   */
  @GeneratedMavEnumEntry
  GOPRO_BURST_RATE_30_IN_1_SECOND(5L),
  /**
   * 30 Shots / 2 Second.
   */
  @GeneratedMavEnumEntry
  GOPRO_BURST_RATE_30_IN_2_SECOND(6L),
  /**
   * 30 Shots / 3 Second.
   */
  @GeneratedMavEnumEntry
  GOPRO_BURST_RATE_30_IN_3_SECOND(7L),
  /**
   * 30 Shots / 6 Second.
   */
  @GeneratedMavEnumEntry
  GOPRO_BURST_RATE_30_IN_6_SECOND(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproBurstRate? = when (v) {
      0L -> GOPRO_BURST_RATE_3_IN_1_SECOND
      1L -> GOPRO_BURST_RATE_5_IN_1_SECOND
      2L -> GOPRO_BURST_RATE_10_IN_1_SECOND
      3L -> GOPRO_BURST_RATE_10_IN_2_SECOND
      4L -> GOPRO_BURST_RATE_10_IN_3_SECOND
      5L -> GOPRO_BURST_RATE_30_IN_1_SECOND
      6L -> GOPRO_BURST_RATE_30_IN_2_SECOND
      7L -> GOPRO_BURST_RATE_30_IN_3_SECOND
      8L -> GOPRO_BURST_RATE_30_IN_6_SECOND
      else -> null
    }
  }
}

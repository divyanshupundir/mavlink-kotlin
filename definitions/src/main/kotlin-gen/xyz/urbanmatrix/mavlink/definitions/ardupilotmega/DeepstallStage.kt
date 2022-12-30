package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Deepstall flight stage.
 */
@GeneratedMavEnum
public enum class DeepstallStage(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Flying to the landing point.
   */
  @GeneratedMavEnumEntry
  FLY_TO_LANDING(0L),
  /**
   * Building an estimate of the wind.
   */
  @GeneratedMavEnumEntry
  ESTIMATE_WIND(1L),
  /**
   * Waiting to breakout of the loiter to fly the approach.
   */
  @GeneratedMavEnumEntry
  WAIT_FOR_BREAKOUT(2L),
  /**
   * Flying to the first arc point to turn around to the landing point.
   */
  @GeneratedMavEnumEntry
  FLY_TO_ARC(3L),
  /**
   * Turning around back to the deepstall landing point.
   */
  @GeneratedMavEnumEntry
  ARC(4L),
  /**
   * Approaching the landing point.
   */
  @GeneratedMavEnumEntry
  APPROACH(5L),
  /**
   * Stalling and steering towards the land point.
   */
  @GeneratedMavEnumEntry
  LAND(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): DeepstallStage? = when (v) {
      0L -> FLY_TO_LANDING
      1L -> ESTIMATE_WIND
      2L -> WAIT_FOR_BREAKOUT
      3L -> FLY_TO_ARC
      4L -> ARC
      5L -> APPROACH
      6L -> LAND
      else -> null
    }
  }
}

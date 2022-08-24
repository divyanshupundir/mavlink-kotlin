package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
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
  DEEPSTALL_STAGE_FLY_TO_LANDING(0L),
  /**
   * Building an estimate of the wind.
   */
  DEEPSTALL_STAGE_ESTIMATE_WIND(1L),
  /**
   * Waiting to breakout of the loiter to fly the approach.
   */
  DEEPSTALL_STAGE_WAIT_FOR_BREAKOUT(2L),
  /**
   * Flying to the first arc point to turn around to the landing point.
   */
  DEEPSTALL_STAGE_FLY_TO_ARC(3L),
  /**
   * Turning around back to the deepstall landing point.
   */
  DEEPSTALL_STAGE_ARC(4L),
  /**
   * Approaching the landing point.
   */
  DEEPSTALL_STAGE_APPROACH(5L),
  /**
   * Stalling and steering towards the land point.
   */
  DEEPSTALL_STAGE_LAND(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): DeepstallStage? = when (v) {
      0L -> DEEPSTALL_STAGE_FLY_TO_LANDING
      1L -> DEEPSTALL_STAGE_ESTIMATE_WIND
      2L -> DEEPSTALL_STAGE_WAIT_FOR_BREAKOUT
      3L -> DEEPSTALL_STAGE_FLY_TO_ARC
      4L -> DEEPSTALL_STAGE_ARC
      5L -> DEEPSTALL_STAGE_APPROACH
      6L -> DEEPSTALL_STAGE_LAND
      else -> null
    }
  }
}

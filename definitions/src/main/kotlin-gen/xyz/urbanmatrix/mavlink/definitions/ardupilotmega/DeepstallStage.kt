package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Deepstall flight stage.
 */
@GeneratedMavEnum
public enum class DeepstallStage(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Flying to the landing point.
   */
  @GeneratedMavEnumEntry
  FLY_TO_LANDING(0u),
  /**
   * Building an estimate of the wind.
   */
  @GeneratedMavEnumEntry
  ESTIMATE_WIND(1u),
  /**
   * Waiting to breakout of the loiter to fly the approach.
   */
  @GeneratedMavEnumEntry
  WAIT_FOR_BREAKOUT(2u),
  /**
   * Flying to the first arc point to turn around to the landing point.
   */
  @GeneratedMavEnumEntry
  FLY_TO_ARC(3u),
  /**
   * Turning around back to the deepstall landing point.
   */
  @GeneratedMavEnumEntry
  ARC(4u),
  /**
   * Approaching the landing point.
   */
  @GeneratedMavEnumEntry
  APPROACH(5u),
  /**
   * Stalling and steering towards the land point.
   */
  @GeneratedMavEnumEntry
  LAND(6u),
  ;

  public companion object : MavEnum.Companion<DeepstallStage> {
    public override fun getEntryFromValueOrNull(v: UInt): DeepstallStage? = when (v) {
      0u -> FLY_TO_LANDING
      1u -> ESTIMATE_WIND
      2u -> WAIT_FOR_BREAKOUT
      3u -> FLY_TO_ARC
      4u -> ARC
      5u -> APPROACH
      6u -> LAND
      else -> null
    }
  }
}

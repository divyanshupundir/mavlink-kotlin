package xyz.urbanmatrix.mavlink.definitions.avssuas

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class AvssHorseflyOperationMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * In manual control mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_MANUAL_CTRL(0L),
  /**
   * In auto takeoff mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_AUTO_TAKEOFF(1L),
  /**
   * In auto landing mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_AUTO_LANDING(2L),
  /**
   * In go home mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_NAVI_GO_HOME(3L),
  /**
   * In drop mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_DROP(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AvssHorseflyOperationMode? = when (v) {
      0L -> MODE_HORSEFLY_MANUAL_CTRL
      1L -> MODE_HORSEFLY_AUTO_TAKEOFF
      2L -> MODE_HORSEFLY_AUTO_LANDING
      3L -> MODE_HORSEFLY_NAVI_GO_HOME
      4L -> MODE_HORSEFLY_DROP
      else -> null
    }
  }
}

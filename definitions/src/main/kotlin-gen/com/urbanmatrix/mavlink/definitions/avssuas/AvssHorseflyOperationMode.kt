package com.urbanmatrix.mavlink.definitions.avssuas

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class AvssHorseflyOperationMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * In manual control mode
   */
  MODE_HORSEFLY_MANUAL_CTRL(0L),
  /**
   * In auto takeoff mode
   */
  MODE_HORSEFLY_AUTO_TAKEOFF(1L),
  /**
   * In auto landing mode
   */
  MODE_HORSEFLY_AUTO_LANDING(2L),
  /**
   * In go home mode
   */
  MODE_HORSEFLY_NAVI_GO_HOME(3L),
  /**
   * In drop mode
   */
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

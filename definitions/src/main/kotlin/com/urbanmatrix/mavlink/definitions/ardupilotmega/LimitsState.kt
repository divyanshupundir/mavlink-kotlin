package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class LimitsState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Pre-initialization.
   */
  LIMITS_INIT(0L),
  /**
   * Disabled.
   */
  LIMITS_DISABLED(1L),
  /**
   * Checking limits.
   */
  LIMITS_ENABLED(2L),
  /**
   * A limit has been breached.
   */
  LIMITS_TRIGGERED(3L),
  /**
   * Taking action e.g. Return/RTL.
   */
  LIMITS_RECOVERING(4L),
  /**
   * We're no longer in breach of a limit.
   */
  LIMITS_RECOVERED(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): LimitsState? = when (v) {
      0L -> LIMITS_INIT
      1L -> LIMITS_DISABLED
      2L -> LIMITS_ENABLED
      3L -> LIMITS_TRIGGERED
      4L -> LIMITS_RECOVERING
      5L -> LIMITS_RECOVERED
      else -> null
    }
  }
}

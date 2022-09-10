package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class LimitsState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Pre-initialization.
   */
  @GeneratedMavEnumEntry
  LIMITS_INIT(0L),
  /**
   * Disabled.
   */
  @GeneratedMavEnumEntry
  LIMITS_DISABLED(1L),
  /**
   * Checking limits.
   */
  @GeneratedMavEnumEntry
  LIMITS_ENABLED(2L),
  /**
   * A limit has been breached.
   */
  @GeneratedMavEnumEntry
  LIMITS_TRIGGERED(3L),
  /**
   * Taking action e.g. Return/RTL.
   */
  @GeneratedMavEnumEntry
  LIMITS_RECOVERING(4L),
  /**
   * We're no longer in breach of a limit.
   */
  @GeneratedMavEnumEntry
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

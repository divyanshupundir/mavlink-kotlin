package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * List of possible failure type to inject.
 */
@GeneratedMavEnum
public enum class FailureType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No failure injected, used to reset a previous failure.
   */
  FAILURE_TYPE_OK(0L),
  /**
   * Sets unit off, so completely non-responsive.
   */
  FAILURE_TYPE_OFF(1L),
  /**
   * Unit is stuck e.g. keeps reporting the same value.
   */
  FAILURE_TYPE_STUCK(2L),
  /**
   * Unit is reporting complete garbage.
   */
  FAILURE_TYPE_GARBAGE(3L),
  /**
   * Unit is consistently wrong.
   */
  FAILURE_TYPE_WRONG(4L),
  /**
   * Unit is slow, so e.g. reporting at slower than expected rate.
   */
  FAILURE_TYPE_SLOW(5L),
  /**
   * Data of unit is delayed in time.
   */
  FAILURE_TYPE_DELAYED(6L),
  /**
   * Unit is sometimes working, sometimes not.
   */
  FAILURE_TYPE_INTERMITTENT(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FailureType? = when (v) {
      0L -> FAILURE_TYPE_OK
      1L -> FAILURE_TYPE_OFF
      2L -> FAILURE_TYPE_STUCK
      3L -> FAILURE_TYPE_GARBAGE
      4L -> FAILURE_TYPE_WRONG
      5L -> FAILURE_TYPE_SLOW
      6L -> FAILURE_TYPE_DELAYED
      7L -> FAILURE_TYPE_INTERMITTENT
      else -> null
    }
  }
}

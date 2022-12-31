package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
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
  @GeneratedMavEnumEntry
  OK(0L),
  /**
   * Sets unit off, so completely non-responsive.
   */
  @GeneratedMavEnumEntry
  OFF(1L),
  /**
   * Unit is stuck e.g. keeps reporting the same value.
   */
  @GeneratedMavEnumEntry
  STUCK(2L),
  /**
   * Unit is reporting complete garbage.
   */
  @GeneratedMavEnumEntry
  GARBAGE(3L),
  /**
   * Unit is consistently wrong.
   */
  @GeneratedMavEnumEntry
  WRONG(4L),
  /**
   * Unit is slow, so e.g. reporting at slower than expected rate.
   */
  @GeneratedMavEnumEntry
  SLOW(5L),
  /**
   * Data of unit is delayed in time.
   */
  @GeneratedMavEnumEntry
  DELAYED(6L),
  /**
   * Unit is sometimes working, sometimes not.
   */
  @GeneratedMavEnumEntry
  INTERMITTENT(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FailureType? = when (v) {
      0L -> OK
      1L -> OFF
      2L -> STUCK
      3L -> GARBAGE
      4L -> WRONG
      5L -> SLOW
      6L -> DELAYED
      7L -> INTERMITTENT
      else -> null
    }
  }
}

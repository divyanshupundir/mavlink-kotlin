package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Flags to report ESC failures.
 */
@GeneratedMavEnum(bitmask = true)
public enum class EscFailureFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * No ESC failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_NONE(0L),
  /**
   * Over current failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_OVER_CURRENT(1L),
  /**
   * Over voltage failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_OVER_VOLTAGE(2L),
  /**
   * Over temperature failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_OVER_TEMPERATURE(4L),
  /**
   * Over RPM failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_OVER_RPM(8L),
  /**
   * Inconsistent command failure i.e. out of bounds.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_INCONSISTENT_CMD(16L),
  /**
   * Motor stuck failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_MOTOR_STUCK(32L),
  /**
   * Generic ESC failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_GENERIC(64L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): EscFailureFlags? = when (v) {
      0L -> ESC_FAILURE_NONE
      1L -> ESC_FAILURE_OVER_CURRENT
      2L -> ESC_FAILURE_OVER_VOLTAGE
      4L -> ESC_FAILURE_OVER_TEMPERATURE
      8L -> ESC_FAILURE_OVER_RPM
      16L -> ESC_FAILURE_INCONSISTENT_CMD
      32L -> ESC_FAILURE_MOTOR_STUCK
      64L -> ESC_FAILURE_GENERIC
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<EscFailureFlags> = buildList {
      if (v and 0L == 0L) add(ESC_FAILURE_NONE)
      if (v and 1L == 1L) add(ESC_FAILURE_OVER_CURRENT)
      if (v and 2L == 2L) add(ESC_FAILURE_OVER_VOLTAGE)
      if (v and 4L == 4L) add(ESC_FAILURE_OVER_TEMPERATURE)
      if (v and 8L == 8L) add(ESC_FAILURE_OVER_RPM)
      if (v and 16L == 16L) add(ESC_FAILURE_INCONSISTENT_CMD)
      if (v and 32L == 32L) add(ESC_FAILURE_MOTOR_STUCK)
      if (v and 64L == 64L) add(ESC_FAILURE_GENERIC)
    }
  }
}

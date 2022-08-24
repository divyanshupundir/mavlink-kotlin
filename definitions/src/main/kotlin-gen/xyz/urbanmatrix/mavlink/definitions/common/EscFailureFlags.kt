package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags to report ESC failures.
 */
@GeneratedMavEnum
public enum class EscFailureFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No ESC failure.
   */
  ESC_FAILURE_NONE(0L),
  /**
   * Over current failure.
   */
  ESC_FAILURE_OVER_CURRENT(1L),
  /**
   * Over voltage failure.
   */
  ESC_FAILURE_OVER_VOLTAGE(2L),
  /**
   * Over temperature failure.
   */
  ESC_FAILURE_OVER_TEMPERATURE(4L),
  /**
   * Over RPM failure.
   */
  ESC_FAILURE_OVER_RPM(8L),
  /**
   * Inconsistent command failure i.e. out of bounds.
   */
  ESC_FAILURE_INCONSISTENT_CMD(16L),
  /**
   * Motor stuck failure.
   */
  ESC_FAILURE_MOTOR_STUCK(32L),
  /**
   * Generic ESC failure.
   */
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
  }
}

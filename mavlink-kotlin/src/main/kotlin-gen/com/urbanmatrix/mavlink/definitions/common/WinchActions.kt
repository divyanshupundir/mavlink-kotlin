package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Winch actions.
 */
public enum class WinchActions(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Allow motor to freewheel.
   */
  WINCH_RELAXED(0L),
  /**
   * Wind or unwind specified length of line, optionally using specified rate.
   */
  WINCH_RELATIVE_LENGTH_CONTROL(1L),
  /**
   * Wind or unwind line at specified rate.
   */
  WINCH_RATE_CONTROL(2L),
  /**
   * Perform the locking sequence to relieve motor while in the fully retracted position. Only
   * action and instance command parameters are used, others are ignored.
   */
  WINCH_LOCK(3L),
  /**
   * Sequence of drop, slow down, touch down, reel up, lock. Only action and instance command
   * parameters are used, others are ignored.
   */
  WINCH_DELIVER(4L),
  /**
   * Engage motor and hold current position. Only action and instance command parameters are used,
   * others are ignored.
   */
  WINCH_HOLD(5L),
  /**
   * Return the reel to the fully retracted position. Only action and instance command parameters
   * are used, others are ignored.
   */
  WINCH_RETRACT(6L),
  /**
   * Load the reel with line. The winch will calculate the total loaded length and stop when the
   * tension exceeds a threshold. Only action and instance command parameters are used, others are
   * ignored.
   */
  WINCH_LOAD_LINE(7L),
  /**
   * Spool out the entire length of the line. Only action and instance command parameters are used,
   * others are ignored.
   */
  WINCH_ABANDON_LINE(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): WinchActions? = when (v) {
      0L -> WINCH_RELAXED
      1L -> WINCH_RELATIVE_LENGTH_CONTROL
      2L -> WINCH_RATE_CONTROL
      3L -> WINCH_LOCK
      4L -> WINCH_DELIVER
      5L -> WINCH_HOLD
      6L -> WINCH_RETRACT
      7L -> WINCH_LOAD_LINE
      8L -> WINCH_ABANDON_LINE
      else -> null
    }
  }
}

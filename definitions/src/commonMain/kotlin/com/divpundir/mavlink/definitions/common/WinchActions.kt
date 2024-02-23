package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Winch actions.
 */
@GeneratedMavEnum
public enum class WinchActions(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Allow motor to freewheel.
   */
  @GeneratedMavEnumEntry
  WINCH_RELAXED(0u),
  /**
   * Wind or unwind specified length of line, optionally using specified rate.
   */
  @GeneratedMavEnumEntry
  WINCH_RELATIVE_LENGTH_CONTROL(1u),
  /**
   * Wind or unwind line at specified rate.
   */
  @GeneratedMavEnumEntry
  WINCH_RATE_CONTROL(2u),
  /**
   * Perform the locking sequence to relieve motor while in the fully retracted position. Only
   * action and instance command parameters are used, others are ignored.
   */
  @GeneratedMavEnumEntry
  WINCH_LOCK(3u),
  /**
   * Sequence of drop, slow down, touch down, reel up, lock. Only action and instance command
   * parameters are used, others are ignored.
   */
  @GeneratedMavEnumEntry
  WINCH_DELIVER(4u),
  /**
   * Engage motor and hold current position. Only action and instance command parameters are used,
   * others are ignored.
   */
  @GeneratedMavEnumEntry
  WINCH_HOLD(5u),
  /**
   * Return the reel to the fully retracted position. Only action and instance command parameters
   * are used, others are ignored.
   */
  @GeneratedMavEnumEntry
  WINCH_RETRACT(6u),
  /**
   * Load the reel with line. The winch will calculate the total loaded length and stop when the
   * tension exceeds a threshold. Only action and instance command parameters are used, others are
   * ignored.
   */
  @GeneratedMavEnumEntry
  WINCH_LOAD_LINE(7u),
  /**
   * Spool out the entire length of the line. Only action and instance command parameters are used,
   * others are ignored.
   */
  @GeneratedMavEnumEntry
  WINCH_ABANDON_LINE(8u),
  /**
   * Spools out just enough to present the hook to the user to load the payload. Only action and
   * instance command parameters are used, others are ignored
   */
  @GeneratedMavEnumEntry
  WINCH_LOAD_PAYLOAD(9u),
  ;

  public companion object : MavEnum.MavCompanion<WinchActions> {
    override fun getEntryFromValueOrNull(v: UInt): WinchActions? = when (v) {
      0u -> WINCH_RELAXED
      1u -> WINCH_RELATIVE_LENGTH_CONTROL
      2u -> WINCH_RATE_CONTROL
      3u -> WINCH_LOCK
      4u -> WINCH_DELIVER
      5u -> WINCH_HOLD
      6u -> WINCH_RETRACT
      7u -> WINCH_LOAD_LINE
      8u -> WINCH_ABANDON_LINE
      9u -> WINCH_LOAD_PAYLOAD
      else -> null
    }
  }
}

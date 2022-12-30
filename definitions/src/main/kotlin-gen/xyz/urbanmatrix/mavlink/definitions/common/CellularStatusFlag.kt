package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * These flags encode the cellular network status
 */
@GeneratedMavEnum
public enum class CellularStatusFlag(
  public override val `value`: Long,
) : MavEnum {
  /**
   * State unknown or not reportable.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * Modem is unusable
   */
  @GeneratedMavEnumEntry
  FAILED(1L),
  /**
   * Modem is being initialized
   */
  @GeneratedMavEnumEntry
  INITIALIZING(2L),
  /**
   * Modem is locked
   */
  @GeneratedMavEnumEntry
  LOCKED(3L),
  /**
   * Modem is not enabled and is powered down
   */
  @GeneratedMavEnumEntry
  DISABLED(4L),
  /**
   * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_DISABLED state
   */
  @GeneratedMavEnumEntry
  DISABLING(5L),
  /**
   * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_ENABLED state
   */
  @GeneratedMavEnumEntry
  ENABLING(6L),
  /**
   * Modem is enabled and powered on but not registered with a network provider and not available
   * for data connections
   */
  @GeneratedMavEnumEntry
  ENABLED(7L),
  /**
   * Modem is searching for a network provider to register
   */
  @GeneratedMavEnumEntry
  SEARCHING(8L),
  /**
   * Modem is registered with a network provider, and data connections and messaging may be
   * available for use
   */
  @GeneratedMavEnumEntry
  REGISTERED(9L),
  /**
   * Modem is disconnecting and deactivating the last active packet data bearer. This state will not
   * be entered if more than one packet data bearer is active and one of the active bearers is
   * deactivated
   */
  @GeneratedMavEnumEntry
  DISCONNECTING(10L),
  /**
   * Modem is activating and connecting the first packet data bearer. Subsequent bearer activations
   * when another bearer is already active do not cause this state to be entered
   */
  @GeneratedMavEnumEntry
  CONNECTING(11L),
  /**
   * One or more packet data bearers is active and connected
   */
  @GeneratedMavEnumEntry
  CONNECTED(12L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CellularStatusFlag? = when (v) {
      0L -> UNKNOWN
      1L -> FAILED
      2L -> INITIALIZING
      3L -> LOCKED
      4L -> DISABLED
      5L -> DISABLING
      6L -> ENABLING
      7L -> ENABLED
      8L -> SEARCHING
      9L -> REGISTERED
      10L -> DISCONNECTING
      11L -> CONNECTING
      12L -> CONNECTED
      else -> null
    }
  }
}

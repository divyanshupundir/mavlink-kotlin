package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
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
  CELLULAR_STATUS_FLAG_UNKNOWN(0L),
  /**
   * Modem is unusable
   */
  CELLULAR_STATUS_FLAG_FAILED(1L),
  /**
   * Modem is being initialized
   */
  CELLULAR_STATUS_FLAG_INITIALIZING(2L),
  /**
   * Modem is locked
   */
  CELLULAR_STATUS_FLAG_LOCKED(3L),
  /**
   * Modem is not enabled and is powered down
   */
  CELLULAR_STATUS_FLAG_DISABLED(4L),
  /**
   * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_DISABLED state
   */
  CELLULAR_STATUS_FLAG_DISABLING(5L),
  /**
   * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_ENABLED state
   */
  CELLULAR_STATUS_FLAG_ENABLING(6L),
  /**
   * Modem is enabled and powered on but not registered with a network provider and not available
   * for data connections
   */
  CELLULAR_STATUS_FLAG_ENABLED(7L),
  /**
   * Modem is searching for a network provider to register
   */
  CELLULAR_STATUS_FLAG_SEARCHING(8L),
  /**
   * Modem is registered with a network provider, and data connections and messaging may be
   * available for use
   */
  CELLULAR_STATUS_FLAG_REGISTERED(9L),
  /**
   * Modem is disconnecting and deactivating the last active packet data bearer. This state will not
   * be entered if more than one packet data bearer is active and one of the active bearers is
   * deactivated
   */
  CELLULAR_STATUS_FLAG_DISCONNECTING(10L),
  /**
   * Modem is activating and connecting the first packet data bearer. Subsequent bearer activations
   * when another bearer is already active do not cause this state to be entered
   */
  CELLULAR_STATUS_FLAG_CONNECTING(11L),
  /**
   * One or more packet data bearers is active and connected
   */
  CELLULAR_STATUS_FLAG_CONNECTED(12L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CellularStatusFlag? = when (v) {
      0L -> CELLULAR_STATUS_FLAG_UNKNOWN
      1L -> CELLULAR_STATUS_FLAG_FAILED
      2L -> CELLULAR_STATUS_FLAG_INITIALIZING
      3L -> CELLULAR_STATUS_FLAG_LOCKED
      4L -> CELLULAR_STATUS_FLAG_DISABLED
      5L -> CELLULAR_STATUS_FLAG_DISABLING
      6L -> CELLULAR_STATUS_FLAG_ENABLING
      7L -> CELLULAR_STATUS_FLAG_ENABLED
      8L -> CELLULAR_STATUS_FLAG_SEARCHING
      9L -> CELLULAR_STATUS_FLAG_REGISTERED
      10L -> CELLULAR_STATUS_FLAG_DISCONNECTING
      11L -> CELLULAR_STATUS_FLAG_CONNECTING
      12L -> CELLULAR_STATUS_FLAG_CONNECTED
      else -> null
    }
  }
}

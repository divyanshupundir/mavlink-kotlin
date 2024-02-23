package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * These flags encode the cellular network status
 */
@GeneratedMavEnum
public enum class CellularStatusFlag(
  override val `value`: UInt,
) : MavEnum {
  /**
   * State unknown or not reportable.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Modem is unusable
   */
  @GeneratedMavEnumEntry
  FAILED(1u),
  /**
   * Modem is being initialized
   */
  @GeneratedMavEnumEntry
  INITIALIZING(2u),
  /**
   * Modem is locked
   */
  @GeneratedMavEnumEntry
  LOCKED(3u),
  /**
   * Modem is not enabled and is powered down
   */
  @GeneratedMavEnumEntry
  DISABLED(4u),
  /**
   * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_DISABLED state
   */
  @GeneratedMavEnumEntry
  DISABLING(5u),
  /**
   * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_ENABLED state
   */
  @GeneratedMavEnumEntry
  ENABLING(6u),
  /**
   * Modem is enabled and powered on but not registered with a network provider and not available
   * for data connections
   */
  @GeneratedMavEnumEntry
  ENABLED(7u),
  /**
   * Modem is searching for a network provider to register
   */
  @GeneratedMavEnumEntry
  SEARCHING(8u),
  /**
   * Modem is registered with a network provider, and data connections and messaging may be
   * available for use
   */
  @GeneratedMavEnumEntry
  REGISTERED(9u),
  /**
   * Modem is disconnecting and deactivating the last active packet data bearer. This state will not
   * be entered if more than one packet data bearer is active and one of the active bearers is
   * deactivated
   */
  @GeneratedMavEnumEntry
  DISCONNECTING(10u),
  /**
   * Modem is activating and connecting the first packet data bearer. Subsequent bearer activations
   * when another bearer is already active do not cause this state to be entered
   */
  @GeneratedMavEnumEntry
  CONNECTING(11u),
  /**
   * One or more packet data bearers is active and connected
   */
  @GeneratedMavEnumEntry
  CONNECTED(12u),
  ;

  public companion object : MavEnum.MavCompanion<CellularStatusFlag> {
    override fun getEntryFromValueOrNull(v: UInt): CellularStatusFlag? = when (v) {
      0u -> UNKNOWN
      1u -> FAILED
      2u -> INITIALIZING
      3u -> LOCKED
      4u -> DISABLED
      5u -> DISABLING
      6u -> ENABLING
      7u -> ENABLED
      8u -> SEARCHING
      9u -> REGISTERED
      10u -> DISCONNECTING
      11u -> CONNECTING
      12u -> CONNECTED
      else -> null
    }
  }
}

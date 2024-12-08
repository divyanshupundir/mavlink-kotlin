package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class SecureCommandOp(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Get an 8 byte session key which is used for remote secure updates which operate on flight
   * controller data such as bootloader public keys. Return data will be 8 bytes on success. The
   * session key remains valid until either the flight controller reboots or another
   * SECURE_COMMAND_GET_SESSION_KEY is run.
   */
  @GeneratedMavEnumEntry
  SECURE_COMMAND_GET_SESSION_KEY(0u),
  /**
   * Get an 8 byte session key which is used for remote secure updates which operate on RemoteID
   * module data. Return data will be 8 bytes on success. The session key remains valid until either
   * the remote ID module reboots or another SECURE_COMMAND_GET_REMOTEID_SESSION_KEY is run.
   */
  @GeneratedMavEnumEntry
  SECURE_COMMAND_GET_REMOTEID_SESSION_KEY(1u),
  /**
   * Remove range of public keys from the bootloader. Command data consists of two bytes, first byte
   * if index of first public key to remove. Second byte is the number of keys to remove. If all keys
   * are removed then secure boot is disabled and insecure firmware can be loaded.
   */
  @GeneratedMavEnumEntry
  SECURE_COMMAND_REMOVE_PUBLIC_KEYS(2u),
  /**
   * Get current public keys from the bootloader. Command data consists of two bytes, first byte is
   * index of first public key to fetch, 2nd byte is number of keys to fetch. Total data needs to fit
   * in data portion of reply (max 6 keys for 32 byte keys). Reply data has the index of the first key
   * in the first byte, followed by the keys. Returned keys may be less than the number of keys
   * requested if there are less keys installed than requested.
   */
  @GeneratedMavEnumEntry
  SECURE_COMMAND_GET_PUBLIC_KEYS(3u),
  /**
   * Set current public keys in the bootloader. Data consists of a one byte public key index
   * followed by the public keys. With 32 byte keys this allows for up to 6 keys to be set in one
   * request. Keys outside of the range that is being set will remain unchanged.
   */
  @GeneratedMavEnumEntry
  SECURE_COMMAND_SET_PUBLIC_KEYS(4u),
  /**
   * Get config data for remote ID module. This command should be sent to the component ID of the
   * flight controller which will forward it to the RemoteID module either over mavlink or DroneCAN.
   * Data format is specific to the RemoteID implementation, see RemoteID firmware documentation for
   * details.
   */
  @GeneratedMavEnumEntry
  SECURE_COMMAND_GET_REMOTEID_CONFIG(5u),
  /**
   * Set config data for remote ID module. This command should be sent to the component ID of the
   * flight controller which will forward it to the RemoteID module either over mavlink or DroneCAN.
   * Data format is specific to the RemoteID implementation, see RemoteID firmware documentation for
   * details.
   */
  @GeneratedMavEnumEntry
  SECURE_COMMAND_SET_REMOTEID_CONFIG(6u),
  /**
   * Flash bootloader from local storage. Data is the filename to use for the bootloader. This is
   * intended to be used with MAVFtp to upload a new bootloader to a microSD before flashing.
   */
  @GeneratedMavEnumEntry
  SECURE_COMMAND_FLASH_BOOTLOADER(7u),
  ;

  public companion object : MavEnum.MavCompanion<SecureCommandOp> {
    override fun getEntryFromValueOrNull(v: UInt): SecureCommandOp? = when (v) {
      0u -> SECURE_COMMAND_GET_SESSION_KEY
      1u -> SECURE_COMMAND_GET_REMOTEID_SESSION_KEY
      2u -> SECURE_COMMAND_REMOVE_PUBLIC_KEYS
      3u -> SECURE_COMMAND_GET_PUBLIC_KEYS
      4u -> SECURE_COMMAND_SET_PUBLIC_KEYS
      5u -> SECURE_COMMAND_GET_REMOTEID_CONFIG
      6u -> SECURE_COMMAND_SET_REMOTEID_CONFIG
      7u -> SECURE_COMMAND_FLASH_BOOTLOADER
      else -> null
    }
  }
}

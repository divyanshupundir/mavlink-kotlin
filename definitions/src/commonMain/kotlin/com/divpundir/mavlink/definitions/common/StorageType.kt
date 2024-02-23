package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Flags to indicate the type of storage.
 */
@GeneratedMavEnum
public enum class StorageType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Storage type is not known.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Storage type is USB device.
   */
  @GeneratedMavEnumEntry
  USB_STICK(1u),
  /**
   * Storage type is SD card.
   */
  @GeneratedMavEnumEntry
  SD(2u),
  /**
   * Storage type is microSD card.
   */
  @GeneratedMavEnumEntry
  MICROSD(3u),
  /**
   * Storage type is CFast.
   */
  @GeneratedMavEnumEntry
  CF(4u),
  /**
   * Storage type is CFexpress.
   */
  @GeneratedMavEnumEntry
  CFE(5u),
  /**
   * Storage type is XQD.
   */
  @GeneratedMavEnumEntry
  XQD(6u),
  /**
   * Storage type is HD mass storage type.
   */
  @GeneratedMavEnumEntry
  HD(7u),
  /**
   * Storage type is other, not listed type.
   */
  @GeneratedMavEnumEntry
  OTHER(254u),
  ;

  public companion object : MavEnum.MavCompanion<StorageType> {
    override fun getEntryFromValueOrNull(v: UInt): StorageType? = when (v) {
      0u -> UNKNOWN
      1u -> USB_STICK
      2u -> SD
      3u -> MICROSD
      4u -> CF
      5u -> CFE
      6u -> XQD
      7u -> HD
      254u -> OTHER
      else -> null
    }
  }
}

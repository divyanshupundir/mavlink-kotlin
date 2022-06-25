package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Flags to indicate the type of storage.
 */
public enum class StorageType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Storage type is not known.
   */
  STORAGE_TYPE_UNKNOWN(0L),
  /**
   * Storage type is USB device.
   */
  STORAGE_TYPE_USB_STICK(1L),
  /**
   * Storage type is SD card.
   */
  STORAGE_TYPE_SD(2L),
  /**
   * Storage type is microSD card.
   */
  STORAGE_TYPE_MICROSD(3L),
  /**
   * Storage type is CFast.
   */
  STORAGE_TYPE_CF(4L),
  /**
   * Storage type is CFexpress.
   */
  STORAGE_TYPE_CFE(5L),
  /**
   * Storage type is XQD.
   */
  STORAGE_TYPE_XQD(6L),
  /**
   * Storage type is HD mass storage type.
   */
  STORAGE_TYPE_HD(7L),
  /**
   * Storage type is other, not listed type.
   */
  STORAGE_TYPE_OTHER(254L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): StorageType? = when (v) {
      0L -> STORAGE_TYPE_UNKNOWN
      1L -> STORAGE_TYPE_USB_STICK
      2L -> STORAGE_TYPE_SD
      3L -> STORAGE_TYPE_MICROSD
      4L -> STORAGE_TYPE_CF
      5L -> STORAGE_TYPE_CFE
      6L -> STORAGE_TYPE_XQD
      7L -> STORAGE_TYPE_HD
      254L -> STORAGE_TYPE_OTHER
      else -> null
    }
  }
}

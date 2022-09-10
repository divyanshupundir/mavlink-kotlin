package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags to indicate the type of storage.
 */
@GeneratedMavEnum
public enum class StorageType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Storage type is not known.
   */
  @GeneratedMavEnumEntry
  STORAGE_TYPE_UNKNOWN(0L),
  /**
   * Storage type is USB device.
   */
  @GeneratedMavEnumEntry
  STORAGE_TYPE_USB_STICK(1L),
  /**
   * Storage type is SD card.
   */
  @GeneratedMavEnumEntry
  STORAGE_TYPE_SD(2L),
  /**
   * Storage type is microSD card.
   */
  @GeneratedMavEnumEntry
  STORAGE_TYPE_MICROSD(3L),
  /**
   * Storage type is CFast.
   */
  @GeneratedMavEnumEntry
  STORAGE_TYPE_CF(4L),
  /**
   * Storage type is CFexpress.
   */
  @GeneratedMavEnumEntry
  STORAGE_TYPE_CFE(5L),
  /**
   * Storage type is XQD.
   */
  @GeneratedMavEnumEntry
  STORAGE_TYPE_XQD(6L),
  /**
   * Storage type is HD mass storage type.
   */
  @GeneratedMavEnumEntry
  STORAGE_TYPE_HD(7L),
  /**
   * Storage type is other, not listed type.
   */
  @GeneratedMavEnumEntry
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

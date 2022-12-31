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
  UNKNOWN(0L),
  /**
   * Storage type is USB device.
   */
  @GeneratedMavEnumEntry
  USB_STICK(1L),
  /**
   * Storage type is SD card.
   */
  @GeneratedMavEnumEntry
  SD(2L),
  /**
   * Storage type is microSD card.
   */
  @GeneratedMavEnumEntry
  MICROSD(3L),
  /**
   * Storage type is CFast.
   */
  @GeneratedMavEnumEntry
  CF(4L),
  /**
   * Storage type is CFexpress.
   */
  @GeneratedMavEnumEntry
  CFE(5L),
  /**
   * Storage type is XQD.
   */
  @GeneratedMavEnumEntry
  XQD(6L),
  /**
   * Storage type is HD mass storage type.
   */
  @GeneratedMavEnumEntry
  HD(7L),
  /**
   * Storage type is other, not listed type.
   */
  @GeneratedMavEnumEntry
  OTHER(254L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): StorageType? = when (v) {
      0L -> UNKNOWN
      1L -> USB_STICK
      2L -> SD
      3L -> MICROSD
      4L -> CF
      5L -> CFE
      6L -> XQD
      7L -> HD
      254L -> OTHER
      else -> null
    }
  }
}

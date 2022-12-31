package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags to indicate usage for a particular storage (see STORAGE_INFORMATION.storage_usage and
 * MAV_CMD_SET_STORAGE_USAGE).
 */
@GeneratedMavEnum
public enum class StorageUsageFlag(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Always set to 1 (indicates STORAGE_INFORMATION.storage_usage is supported).
   */
  @GeneratedMavEnumEntry
  SET(1L),
  /**
   * Storage for saving photos.
   */
  @GeneratedMavEnumEntry
  PHOTO(2L),
  /**
   * Storage for saving videos.
   */
  @GeneratedMavEnumEntry
  VIDEO(4L),
  /**
   * Storage for saving logs.
   */
  @GeneratedMavEnumEntry
  LOGS(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): StorageUsageFlag? = when (v) {
      1L -> SET
      2L -> PHOTO
      4L -> VIDEO
      8L -> LOGS
      else -> null
    }
  }
}

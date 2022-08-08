package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

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
  STORAGE_USAGE_FLAG_SET(1L),
  /**
   * Storage for saving photos.
   */
  STORAGE_USAGE_FLAG_PHOTO(2L),
  /**
   * Storage for saving videos.
   */
  STORAGE_USAGE_FLAG_VIDEO(4L),
  /**
   * Storage for saving logs.
   */
  STORAGE_USAGE_FLAG_LOGS(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): StorageUsageFlag? = when (v) {
      1L -> STORAGE_USAGE_FLAG_SET
      2L -> STORAGE_USAGE_FLAG_PHOTO
      4L -> STORAGE_USAGE_FLAG_VIDEO
      8L -> STORAGE_USAGE_FLAG_LOGS
      else -> null
    }
  }
}

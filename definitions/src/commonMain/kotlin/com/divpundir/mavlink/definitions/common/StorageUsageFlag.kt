package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Flags to indicate usage for a particular storage (see STORAGE_INFORMATION.storage_usage and
 * MAV_CMD_SET_STORAGE_USAGE).
 */
@GeneratedMavEnum
public enum class StorageUsageFlag(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Always set to 1 (indicates STORAGE_INFORMATION.storage_usage is supported).
   */
  @GeneratedMavEnumEntry
  SET(1u),
  /**
   * Storage for saving photos.
   */
  @GeneratedMavEnumEntry
  PHOTO(2u),
  /**
   * Storage for saving videos.
   */
  @GeneratedMavEnumEntry
  VIDEO(4u),
  /**
   * Storage for saving logs.
   */
  @GeneratedMavEnumEntry
  LOGS(8u),
  ;

  public companion object : MavEnum.MavCompanion<StorageUsageFlag> {
    override fun getEntryFromValueOrNull(v: UInt): StorageUsageFlag? = when (v) {
      1u -> SET
      2u -> PHOTO
      4u -> VIDEO
      8u -> LOGS
      else -> null
    }
  }
}

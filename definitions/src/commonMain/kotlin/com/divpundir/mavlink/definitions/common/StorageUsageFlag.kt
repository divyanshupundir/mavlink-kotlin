package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags to indicate usage for a particular storage (see STORAGE_INFORMATION.storage_usage and
 * MAV_CMD_SET_STORAGE_USAGE).
 */
@GeneratedMavEnum(bitmask = true)
public enum class StorageUsageFlag(
  override val `value`: UInt,
) : MavBitmask {
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

  public companion object : MavBitmask.MavCompanion<StorageUsageFlag> {
    override fun getEntryFromValueOrNull(v: UInt): StorageUsageFlag? = when (v) {
      1u -> SET
      2u -> PHOTO
      4u -> VIDEO
      8u -> LOGS
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<StorageUsageFlag> = buildList {
      if (v and 1u == 1u) add(SET)
      if (v and 2u == 2u) add(PHOTO)
      if (v and 4u == 4u) add(VIDEO)
      if (v and 8u == 8u) add(LOGS)
    }
  }
}

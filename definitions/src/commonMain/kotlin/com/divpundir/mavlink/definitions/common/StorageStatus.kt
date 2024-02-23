package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Flags to indicate the status of camera storage.
 */
@GeneratedMavEnum
public enum class StorageStatus(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Storage is missing (no microSD card loaded for example.)
   */
  @GeneratedMavEnumEntry
  EMPTY(0u),
  /**
   * Storage present but unformatted.
   */
  @GeneratedMavEnumEntry
  UNFORMATTED(1u),
  /**
   * Storage present and ready.
   */
  @GeneratedMavEnumEntry
  READY(2u),
  /**
   * Camera does not supply storage status information. Capacity information in STORAGE_INFORMATION
   * fields will be ignored.
   */
  @GeneratedMavEnumEntry
  NOT_SUPPORTED(3u),
  ;

  public companion object : MavEnum.MavCompanion<StorageStatus> {
    override fun getEntryFromValueOrNull(v: UInt): StorageStatus? = when (v) {
      0u -> EMPTY
      1u -> UNFORMATTED
      2u -> READY
      3u -> NOT_SUPPORTED
      else -> null
    }
  }
}

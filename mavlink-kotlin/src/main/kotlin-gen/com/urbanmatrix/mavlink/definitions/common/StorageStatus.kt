package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Flags to indicate the status of camera storage.
 */
public enum class StorageStatus(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Storage is missing (no microSD card loaded for example.)
   */
  STORAGE_STATUS_EMPTY(0L),
  /**
   * Storage present but unformatted.
   */
  STORAGE_STATUS_UNFORMATTED(1L),
  /**
   * Storage present and ready.
   */
  STORAGE_STATUS_READY(2L),
  /**
   * Camera does not supply storage status information. Capacity information in STORAGE_INFORMATION
   * fields will be ignored.
   */
  STORAGE_STATUS_NOT_SUPPORTED(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): StorageStatus? = when (v) {
      0L -> STORAGE_STATUS_EMPTY
      1L -> STORAGE_STATUS_UNFORMATTED
      2L -> STORAGE_STATUS_READY
      3L -> STORAGE_STATUS_NOT_SUPPORTED
      else -> null
    }
  }
}

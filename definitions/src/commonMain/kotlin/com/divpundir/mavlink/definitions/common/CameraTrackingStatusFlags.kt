package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Camera tracking status flags
 */
@GeneratedMavEnum
public enum class CameraTrackingStatusFlags(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Camera is not tracking
   */
  @GeneratedMavEnumEntry
  IDLE(0u),
  /**
   * Camera is tracking
   */
  @GeneratedMavEnumEntry
  ACTIVE(1u),
  /**
   * Camera tracking in error state
   */
  @GeneratedMavEnumEntry
  ERROR(2u),
  ;

  public companion object : MavEnum.MavCompanion<CameraTrackingStatusFlags> {
    override fun getEntryFromValueOrNull(v: UInt): CameraTrackingStatusFlags? = when (v) {
      0u -> IDLE
      1u -> ACTIVE
      2u -> ERROR
      else -> null
    }
  }
}

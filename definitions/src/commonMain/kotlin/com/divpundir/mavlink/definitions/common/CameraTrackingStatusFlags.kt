package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import com.divpundir.mavlink.api.WorkInProgress
import kotlin.UInt
import kotlin.collections.List

/**
 * Camera tracking status flags
 */
@GeneratedMavEnum(bitmask = true)
public enum class CameraTrackingStatusFlags(
  override val `value`: UInt,
) : MavBitmask {
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
  /**
   * Camera Moving Target Indicators (MTI) are active
   */
  @WorkInProgress
  @GeneratedMavEnumEntry
  MTI(4u),
  /**
   * Camera tracking target is obscured and is being predicted
   */
  @WorkInProgress
  @GeneratedMavEnumEntry
  COASTING(8u),
  ;

  public companion object : MavBitmask.MavCompanion<CameraTrackingStatusFlags> {
    override fun getEntryFromValueOrNull(v: UInt): CameraTrackingStatusFlags? = when (v) {
      0u -> IDLE
      1u -> ACTIVE
      2u -> ERROR
      4u -> MTI
      8u -> COASTING
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<CameraTrackingStatusFlags> = buildList {
      if (v and 0u == 0u) add(IDLE)
      if (v and 1u == 1u) add(ACTIVE)
      if (v and 2u == 2u) add(ERROR)
      if (v and 4u == 4u) add(MTI)
      if (v and 8u == 8u) add(COASTING)
    }
  }
}

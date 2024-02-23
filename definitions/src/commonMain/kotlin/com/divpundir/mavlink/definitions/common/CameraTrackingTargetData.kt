package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Camera tracking target data (shows where tracked target is within image)
 */
@GeneratedMavEnum(bitmask = true)
public enum class CameraTrackingTargetData(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * No target data
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Target data embedded in image data (proprietary)
   */
  @GeneratedMavEnumEntry
  EMBEDDED(1u),
  /**
   * Target data rendered in image
   */
  @GeneratedMavEnumEntry
  RENDERED(2u),
  /**
   * Target data within status message (Point or Rectangle)
   */
  @GeneratedMavEnumEntry
  IN_STATUS(4u),
  ;

  public companion object : MavBitmask.MavCompanion<CameraTrackingTargetData> {
    override fun getEntryFromValueOrNull(v: UInt): CameraTrackingTargetData? = when (v) {
      0u -> NONE
      1u -> EMBEDDED
      2u -> RENDERED
      4u -> IN_STATUS
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<CameraTrackingTargetData> = buildList {
      if (v and 0u == 0u) add(NONE)
      if (v and 1u == 1u) add(EMBEDDED)
      if (v and 2u == 2u) add(RENDERED)
      if (v and 4u == 4u) add(IN_STATUS)
    }
  }
}

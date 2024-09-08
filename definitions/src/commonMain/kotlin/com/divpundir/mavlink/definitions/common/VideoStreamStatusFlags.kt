package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Stream status flags (Bitmap)
 */
@GeneratedMavEnum(bitmask = true)
public enum class VideoStreamStatusFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Stream is active (running)
   */
  @GeneratedMavEnumEntry
  RUNNING(1u),
  /**
   * Stream is thermal imaging
   */
  @GeneratedMavEnumEntry
  THERMAL(2u),
  /**
   * Stream can report absolute thermal range (see CAMERA_THERMAL_RANGE). (WIP).
   */
  @GeneratedMavEnumEntry
  THERMAL_RANGE_ENABLED(4u),
  ;

  public companion object : MavBitmask.MavCompanion<VideoStreamStatusFlags> {
    override fun getEntryFromValueOrNull(v: UInt): VideoStreamStatusFlags? = when (v) {
      1u -> RUNNING
      2u -> THERMAL
      4u -> THERMAL_RANGE_ENABLED
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<VideoStreamStatusFlags> = buildList {
      if (v and 1u == 1u) add(RUNNING)
      if (v and 2u == 2u) add(THERMAL)
      if (v and 4u == 4u) add(THERMAL_RANGE_ENABLED)
    }
  }
}

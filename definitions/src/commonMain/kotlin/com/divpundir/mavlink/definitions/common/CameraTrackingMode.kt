package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Camera tracking modes
 */
@GeneratedMavEnum
public enum class CameraTrackingMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Not tracking
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Target is a point
   */
  @GeneratedMavEnumEntry
  POINT(1u),
  /**
   * Target is a rectangle
   */
  @GeneratedMavEnumEntry
  RECTANGLE(2u),
  ;

  public companion object : MavEnum.MavCompanion<CameraTrackingMode> {
    override fun getEntryFromValueOrNull(v: UInt): CameraTrackingMode? = when (v) {
      0u -> NONE
      1u -> POINT
      2u -> RECTANGLE
      else -> null
    }
  }
}

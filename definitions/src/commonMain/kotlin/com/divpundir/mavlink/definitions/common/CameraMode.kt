package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Camera Modes.
 */
@GeneratedMavEnum
public enum class CameraMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Camera is in image/photo capture mode.
   */
  @GeneratedMavEnumEntry
  IMAGE(0u),
  /**
   * Camera is in video capture mode.
   */
  @GeneratedMavEnumEntry
  VIDEO(1u),
  /**
   * Camera is in image survey capture mode. It allows for camera controller to do specific settings
   * for surveys.
   */
  @GeneratedMavEnumEntry
  IMAGE_SURVEY(2u),
  ;

  public companion object : MavEnum.MavCompanion<CameraMode> {
    override fun getEntryFromValueOrNull(v: UInt): CameraMode? = when (v) {
      0u -> IMAGE
      1u -> VIDEO
      2u -> IMAGE_SURVEY
      else -> null
    }
  }
}

package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Camera Modes.
 */
public enum class CameraMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Camera is in image/photo capture mode.
   */
  CAMERA_MODE_IMAGE(0L),
  /**
   * Camera is in video capture mode.
   */
  CAMERA_MODE_VIDEO(1L),
  /**
   * Camera is in image survey capture mode. It allows for camera controller to do specific settings
   * for surveys.
   */
  CAMERA_MODE_IMAGE_SURVEY(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraMode? = when (v) {
      0L -> CAMERA_MODE_IMAGE
      1L -> CAMERA_MODE_VIDEO
      2L -> CAMERA_MODE_IMAGE_SURVEY
      else -> null
    }
  }
}

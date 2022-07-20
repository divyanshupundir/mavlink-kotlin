package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Camera tracking status flags
 */
public enum class CameraTrackingStatusFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Camera is not tracking
   */
  CAMERA_TRACKING_STATUS_FLAGS_IDLE(0L),
  /**
   * Camera is tracking
   */
  CAMERA_TRACKING_STATUS_FLAGS_ACTIVE(1L),
  /**
   * Camera tracking in error state
   */
  CAMERA_TRACKING_STATUS_FLAGS_ERROR(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraTrackingStatusFlags? = when (v) {
      0L -> CAMERA_TRACKING_STATUS_FLAGS_IDLE
      1L -> CAMERA_TRACKING_STATUS_FLAGS_ACTIVE
      2L -> CAMERA_TRACKING_STATUS_FLAGS_ERROR
      else -> null
    }
  }
}

package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Camera tracking target data (shows where tracked target is within image)
 */
public enum class CameraTrackingTargetData(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No target data
   */
  CAMERA_TRACKING_TARGET_DATA_NONE(0L),
  /**
   * Target data embedded in image data (proprietary)
   */
  CAMERA_TRACKING_TARGET_DATA_EMBEDDED(1L),
  /**
   * Target data rendered in image
   */
  CAMERA_TRACKING_TARGET_DATA_RENDERED(2L),
  /**
   * Target data within status message (Point or Rectangle)
   */
  CAMERA_TRACKING_TARGET_DATA_IN_STATUS(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraTrackingTargetData? = when (v) {
      0L -> CAMERA_TRACKING_TARGET_DATA_NONE
      1L -> CAMERA_TRACKING_TARGET_DATA_EMBEDDED
      2L -> CAMERA_TRACKING_TARGET_DATA_RENDERED
      4L -> CAMERA_TRACKING_TARGET_DATA_IN_STATUS
      else -> null
    }
  }
}

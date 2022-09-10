package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Camera tracking target data (shows where tracked target is within image)
 */
@GeneratedMavEnum
public enum class CameraTrackingTargetData(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No target data
   */
  @GeneratedMavEnumEntry
  CAMERA_TRACKING_TARGET_DATA_NONE(0L),
  /**
   * Target data embedded in image data (proprietary)
   */
  @GeneratedMavEnumEntry
  CAMERA_TRACKING_TARGET_DATA_EMBEDDED(1L),
  /**
   * Target data rendered in image
   */
  @GeneratedMavEnumEntry
  CAMERA_TRACKING_TARGET_DATA_RENDERED(2L),
  /**
   * Target data within status message (Point or Rectangle)
   */
  @GeneratedMavEnumEntry
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

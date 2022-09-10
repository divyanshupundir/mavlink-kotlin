package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Camera tracking modes
 */
@GeneratedMavEnum
public enum class CameraTrackingMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Not tracking
   */
  @GeneratedMavEnumEntry
  CAMERA_TRACKING_MODE_NONE(0L),
  /**
   * Target is a point
   */
  @GeneratedMavEnumEntry
  CAMERA_TRACKING_MODE_POINT(1L),
  /**
   * Target is a rectangle
   */
  @GeneratedMavEnumEntry
  CAMERA_TRACKING_MODE_RECTANGLE(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraTrackingMode? = when (v) {
      0L -> CAMERA_TRACKING_MODE_NONE
      1L -> CAMERA_TRACKING_MODE_POINT
      2L -> CAMERA_TRACKING_MODE_RECTANGLE
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Zoom types for MAV_CMD_SET_CAMERA_ZOOM
 */
@GeneratedMavEnum
public enum class CameraZoomType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Zoom one step increment (-1 for wide, 1 for tele)
   */
  @GeneratedMavEnumEntry
  ZOOM_TYPE_STEP(0u),
  /**
   * Continuous zoom up/down until stopped (-1 for wide, 1 for tele, 0 to stop zooming)
   */
  @GeneratedMavEnumEntry
  ZOOM_TYPE_CONTINUOUS(1u),
  /**
   * Zoom value as proportion of full camera range (a percentage value between 0.0 and 100.0)
   */
  @GeneratedMavEnumEntry
  ZOOM_TYPE_RANGE(2u),
  /**
   * Zoom value/variable focal length in millimetres. Note that there is no message to get the valid
   * zoom range of the camera, so this can type can only be used for cameras where the zoom range is
   * known (implying that this cannot reliably be used in a GCS for an arbitrary camera)
   */
  @GeneratedMavEnumEntry
  ZOOM_TYPE_FOCAL_LENGTH(3u),
  /**
   * Zoom value as horizontal field of view in degrees.
   */
  @GeneratedMavEnumEntry
  ZOOM_TYPE_HORIZONTAL_FOV(4u),
  ;

  public companion object : MavEnum.MavCompanion<CameraZoomType> {
    override fun getEntryFromValueOrNull(v: UInt): CameraZoomType? = when (v) {
      0u -> ZOOM_TYPE_STEP
      1u -> ZOOM_TYPE_CONTINUOUS
      2u -> ZOOM_TYPE_RANGE
      3u -> ZOOM_TYPE_FOCAL_LENGTH
      4u -> ZOOM_TYPE_HORIZONTAL_FOV
      else -> null
    }
  }
}

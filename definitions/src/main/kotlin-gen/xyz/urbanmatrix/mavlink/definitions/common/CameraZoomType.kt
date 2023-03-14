package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Zoom types for MAV_CMD_SET_CAMERA_ZOOM
 */
@GeneratedMavEnum
public enum class CameraZoomType(
  public override val `value`: UInt,
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
   * Zoom value as proportion of full camera range (a value between 0.0 and 100.0)
   */
  @GeneratedMavEnumEntry
  ZOOM_TYPE_RANGE(2u),
  /**
   * Zoom value/variable focal length in milimetres. Note that there is no message to get the valid
   * zoom range of the camera, so this can type can only be used for cameras where the zoom range is
   * known (implying that this cannot reliably be used in a GCS for an arbitrary camera)
   */
  @GeneratedMavEnumEntry
  ZOOM_TYPE_FOCAL_LENGTH(3u),
  ;

  public companion object : MavEnum.Companion<CameraZoomType> {
    public override fun getEntryFromValueOrNull(v: UInt): CameraZoomType? = when (v) {
      0u -> ZOOM_TYPE_STEP
      1u -> ZOOM_TYPE_CONTINUOUS
      2u -> ZOOM_TYPE_RANGE
      3u -> ZOOM_TYPE_FOCAL_LENGTH
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Camera capability flags (Bitmap)
 */
@GeneratedMavEnum
public enum class CameraCapFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Camera is able to record video
   */
  CAMERA_CAP_FLAGS_CAPTURE_VIDEO(1L),
  /**
   * Camera is able to capture images
   */
  CAMERA_CAP_FLAGS_CAPTURE_IMAGE(2L),
  /**
   * Camera has separate Video and Image/Photo modes (MAV_CMD_SET_CAMERA_MODE)
   */
  CAMERA_CAP_FLAGS_HAS_MODES(4L),
  /**
   * Camera can capture images while in video mode
   */
  CAMERA_CAP_FLAGS_CAN_CAPTURE_IMAGE_IN_VIDEO_MODE(8L),
  /**
   * Camera can capture videos while in Photo/Image mode
   */
  CAMERA_CAP_FLAGS_CAN_CAPTURE_VIDEO_IN_IMAGE_MODE(16L),
  /**
   * Camera has image survey mode (MAV_CMD_SET_CAMERA_MODE)
   */
  CAMERA_CAP_FLAGS_HAS_IMAGE_SURVEY_MODE(32L),
  /**
   * Camera has basic zoom control (MAV_CMD_SET_CAMERA_ZOOM)
   */
  CAMERA_CAP_FLAGS_HAS_BASIC_ZOOM(64L),
  /**
   * Camera has basic focus control (MAV_CMD_SET_CAMERA_FOCUS)
   */
  CAMERA_CAP_FLAGS_HAS_BASIC_FOCUS(128L),
  /**
   * Camera has video streaming capabilities (request VIDEO_STREAM_INFORMATION with
   * MAV_CMD_REQUEST_MESSAGE for video streaming info)
   */
  CAMERA_CAP_FLAGS_HAS_VIDEO_STREAM(256L),
  /**
   * Camera supports tracking of a point on the camera view.
   */
  CAMERA_CAP_FLAGS_HAS_TRACKING_POINT(512L),
  /**
   * Camera supports tracking of a selection rectangle on the camera view.
   */
  CAMERA_CAP_FLAGS_HAS_TRACKING_RECTANGLE(1024L),
  /**
   * Camera supports tracking geo status (CAMERA_TRACKING_GEO_STATUS).
   */
  CAMERA_CAP_FLAGS_HAS_TRACKING_GEO_STATUS(2048L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraCapFlags? = when (v) {
      1L -> CAMERA_CAP_FLAGS_CAPTURE_VIDEO
      2L -> CAMERA_CAP_FLAGS_CAPTURE_IMAGE
      4L -> CAMERA_CAP_FLAGS_HAS_MODES
      8L -> CAMERA_CAP_FLAGS_CAN_CAPTURE_IMAGE_IN_VIDEO_MODE
      16L -> CAMERA_CAP_FLAGS_CAN_CAPTURE_VIDEO_IN_IMAGE_MODE
      32L -> CAMERA_CAP_FLAGS_HAS_IMAGE_SURVEY_MODE
      64L -> CAMERA_CAP_FLAGS_HAS_BASIC_ZOOM
      128L -> CAMERA_CAP_FLAGS_HAS_BASIC_FOCUS
      256L -> CAMERA_CAP_FLAGS_HAS_VIDEO_STREAM
      512L -> CAMERA_CAP_FLAGS_HAS_TRACKING_POINT
      1024L -> CAMERA_CAP_FLAGS_HAS_TRACKING_RECTANGLE
      2048L -> CAMERA_CAP_FLAGS_HAS_TRACKING_GEO_STATUS
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Camera capability flags (Bitmap)
 */
@GeneratedMavEnum(bitmask = true)
public enum class CameraCapFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Camera is able to record video
   */
  @GeneratedMavEnumEntry
  CAPTURE_VIDEO(1L),
  /**
   * Camera is able to capture images
   */
  @GeneratedMavEnumEntry
  CAPTURE_IMAGE(2L),
  /**
   * Camera has separate Video and Image/Photo modes (MAV_CMD_SET_CAMERA_MODE)
   */
  @GeneratedMavEnumEntry
  HAS_MODES(4L),
  /**
   * Camera can capture images while in video mode
   */
  @GeneratedMavEnumEntry
  CAN_CAPTURE_IMAGE_IN_VIDEO_MODE(8L),
  /**
   * Camera can capture videos while in Photo/Image mode
   */
  @GeneratedMavEnumEntry
  CAN_CAPTURE_VIDEO_IN_IMAGE_MODE(16L),
  /**
   * Camera has image survey mode (MAV_CMD_SET_CAMERA_MODE)
   */
  @GeneratedMavEnumEntry
  HAS_IMAGE_SURVEY_MODE(32L),
  /**
   * Camera has basic zoom control (MAV_CMD_SET_CAMERA_ZOOM)
   */
  @GeneratedMavEnumEntry
  HAS_BASIC_ZOOM(64L),
  /**
   * Camera has basic focus control (MAV_CMD_SET_CAMERA_FOCUS)
   */
  @GeneratedMavEnumEntry
  HAS_BASIC_FOCUS(128L),
  /**
   * Camera has video streaming capabilities (request VIDEO_STREAM_INFORMATION with
   * MAV_CMD_REQUEST_MESSAGE for video streaming info)
   */
  @GeneratedMavEnumEntry
  HAS_VIDEO_STREAM(256L),
  /**
   * Camera supports tracking of a point on the camera view.
   */
  @GeneratedMavEnumEntry
  HAS_TRACKING_POINT(512L),
  /**
   * Camera supports tracking of a selection rectangle on the camera view.
   */
  @GeneratedMavEnumEntry
  HAS_TRACKING_RECTANGLE(1024L),
  /**
   * Camera supports tracking geo status (CAMERA_TRACKING_GEO_STATUS).
   */
  @GeneratedMavEnumEntry
  HAS_TRACKING_GEO_STATUS(2048L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraCapFlags? = when (v) {
      1L -> CAPTURE_VIDEO
      2L -> CAPTURE_IMAGE
      4L -> HAS_MODES
      8L -> CAN_CAPTURE_IMAGE_IN_VIDEO_MODE
      16L -> CAN_CAPTURE_VIDEO_IN_IMAGE_MODE
      32L -> HAS_IMAGE_SURVEY_MODE
      64L -> HAS_BASIC_ZOOM
      128L -> HAS_BASIC_FOCUS
      256L -> HAS_VIDEO_STREAM
      512L -> HAS_TRACKING_POINT
      1024L -> HAS_TRACKING_RECTANGLE
      2048L -> HAS_TRACKING_GEO_STATUS
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<CameraCapFlags> = buildList {
      if (v and 1L == 1L) add(CAPTURE_VIDEO)
      if (v and 2L == 2L) add(CAPTURE_IMAGE)
      if (v and 4L == 4L) add(HAS_MODES)
      if (v and 8L == 8L) add(CAN_CAPTURE_IMAGE_IN_VIDEO_MODE)
      if (v and 16L == 16L) add(CAN_CAPTURE_VIDEO_IN_IMAGE_MODE)
      if (v and 32L == 32L) add(HAS_IMAGE_SURVEY_MODE)
      if (v and 64L == 64L) add(HAS_BASIC_ZOOM)
      if (v and 128L == 128L) add(HAS_BASIC_FOCUS)
      if (v and 256L == 256L) add(HAS_VIDEO_STREAM)
      if (v and 512L == 512L) add(HAS_TRACKING_POINT)
      if (v and 1024L == 1024L) add(HAS_TRACKING_RECTANGLE)
      if (v and 2048L == 2048L) add(HAS_TRACKING_GEO_STATUS)
    }
  }
}

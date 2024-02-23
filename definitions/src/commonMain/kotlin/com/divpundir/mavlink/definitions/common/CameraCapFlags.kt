package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Camera capability flags (Bitmap)
 */
@GeneratedMavEnum(bitmask = true)
public enum class CameraCapFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Camera is able to record video
   */
  @GeneratedMavEnumEntry
  CAPTURE_VIDEO(1u),
  /**
   * Camera is able to capture images
   */
  @GeneratedMavEnumEntry
  CAPTURE_IMAGE(2u),
  /**
   * Camera has separate Video and Image/Photo modes (MAV_CMD_SET_CAMERA_MODE)
   */
  @GeneratedMavEnumEntry
  HAS_MODES(4u),
  /**
   * Camera can capture images while in video mode
   */
  @GeneratedMavEnumEntry
  CAN_CAPTURE_IMAGE_IN_VIDEO_MODE(8u),
  /**
   * Camera can capture videos while in Photo/Image mode
   */
  @GeneratedMavEnumEntry
  CAN_CAPTURE_VIDEO_IN_IMAGE_MODE(16u),
  /**
   * Camera has image survey mode (MAV_CMD_SET_CAMERA_MODE)
   */
  @GeneratedMavEnumEntry
  HAS_IMAGE_SURVEY_MODE(32u),
  /**
   * Camera has basic zoom control (MAV_CMD_SET_CAMERA_ZOOM)
   */
  @GeneratedMavEnumEntry
  HAS_BASIC_ZOOM(64u),
  /**
   * Camera has basic focus control (MAV_CMD_SET_CAMERA_FOCUS)
   */
  @GeneratedMavEnumEntry
  HAS_BASIC_FOCUS(128u),
  /**
   * Camera has video streaming capabilities (request VIDEO_STREAM_INFORMATION with
   * MAV_CMD_REQUEST_MESSAGE for video streaming info)
   */
  @GeneratedMavEnumEntry
  HAS_VIDEO_STREAM(256u),
  /**
   * Camera supports tracking of a point on the camera view.
   */
  @GeneratedMavEnumEntry
  HAS_TRACKING_POINT(512u),
  /**
   * Camera supports tracking of a selection rectangle on the camera view.
   */
  @GeneratedMavEnumEntry
  HAS_TRACKING_RECTANGLE(1_024u),
  /**
   * Camera supports tracking geo status (CAMERA_TRACKING_GEO_STATUS).
   */
  @GeneratedMavEnumEntry
  HAS_TRACKING_GEO_STATUS(2_048u),
  ;

  public companion object : MavBitmask.MavCompanion<CameraCapFlags> {
    override fun getEntryFromValueOrNull(v: UInt): CameraCapFlags? = when (v) {
      1u -> CAPTURE_VIDEO
      2u -> CAPTURE_IMAGE
      4u -> HAS_MODES
      8u -> CAN_CAPTURE_IMAGE_IN_VIDEO_MODE
      16u -> CAN_CAPTURE_VIDEO_IN_IMAGE_MODE
      32u -> HAS_IMAGE_SURVEY_MODE
      64u -> HAS_BASIC_ZOOM
      128u -> HAS_BASIC_FOCUS
      256u -> HAS_VIDEO_STREAM
      512u -> HAS_TRACKING_POINT
      1024u -> HAS_TRACKING_RECTANGLE
      2048u -> HAS_TRACKING_GEO_STATUS
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<CameraCapFlags> = buildList {
      if (v and 1u == 1u) add(CAPTURE_VIDEO)
      if (v and 2u == 2u) add(CAPTURE_IMAGE)
      if (v and 4u == 4u) add(HAS_MODES)
      if (v and 8u == 8u) add(CAN_CAPTURE_IMAGE_IN_VIDEO_MODE)
      if (v and 16u == 16u) add(CAN_CAPTURE_VIDEO_IN_IMAGE_MODE)
      if (v and 32u == 32u) add(HAS_IMAGE_SURVEY_MODE)
      if (v and 64u == 64u) add(HAS_BASIC_ZOOM)
      if (v and 128u == 128u) add(HAS_BASIC_FOCUS)
      if (v and 256u == 256u) add(HAS_VIDEO_STREAM)
      if (v and 512u == 512u) add(HAS_TRACKING_POINT)
      if (v and 1024u == 1024u) add(HAS_TRACKING_RECTANGLE)
      if (v and 2048u == 2048u) add(HAS_TRACKING_GEO_STATUS)
    }
  }
}

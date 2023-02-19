package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class CameraFeedbackFlags(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Shooting photos, not video.
   */
  @GeneratedMavEnumEntry
  CAMERA_FEEDBACK_PHOTO(0u),
  /**
   * Shooting video, not stills.
   */
  @GeneratedMavEnumEntry
  CAMERA_FEEDBACK_VIDEO(1u),
  /**
   * Unable to achieve requested exposure (e.g. shutter speed too low).
   */
  @GeneratedMavEnumEntry
  CAMERA_FEEDBACK_BADEXPOSURE(2u),
  /**
   * Closed loop feedback from camera, we know for sure it has successfully taken a picture.
   */
  @GeneratedMavEnumEntry
  CAMERA_FEEDBACK_CLOSEDLOOP(3u),
  /**
   * Open loop camera, an image trigger has been requested but we can't know for sure it has
   * successfully taken a picture.
   */
  @GeneratedMavEnumEntry
  CAMERA_FEEDBACK_OPENLOOP(4u),
  ;

  public companion object : MavEnum.Companion<CameraFeedbackFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): CameraFeedbackFlags? = when (v) {
      0u -> CAMERA_FEEDBACK_PHOTO
      1u -> CAMERA_FEEDBACK_VIDEO
      2u -> CAMERA_FEEDBACK_BADEXPOSURE
      3u -> CAMERA_FEEDBACK_CLOSEDLOOP
      4u -> CAMERA_FEEDBACK_OPENLOOP
      else -> null
    }
  }
}

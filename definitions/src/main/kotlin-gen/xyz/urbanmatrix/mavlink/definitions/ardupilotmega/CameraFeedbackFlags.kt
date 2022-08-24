package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class CameraFeedbackFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Shooting photos, not video.
   */
  CAMERA_FEEDBACK_PHOTO(0L),
  /**
   * Shooting video, not stills.
   */
  CAMERA_FEEDBACK_VIDEO(1L),
  /**
   * Unable to achieve requested exposure (e.g. shutter speed too low).
   */
  CAMERA_FEEDBACK_BADEXPOSURE(2L),
  /**
   * Closed loop feedback from camera, we know for sure it has successfully taken a picture.
   */
  CAMERA_FEEDBACK_CLOSEDLOOP(3L),
  /**
   * Open loop camera, an image trigger has been requested but we can't know for sure it has
   * successfully taken a picture.
   */
  CAMERA_FEEDBACK_OPENLOOP(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraFeedbackFlags? = when (v) {
      0L -> CAMERA_FEEDBACK_PHOTO
      1L -> CAMERA_FEEDBACK_VIDEO
      2L -> CAMERA_FEEDBACK_BADEXPOSURE
      3L -> CAMERA_FEEDBACK_CLOSEDLOOP
      4L -> CAMERA_FEEDBACK_OPENLOOP
      else -> null
    }
  }
}

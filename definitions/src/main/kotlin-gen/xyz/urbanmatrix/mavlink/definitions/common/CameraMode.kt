package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Camera Modes.
 */
@GeneratedMavEnum
public enum class CameraMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Camera is in image/photo capture mode.
   */
  @GeneratedMavEnumEntry
  IMAGE(0L),
  /**
   * Camera is in video capture mode.
   */
  @GeneratedMavEnumEntry
  VIDEO(1L),
  /**
   * Camera is in image survey capture mode. It allows for camera controller to do specific settings
   * for surveys.
   */
  @GeneratedMavEnumEntry
  IMAGE_SURVEY(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraMode? = when (v) {
      0L -> IMAGE
      1L -> VIDEO
      2L -> IMAGE_SURVEY
      else -> null
    }
  }
}

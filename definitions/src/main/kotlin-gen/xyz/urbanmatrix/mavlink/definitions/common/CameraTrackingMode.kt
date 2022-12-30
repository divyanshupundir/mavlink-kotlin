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
  NONE(0L),
  /**
   * Target is a point
   */
  @GeneratedMavEnumEntry
  POINT(1L),
  /**
   * Target is a rectangle
   */
  @GeneratedMavEnumEntry
  RECTANGLE(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraTrackingMode? = when (v) {
      0L -> NONE
      1L -> POINT
      2L -> RECTANGLE
      else -> null
    }
  }
}

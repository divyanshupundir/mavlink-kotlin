package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Camera tracking status flags
 */
@GeneratedMavEnum
public enum class CameraTrackingStatusFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Camera is not tracking
   */
  @GeneratedMavEnumEntry
  IDLE(0L),
  /**
   * Camera is tracking
   */
  @GeneratedMavEnumEntry
  ACTIVE(1L),
  /**
   * Camera tracking in error state
   */
  @GeneratedMavEnumEntry
  ERROR(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraTrackingStatusFlags? = when (v) {
      0L -> IDLE
      1L -> ACTIVE
      2L -> ERROR
      else -> null
    }
  }
}

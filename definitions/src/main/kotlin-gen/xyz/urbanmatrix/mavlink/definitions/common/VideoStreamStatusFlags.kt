package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Stream status flags (Bitmap)
 */
@GeneratedMavEnum
public enum class VideoStreamStatusFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Stream is active (running)
   */
  @GeneratedMavEnumEntry
  VIDEO_STREAM_STATUS_FLAGS_RUNNING(1L),
  /**
   * Stream is thermal imaging
   */
  @GeneratedMavEnumEntry
  VIDEO_STREAM_STATUS_FLAGS_THERMAL(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): VideoStreamStatusFlags? = when (v) {
      1L -> VIDEO_STREAM_STATUS_FLAGS_RUNNING
      2L -> VIDEO_STREAM_STATUS_FLAGS_THERMAL
      else -> null
    }
  }
}

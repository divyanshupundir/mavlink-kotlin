package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Stream status flags (Bitmap)
 */
@GeneratedMavEnum(bitmask = true)
public enum class VideoStreamStatusFlags(
  public override val `value`: Long,
) : MavBitmask {
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

    public fun getFlagsFromValue(v: Long): List<VideoStreamStatusFlags> = buildList {
      if (v and 1L == 1L) add(VIDEO_STREAM_STATUS_FLAGS_RUNNING)
      if (v and 2L == 2L) add(VIDEO_STREAM_STATUS_FLAGS_THERMAL)
    }
  }
}

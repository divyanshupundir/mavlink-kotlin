package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Stream status flags (Bitmap)
 */
public enum class VideoStreamStatusFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Stream is active (running)
   */
  VIDEO_STREAM_STATUS_FLAGS_RUNNING(1L),
  /**
   * Stream is thermal imaging
   */
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

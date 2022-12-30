package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Camera tracking target data (shows where tracked target is within image)
 */
@GeneratedMavEnum(bitmask = true)
public enum class CameraTrackingTargetData(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * No target data
   */
  @GeneratedMavEnumEntry
  NONE(0L),
  /**
   * Target data embedded in image data (proprietary)
   */
  @GeneratedMavEnumEntry
  EMBEDDED(1L),
  /**
   * Target data rendered in image
   */
  @GeneratedMavEnumEntry
  RENDERED(2L),
  /**
   * Target data within status message (Point or Rectangle)
   */
  @GeneratedMavEnumEntry
  IN_STATUS(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraTrackingTargetData? = when (v) {
      0L -> NONE
      1L -> EMBEDDED
      2L -> RENDERED
      4L -> IN_STATUS
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<CameraTrackingTargetData> = buildList {
      if (v and 0L == 0L) add(NONE)
      if (v and 1L == 1L) add(EMBEDDED)
      if (v and 2L == 2L) add(RENDERED)
      if (v and 4L == 4L) add(IN_STATUS)
    }
  }
}

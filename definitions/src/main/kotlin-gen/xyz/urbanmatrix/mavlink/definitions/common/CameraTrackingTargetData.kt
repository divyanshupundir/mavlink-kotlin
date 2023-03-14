package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Camera tracking target data (shows where tracked target is within image)
 */
@GeneratedMavEnum(bitmask = true)
public enum class CameraTrackingTargetData(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * No target data
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Target data embedded in image data (proprietary)
   */
  @GeneratedMavEnumEntry
  EMBEDDED(1u),
  /**
   * Target data rendered in image
   */
  @GeneratedMavEnumEntry
  RENDERED(2u),
  /**
   * Target data within status message (Point or Rectangle)
   */
  @GeneratedMavEnumEntry
  IN_STATUS(4u),
  ;

  public companion object : MavEnum.Companion<CameraTrackingTargetData>,
      MavBitmask.Companion<CameraTrackingTargetData> {
    public override fun getEntryFromValueOrNull(v: UInt): CameraTrackingTargetData? = when (v) {
      0u -> NONE
      1u -> EMBEDDED
      2u -> RENDERED
      4u -> IN_STATUS
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<CameraTrackingTargetData> = buildList {
      if (v and 0u == 0u) add(NONE)
      if (v and 1u == 1u) add(EMBEDDED)
      if (v and 2u == 2u) add(RENDERED)
      if (v and 4u == 4u) add(IN_STATUS)
    }
  }
}

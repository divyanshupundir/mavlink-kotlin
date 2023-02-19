package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Camera tracking status flags
 */
@GeneratedMavEnum
public enum class CameraTrackingStatusFlags(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Camera is not tracking
   */
  @GeneratedMavEnumEntry
  IDLE(0u),
  /**
   * Camera is tracking
   */
  @GeneratedMavEnumEntry
  ACTIVE(1u),
  /**
   * Camera tracking in error state
   */
  @GeneratedMavEnumEntry
  ERROR(2u),
  ;

  public companion object : MavEnum.Companion<CameraTrackingStatusFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): CameraTrackingStatusFlags? = when (v) {
      0u -> IDLE
      1u -> ACTIVE
      2u -> ERROR
      else -> null
    }
  }
}

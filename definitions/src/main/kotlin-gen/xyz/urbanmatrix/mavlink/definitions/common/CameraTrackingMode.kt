package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Camera tracking modes
 */
@GeneratedMavEnum
public enum class CameraTrackingMode(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Not tracking
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Target is a point
   */
  @GeneratedMavEnumEntry
  POINT(1u),
  /**
   * Target is a rectangle
   */
  @GeneratedMavEnumEntry
  RECTANGLE(2u),
  ;

  public companion object : MavEnum.Companion<CameraTrackingMode> {
    public override fun getEntryFromValueOrNull(v: UInt): CameraTrackingMode? = when (v) {
      0u -> NONE
      1u -> POINT
      2u -> RECTANGLE
      else -> null
    }
  }
}

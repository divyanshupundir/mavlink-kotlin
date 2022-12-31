package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Status for ADS-B transponder dynamic input
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutDynamicGpsFix(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  NONE_0(0L),
  @GeneratedMavEnumEntry
  NONE_1(1L),
  @GeneratedMavEnumEntry
  _2D(2L),
  @GeneratedMavEnumEntry
  _3D(3L),
  @GeneratedMavEnumEntry
  DGPS(4L),
  @GeneratedMavEnumEntry
  RTK(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutDynamicGpsFix? = when (v) {
      0L -> NONE_0
      1L -> NONE_1
      2L -> _2D
      3L -> _3D
      4L -> DGPS
      5L -> RTK
      else -> null
    }
  }
}

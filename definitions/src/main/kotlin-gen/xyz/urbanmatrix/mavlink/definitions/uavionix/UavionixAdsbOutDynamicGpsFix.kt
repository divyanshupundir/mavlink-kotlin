package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Status for ADS-B transponder dynamic input
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutDynamicGpsFix(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  NONE_0(0u),
  @GeneratedMavEnumEntry
  NONE_1(1u),
  @GeneratedMavEnumEntry
  _2D(2u),
  @GeneratedMavEnumEntry
  _3D(3u),
  @GeneratedMavEnumEntry
  DGPS(4u),
  @GeneratedMavEnumEntry
  RTK(5u),
  ;

  public companion object : MavEnum.Companion<UavionixAdsbOutDynamicGpsFix> {
    public override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutDynamicGpsFix? = when (v) {
      0u -> NONE_0
      1u -> NONE_1
      2u -> _2D
      3u -> _3D
      4u -> DGPS
      5u -> RTK
      else -> null
    }
  }
}

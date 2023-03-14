package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * GPS lataral offset encoding
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutCfgGpsOffsetLat(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  NO_DATA(0u),
  @GeneratedMavEnumEntry
  LEFT_2M(1u),
  @GeneratedMavEnumEntry
  LEFT_4M(2u),
  @GeneratedMavEnumEntry
  LEFT_6M(3u),
  @GeneratedMavEnumEntry
  RIGHT_0M(4u),
  @GeneratedMavEnumEntry
  RIGHT_2M(5u),
  @GeneratedMavEnumEntry
  RIGHT_4M(6u),
  @GeneratedMavEnumEntry
  RIGHT_6M(7u),
  ;

  public companion object : MavEnum.Companion<UavionixAdsbOutCfgGpsOffsetLat> {
    public override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutCfgGpsOffsetLat? = when (v)
        {
      0u -> NO_DATA
      1u -> LEFT_2M
      2u -> LEFT_4M
      3u -> LEFT_6M
      4u -> RIGHT_0M
      5u -> RIGHT_2M
      6u -> RIGHT_4M
      7u -> RIGHT_6M
      else -> null
    }
  }
}

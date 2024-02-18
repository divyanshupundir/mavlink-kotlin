package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * GPS lataral offset encoding
 *
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutCfgGpsOffsetLat(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<UavionixAdsbOutCfgGpsOffsetLat> {
    override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutCfgGpsOffsetLat? = when (v) {
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

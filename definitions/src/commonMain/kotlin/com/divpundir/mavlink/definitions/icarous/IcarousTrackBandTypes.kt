package com.divpundir.mavlink.definitions.icarous

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class IcarousTrackBandTypes(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  ICAROUS_TRACK_BAND_TYPE_NONE(0u),
  @GeneratedMavEnumEntry
  ICAROUS_TRACK_BAND_TYPE_NEAR(1u),
  @GeneratedMavEnumEntry
  ICAROUS_TRACK_BAND_TYPE_RECOVERY(2u),
  ;

  public companion object : MavEnum.MavCompanion<IcarousTrackBandTypes> {
    override fun getEntryFromValueOrNull(v: UInt): IcarousTrackBandTypes? = when (v) {
      0u -> ICAROUS_TRACK_BAND_TYPE_NONE
      1u -> ICAROUS_TRACK_BAND_TYPE_NEAR
      2u -> ICAROUS_TRACK_BAND_TYPE_RECOVERY
      else -> null
    }
  }
}

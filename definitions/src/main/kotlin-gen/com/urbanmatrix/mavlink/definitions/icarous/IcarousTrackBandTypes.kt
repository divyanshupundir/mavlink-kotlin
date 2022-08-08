package com.urbanmatrix.mavlink.definitions.icarous

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class IcarousTrackBandTypes(
  public override val `value`: Long,
) : MavEnum {
  ICAROUS_TRACK_BAND_TYPE_NONE(0L),
  ICAROUS_TRACK_BAND_TYPE_NEAR(1L),
  ICAROUS_TRACK_BAND_TYPE_RECOVERY(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): IcarousTrackBandTypes? = when (v) {
      0L -> ICAROUS_TRACK_BAND_TYPE_NONE
      1L -> ICAROUS_TRACK_BAND_TYPE_NEAR
      2L -> ICAROUS_TRACK_BAND_TYPE_RECOVERY
      else -> null
    }
  }
}

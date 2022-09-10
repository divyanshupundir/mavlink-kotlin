package xyz.urbanmatrix.mavlink.definitions.icarous

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class IcarousTrackBandTypes(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  ICAROUS_TRACK_BAND_TYPE_NONE(0L),
  @GeneratedMavEnumEntry
  ICAROUS_TRACK_BAND_TYPE_NEAR(1L),
  @GeneratedMavEnumEntry
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

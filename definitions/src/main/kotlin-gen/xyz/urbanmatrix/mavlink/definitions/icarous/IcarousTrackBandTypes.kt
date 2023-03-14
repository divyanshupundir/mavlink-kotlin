package xyz.urbanmatrix.mavlink.definitions.icarous

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class IcarousTrackBandTypes(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  ICAROUS_TRACK_BAND_TYPE_NONE(0u),
  @GeneratedMavEnumEntry
  ICAROUS_TRACK_BAND_TYPE_NEAR(1u),
  @GeneratedMavEnumEntry
  ICAROUS_TRACK_BAND_TYPE_RECOVERY(2u),
  ;

  public companion object : MavEnum.Companion<IcarousTrackBandTypes> {
    public override fun getEntryFromValueOrNull(v: UInt): IcarousTrackBandTypes? = when (v) {
      0u -> ICAROUS_TRACK_BAND_TYPE_NONE
      1u -> ICAROUS_TRACK_BAND_TYPE_NEAR
      2u -> ICAROUS_TRACK_BAND_TYPE_RECOVERY
      else -> null
    }
  }
}

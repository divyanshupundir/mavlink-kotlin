package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * GPS longitudinal offset encoding
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutCfgGpsOffsetLon(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  NO_DATA(0u),
  @GeneratedMavEnumEntry
  APPLIED_BY_SENSOR(1u),
  ;

  public companion object : MavEnum.Companion<UavionixAdsbOutCfgGpsOffsetLon> {
    public override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutCfgGpsOffsetLon? = when (v)
        {
      0u -> NO_DATA
      1u -> APPLIED_BY_SENSOR
      else -> null
    }
  }
}

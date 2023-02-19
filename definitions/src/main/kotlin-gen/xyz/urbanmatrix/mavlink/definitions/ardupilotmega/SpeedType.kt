package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class SpeedType(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  AIRSPEED(0u),
  @GeneratedMavEnumEntry
  GROUNDSPEED(1u),
  ;

  public companion object : MavEnum.Companion<SpeedType> {
    public override fun getEntryFromValueOrNull(v: UInt): SpeedType? = when (v) {
      0u -> AIRSPEED
      1u -> GROUNDSPEED
      else -> null
    }
  }
}

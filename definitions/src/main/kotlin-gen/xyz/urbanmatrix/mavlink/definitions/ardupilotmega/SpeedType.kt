package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class SpeedType(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  AIRSPEED(0L),
  @GeneratedMavEnumEntry
  GROUNDSPEED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): SpeedType? = when (v) {
      0L -> AIRSPEED
      1L -> GROUNDSPEED
      else -> null
    }
  }
}

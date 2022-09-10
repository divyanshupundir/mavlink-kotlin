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
  SPEED_TYPE_AIRSPEED(0L),
  @GeneratedMavEnumEntry
  SPEED_TYPE_GROUNDSPEED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): SpeedType? = when (v) {
      0L -> SPEED_TYPE_AIRSPEED
      1L -> SPEED_TYPE_GROUNDSPEED
      else -> null
    }
  }
}

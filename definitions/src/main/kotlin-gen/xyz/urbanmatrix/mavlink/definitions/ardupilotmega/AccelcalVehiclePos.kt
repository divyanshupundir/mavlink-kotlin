package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class AccelcalVehiclePos(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  LEVEL(1L),
  @GeneratedMavEnumEntry
  LEFT(2L),
  @GeneratedMavEnumEntry
  RIGHT(3L),
  @GeneratedMavEnumEntry
  NOSEDOWN(4L),
  @GeneratedMavEnumEntry
  NOSEUP(5L),
  @GeneratedMavEnumEntry
  BACK(6L),
  @GeneratedMavEnumEntry
  SUCCESS(16777215L),
  @GeneratedMavEnumEntry
  FAILED(16777216L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AccelcalVehiclePos? = when (v) {
      1L -> LEVEL
      2L -> LEFT
      3L -> RIGHT
      4L -> NOSEDOWN
      5L -> NOSEUP
      6L -> BACK
      16777215L -> SUCCESS
      16777216L -> FAILED
      else -> null
    }
  }
}

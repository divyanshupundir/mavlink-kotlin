package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class AccelcalVehiclePos(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  LEVEL(1u),
  @GeneratedMavEnumEntry
  LEFT(2u),
  @GeneratedMavEnumEntry
  RIGHT(3u),
  @GeneratedMavEnumEntry
  NOSEDOWN(4u),
  @GeneratedMavEnumEntry
  NOSEUP(5u),
  @GeneratedMavEnumEntry
  BACK(6u),
  @GeneratedMavEnumEntry
  SUCCESS(16_777_215u),
  @GeneratedMavEnumEntry
  FAILED(16_777_216u),
  ;

  public companion object : MavEnum.MavCompanion<AccelcalVehiclePos> {
    public override fun getEntryFromValueOrNull(v: UInt): AccelcalVehiclePos? = when (v) {
      1u -> LEVEL
      2u -> LEFT
      3u -> RIGHT
      4u -> NOSEDOWN
      5u -> NOSEUP
      6u -> BACK
      16777215u -> SUCCESS
      16777216u -> FAILED
      else -> null
    }
  }
}

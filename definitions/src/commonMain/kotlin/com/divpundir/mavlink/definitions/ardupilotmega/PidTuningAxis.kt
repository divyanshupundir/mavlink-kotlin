package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class PidTuningAxis(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  PID_TUNING_ROLL(1u),
  @GeneratedMavEnumEntry
  PID_TUNING_PITCH(2u),
  @GeneratedMavEnumEntry
  PID_TUNING_YAW(3u),
  @GeneratedMavEnumEntry
  PID_TUNING_ACCZ(4u),
  @GeneratedMavEnumEntry
  PID_TUNING_STEER(5u),
  @GeneratedMavEnumEntry
  PID_TUNING_LANDING(6u),
  ;

  public companion object : MavEnum.MavCompanion<PidTuningAxis> {
    public override fun getEntryFromValueOrNull(v: UInt): PidTuningAxis? = when (v) {
      1u -> PID_TUNING_ROLL
      2u -> PID_TUNING_PITCH
      3u -> PID_TUNING_YAW
      4u -> PID_TUNING_ACCZ
      5u -> PID_TUNING_STEER
      6u -> PID_TUNING_LANDING
      else -> null
    }
  }
}

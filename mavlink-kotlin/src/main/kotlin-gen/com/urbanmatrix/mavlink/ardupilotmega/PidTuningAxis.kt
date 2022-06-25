package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class PidTuningAxis(
  public override val `value`: Long,
) : MavEnum {
  PID_TUNING_ROLL(1L),
  PID_TUNING_PITCH(2L),
  PID_TUNING_YAW(3L),
  PID_TUNING_ACCZ(4L),
  PID_TUNING_STEER(5L),
  PID_TUNING_LANDING(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): PidTuningAxis? = when (v) {
      1L -> PID_TUNING_ROLL
      2L -> PID_TUNING_PITCH
      3L -> PID_TUNING_YAW
      4L -> PID_TUNING_ACCZ
      5L -> PID_TUNING_STEER
      6L -> PID_TUNING_LANDING
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
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

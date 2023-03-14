package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavModeGimbal(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Gimbal is powered on but has not started initializing yet.
   */
  @GeneratedMavEnumEntry
  UNINITIALIZED(0u),
  /**
   * Gimbal is currently running calibration on the pitch axis.
   */
  @GeneratedMavEnumEntry
  CALIBRATING_PITCH(1u),
  /**
   * Gimbal is currently running calibration on the roll axis.
   */
  @GeneratedMavEnumEntry
  CALIBRATING_ROLL(2u),
  /**
   * Gimbal is currently running calibration on the yaw axis.
   */
  @GeneratedMavEnumEntry
  CALIBRATING_YAW(3u),
  /**
   * Gimbal has finished calibrating and initializing, but is relaxed pending reception of first
   * rate command from copter.
   */
  @GeneratedMavEnumEntry
  INITIALIZED(4u),
  /**
   * Gimbal is actively stabilizing.
   */
  @GeneratedMavEnumEntry
  ACTIVE(5u),
  /**
   * Gimbal is relaxed because it missed more than 10 expected rate command messages in a row.
   * Gimbal will move back to active mode when it receives a new rate command.
   */
  @GeneratedMavEnumEntry
  RATE_CMD_TIMEOUT(6u),
  ;

  public companion object : MavEnum.Companion<MavModeGimbal> {
    public override fun getEntryFromValueOrNull(v: UInt): MavModeGimbal? = when (v) {
      0u -> UNINITIALIZED
      1u -> CALIBRATING_PITCH
      2u -> CALIBRATING_ROLL
      3u -> CALIBRATING_YAW
      4u -> INITIALIZED
      5u -> ACTIVE
      6u -> RATE_CMD_TIMEOUT
      else -> null
    }
  }
}

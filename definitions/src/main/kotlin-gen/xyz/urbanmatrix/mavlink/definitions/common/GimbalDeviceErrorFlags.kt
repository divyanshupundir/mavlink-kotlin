package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Gimbal device (low level) error flags (bitmap, 0 means no error)
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalDeviceErrorFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Gimbal device is limited by hardware roll limit.
   */
  @GeneratedMavEnumEntry
  AT_ROLL_LIMIT(1L),
  /**
   * Gimbal device is limited by hardware pitch limit.
   */
  @GeneratedMavEnumEntry
  AT_PITCH_LIMIT(2L),
  /**
   * Gimbal device is limited by hardware yaw limit.
   */
  @GeneratedMavEnumEntry
  AT_YAW_LIMIT(4L),
  /**
   * There is an error with the gimbal encoders.
   */
  @GeneratedMavEnumEntry
  ENCODER_ERROR(8L),
  /**
   * There is an error with the gimbal power source.
   */
  @GeneratedMavEnumEntry
  POWER_ERROR(16L),
  /**
   * There is an error with the gimbal motor's.
   */
  @GeneratedMavEnumEntry
  MOTOR_ERROR(32L),
  /**
   * There is an error with the gimbal's software.
   */
  @GeneratedMavEnumEntry
  SOFTWARE_ERROR(64L),
  /**
   * There is an error with the gimbal's communication.
   */
  @GeneratedMavEnumEntry
  COMMS_ERROR(128L),
  /**
   * Gimbal is currently calibrating.
   */
  @GeneratedMavEnumEntry
  CALIBRATION_RUNNING(256L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalDeviceErrorFlags? = when (v) {
      1L -> AT_ROLL_LIMIT
      2L -> AT_PITCH_LIMIT
      4L -> AT_YAW_LIMIT
      8L -> ENCODER_ERROR
      16L -> POWER_ERROR
      32L -> MOTOR_ERROR
      64L -> SOFTWARE_ERROR
      128L -> COMMS_ERROR
      256L -> CALIBRATION_RUNNING
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<GimbalDeviceErrorFlags> = buildList {
      if (v and 1L == 1L) add(AT_ROLL_LIMIT)
      if (v and 2L == 2L) add(AT_PITCH_LIMIT)
      if (v and 4L == 4L) add(AT_YAW_LIMIT)
      if (v and 8L == 8L) add(ENCODER_ERROR)
      if (v and 16L == 16L) add(POWER_ERROR)
      if (v and 32L == 32L) add(MOTOR_ERROR)
      if (v and 64L == 64L) add(SOFTWARE_ERROR)
      if (v and 128L == 128L) add(COMMS_ERROR)
      if (v and 256L == 256L) add(CALIBRATION_RUNNING)
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Gimbal device (low level) error flags (bitmap, 0 means no error)
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalDeviceErrorFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Gimbal device is limited by hardware roll limit.
   */
  @GeneratedMavEnumEntry
  AT_ROLL_LIMIT(1u),
  /**
   * Gimbal device is limited by hardware pitch limit.
   */
  @GeneratedMavEnumEntry
  AT_PITCH_LIMIT(2u),
  /**
   * Gimbal device is limited by hardware yaw limit.
   */
  @GeneratedMavEnumEntry
  AT_YAW_LIMIT(4u),
  /**
   * There is an error with the gimbal encoders.
   */
  @GeneratedMavEnumEntry
  ENCODER_ERROR(8u),
  /**
   * There is an error with the gimbal power source.
   */
  @GeneratedMavEnumEntry
  POWER_ERROR(16u),
  /**
   * There is an error with the gimbal motors.
   */
  @GeneratedMavEnumEntry
  MOTOR_ERROR(32u),
  /**
   * There is an error with the gimbal's software.
   */
  @GeneratedMavEnumEntry
  SOFTWARE_ERROR(64u),
  /**
   * There is an error with the gimbal's communication.
   */
  @GeneratedMavEnumEntry
  COMMS_ERROR(128u),
  /**
   * Gimbal device is currently calibrating.
   */
  @GeneratedMavEnumEntry
  CALIBRATION_RUNNING(256u),
  /**
   * Gimbal device is not assigned to a gimbal manager.
   */
  @GeneratedMavEnumEntry
  NO_MANAGER(512u),
  ;

  public companion object : MavBitmask.MavCompanion<GimbalDeviceErrorFlags> {
    override fun getEntryFromValueOrNull(v: UInt): GimbalDeviceErrorFlags? = when (v) {
      1u -> AT_ROLL_LIMIT
      2u -> AT_PITCH_LIMIT
      4u -> AT_YAW_LIMIT
      8u -> ENCODER_ERROR
      16u -> POWER_ERROR
      32u -> MOTOR_ERROR
      64u -> SOFTWARE_ERROR
      128u -> COMMS_ERROR
      256u -> CALIBRATION_RUNNING
      512u -> NO_MANAGER
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<GimbalDeviceErrorFlags> = buildList {
      if (v and 1u == 1u) add(AT_ROLL_LIMIT)
      if (v and 2u == 2u) add(AT_PITCH_LIMIT)
      if (v and 4u == 4u) add(AT_YAW_LIMIT)
      if (v and 8u == 8u) add(ENCODER_ERROR)
      if (v and 16u == 16u) add(POWER_ERROR)
      if (v and 32u == 32u) add(MOTOR_ERROR)
      if (v and 64u == 64u) add(SOFTWARE_ERROR)
      if (v and 128u == 128u) add(COMMS_ERROR)
      if (v and 256u == 256u) add(CALIBRATION_RUNNING)
      if (v and 512u == 512u) add(NO_MANAGER)
    }
  }
}

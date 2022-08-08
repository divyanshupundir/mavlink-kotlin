package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Flags for high level gimbal manager operation The first 16 bits are identical to the
 * GIMBAL_DEVICE_FLAGS.
 */
@GeneratedMavEnum
public enum class GimbalManagerFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Based on GIMBAL_DEVICE_FLAGS_RETRACT
   */
  GIMBAL_MANAGER_FLAGS_RETRACT(1L),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_NEUTRAL
   */
  GIMBAL_MANAGER_FLAGS_NEUTRAL(2L),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_ROLL_LOCK
   */
  GIMBAL_MANAGER_FLAGS_ROLL_LOCK(4L),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_PITCH_LOCK
   */
  GIMBAL_MANAGER_FLAGS_PITCH_LOCK(8L),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_YAW_LOCK
   */
  GIMBAL_MANAGER_FLAGS_YAW_LOCK(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalManagerFlags? = when (v) {
      1L -> GIMBAL_MANAGER_FLAGS_RETRACT
      2L -> GIMBAL_MANAGER_FLAGS_NEUTRAL
      4L -> GIMBAL_MANAGER_FLAGS_ROLL_LOCK
      8L -> GIMBAL_MANAGER_FLAGS_PITCH_LOCK
      16L -> GIMBAL_MANAGER_FLAGS_YAW_LOCK
      else -> null
    }
  }
}

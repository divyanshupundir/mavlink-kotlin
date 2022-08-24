package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Gimbal manager high level capability flags (bitmap). The first 16 bits are identical to the
 * GIMBAL_DEVICE_CAP_FLAGS. However, the gimbal manager does not need to copy the flags from the gimbal
 * but can also enhance the capabilities and thus add flags.
 */
@GeneratedMavEnum
public enum class GimbalManagerCapFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_RETRACT(1L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_NEUTRAL(2L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_AXIS(4L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_FOLLOW(8L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_LOCK(16L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_AXIS(32L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_FOLLOW(64L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_LOCK(128L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_AXIS(256L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_FOLLOW(512L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK.
   */
  GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_LOCK(1024L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW.
   */
  GIMBAL_MANAGER_CAP_FLAGS_SUPPORTS_INFINITE_YAW(2048L),
  /**
   * Gimbal manager supports to point to a local position.
   */
  GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_LOCAL(65536L),
  /**
   * Gimbal manager supports to point to a global latitude, longitude, altitude position.
   */
  GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_GLOBAL(131072L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalManagerCapFlags? = when (v) {
      1L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_RETRACT
      2L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_NEUTRAL
      4L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_AXIS
      8L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_FOLLOW
      16L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_LOCK
      32L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_AXIS
      64L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_FOLLOW
      128L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_LOCK
      256L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_AXIS
      512L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_FOLLOW
      1024L -> GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_LOCK
      2048L -> GIMBAL_MANAGER_CAP_FLAGS_SUPPORTS_INFINITE_YAW
      65536L -> GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_LOCAL
      131072L -> GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_GLOBAL
      else -> null
    }
  }
}

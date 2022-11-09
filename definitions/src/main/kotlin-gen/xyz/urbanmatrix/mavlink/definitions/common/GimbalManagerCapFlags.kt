package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Gimbal manager high level capability flags (bitmap). The first 16 bits are identical to the
 * GIMBAL_DEVICE_CAP_FLAGS. However, the gimbal manager does not need to copy the flags from the gimbal
 * but can also enhance the capabilities and thus add flags.
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalManagerCapFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_RETRACT(1L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_NEUTRAL(2L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_AXIS(4L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_FOLLOW(8L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_LOCK(16L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_AXIS(32L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_FOLLOW(64L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_LOCK(128L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_AXIS(256L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_FOLLOW(512L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_LOCK(1024L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_SUPPORTS_INFINITE_YAW(2048L),
  /**
   * Gimbal manager supports to point to a local position.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_LOCAL(65536L),
  /**
   * Gimbal manager supports to point to a global latitude, longitude, altitude position.
   */
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<GimbalManagerCapFlags> = buildList {
      if (v and 1L == 1L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_RETRACT)
      if (v and 2L == 2L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_NEUTRAL)
      if (v and 4L == 4L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_AXIS)
      if (v and 8L == 8L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_FOLLOW)
      if (v and 16L == 16L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_LOCK)
      if (v and 32L == 32L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_AXIS)
      if (v and 64L == 64L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_FOLLOW)
      if (v and 128L == 128L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_LOCK)
      if (v and 256L == 256L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_AXIS)
      if (v and 512L == 512L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_FOLLOW)
      if (v and 1024L == 1024L) add(GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_LOCK)
      if (v and 2048L == 2048L) add(GIMBAL_MANAGER_CAP_FLAGS_SUPPORTS_INFINITE_YAW)
      if (v and 65536L == 65536L) add(GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_LOCAL)
      if (v and 131072L == 131072L) add(GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_GLOBAL)
    }
  }
}

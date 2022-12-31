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
  HAS_RETRACT(1L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL.
   */
  @GeneratedMavEnumEntry
  HAS_NEUTRAL(2L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS.
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_AXIS(4L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW.
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_FOLLOW(8L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK.
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_LOCK(16L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS.
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_AXIS(32L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW.
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_FOLLOW(64L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK.
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_LOCK(128L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS.
   */
  @GeneratedMavEnumEntry
  HAS_YAW_AXIS(256L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW.
   */
  @GeneratedMavEnumEntry
  HAS_YAW_FOLLOW(512L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK.
   */
  @GeneratedMavEnumEntry
  HAS_YAW_LOCK(1024L),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW.
   */
  @GeneratedMavEnumEntry
  SUPPORTS_INFINITE_YAW(2048L),
  /**
   * Gimbal manager supports to point to a local position.
   */
  @GeneratedMavEnumEntry
  CAN_POINT_LOCATION_LOCAL(65536L),
  /**
   * Gimbal manager supports to point to a global latitude, longitude, altitude position.
   */
  @GeneratedMavEnumEntry
  CAN_POINT_LOCATION_GLOBAL(131072L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalManagerCapFlags? = when (v) {
      1L -> HAS_RETRACT
      2L -> HAS_NEUTRAL
      4L -> HAS_ROLL_AXIS
      8L -> HAS_ROLL_FOLLOW
      16L -> HAS_ROLL_LOCK
      32L -> HAS_PITCH_AXIS
      64L -> HAS_PITCH_FOLLOW
      128L -> HAS_PITCH_LOCK
      256L -> HAS_YAW_AXIS
      512L -> HAS_YAW_FOLLOW
      1024L -> HAS_YAW_LOCK
      2048L -> SUPPORTS_INFINITE_YAW
      65536L -> CAN_POINT_LOCATION_LOCAL
      131072L -> CAN_POINT_LOCATION_GLOBAL
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<GimbalManagerCapFlags> = buildList {
      if (v and 1L == 1L) add(HAS_RETRACT)
      if (v and 2L == 2L) add(HAS_NEUTRAL)
      if (v and 4L == 4L) add(HAS_ROLL_AXIS)
      if (v and 8L == 8L) add(HAS_ROLL_FOLLOW)
      if (v and 16L == 16L) add(HAS_ROLL_LOCK)
      if (v and 32L == 32L) add(HAS_PITCH_AXIS)
      if (v and 64L == 64L) add(HAS_PITCH_FOLLOW)
      if (v and 128L == 128L) add(HAS_PITCH_LOCK)
      if (v and 256L == 256L) add(HAS_YAW_AXIS)
      if (v and 512L == 512L) add(HAS_YAW_FOLLOW)
      if (v and 1024L == 1024L) add(HAS_YAW_LOCK)
      if (v and 2048L == 2048L) add(SUPPORTS_INFINITE_YAW)
      if (v and 65536L == 65536L) add(CAN_POINT_LOCATION_LOCAL)
      if (v and 131072L == 131072L) add(CAN_POINT_LOCATION_GLOBAL)
    }
  }
}

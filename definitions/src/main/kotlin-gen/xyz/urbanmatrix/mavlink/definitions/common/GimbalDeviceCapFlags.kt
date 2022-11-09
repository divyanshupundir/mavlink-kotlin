package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Gimbal device (low level) capability flags (bitmap)
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalDeviceCapFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Gimbal device supports a retracted position
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT(1L),
  /**
   * Gimbal device supports a horizontal, forward looking position, stabilized
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL(2L),
  /**
   * Gimbal device supports rotating around roll axis.
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS(4L),
  /**
   * Gimbal device supports to follow a roll angle relative to the vehicle
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW(8L),
  /**
   * Gimbal device supports locking to an roll angle (generally that's the default with roll
   * stabilized)
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK(16L),
  /**
   * Gimbal device supports rotating around pitch axis.
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS(32L),
  /**
   * Gimbal device supports to follow a pitch angle relative to the vehicle
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW(64L),
  /**
   * Gimbal device supports locking to an pitch angle (generally that's the default with pitch
   * stabilized)
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK(128L),
  /**
   * Gimbal device supports rotating around yaw axis.
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS(256L),
  /**
   * Gimbal device supports to follow a yaw angle relative to the vehicle (generally that's the
   * default)
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW(512L),
  /**
   * Gimbal device supports locking to an absolute heading (often this is an option available)
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK(1024L),
  /**
   * Gimbal device supports yawing/panning infinetely (e.g. using slip disk).
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW(2048L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalDeviceCapFlags? = when (v) {
      1L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT
      2L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL
      4L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS
      8L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW
      16L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK
      32L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS
      64L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW
      128L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK
      256L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS
      512L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW
      1024L -> GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK
      2048L -> GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<GimbalDeviceCapFlags> = buildList {
      if (v and 1L == 1L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT)
      if (v and 2L == 2L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL)
      if (v and 4L == 4L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS)
      if (v and 8L == 8L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW)
      if (v and 16L == 16L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK)
      if (v and 32L == 32L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS)
      if (v and 64L == 64L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW)
      if (v and 128L == 128L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK)
      if (v and 256L == 256L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS)
      if (v and 512L == 512L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW)
      if (v and 1024L == 1024L) add(GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK)
      if (v and 2048L == 2048L) add(GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW)
    }
  }
}

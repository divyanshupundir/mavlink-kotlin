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
  HAS_RETRACT(1L),
  /**
   * Gimbal device supports a horizontal, forward looking position, stabilized
   */
  @GeneratedMavEnumEntry
  HAS_NEUTRAL(2L),
  /**
   * Gimbal device supports rotating around roll axis.
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_AXIS(4L),
  /**
   * Gimbal device supports to follow a roll angle relative to the vehicle
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_FOLLOW(8L),
  /**
   * Gimbal device supports locking to an roll angle (generally that's the default with roll
   * stabilized)
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_LOCK(16L),
  /**
   * Gimbal device supports rotating around pitch axis.
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_AXIS(32L),
  /**
   * Gimbal device supports to follow a pitch angle relative to the vehicle
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_FOLLOW(64L),
  /**
   * Gimbal device supports locking to an pitch angle (generally that's the default with pitch
   * stabilized)
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_LOCK(128L),
  /**
   * Gimbal device supports rotating around yaw axis.
   */
  @GeneratedMavEnumEntry
  HAS_YAW_AXIS(256L),
  /**
   * Gimbal device supports to follow a yaw angle relative to the vehicle (generally that's the
   * default)
   */
  @GeneratedMavEnumEntry
  HAS_YAW_FOLLOW(512L),
  /**
   * Gimbal device supports locking to an absolute heading (often this is an option available)
   */
  @GeneratedMavEnumEntry
  HAS_YAW_LOCK(1024L),
  /**
   * Gimbal device supports yawing/panning infinetely (e.g. using slip disk).
   */
  @GeneratedMavEnumEntry
  SUPPORTS_INFINITE_YAW(2048L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalDeviceCapFlags? = when (v) {
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
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<GimbalDeviceCapFlags> = buildList {
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
    }
  }
}

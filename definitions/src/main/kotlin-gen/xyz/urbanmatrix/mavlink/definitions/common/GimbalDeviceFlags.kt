package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Flags for gimbal device (lower level) operation.
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalDeviceFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Set to retracted safe position (no stabilization), takes presedence over all other flags.
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_FLAGS_RETRACT(1L),
  /**
   * Set to neutral/default position, taking precedence over all other flags except RETRACT. Neutral
   * is commonly forward-facing and horizontal (pitch=yaw=0) but may be any orientation.
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_FLAGS_NEUTRAL(2L),
  /**
   * Lock roll angle to absolute angle relative to horizon (not relative to drone). This is
   * generally the default with a stabilizing gimbal.
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_FLAGS_ROLL_LOCK(4L),
  /**
   * Lock pitch angle to absolute angle relative to horizon (not relative to drone). This is
   * generally the default.
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_FLAGS_PITCH_LOCK(8L),
  /**
   * Lock yaw angle to absolute angle relative to North (not relative to drone). If this flag is
   * set, the quaternion is in the Earth frame with the x-axis pointing North (yaw absolute). If this
   * flag is not set, the quaternion frame is in the Earth frame rotated so that the x-axis is pointing
   * forward (yaw relative to vehicle).
   */
  @GeneratedMavEnumEntry
  GIMBAL_DEVICE_FLAGS_YAW_LOCK(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalDeviceFlags? = when (v) {
      1L -> GIMBAL_DEVICE_FLAGS_RETRACT
      2L -> GIMBAL_DEVICE_FLAGS_NEUTRAL
      4L -> GIMBAL_DEVICE_FLAGS_ROLL_LOCK
      8L -> GIMBAL_DEVICE_FLAGS_PITCH_LOCK
      16L -> GIMBAL_DEVICE_FLAGS_YAW_LOCK
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<GimbalDeviceFlags> = buildList {
      if (v and 1L == 1L) add(GIMBAL_DEVICE_FLAGS_RETRACT)
      if (v and 2L == 2L) add(GIMBAL_DEVICE_FLAGS_NEUTRAL)
      if (v and 4L == 4L) add(GIMBAL_DEVICE_FLAGS_ROLL_LOCK)
      if (v and 8L == 8L) add(GIMBAL_DEVICE_FLAGS_PITCH_LOCK)
      if (v and 16L == 16L) add(GIMBAL_DEVICE_FLAGS_YAW_LOCK)
    }
  }
}

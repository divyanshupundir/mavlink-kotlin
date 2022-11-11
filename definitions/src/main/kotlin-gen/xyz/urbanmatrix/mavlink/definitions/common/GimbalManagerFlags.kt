package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Flags for high level gimbal manager operation The first 16 bits are identical to the
 * GIMBAL_DEVICE_FLAGS.
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalManagerFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Based on GIMBAL_DEVICE_FLAGS_RETRACT
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_FLAGS_RETRACT(1L),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_NEUTRAL
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_FLAGS_NEUTRAL(2L),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_ROLL_LOCK
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_FLAGS_ROLL_LOCK(4L),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_PITCH_LOCK
   */
  @GeneratedMavEnumEntry
  GIMBAL_MANAGER_FLAGS_PITCH_LOCK(8L),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_YAW_LOCK
   */
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<GimbalManagerFlags> = buildList {
      if (v and 1L == 1L) add(GIMBAL_MANAGER_FLAGS_RETRACT)
      if (v and 2L == 2L) add(GIMBAL_MANAGER_FLAGS_NEUTRAL)
      if (v and 4L == 4L) add(GIMBAL_MANAGER_FLAGS_ROLL_LOCK)
      if (v and 8L == 8L) add(GIMBAL_MANAGER_FLAGS_PITCH_LOCK)
      if (v and 16L == 16L) add(GIMBAL_MANAGER_FLAGS_YAW_LOCK)
    }
  }
}

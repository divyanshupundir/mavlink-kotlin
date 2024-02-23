package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags for high level gimbal manager operation The first 16 bits are identical to the
 * GIMBAL_DEVICE_FLAGS.
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalManagerFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Based on GIMBAL_DEVICE_FLAGS_RETRACT.
   */
  @GeneratedMavEnumEntry
  RETRACT(1u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_NEUTRAL.
   */
  @GeneratedMavEnumEntry
  NEUTRAL(2u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_ROLL_LOCK.
   */
  @GeneratedMavEnumEntry
  ROLL_LOCK(4u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_PITCH_LOCK.
   */
  @GeneratedMavEnumEntry
  PITCH_LOCK(8u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_YAW_LOCK.
   */
  @GeneratedMavEnumEntry
  YAW_LOCK(16u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME.
   */
  @GeneratedMavEnumEntry
  YAW_IN_VEHICLE_FRAME(32u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME.
   */
  @GeneratedMavEnumEntry
  YAW_IN_EARTH_FRAME(64u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_ACCEPTS_YAW_IN_EARTH_FRAME.
   */
  @GeneratedMavEnumEntry
  ACCEPTS_YAW_IN_EARTH_FRAME(128u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_RC_EXCLUSIVE.
   */
  @GeneratedMavEnumEntry
  RC_EXCLUSIVE(256u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_RC_MIXED.
   */
  @GeneratedMavEnumEntry
  RC_MIXED(512u),
  ;

  public companion object : MavBitmask.MavCompanion<GimbalManagerFlags> {
    override fun getEntryFromValueOrNull(v: UInt): GimbalManagerFlags? = when (v) {
      1u -> RETRACT
      2u -> NEUTRAL
      4u -> ROLL_LOCK
      8u -> PITCH_LOCK
      16u -> YAW_LOCK
      32u -> YAW_IN_VEHICLE_FRAME
      64u -> YAW_IN_EARTH_FRAME
      128u -> ACCEPTS_YAW_IN_EARTH_FRAME
      256u -> RC_EXCLUSIVE
      512u -> RC_MIXED
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<GimbalManagerFlags> = buildList {
      if (v and 1u == 1u) add(RETRACT)
      if (v and 2u == 2u) add(NEUTRAL)
      if (v and 4u == 4u) add(ROLL_LOCK)
      if (v and 8u == 8u) add(PITCH_LOCK)
      if (v and 16u == 16u) add(YAW_LOCK)
      if (v and 32u == 32u) add(YAW_IN_VEHICLE_FRAME)
      if (v and 64u == 64u) add(YAW_IN_EARTH_FRAME)
      if (v and 128u == 128u) add(ACCEPTS_YAW_IN_EARTH_FRAME)
      if (v and 256u == 256u) add(RC_EXCLUSIVE)
      if (v and 512u == 512u) add(RC_MIXED)
    }
  }
}

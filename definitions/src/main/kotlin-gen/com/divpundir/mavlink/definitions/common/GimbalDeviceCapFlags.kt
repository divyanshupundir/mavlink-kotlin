package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Gimbal device (low level) capability flags (bitmap)
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalDeviceCapFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * Gimbal device supports a retracted position
   */
  @GeneratedMavEnumEntry
  HAS_RETRACT(1u),
  /**
   * Gimbal device supports a horizontal, forward looking position, stabilized
   */
  @GeneratedMavEnumEntry
  HAS_NEUTRAL(2u),
  /**
   * Gimbal device supports rotating around roll axis.
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_AXIS(4u),
  /**
   * Gimbal device supports to follow a roll angle relative to the vehicle
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_FOLLOW(8u),
  /**
   * Gimbal device supports locking to an roll angle (generally that's the default with roll
   * stabilized)
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_LOCK(16u),
  /**
   * Gimbal device supports rotating around pitch axis.
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_AXIS(32u),
  /**
   * Gimbal device supports to follow a pitch angle relative to the vehicle
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_FOLLOW(64u),
  /**
   * Gimbal device supports locking to an pitch angle (generally that's the default with pitch
   * stabilized)
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_LOCK(128u),
  /**
   * Gimbal device supports rotating around yaw axis.
   */
  @GeneratedMavEnumEntry
  HAS_YAW_AXIS(256u),
  /**
   * Gimbal device supports to follow a yaw angle relative to the vehicle (generally that's the
   * default)
   */
  @GeneratedMavEnumEntry
  HAS_YAW_FOLLOW(512u),
  /**
   * Gimbal device supports locking to an absolute heading (often this is an option available)
   */
  @GeneratedMavEnumEntry
  HAS_YAW_LOCK(1_024u),
  /**
   * Gimbal device supports yawing/panning infinetely (e.g. using slip disk).
   */
  @GeneratedMavEnumEntry
  SUPPORTS_INFINITE_YAW(2_048u),
  ;

  public companion object : MavBitmask.MavCompanion<GimbalDeviceCapFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): GimbalDeviceCapFlags? = when (v) {
      1u -> HAS_RETRACT
      2u -> HAS_NEUTRAL
      4u -> HAS_ROLL_AXIS
      8u -> HAS_ROLL_FOLLOW
      16u -> HAS_ROLL_LOCK
      32u -> HAS_PITCH_AXIS
      64u -> HAS_PITCH_FOLLOW
      128u -> HAS_PITCH_LOCK
      256u -> HAS_YAW_AXIS
      512u -> HAS_YAW_FOLLOW
      1024u -> HAS_YAW_LOCK
      2048u -> SUPPORTS_INFINITE_YAW
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<GimbalDeviceCapFlags> = buildList {
      if (v and 1u == 1u) add(HAS_RETRACT)
      if (v and 2u == 2u) add(HAS_NEUTRAL)
      if (v and 4u == 4u) add(HAS_ROLL_AXIS)
      if (v and 8u == 8u) add(HAS_ROLL_FOLLOW)
      if (v and 16u == 16u) add(HAS_ROLL_LOCK)
      if (v and 32u == 32u) add(HAS_PITCH_AXIS)
      if (v and 64u == 64u) add(HAS_PITCH_FOLLOW)
      if (v and 128u == 128u) add(HAS_PITCH_LOCK)
      if (v and 256u == 256u) add(HAS_YAW_AXIS)
      if (v and 512u == 512u) add(HAS_YAW_FOLLOW)
      if (v and 1024u == 1024u) add(HAS_YAW_LOCK)
      if (v and 2048u == 2048u) add(SUPPORTS_INFINITE_YAW)
    }
  }
}

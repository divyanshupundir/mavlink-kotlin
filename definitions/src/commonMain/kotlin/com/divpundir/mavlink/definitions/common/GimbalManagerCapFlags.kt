package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Gimbal manager high level capability flags (bitmap). The first 16 bits are identical to the
 * GIMBAL_DEVICE_CAP_FLAGS. However, the gimbal manager does not need to copy the flags from the gimbal
 * but can also enhance the capabilities and thus add flags.
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalManagerCapFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT.
   */
  @GeneratedMavEnumEntry
  HAS_RETRACT(1u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL.
   */
  @GeneratedMavEnumEntry
  HAS_NEUTRAL(2u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS.
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_AXIS(4u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW.
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_FOLLOW(8u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK.
   */
  @GeneratedMavEnumEntry
  HAS_ROLL_LOCK(16u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS.
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_AXIS(32u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW.
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_FOLLOW(64u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK.
   */
  @GeneratedMavEnumEntry
  HAS_PITCH_LOCK(128u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS.
   */
  @GeneratedMavEnumEntry
  HAS_YAW_AXIS(256u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW.
   */
  @GeneratedMavEnumEntry
  HAS_YAW_FOLLOW(512u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK.
   */
  @GeneratedMavEnumEntry
  HAS_YAW_LOCK(1_024u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW.
   */
  @GeneratedMavEnumEntry
  SUPPORTS_INFINITE_YAW(2_048u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_YAW_IN_EARTH_FRAME.
   */
  @GeneratedMavEnumEntry
  SUPPORTS_YAW_IN_EARTH_FRAME(4_096u),
  /**
   * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RC_INPUTS.
   */
  @GeneratedMavEnumEntry
  HAS_RC_INPUTS(8_192u),
  /**
   * Gimbal manager supports to point to a local position.
   */
  @GeneratedMavEnumEntry
  CAN_POINT_LOCATION_LOCAL(65_536u),
  /**
   * Gimbal manager supports to point to a global latitude, longitude, altitude position.
   */
  @GeneratedMavEnumEntry
  CAN_POINT_LOCATION_GLOBAL(131_072u),
  ;

  public companion object : MavBitmask.MavCompanion<GimbalManagerCapFlags> {
    override fun getEntryFromValueOrNull(v: UInt): GimbalManagerCapFlags? = when (v) {
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
      4096u -> SUPPORTS_YAW_IN_EARTH_FRAME
      8192u -> HAS_RC_INPUTS
      65536u -> CAN_POINT_LOCATION_LOCAL
      131072u -> CAN_POINT_LOCATION_GLOBAL
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<GimbalManagerCapFlags> = buildList {
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
      if (v and 4096u == 4096u) add(SUPPORTS_YAW_IN_EARTH_FRAME)
      if (v and 8192u == 8192u) add(HAS_RC_INPUTS)
      if (v and 65536u == 65536u) add(CAN_POINT_LOCATION_LOCAL)
      if (v and 131072u == 131072u) add(CAN_POINT_LOCATION_GLOBAL)
    }
  }
}

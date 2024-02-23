package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags for gimbal device (lower level) operation.
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalDeviceFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Set to retracted safe position (no stabilization), takes precedence over all other flags.
   */
  @GeneratedMavEnumEntry
  RETRACT(1u),
  /**
   * Set to neutral/default position, taking precedence over all other flags except RETRACT. Neutral
   * is commonly forward-facing and horizontal (roll=pitch=yaw=0) but may be any orientation.
   */
  @GeneratedMavEnumEntry
  NEUTRAL(2u),
  /**
   * Lock roll angle to absolute angle relative to horizon (not relative to vehicle). This is
   * generally the default with a stabilizing gimbal.
   */
  @GeneratedMavEnumEntry
  ROLL_LOCK(4u),
  /**
   * Lock pitch angle to absolute angle relative to horizon (not relative to vehicle). This is
   * generally the default with a stabilizing gimbal.
   */
  @GeneratedMavEnumEntry
  PITCH_LOCK(8u),
  /**
   * Lock yaw angle to absolute angle relative to North (not relative to vehicle). If this flag is
   * set, the yaw angle and z component of angular velocity are relative to North (earth frame, x-axis
   * pointing North), else they are relative to the vehicle heading (vehicle frame, earth frame rotated
   * so that the x-axis is pointing forward).
   */
  @GeneratedMavEnumEntry
  YAW_LOCK(16u),
  /**
   * Yaw angle and z component of angular velocity are relative to the vehicle heading (vehicle
   * frame, earth frame rotated such that the x-axis is pointing forward).
   */
  @GeneratedMavEnumEntry
  YAW_IN_VEHICLE_FRAME(32u),
  /**
   * Yaw angle and z component of angular velocity are relative to North (earth frame, x-axis is
   * pointing North).
   */
  @GeneratedMavEnumEntry
  YAW_IN_EARTH_FRAME(64u),
  /**
   * Gimbal device can accept yaw angle inputs relative to North (earth frame). This flag is only
   * for reporting (attempts to set this flag are ignored).
   */
  @GeneratedMavEnumEntry
  ACCEPTS_YAW_IN_EARTH_FRAME(128u),
  /**
   * The gimbal orientation is set exclusively by the RC signals feed to the gimbal's radio control
   * inputs. MAVLink messages for setting the gimbal orientation (GIMBAL_DEVICE_SET_ATTITUDE) are
   * ignored.
   */
  @GeneratedMavEnumEntry
  RC_EXCLUSIVE(256u),
  /**
   * The gimbal orientation is determined by combining/mixing the RC signals feed to the gimbal's
   * radio control inputs and the MAVLink messages for setting the gimbal orientation
   * (GIMBAL_DEVICE_SET_ATTITUDE). How these two controls are combined or mixed is not defined by the
   * protocol but is up to the implementation.
   */
  @GeneratedMavEnumEntry
  RC_MIXED(512u),
  ;

  public companion object : MavBitmask.MavCompanion<GimbalDeviceFlags> {
    override fun getEntryFromValueOrNull(v: UInt): GimbalDeviceFlags? = when (v) {
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

    override fun getFlagsFromValue(v: UInt): List<GimbalDeviceFlags> = buildList {
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

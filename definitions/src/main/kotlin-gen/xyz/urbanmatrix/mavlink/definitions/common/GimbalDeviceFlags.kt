package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags for gimbal device (lower level) operation.
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalDeviceFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * Set to retracted safe position (no stabilization), takes presedence over all other flags.
   */
  @GeneratedMavEnumEntry
  RETRACT(1u),
  /**
   * Set to neutral/default position, taking precedence over all other flags except RETRACT. Neutral
   * is commonly forward-facing and horizontal (pitch=yaw=0) but may be any orientation.
   */
  @GeneratedMavEnumEntry
  NEUTRAL(2u),
  /**
   * Lock roll angle to absolute angle relative to horizon (not relative to drone). This is
   * generally the default with a stabilizing gimbal.
   */
  @GeneratedMavEnumEntry
  ROLL_LOCK(4u),
  /**
   * Lock pitch angle to absolute angle relative to horizon (not relative to drone). This is
   * generally the default.
   */
  @GeneratedMavEnumEntry
  PITCH_LOCK(8u),
  /**
   * Lock yaw angle to absolute angle relative to North (not relative to drone). If this flag is
   * set, the quaternion is in the Earth frame with the x-axis pointing North (yaw absolute). If this
   * flag is not set, the quaternion frame is in the Earth frame rotated so that the x-axis is pointing
   * forward (yaw relative to vehicle).
   */
  @GeneratedMavEnumEntry
  YAW_LOCK(16u),
  ;

  public companion object : MavEnum.Companion<GimbalDeviceFlags>,
      MavBitmask.Companion<GimbalDeviceFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): GimbalDeviceFlags? = when (v) {
      1u -> RETRACT
      2u -> NEUTRAL
      4u -> ROLL_LOCK
      8u -> PITCH_LOCK
      16u -> YAW_LOCK
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<GimbalDeviceFlags> = buildList {
      if (v and 1u == 1u) add(RETRACT)
      if (v and 2u == 2u) add(NEUTRAL)
      if (v and 4u == 4u) add(ROLL_LOCK)
      if (v and 8u == 8u) add(PITCH_LOCK)
      if (v and 16u == 16u) add(YAW_LOCK)
    }
  }
}

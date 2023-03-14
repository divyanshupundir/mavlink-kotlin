package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags for high level gimbal manager operation The first 16 bits are identical to the
 * GIMBAL_DEVICE_FLAGS.
 */
@GeneratedMavEnum(bitmask = true)
public enum class GimbalManagerFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * Based on GIMBAL_DEVICE_FLAGS_RETRACT
   */
  @GeneratedMavEnumEntry
  RETRACT(1u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_NEUTRAL
   */
  @GeneratedMavEnumEntry
  NEUTRAL(2u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_ROLL_LOCK
   */
  @GeneratedMavEnumEntry
  ROLL_LOCK(4u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_PITCH_LOCK
   */
  @GeneratedMavEnumEntry
  PITCH_LOCK(8u),
  /**
   * Based on GIMBAL_DEVICE_FLAGS_YAW_LOCK
   */
  @GeneratedMavEnumEntry
  YAW_LOCK(16u),
  ;

  public companion object : MavEnum.Companion<GimbalManagerFlags>,
      MavBitmask.Companion<GimbalManagerFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): GimbalManagerFlags? = when (v) {
      1u -> RETRACT
      2u -> NEUTRAL
      4u -> ROLL_LOCK
      8u -> PITCH_LOCK
      16u -> YAW_LOCK
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<GimbalManagerFlags> = buildList {
      if (v and 1u == 1u) add(RETRACT)
      if (v and 2u == 2u) add(NEUTRAL)
      if (v and 4u == 4u) add(ROLL_LOCK)
      if (v and 8u == 8u) add(PITCH_LOCK)
      if (v and 16u == 16u) add(YAW_LOCK)
    }
  }
}

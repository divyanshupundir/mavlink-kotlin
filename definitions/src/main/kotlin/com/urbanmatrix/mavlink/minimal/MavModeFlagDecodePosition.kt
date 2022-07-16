package com.urbanmatrix.mavlink.minimal

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * These values encode the bit positions of the decode position. These values can be used to read
 * the value of a flag bit by combining the base_mode variable with AND with the flag position value.
 * The result will be either 0 or 1, depending on if the flag is set or not.
 */
public enum class MavModeFlagDecodePosition(
  public override val `value`: Long,
) : MavEnum {
  /**
   * First bit:  10000000
   */
  MAV_MODE_FLAG_DECODE_POSITION_SAFETY(128L),
  /**
   * Second bit: 01000000
   */
  MAV_MODE_FLAG_DECODE_POSITION_MANUAL(64L),
  /**
   * Third bit:  00100000
   */
  MAV_MODE_FLAG_DECODE_POSITION_HIL(32L),
  /**
   * Fourth bit: 00010000
   */
  MAV_MODE_FLAG_DECODE_POSITION_STABILIZE(16L),
  /**
   * Fifth bit:  00001000
   */
  MAV_MODE_FLAG_DECODE_POSITION_GUIDED(8L),
  /**
   * Sixth bit:   00000100
   */
  MAV_MODE_FLAG_DECODE_POSITION_AUTO(4L),
  /**
   * Seventh bit: 00000010
   */
  MAV_MODE_FLAG_DECODE_POSITION_TEST(2L),
  /**
   * Eighth bit: 00000001
   */
  MAV_MODE_FLAG_DECODE_POSITION_CUSTOM_MODE(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavModeFlagDecodePosition? = when (v) {
      128L -> MAV_MODE_FLAG_DECODE_POSITION_SAFETY
      64L -> MAV_MODE_FLAG_DECODE_POSITION_MANUAL
      32L -> MAV_MODE_FLAG_DECODE_POSITION_HIL
      16L -> MAV_MODE_FLAG_DECODE_POSITION_STABILIZE
      8L -> MAV_MODE_FLAG_DECODE_POSITION_GUIDED
      4L -> MAV_MODE_FLAG_DECODE_POSITION_AUTO
      2L -> MAV_MODE_FLAG_DECODE_POSITION_TEST
      1L -> MAV_MODE_FLAG_DECODE_POSITION_CUSTOM_MODE
      else -> null
    }
  }
}

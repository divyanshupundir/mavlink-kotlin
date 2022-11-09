package xyz.urbanmatrix.mavlink.definitions.minimal

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * These values encode the bit positions of the decode position. These values can be used to read
 * the value of a flag bit by combining the base_mode variable with AND with the flag position value.
 * The result will be either 0 or 1, depending on if the flag is set or not.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavModeFlagDecodePosition(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * First bit:  10000000
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_DECODE_POSITION_SAFETY(128L),
  /**
   * Second bit: 01000000
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_DECODE_POSITION_MANUAL(64L),
  /**
   * Third bit:  00100000
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_DECODE_POSITION_HIL(32L),
  /**
   * Fourth bit: 00010000
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_DECODE_POSITION_STABILIZE(16L),
  /**
   * Fifth bit:  00001000
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_DECODE_POSITION_GUIDED(8L),
  /**
   * Sixth bit:   00000100
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_DECODE_POSITION_AUTO(4L),
  /**
   * Seventh bit: 00000010
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_DECODE_POSITION_TEST(2L),
  /**
   * Eighth bit: 00000001
   */
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<MavModeFlagDecodePosition> = buildList {
      if (v and 128L == 128L) add(MAV_MODE_FLAG_DECODE_POSITION_SAFETY)
      if (v and 64L == 64L) add(MAV_MODE_FLAG_DECODE_POSITION_MANUAL)
      if (v and 32L == 32L) add(MAV_MODE_FLAG_DECODE_POSITION_HIL)
      if (v and 16L == 16L) add(MAV_MODE_FLAG_DECODE_POSITION_STABILIZE)
      if (v and 8L == 8L) add(MAV_MODE_FLAG_DECODE_POSITION_GUIDED)
      if (v and 4L == 4L) add(MAV_MODE_FLAG_DECODE_POSITION_AUTO)
      if (v and 2L == 2L) add(MAV_MODE_FLAG_DECODE_POSITION_TEST)
      if (v and 1L == 1L) add(MAV_MODE_FLAG_DECODE_POSITION_CUSTOM_MODE)
    }
  }
}

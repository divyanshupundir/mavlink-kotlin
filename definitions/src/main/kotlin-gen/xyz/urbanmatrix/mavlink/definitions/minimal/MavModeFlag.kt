package xyz.urbanmatrix.mavlink.definitions.minimal

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * These flags encode the MAV mode.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavModeFlag(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * 0b10000000 MAV safety set to armed. Motors are enabled / running / can start. Ready to fly.
   * Additional note: this flag is to be ignore when sent in the command MAV_CMD_DO_SET_MODE and
   * MAV_CMD_COMPONENT_ARM_DISARM shall be used instead. The flag can still be used to report the armed
   * state.
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_SAFETY_ARMED(128L),
  /**
   * 0b01000000 remote control input is enabled.
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_MANUAL_INPUT_ENABLED(64L),
  /**
   * 0b00100000 hardware in the loop simulation. All motors / actuators are blocked, but internal
   * software is full operational.
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_HIL_ENABLED(32L),
  /**
   * 0b00010000 system stabilizes electronically its attitude (and optionally position). It needs
   * however further control inputs to move around.
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_STABILIZE_ENABLED(16L),
  /**
   * 0b00001000 guided mode enabled, system flies waypoints / mission items.
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_GUIDED_ENABLED(8L),
  /**
   * 0b00000100 autonomous mode enabled, system finds its own goal positions. Guided flag can be set
   * or not, depends on the actual implementation.
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_AUTO_ENABLED(4L),
  /**
   * 0b00000010 system has a test mode enabled. This flag is intended for temporary system tests and
   * should not be used for stable implementations.
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_TEST_ENABLED(2L),
  /**
   * 0b00000001 Reserved for future use.
   */
  @GeneratedMavEnumEntry
  MAV_MODE_FLAG_CUSTOM_MODE_ENABLED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavModeFlag? = when (v) {
      128L -> MAV_MODE_FLAG_SAFETY_ARMED
      64L -> MAV_MODE_FLAG_MANUAL_INPUT_ENABLED
      32L -> MAV_MODE_FLAG_HIL_ENABLED
      16L -> MAV_MODE_FLAG_STABILIZE_ENABLED
      8L -> MAV_MODE_FLAG_GUIDED_ENABLED
      4L -> MAV_MODE_FLAG_AUTO_ENABLED
      2L -> MAV_MODE_FLAG_TEST_ENABLED
      1L -> MAV_MODE_FLAG_CUSTOM_MODE_ENABLED
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<MavModeFlag> = buildList {
      if (v and 128L == 128L) add(MAV_MODE_FLAG_SAFETY_ARMED)
      if (v and 64L == 64L) add(MAV_MODE_FLAG_MANUAL_INPUT_ENABLED)
      if (v and 32L == 32L) add(MAV_MODE_FLAG_HIL_ENABLED)
      if (v and 16L == 16L) add(MAV_MODE_FLAG_STABILIZE_ENABLED)
      if (v and 8L == 8L) add(MAV_MODE_FLAG_GUIDED_ENABLED)
      if (v and 4L == 4L) add(MAV_MODE_FLAG_AUTO_ENABLED)
      if (v and 2L == 2L) add(MAV_MODE_FLAG_TEST_ENABLED)
      if (v and 1L == 1L) add(MAV_MODE_FLAG_CUSTOM_MODE_ENABLED)
    }
  }
}

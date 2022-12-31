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
  SAFETY_ARMED(128L),
  /**
   * 0b01000000 remote control input is enabled.
   */
  @GeneratedMavEnumEntry
  MANUAL_INPUT_ENABLED(64L),
  /**
   * 0b00100000 hardware in the loop simulation. All motors / actuators are blocked, but internal
   * software is full operational.
   */
  @GeneratedMavEnumEntry
  HIL_ENABLED(32L),
  /**
   * 0b00010000 system stabilizes electronically its attitude (and optionally position). It needs
   * however further control inputs to move around.
   */
  @GeneratedMavEnumEntry
  STABILIZE_ENABLED(16L),
  /**
   * 0b00001000 guided mode enabled, system flies waypoints / mission items.
   */
  @GeneratedMavEnumEntry
  GUIDED_ENABLED(8L),
  /**
   * 0b00000100 autonomous mode enabled, system finds its own goal positions. Guided flag can be set
   * or not, depends on the actual implementation.
   */
  @GeneratedMavEnumEntry
  AUTO_ENABLED(4L),
  /**
   * 0b00000010 system has a test mode enabled. This flag is intended for temporary system tests and
   * should not be used for stable implementations.
   */
  @GeneratedMavEnumEntry
  TEST_ENABLED(2L),
  /**
   * 0b00000001 Reserved for future use.
   */
  @GeneratedMavEnumEntry
  CUSTOM_MODE_ENABLED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavModeFlag? = when (v) {
      128L -> SAFETY_ARMED
      64L -> MANUAL_INPUT_ENABLED
      32L -> HIL_ENABLED
      16L -> STABILIZE_ENABLED
      8L -> GUIDED_ENABLED
      4L -> AUTO_ENABLED
      2L -> TEST_ENABLED
      1L -> CUSTOM_MODE_ENABLED
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<MavModeFlag> = buildList {
      if (v and 128L == 128L) add(SAFETY_ARMED)
      if (v and 64L == 64L) add(MANUAL_INPUT_ENABLED)
      if (v and 32L == 32L) add(HIL_ENABLED)
      if (v and 16L == 16L) add(STABILIZE_ENABLED)
      if (v and 8L == 8L) add(GUIDED_ENABLED)
      if (v and 4L == 4L) add(AUTO_ENABLED)
      if (v and 2L == 2L) add(TEST_ENABLED)
      if (v and 1L == 1L) add(CUSTOM_MODE_ENABLED)
    }
  }
}

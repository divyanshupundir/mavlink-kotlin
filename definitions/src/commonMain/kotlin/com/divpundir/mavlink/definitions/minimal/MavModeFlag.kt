package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * These flags encode the MAV mode.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavModeFlag(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * 0b10000000 MAV safety set to armed. Motors are enabled / running / can start. Ready to fly.
   * Additional note: this flag is to be ignore when sent in the command MAV_CMD_DO_SET_MODE and
   * MAV_CMD_COMPONENT_ARM_DISARM shall be used instead. The flag can still be used to report the armed
   * state.
   */
  @GeneratedMavEnumEntry
  SAFETY_ARMED(128u),
  /**
   * 0b01000000 remote control input is enabled.
   */
  @GeneratedMavEnumEntry
  MANUAL_INPUT_ENABLED(64u),
  /**
   * 0b00100000 hardware in the loop simulation. All motors / actuators are blocked, but internal
   * software is full operational.
   */
  @GeneratedMavEnumEntry
  HIL_ENABLED(32u),
  /**
   * 0b00010000 system stabilizes electronically its attitude (and optionally position). It needs
   * however further control inputs to move around.
   */
  @GeneratedMavEnumEntry
  STABILIZE_ENABLED(16u),
  /**
   * 0b00001000 guided mode enabled, system flies waypoints / mission items.
   */
  @GeneratedMavEnumEntry
  GUIDED_ENABLED(8u),
  /**
   * 0b00000100 autonomous mode enabled, system finds its own goal positions. Guided flag can be set
   * or not, depends on the actual implementation.
   */
  @GeneratedMavEnumEntry
  AUTO_ENABLED(4u),
  /**
   * 0b00000010 system has a test mode enabled. This flag is intended for temporary system tests and
   * should not be used for stable implementations.
   */
  @GeneratedMavEnumEntry
  TEST_ENABLED(2u),
  /**
   * 0b00000001 Reserved for future use.
   */
  @GeneratedMavEnumEntry
  CUSTOM_MODE_ENABLED(1u),
  ;

  public companion object : MavBitmask.MavCompanion<MavModeFlag> {
    override fun getEntryFromValueOrNull(v: UInt): MavModeFlag? = when (v) {
      128u -> SAFETY_ARMED
      64u -> MANUAL_INPUT_ENABLED
      32u -> HIL_ENABLED
      16u -> STABILIZE_ENABLED
      8u -> GUIDED_ENABLED
      4u -> AUTO_ENABLED
      2u -> TEST_ENABLED
      1u -> CUSTOM_MODE_ENABLED
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavModeFlag> = buildList {
      if (v and 128u == 128u) add(SAFETY_ARMED)
      if (v and 64u == 64u) add(MANUAL_INPUT_ENABLED)
      if (v and 32u == 32u) add(HIL_ENABLED)
      if (v and 16u == 16u) add(STABILIZE_ENABLED)
      if (v and 8u == 8u) add(GUIDED_ENABLED)
      if (v and 4u == 4u) add(AUTO_ENABLED)
      if (v and 2u == 2u) add(TEST_ENABLED)
      if (v and 1u == 1u) add(CUSTOM_MODE_ENABLED)
    }
  }
}

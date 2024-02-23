package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * These values encode the bit positions of the decode position. These values can be used to read
 * the value of a flag bit by combining the base_mode variable with AND with the flag position value.
 * The result will be either 0 or 1, depending on if the flag is set or not.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavModeFlagDecodePosition(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * First bit:  10000000
   */
  @GeneratedMavEnumEntry
  SAFETY(128u),
  /**
   * Second bit: 01000000
   */
  @GeneratedMavEnumEntry
  MANUAL(64u),
  /**
   * Third bit:  00100000
   */
  @GeneratedMavEnumEntry
  HIL(32u),
  /**
   * Fourth bit: 00010000
   */
  @GeneratedMavEnumEntry
  STABILIZE(16u),
  /**
   * Fifth bit:  00001000
   */
  @GeneratedMavEnumEntry
  GUIDED(8u),
  /**
   * Sixth bit:   00000100
   */
  @GeneratedMavEnumEntry
  AUTO(4u),
  /**
   * Seventh bit: 00000010
   */
  @GeneratedMavEnumEntry
  TEST(2u),
  /**
   * Eighth bit: 00000001
   */
  @GeneratedMavEnumEntry
  CUSTOM_MODE(1u),
  ;

  public companion object : MavBitmask.MavCompanion<MavModeFlagDecodePosition> {
    override fun getEntryFromValueOrNull(v: UInt): MavModeFlagDecodePosition? = when (v) {
      128u -> SAFETY
      64u -> MANUAL
      32u -> HIL
      16u -> STABILIZE
      8u -> GUIDED
      4u -> AUTO
      2u -> TEST
      1u -> CUSTOM_MODE
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavModeFlagDecodePosition> = buildList {
      if (v and 128u == 128u) add(SAFETY)
      if (v and 64u == 64u) add(MANUAL)
      if (v and 32u == 32u) add(HIL)
      if (v and 16u == 16u) add(STABILIZE)
      if (v and 8u == 8u) add(GUIDED)
      if (v and 4u == 4u) add(AUTO)
      if (v and 2u == 2u) add(TEST)
      if (v and 1u == 1u) add(CUSTOM_MODE)
    }
  }
}

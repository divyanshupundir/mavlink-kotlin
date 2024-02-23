package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * These flags are used in the AIS_VESSEL.fields bitmask to indicate validity of data in the other
 * message fields. When set, the data is valid.
 */
@GeneratedMavEnum(bitmask = true)
public enum class AisFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * 1 = Position accuracy less than 10m, 0 = position accuracy greater than 10m.
   */
  @GeneratedMavEnumEntry
  POSITION_ACCURACY(1u),
  @GeneratedMavEnumEntry
  VALID_COG(2u),
  @GeneratedMavEnumEntry
  VALID_VELOCITY(4u),
  /**
   * 1 = Velocity over 52.5765m/s (102.2 knots)
   */
  @GeneratedMavEnumEntry
  HIGH_VELOCITY(8u),
  @GeneratedMavEnumEntry
  VALID_TURN_RATE(16u),
  /**
   * Only the sign of the returned turn rate value is valid, either greater than 5deg/30s or less
   * than -5deg/30s
   */
  @GeneratedMavEnumEntry
  TURN_RATE_SIGN_ONLY(32u),
  @GeneratedMavEnumEntry
  VALID_DIMENSIONS(64u),
  /**
   * Distance to bow is larger than 511m
   */
  @GeneratedMavEnumEntry
  LARGE_BOW_DIMENSION(128u),
  /**
   * Distance to stern is larger than 511m
   */
  @GeneratedMavEnumEntry
  LARGE_STERN_DIMENSION(256u),
  /**
   * Distance to port side is larger than 63m
   */
  @GeneratedMavEnumEntry
  LARGE_PORT_DIMENSION(512u),
  /**
   * Distance to starboard side is larger than 63m
   */
  @GeneratedMavEnumEntry
  LARGE_STARBOARD_DIMENSION(1_024u),
  @GeneratedMavEnumEntry
  VALID_CALLSIGN(2_048u),
  @GeneratedMavEnumEntry
  VALID_NAME(4_096u),
  ;

  public companion object : MavBitmask.MavCompanion<AisFlags> {
    override fun getEntryFromValueOrNull(v: UInt): AisFlags? = when (v) {
      1u -> POSITION_ACCURACY
      2u -> VALID_COG
      4u -> VALID_VELOCITY
      8u -> HIGH_VELOCITY
      16u -> VALID_TURN_RATE
      32u -> TURN_RATE_SIGN_ONLY
      64u -> VALID_DIMENSIONS
      128u -> LARGE_BOW_DIMENSION
      256u -> LARGE_STERN_DIMENSION
      512u -> LARGE_PORT_DIMENSION
      1024u -> LARGE_STARBOARD_DIMENSION
      2048u -> VALID_CALLSIGN
      4096u -> VALID_NAME
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<AisFlags> = buildList {
      if (v and 1u == 1u) add(POSITION_ACCURACY)
      if (v and 2u == 2u) add(VALID_COG)
      if (v and 4u == 4u) add(VALID_VELOCITY)
      if (v and 8u == 8u) add(HIGH_VELOCITY)
      if (v and 16u == 16u) add(VALID_TURN_RATE)
      if (v and 32u == 32u) add(TURN_RATE_SIGN_ONLY)
      if (v and 64u == 64u) add(VALID_DIMENSIONS)
      if (v and 128u == 128u) add(LARGE_BOW_DIMENSION)
      if (v and 256u == 256u) add(LARGE_STERN_DIMENSION)
      if (v and 512u == 512u) add(LARGE_PORT_DIMENSION)
      if (v and 1024u == 1024u) add(LARGE_STARBOARD_DIMENSION)
      if (v and 2048u == 2048u) add(VALID_CALLSIGN)
      if (v and 4096u == 4096u) add(VALID_NAME)
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * These flags are used in the AIS_VESSEL.fields bitmask to indicate validity of data in the other
 * message fields. When set, the data is valid.
 */
@GeneratedMavEnum(bitmask = true)
public enum class AisFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * 1 = Position accuracy less than 10m, 0 = position accuracy greater than 10m.
   */
  @GeneratedMavEnumEntry
  AIS_FLAGS_POSITION_ACCURACY(1L),
  @GeneratedMavEnumEntry
  AIS_FLAGS_VALID_COG(2L),
  @GeneratedMavEnumEntry
  AIS_FLAGS_VALID_VELOCITY(4L),
  /**
   * 1 = Velocity over 52.5765m/s (102.2 knots)
   */
  @GeneratedMavEnumEntry
  AIS_FLAGS_HIGH_VELOCITY(8L),
  @GeneratedMavEnumEntry
  AIS_FLAGS_VALID_TURN_RATE(16L),
  /**
   * Only the sign of the returned turn rate value is valid, either greater than 5deg/30s or less
   * than -5deg/30s
   */
  @GeneratedMavEnumEntry
  AIS_FLAGS_TURN_RATE_SIGN_ONLY(32L),
  @GeneratedMavEnumEntry
  AIS_FLAGS_VALID_DIMENSIONS(64L),
  /**
   * Distance to bow is larger than 511m
   */
  @GeneratedMavEnumEntry
  AIS_FLAGS_LARGE_BOW_DIMENSION(128L),
  /**
   * Distance to stern is larger than 511m
   */
  @GeneratedMavEnumEntry
  AIS_FLAGS_LARGE_STERN_DIMENSION(256L),
  /**
   * Distance to port side is larger than 63m
   */
  @GeneratedMavEnumEntry
  AIS_FLAGS_LARGE_PORT_DIMENSION(512L),
  /**
   * Distance to starboard side is larger than 63m
   */
  @GeneratedMavEnumEntry
  AIS_FLAGS_LARGE_STARBOARD_DIMENSION(1024L),
  @GeneratedMavEnumEntry
  AIS_FLAGS_VALID_CALLSIGN(2048L),
  @GeneratedMavEnumEntry
  AIS_FLAGS_VALID_NAME(4096L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AisFlags? = when (v) {
      1L -> AIS_FLAGS_POSITION_ACCURACY
      2L -> AIS_FLAGS_VALID_COG
      4L -> AIS_FLAGS_VALID_VELOCITY
      8L -> AIS_FLAGS_HIGH_VELOCITY
      16L -> AIS_FLAGS_VALID_TURN_RATE
      32L -> AIS_FLAGS_TURN_RATE_SIGN_ONLY
      64L -> AIS_FLAGS_VALID_DIMENSIONS
      128L -> AIS_FLAGS_LARGE_BOW_DIMENSION
      256L -> AIS_FLAGS_LARGE_STERN_DIMENSION
      512L -> AIS_FLAGS_LARGE_PORT_DIMENSION
      1024L -> AIS_FLAGS_LARGE_STARBOARD_DIMENSION
      2048L -> AIS_FLAGS_VALID_CALLSIGN
      4096L -> AIS_FLAGS_VALID_NAME
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<AisFlags> = buildList {
      if (v and 1L == 1L) add(AIS_FLAGS_POSITION_ACCURACY)
      if (v and 2L == 2L) add(AIS_FLAGS_VALID_COG)
      if (v and 4L == 4L) add(AIS_FLAGS_VALID_VELOCITY)
      if (v and 8L == 8L) add(AIS_FLAGS_HIGH_VELOCITY)
      if (v and 16L == 16L) add(AIS_FLAGS_VALID_TURN_RATE)
      if (v and 32L == 32L) add(AIS_FLAGS_TURN_RATE_SIGN_ONLY)
      if (v and 64L == 64L) add(AIS_FLAGS_VALID_DIMENSIONS)
      if (v and 128L == 128L) add(AIS_FLAGS_LARGE_BOW_DIMENSION)
      if (v and 256L == 256L) add(AIS_FLAGS_LARGE_STERN_DIMENSION)
      if (v and 512L == 512L) add(AIS_FLAGS_LARGE_PORT_DIMENSION)
      if (v and 1024L == 1024L) add(AIS_FLAGS_LARGE_STARBOARD_DIMENSION)
      if (v and 2048L == 2048L) add(AIS_FLAGS_VALID_CALLSIGN)
      if (v and 4096L == 4096L) add(AIS_FLAGS_VALID_NAME)
    }
  }
}

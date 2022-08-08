package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * These flags are used in the AIS_VESSEL.fields bitmask to indicate validity of data in the other
 * message fields. When set, the data is valid.
 */
@GeneratedMavEnum
public enum class AisFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 1 = Position accuracy less than 10m, 0 = position accuracy greater than 10m.
   */
  AIS_FLAGS_POSITION_ACCURACY(1L),
  AIS_FLAGS_VALID_COG(2L),
  AIS_FLAGS_VALID_VELOCITY(4L),
  /**
   * 1 = Velocity over 52.5765m/s (102.2 knots)
   */
  AIS_FLAGS_HIGH_VELOCITY(8L),
  AIS_FLAGS_VALID_TURN_RATE(16L),
  /**
   * Only the sign of the returned turn rate value is valid, either greater than 5deg/30s or less
   * than -5deg/30s
   */
  AIS_FLAGS_TURN_RATE_SIGN_ONLY(32L),
  AIS_FLAGS_VALID_DIMENSIONS(64L),
  /**
   * Distance to bow is larger than 511m
   */
  AIS_FLAGS_LARGE_BOW_DIMENSION(128L),
  /**
   * Distance to stern is larger than 511m
   */
  AIS_FLAGS_LARGE_STERN_DIMENSION(256L),
  /**
   * Distance to port side is larger than 63m
   */
  AIS_FLAGS_LARGE_PORT_DIMENSION(512L),
  /**
   * Distance to starboard side is larger than 63m
   */
  AIS_FLAGS_LARGE_STARBOARD_DIMENSION(1024L),
  AIS_FLAGS_VALID_CALLSIGN(2048L),
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
  }
}

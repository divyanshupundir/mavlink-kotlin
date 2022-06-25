package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * A mapping of rover flight modes for custom_mode field of heartbeat.
 */
public enum class RoverMode(
  public override val `value`: Long,
) : MavEnum {
  ROVER_MODE_MANUAL(0L),
  ROVER_MODE_ACRO(1L),
  ROVER_MODE_STEERING(3L),
  ROVER_MODE_HOLD(4L),
  ROVER_MODE_LOITER(5L),
  ROVER_MODE_FOLLOW(6L),
  ROVER_MODE_SIMPLE(7L),
  ROVER_MODE_AUTO(10L),
  ROVER_MODE_RTL(11L),
  ROVER_MODE_SMART_RTL(12L),
  ROVER_MODE_GUIDED(15L),
  ROVER_MODE_INITIALIZING(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): RoverMode? = when (v) {
      0L -> ROVER_MODE_MANUAL
      1L -> ROVER_MODE_ACRO
      3L -> ROVER_MODE_STEERING
      4L -> ROVER_MODE_HOLD
      5L -> ROVER_MODE_LOITER
      6L -> ROVER_MODE_FOLLOW
      7L -> ROVER_MODE_SIMPLE
      10L -> ROVER_MODE_AUTO
      11L -> ROVER_MODE_RTL
      12L -> ROVER_MODE_SMART_RTL
      15L -> ROVER_MODE_GUIDED
      16L -> ROVER_MODE_INITIALIZING
      else -> null
    }
  }
}

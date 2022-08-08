package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * A mapping of antenna tracker flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class TrackerMode(
  public override val `value`: Long,
) : MavEnum {
  TRACKER_MODE_MANUAL(0L),
  TRACKER_MODE_STOP(1L),
  TRACKER_MODE_SCAN(2L),
  TRACKER_MODE_SERVO_TEST(3L),
  TRACKER_MODE_AUTO(10L),
  TRACKER_MODE_INITIALIZING(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): TrackerMode? = when (v) {
      0L -> TRACKER_MODE_MANUAL
      1L -> TRACKER_MODE_STOP
      2L -> TRACKER_MODE_SCAN
      3L -> TRACKER_MODE_SERVO_TEST
      10L -> TRACKER_MODE_AUTO
      16L -> TRACKER_MODE_INITIALIZING
      else -> null
    }
  }
}

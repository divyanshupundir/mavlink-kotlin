package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * A mapping of antenna tracker flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class TrackerMode(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  TRACKER_MODE_MANUAL(0L),
  @GeneratedMavEnumEntry
  TRACKER_MODE_STOP(1L),
  @GeneratedMavEnumEntry
  TRACKER_MODE_SCAN(2L),
  @GeneratedMavEnumEntry
  TRACKER_MODE_SERVO_TEST(3L),
  @GeneratedMavEnumEntry
  TRACKER_MODE_AUTO(10L),
  @GeneratedMavEnumEntry
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

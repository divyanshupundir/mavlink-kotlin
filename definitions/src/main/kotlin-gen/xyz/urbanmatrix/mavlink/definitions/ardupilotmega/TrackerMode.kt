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
  MANUAL(0L),
  @GeneratedMavEnumEntry
  STOP(1L),
  @GeneratedMavEnumEntry
  SCAN(2L),
  @GeneratedMavEnumEntry
  SERVO_TEST(3L),
  @GeneratedMavEnumEntry
  AUTO(10L),
  @GeneratedMavEnumEntry
  INITIALIZING(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): TrackerMode? = when (v) {
      0L -> MANUAL
      1L -> STOP
      2L -> SCAN
      3L -> SERVO_TEST
      10L -> AUTO
      16L -> INITIALIZING
      else -> null
    }
  }
}

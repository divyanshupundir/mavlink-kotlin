package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Deprecated
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * A data stream is not a fixed set of messages, but rather a
 *      recommendation to the autopilot software. Individual autopilots may or may not obey
 *      the recommended messages.
 */
@Deprecated(message = "")
@GeneratedMavEnum
public enum class MavDataStream(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Dependent on the autopilot
   */
  @GeneratedMavEnumEntry
  MAV_DATA_STREAM_EXTRA3(12L),
  /**
   * Dependent on the autopilot
   */
  @GeneratedMavEnumEntry
  MAV_DATA_STREAM_EXTRA2(11L),
  /**
   * Dependent on the autopilot
   */
  @GeneratedMavEnumEntry
  MAV_DATA_STREAM_EXTRA1(10L),
  /**
   * Enable LOCAL_POSITION, GLOBAL_POSITION_INT messages.
   */
  @GeneratedMavEnumEntry
  MAV_DATA_STREAM_POSITION(6L),
  /**
   * Enable ATTITUDE_CONTROLLER_OUTPUT, POSITION_CONTROLLER_OUTPUT, NAV_CONTROLLER_OUTPUT.
   */
  @GeneratedMavEnumEntry
  MAV_DATA_STREAM_RAW_CONTROLLER(4L),
  /**
   * Enable RC_CHANNELS_SCALED, RC_CHANNELS_RAW, SERVO_OUTPUT_RAW
   */
  @GeneratedMavEnumEntry
  MAV_DATA_STREAM_RC_CHANNELS(3L),
  /**
   * Enable GPS_STATUS, CONTROL_STATUS, AUX_STATUS
   */
  @GeneratedMavEnumEntry
  MAV_DATA_STREAM_EXTENDED_STATUS(2L),
  /**
   * Enable IMU_RAW, GPS_RAW, GPS_STATUS packets.
   */
  @GeneratedMavEnumEntry
  MAV_DATA_STREAM_RAW_SENSORS(1L),
  /**
   * Enable all data streams
   */
  @GeneratedMavEnumEntry
  MAV_DATA_STREAM_ALL(0L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavDataStream? = when (v) {
      12L -> MAV_DATA_STREAM_EXTRA3
      11L -> MAV_DATA_STREAM_EXTRA2
      10L -> MAV_DATA_STREAM_EXTRA1
      6L -> MAV_DATA_STREAM_POSITION
      4L -> MAV_DATA_STREAM_RAW_CONTROLLER
      3L -> MAV_DATA_STREAM_RC_CHANNELS
      2L -> MAV_DATA_STREAM_EXTENDED_STATUS
      1L -> MAV_DATA_STREAM_RAW_SENSORS
      0L -> MAV_DATA_STREAM_ALL
      else -> null
    }
  }
}

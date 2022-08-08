package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Deprecated
import kotlin.Long

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
   * Enable all data streams
   */
  MAV_DATA_STREAM_ALL(0L),
  /**
   * Enable IMU_RAW, GPS_RAW, GPS_STATUS packets.
   */
  MAV_DATA_STREAM_RAW_SENSORS(1L),
  /**
   * Enable GPS_STATUS, CONTROL_STATUS, AUX_STATUS
   */
  MAV_DATA_STREAM_EXTENDED_STATUS(2L),
  /**
   * Enable RC_CHANNELS_SCALED, RC_CHANNELS_RAW, SERVO_OUTPUT_RAW
   */
  MAV_DATA_STREAM_RC_CHANNELS(3L),
  /**
   * Enable ATTITUDE_CONTROLLER_OUTPUT, POSITION_CONTROLLER_OUTPUT, NAV_CONTROLLER_OUTPUT.
   */
  MAV_DATA_STREAM_RAW_CONTROLLER(4L),
  /**
   * Enable LOCAL_POSITION, GLOBAL_POSITION_INT messages.
   */
  MAV_DATA_STREAM_POSITION(6L),
  /**
   * Dependent on the autopilot
   */
  MAV_DATA_STREAM_EXTRA1(10L),
  /**
   * Dependent on the autopilot
   */
  MAV_DATA_STREAM_EXTRA2(11L),
  /**
   * Dependent on the autopilot
   */
  MAV_DATA_STREAM_EXTRA3(12L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavDataStream? = when (v) {
      0L -> MAV_DATA_STREAM_ALL
      1L -> MAV_DATA_STREAM_RAW_SENSORS
      2L -> MAV_DATA_STREAM_EXTENDED_STATUS
      3L -> MAV_DATA_STREAM_RC_CHANNELS
      4L -> MAV_DATA_STREAM_RAW_CONTROLLER
      6L -> MAV_DATA_STREAM_POSITION
      10L -> MAV_DATA_STREAM_EXTRA1
      11L -> MAV_DATA_STREAM_EXTRA2
      12L -> MAV_DATA_STREAM_EXTRA3
      else -> null
    }
  }
}

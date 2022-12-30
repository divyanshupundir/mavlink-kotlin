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
  EXTRA3(12L),
  /**
   * Dependent on the autopilot
   */
  @GeneratedMavEnumEntry
  EXTRA2(11L),
  /**
   * Dependent on the autopilot
   */
  @GeneratedMavEnumEntry
  EXTRA1(10L),
  /**
   * Enable LOCAL_POSITION, GLOBAL_POSITION_INT messages.
   */
  @GeneratedMavEnumEntry
  POSITION(6L),
  /**
   * Enable ATTITUDE_CONTROLLER_OUTPUT, POSITION_CONTROLLER_OUTPUT, NAV_CONTROLLER_OUTPUT.
   */
  @GeneratedMavEnumEntry
  RAW_CONTROLLER(4L),
  /**
   * Enable RC_CHANNELS_SCALED, RC_CHANNELS_RAW, SERVO_OUTPUT_RAW
   */
  @GeneratedMavEnumEntry
  RC_CHANNELS(3L),
  /**
   * Enable GPS_STATUS, CONTROL_STATUS, AUX_STATUS
   */
  @GeneratedMavEnumEntry
  EXTENDED_STATUS(2L),
  /**
   * Enable IMU_RAW, GPS_RAW, GPS_STATUS packets.
   */
  @GeneratedMavEnumEntry
  RAW_SENSORS(1L),
  /**
   * Enable all data streams
   */
  @GeneratedMavEnumEntry
  ALL(0L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavDataStream? = when (v) {
      12L -> EXTRA3
      11L -> EXTRA2
      10L -> EXTRA1
      6L -> POSITION
      4L -> RAW_CONTROLLER
      3L -> RC_CHANNELS
      2L -> EXTENDED_STATUS
      1L -> RAW_SENSORS
      0L -> ALL
      else -> null
    }
  }
}

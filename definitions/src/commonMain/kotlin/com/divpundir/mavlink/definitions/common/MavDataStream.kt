package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * A data stream is not a fixed set of messages, but rather a
 *      recommendation to the autopilot software. Individual autopilots may or may not obey
 *      the recommended messages.
 */
@GeneratedMavEnum
public enum class MavDataStream(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Enable all data streams
   */
  @GeneratedMavEnumEntry
  ALL(0u),
  /**
   * Enable IMU_RAW, GPS_RAW, GPS_STATUS packets.
   */
  @GeneratedMavEnumEntry
  RAW_SENSORS(1u),
  /**
   * Enable GPS_STATUS, CONTROL_STATUS, AUX_STATUS
   */
  @GeneratedMavEnumEntry
  EXTENDED_STATUS(2u),
  /**
   * Enable RC_CHANNELS_SCALED, RC_CHANNELS_RAW, SERVO_OUTPUT_RAW
   */
  @GeneratedMavEnumEntry
  RC_CHANNELS(3u),
  /**
   * Enable ATTITUDE_CONTROLLER_OUTPUT, POSITION_CONTROLLER_OUTPUT, NAV_CONTROLLER_OUTPUT.
   */
  @GeneratedMavEnumEntry
  RAW_CONTROLLER(4u),
  /**
   * Enable LOCAL_POSITION, GLOBAL_POSITION_INT messages.
   */
  @GeneratedMavEnumEntry
  POSITION(6u),
  /**
   * Dependent on the autopilot
   */
  @GeneratedMavEnumEntry
  EXTRA1(10u),
  /**
   * Dependent on the autopilot
   */
  @GeneratedMavEnumEntry
  EXTRA2(11u),
  /**
   * Dependent on the autopilot
   */
  @GeneratedMavEnumEntry
  EXTRA3(12u),
  ;

  public companion object : MavEnum.MavCompanion<MavDataStream> {
    override fun getEntryFromValueOrNull(v: UInt): MavDataStream? = when (v) {
      0u -> ALL
      1u -> RAW_SENSORS
      2u -> EXTENDED_STATUS
      3u -> RC_CHANNELS
      4u -> RAW_CONTROLLER
      6u -> POSITION
      10u -> EXTRA1
      11u -> EXTRA2
      12u -> EXTRA3
      else -> null
    }
  }
}

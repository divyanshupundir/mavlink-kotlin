package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Deprecated
import kotlin.Long

/**
 * Bitmask of (optional) autopilot capabilities (64 bit). If a bit is set, the autopilot supports
 * this capability.
 */
@GeneratedMavEnum
public enum class MavProtocolCapability(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Autopilot supports the MISSION_ITEM float message type.
   *           Note that MISSION_ITEM is deprecated, and autopilots should use MISSION_INT instead.
   *         
   */
  MAV_PROTOCOL_CAPABILITY_MISSION_FLOAT(1L),
  /**
   * Autopilot supports the new param float message type.
   */
  @Deprecated(message = "")
  MAV_PROTOCOL_CAPABILITY_PARAM_FLOAT(2L),
  /**
   * Autopilot supports MISSION_ITEM_INT scaled integer message type.
   *           Note that this flag must always be set if missions are supported, because missions
   * must always use MISSION_ITEM_INT (rather than MISSION_ITEM, which is deprecated).
   *         
   */
  MAV_PROTOCOL_CAPABILITY_MISSION_INT(4L),
  /**
   * Autopilot supports COMMAND_INT scaled integer message type.
   */
  MAV_PROTOCOL_CAPABILITY_COMMAND_INT(8L),
  /**
   * Parameter protocol uses byte-wise encoding of parameter values into param_value (float) fields:
   * https://mavlink.io/en/services/parameter.html#parameter-encoding.
   *           Note that either this flag or MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE should be
   * set if the parameter protocol is supported.
   *         
   */
  MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE(16L),
  /**
   * Autopilot supports the File Transfer Protocol v1: https://mavlink.io/en/services/ftp.html.
   */
  MAV_PROTOCOL_CAPABILITY_FTP(32L),
  /**
   * Autopilot supports commanding attitude offboard.
   */
  MAV_PROTOCOL_CAPABILITY_SET_ATTITUDE_TARGET(64L),
  /**
   * Autopilot supports commanding position and velocity targets in local NED frame.
   */
  MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_LOCAL_NED(128L),
  /**
   * Autopilot supports commanding position and velocity targets in global scaled integers.
   */
  MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_GLOBAL_INT(256L),
  /**
   * Autopilot supports terrain protocol / data handling.
   */
  MAV_PROTOCOL_CAPABILITY_TERRAIN(512L),
  /**
   * Autopilot supports direct actuator control.
   */
  MAV_PROTOCOL_CAPABILITY_SET_ACTUATOR_TARGET(1024L),
  /**
   * Autopilot supports the MAV_CMD_DO_FLIGHTTERMINATION command (flight termination).
   */
  MAV_PROTOCOL_CAPABILITY_FLIGHT_TERMINATION(2048L),
  /**
   * Autopilot supports onboard compass calibration.
   */
  MAV_PROTOCOL_CAPABILITY_COMPASS_CALIBRATION(4096L),
  /**
   * Autopilot supports MAVLink version 2.
   */
  MAV_PROTOCOL_CAPABILITY_MAVLINK2(8192L),
  /**
   * Autopilot supports mission fence protocol.
   */
  MAV_PROTOCOL_CAPABILITY_MISSION_FENCE(16384L),
  /**
   * Autopilot supports mission rally point protocol.
   */
  MAV_PROTOCOL_CAPABILITY_MISSION_RALLY(32768L),
  /**
   * Reserved for future use.
   */
  MAV_PROTOCOL_CAPABILITY_RESERVED2(65536L),
  /**
   * Parameter protocol uses C-cast of parameter values to set the param_value (float) fields:
   * https://mavlink.io/en/services/parameter.html#parameter-encoding.
   *           Note that either this flag or MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE should be
   * set if the parameter protocol is supported.
   *         
   */
  MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_C_CAST(131072L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavProtocolCapability? = when (v) {
      1L -> MAV_PROTOCOL_CAPABILITY_MISSION_FLOAT
      2L -> MAV_PROTOCOL_CAPABILITY_PARAM_FLOAT
      4L -> MAV_PROTOCOL_CAPABILITY_MISSION_INT
      8L -> MAV_PROTOCOL_CAPABILITY_COMMAND_INT
      16L -> MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE
      32L -> MAV_PROTOCOL_CAPABILITY_FTP
      64L -> MAV_PROTOCOL_CAPABILITY_SET_ATTITUDE_TARGET
      128L -> MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_LOCAL_NED
      256L -> MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_GLOBAL_INT
      512L -> MAV_PROTOCOL_CAPABILITY_TERRAIN
      1024L -> MAV_PROTOCOL_CAPABILITY_SET_ACTUATOR_TARGET
      2048L -> MAV_PROTOCOL_CAPABILITY_FLIGHT_TERMINATION
      4096L -> MAV_PROTOCOL_CAPABILITY_COMPASS_CALIBRATION
      8192L -> MAV_PROTOCOL_CAPABILITY_MAVLINK2
      16384L -> MAV_PROTOCOL_CAPABILITY_MISSION_FENCE
      32768L -> MAV_PROTOCOL_CAPABILITY_MISSION_RALLY
      65536L -> MAV_PROTOCOL_CAPABILITY_RESERVED2
      131072L -> MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_C_CAST
      else -> null
    }
  }
}

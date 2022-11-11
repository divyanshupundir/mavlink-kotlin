package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Deprecated
import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Bitmask of (optional) autopilot capabilities (64 bit). If a bit is set, the autopilot supports
 * this capability.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavProtocolCapability(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Autopilot supports the MISSION_ITEM float message type.
   *           Note that MISSION_ITEM is deprecated, and autopilots should use MISSION_INT instead.
   *         
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_MISSION_FLOAT(1L),
  /**
   * Autopilot supports the new param float message type.
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_PARAM_FLOAT(2L),
  /**
   * Autopilot supports MISSION_ITEM_INT scaled integer message type.
   *           Note that this flag must always be set if missions are supported, because missions
   * must always use MISSION_ITEM_INT (rather than MISSION_ITEM, which is deprecated).
   *         
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_MISSION_INT(4L),
  /**
   * Autopilot supports COMMAND_INT scaled integer message type.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_COMMAND_INT(8L),
  /**
   * Parameter protocol uses byte-wise encoding of parameter values into param_value (float) fields:
   * https://mavlink.io/en/services/parameter.html#parameter-encoding.
   *           Note that either this flag or MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE should be
   * set if the parameter protocol is supported.
   *         
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE(16L),
  /**
   * Autopilot supports the File Transfer Protocol v1: https://mavlink.io/en/services/ftp.html.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_FTP(32L),
  /**
   * Autopilot supports commanding attitude offboard.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_SET_ATTITUDE_TARGET(64L),
  /**
   * Autopilot supports commanding position and velocity targets in local NED frame.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_LOCAL_NED(128L),
  /**
   * Autopilot supports commanding position and velocity targets in global scaled integers.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_GLOBAL_INT(256L),
  /**
   * Autopilot supports terrain protocol / data handling.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_TERRAIN(512L),
  /**
   * Autopilot supports direct actuator control.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_SET_ACTUATOR_TARGET(1024L),
  /**
   * Autopilot supports the MAV_CMD_DO_FLIGHTTERMINATION command (flight termination).
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_FLIGHT_TERMINATION(2048L),
  /**
   * Autopilot supports onboard compass calibration.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_COMPASS_CALIBRATION(4096L),
  /**
   * Autopilot supports MAVLink version 2.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_MAVLINK2(8192L),
  /**
   * Autopilot supports mission fence protocol.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_MISSION_FENCE(16384L),
  /**
   * Autopilot supports mission rally point protocol.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_MISSION_RALLY(32768L),
  /**
   * Reserved for future use.
   */
  @GeneratedMavEnumEntry
  MAV_PROTOCOL_CAPABILITY_RESERVED2(65536L),
  /**
   * Parameter protocol uses C-cast of parameter values to set the param_value (float) fields:
   * https://mavlink.io/en/services/parameter.html#parameter-encoding.
   *           Note that either this flag or MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE should be
   * set if the parameter protocol is supported.
   *         
   */
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<MavProtocolCapability> = buildList {
      if (v and 1L == 1L) add(MAV_PROTOCOL_CAPABILITY_MISSION_FLOAT)
      if (v and 2L == 2L) add(MAV_PROTOCOL_CAPABILITY_PARAM_FLOAT)
      if (v and 4L == 4L) add(MAV_PROTOCOL_CAPABILITY_MISSION_INT)
      if (v and 8L == 8L) add(MAV_PROTOCOL_CAPABILITY_COMMAND_INT)
      if (v and 16L == 16L) add(MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE)
      if (v and 32L == 32L) add(MAV_PROTOCOL_CAPABILITY_FTP)
      if (v and 64L == 64L) add(MAV_PROTOCOL_CAPABILITY_SET_ATTITUDE_TARGET)
      if (v and 128L == 128L) add(MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_LOCAL_NED)
      if (v and 256L == 256L) add(MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_GLOBAL_INT)
      if (v and 512L == 512L) add(MAV_PROTOCOL_CAPABILITY_TERRAIN)
      if (v and 1024L == 1024L) add(MAV_PROTOCOL_CAPABILITY_SET_ACTUATOR_TARGET)
      if (v and 2048L == 2048L) add(MAV_PROTOCOL_CAPABILITY_FLIGHT_TERMINATION)
      if (v and 4096L == 4096L) add(MAV_PROTOCOL_CAPABILITY_COMPASS_CALIBRATION)
      if (v and 8192L == 8192L) add(MAV_PROTOCOL_CAPABILITY_MAVLINK2)
      if (v and 16384L == 16384L) add(MAV_PROTOCOL_CAPABILITY_MISSION_FENCE)
      if (v and 32768L == 32768L) add(MAV_PROTOCOL_CAPABILITY_MISSION_RALLY)
      if (v and 65536L == 65536L) add(MAV_PROTOCOL_CAPABILITY_RESERVED2)
      if (v and 131072L == 131072L) add(MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_C_CAST)
    }
  }
}

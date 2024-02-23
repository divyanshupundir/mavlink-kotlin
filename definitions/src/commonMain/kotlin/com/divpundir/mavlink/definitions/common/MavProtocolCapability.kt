package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.Deprecated
import kotlin.UInt
import kotlin.collections.List

/**
 * Bitmask of (optional) autopilot capabilities (64 bit). If a bit is set, the autopilot supports
 * this capability.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavProtocolCapability(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Autopilot supports the MISSION_ITEM float message type.
   *           Note that MISSION_ITEM is deprecated, and autopilots should use MISSION_INT instead.
   *         
   */
  @GeneratedMavEnumEntry
  MISSION_FLOAT(1u),
  /**
   * Autopilot supports the new param float message type.
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  PARAM_FLOAT(2u),
  /**
   * Autopilot supports MISSION_ITEM_INT scaled integer message type.
   *           Note that this flag must always be set if missions are supported, because missions
   * must always use MISSION_ITEM_INT (rather than MISSION_ITEM, which is deprecated).
   *         
   */
  @GeneratedMavEnumEntry
  MISSION_INT(4u),
  /**
   * Autopilot supports COMMAND_INT scaled integer message type.
   */
  @GeneratedMavEnumEntry
  COMMAND_INT(8u),
  /**
   * Parameter protocol uses byte-wise encoding of parameter values into param_value (float) fields:
   * https://mavlink.io/en/services/parameter.html#parameter-encoding.
   *           Note that either this flag or MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_C_CAST should be
   * set if the parameter protocol is supported.
   *         
   */
  @GeneratedMavEnumEntry
  PARAM_ENCODE_BYTEWISE(16u),
  /**
   * Autopilot supports the File Transfer Protocol v1: https://mavlink.io/en/services/ftp.html.
   */
  @GeneratedMavEnumEntry
  FTP(32u),
  /**
   * Autopilot supports commanding attitude offboard.
   */
  @GeneratedMavEnumEntry
  SET_ATTITUDE_TARGET(64u),
  /**
   * Autopilot supports commanding position and velocity targets in local NED frame.
   */
  @GeneratedMavEnumEntry
  SET_POSITION_TARGET_LOCAL_NED(128u),
  /**
   * Autopilot supports commanding position and velocity targets in global scaled integers.
   */
  @GeneratedMavEnumEntry
  SET_POSITION_TARGET_GLOBAL_INT(256u),
  /**
   * Autopilot supports terrain protocol / data handling.
   */
  @GeneratedMavEnumEntry
  TERRAIN(512u),
  /**
   * Reserved for future use.
   */
  @GeneratedMavEnumEntry
  RESERVED3(1_024u),
  /**
   * Autopilot supports the MAV_CMD_DO_FLIGHTTERMINATION command (flight termination).
   */
  @GeneratedMavEnumEntry
  FLIGHT_TERMINATION(2_048u),
  /**
   * Autopilot supports onboard compass calibration.
   */
  @GeneratedMavEnumEntry
  COMPASS_CALIBRATION(4_096u),
  /**
   * Autopilot supports MAVLink version 2.
   */
  @GeneratedMavEnumEntry
  MAVLINK2(8_192u),
  /**
   * Autopilot supports mission fence protocol.
   */
  @GeneratedMavEnumEntry
  MISSION_FENCE(16_384u),
  /**
   * Autopilot supports mission rally point protocol.
   */
  @GeneratedMavEnumEntry
  MISSION_RALLY(32_768u),
  /**
   * Reserved for future use.
   */
  @GeneratedMavEnumEntry
  RESERVED2(65_536u),
  /**
   * Parameter protocol uses C-cast of parameter values to set the param_value (float) fields:
   * https://mavlink.io/en/services/parameter.html#parameter-encoding.
   *           Note that either this flag or MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE should be
   * set if the parameter protocol is supported.
   *         
   */
  @GeneratedMavEnumEntry
  PARAM_ENCODE_C_CAST(131_072u),
  ;

  public companion object : MavBitmask.MavCompanion<MavProtocolCapability> {
    override fun getEntryFromValueOrNull(v: UInt): MavProtocolCapability? = when (v) {
      1u -> MISSION_FLOAT
      2u -> PARAM_FLOAT
      4u -> MISSION_INT
      8u -> COMMAND_INT
      16u -> PARAM_ENCODE_BYTEWISE
      32u -> FTP
      64u -> SET_ATTITUDE_TARGET
      128u -> SET_POSITION_TARGET_LOCAL_NED
      256u -> SET_POSITION_TARGET_GLOBAL_INT
      512u -> TERRAIN
      1024u -> RESERVED3
      2048u -> FLIGHT_TERMINATION
      4096u -> COMPASS_CALIBRATION
      8192u -> MAVLINK2
      16384u -> MISSION_FENCE
      32768u -> MISSION_RALLY
      65536u -> RESERVED2
      131072u -> PARAM_ENCODE_C_CAST
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavProtocolCapability> = buildList {
      if (v and 1u == 1u) add(MISSION_FLOAT)
      if (v and 2u == 2u) add(PARAM_FLOAT)
      if (v and 4u == 4u) add(MISSION_INT)
      if (v and 8u == 8u) add(COMMAND_INT)
      if (v and 16u == 16u) add(PARAM_ENCODE_BYTEWISE)
      if (v and 32u == 32u) add(FTP)
      if (v and 64u == 64u) add(SET_ATTITUDE_TARGET)
      if (v and 128u == 128u) add(SET_POSITION_TARGET_LOCAL_NED)
      if (v and 256u == 256u) add(SET_POSITION_TARGET_GLOBAL_INT)
      if (v and 512u == 512u) add(TERRAIN)
      if (v and 1024u == 1024u) add(RESERVED3)
      if (v and 2048u == 2048u) add(FLIGHT_TERMINATION)
      if (v and 4096u == 4096u) add(COMPASS_CALIBRATION)
      if (v and 8192u == 8192u) add(MAVLINK2)
      if (v and 16384u == 16384u) add(MISSION_FENCE)
      if (v and 32768u == 32768u) add(MISSION_RALLY)
      if (v and 65536u == 65536u) add(RESERVED2)
      if (v and 131072u == 131072u) add(PARAM_ENCODE_C_CAST)
    }
  }
}

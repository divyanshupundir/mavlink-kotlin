package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Result of mission operation (in a MISSION_ACK message).
 */
@GeneratedMavEnum
public enum class MavMissionResult(
  override val `value`: UInt,
) : MavEnum {
  /**
   * mission accepted OK
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_ACCEPTED(0u),
  /**
   * Generic error / not accepting mission commands at all right now.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_ERROR(1u),
  /**
   * Coordinate frame is not supported.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_UNSUPPORTED_FRAME(2u),
  /**
   * Command is not supported.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_UNSUPPORTED(3u),
  /**
   * Mission items exceed storage space.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_NO_SPACE(4u),
  /**
   * One of the parameters has an invalid value.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_INVALID(5u),
  /**
   * param1 has an invalid value.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_INVALID_PARAM1(6u),
  /**
   * param2 has an invalid value.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_INVALID_PARAM2(7u),
  /**
   * param3 has an invalid value.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_INVALID_PARAM3(8u),
  /**
   * param4 has an invalid value.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_INVALID_PARAM4(9u),
  /**
   * x / param5 has an invalid value.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_INVALID_PARAM5_X(10u),
  /**
   * y / param6 has an invalid value.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_INVALID_PARAM6_Y(11u),
  /**
   * z / param7 has an invalid value.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_INVALID_PARAM7(12u),
  /**
   * Mission item received out of sequence
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_INVALID_SEQUENCE(13u),
  /**
   * Not accepting any mission commands from this communication partner.
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_DENIED(14u),
  /**
   * Current mission operation cancelled (e.g. mission upload, mission download).
   */
  @GeneratedMavEnumEntry
  MAV_MISSION_OPERATION_CANCELLED(15u),
  ;

  public companion object : MavEnum.MavCompanion<MavMissionResult> {
    override fun getEntryFromValueOrNull(v: UInt): MavMissionResult? = when (v) {
      0u -> MAV_MISSION_ACCEPTED
      1u -> MAV_MISSION_ERROR
      2u -> MAV_MISSION_UNSUPPORTED_FRAME
      3u -> MAV_MISSION_UNSUPPORTED
      4u -> MAV_MISSION_NO_SPACE
      5u -> MAV_MISSION_INVALID
      6u -> MAV_MISSION_INVALID_PARAM1
      7u -> MAV_MISSION_INVALID_PARAM2
      8u -> MAV_MISSION_INVALID_PARAM3
      9u -> MAV_MISSION_INVALID_PARAM4
      10u -> MAV_MISSION_INVALID_PARAM5_X
      11u -> MAV_MISSION_INVALID_PARAM6_Y
      12u -> MAV_MISSION_INVALID_PARAM7
      13u -> MAV_MISSION_INVALID_SEQUENCE
      14u -> MAV_MISSION_DENIED
      15u -> MAV_MISSION_OPERATION_CANCELLED
      else -> null
    }
  }
}

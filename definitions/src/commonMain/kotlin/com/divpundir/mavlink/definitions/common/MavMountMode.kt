package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.Deprecated
import kotlin.UInt

/**
 * Enumeration of possible mount operation modes. This message is used by obsolete/deprecated gimbal
 * messages.
 */
@Deprecated(message = "")
@GeneratedMavEnum
public enum class MavMountMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Gimbal tracks home position
   */
  @GeneratedMavEnumEntry
  HOME_LOCATION(6u),
  /**
   * Gimbal tracks system with specified system ID
   */
  @GeneratedMavEnumEntry
  SYSID_TARGET(5u),
  /**
   * Load neutral position and start to point to Lat,Lon,Alt
   */
  @GeneratedMavEnumEntry
  GPS_POINT(4u),
  /**
   * Load neutral position and start RC Roll,Pitch,Yaw control with stabilization
   */
  @GeneratedMavEnumEntry
  RC_TARGETING(3u),
  /**
   * Load neutral position and start MAVLink Roll,Pitch,Yaw control with stabilization
   */
  @GeneratedMavEnumEntry
  MAVLINK_TARGETING(2u),
  /**
   * Load and keep neutral position (Roll,Pitch,Yaw) from permanent memory.
   */
  @GeneratedMavEnumEntry
  NEUTRAL(1u),
  /**
   * Load and keep safe position (Roll,Pitch,Yaw) from permanent memory and stop stabilization
   */
  @GeneratedMavEnumEntry
  RETRACT(0u),
  ;

  public companion object : MavEnum.MavCompanion<MavMountMode> {
    override fun getEntryFromValueOrNull(v: UInt): MavMountMode? = when (v) {
      6u -> HOME_LOCATION
      5u -> SYSID_TARGET
      4u -> GPS_POINT
      3u -> RC_TARGETING
      2u -> MAVLINK_TARGETING
      1u -> NEUTRAL
      0u -> RETRACT
      else -> null
    }
  }
}

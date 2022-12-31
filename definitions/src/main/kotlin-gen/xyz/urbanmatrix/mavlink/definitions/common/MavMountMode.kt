package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Deprecated
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of possible mount operation modes. This message is used by obsolete/deprecated gimbal
 * messages.
 */
@Deprecated(message = "")
@GeneratedMavEnum
public enum class MavMountMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Gimbal tracks home position
   */
  @GeneratedMavEnumEntry
  HOME_LOCATION(6L),
  /**
   * Gimbal tracks system with specified system ID
   */
  @GeneratedMavEnumEntry
  SYSID_TARGET(5L),
  /**
   * Load neutral position and start to point to Lat,Lon,Alt
   */
  @GeneratedMavEnumEntry
  GPS_POINT(4L),
  /**
   * Load neutral position and start RC Roll,Pitch,Yaw control with stabilization
   */
  @GeneratedMavEnumEntry
  RC_TARGETING(3L),
  /**
   * Load neutral position and start MAVLink Roll,Pitch,Yaw control with stabilization
   */
  @GeneratedMavEnumEntry
  MAVLINK_TARGETING(2L),
  /**
   * Load and keep neutral position (Roll,Pitch,Yaw) from permanent memory.
   */
  @GeneratedMavEnumEntry
  NEUTRAL(1L),
  /**
   * Load and keep safe position (Roll,Pitch,Yaw) from permant memory and stop stabilization
   */
  @GeneratedMavEnumEntry
  RETRACT(0L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavMountMode? = when (v) {
      6L -> HOME_LOCATION
      5L -> SYSID_TARGET
      4L -> GPS_POINT
      3L -> RC_TARGETING
      2L -> MAVLINK_TARGETING
      1L -> NEUTRAL
      0L -> RETRACT
      else -> null
    }
  }
}

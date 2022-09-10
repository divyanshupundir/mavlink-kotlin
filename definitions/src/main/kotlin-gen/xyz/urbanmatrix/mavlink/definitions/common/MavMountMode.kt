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
   * Load and keep safe position (Roll,Pitch,Yaw) from permant memory and stop stabilization
   */
  @GeneratedMavEnumEntry
  MAV_MOUNT_MODE_RETRACT(0L),
  /**
   * Load and keep neutral position (Roll,Pitch,Yaw) from permanent memory.
   */
  @GeneratedMavEnumEntry
  MAV_MOUNT_MODE_NEUTRAL(1L),
  /**
   * Load neutral position and start MAVLink Roll,Pitch,Yaw control with stabilization
   */
  @GeneratedMavEnumEntry
  MAV_MOUNT_MODE_MAVLINK_TARGETING(2L),
  /**
   * Load neutral position and start RC Roll,Pitch,Yaw control with stabilization
   */
  @GeneratedMavEnumEntry
  MAV_MOUNT_MODE_RC_TARGETING(3L),
  /**
   * Load neutral position and start to point to Lat,Lon,Alt
   */
  @GeneratedMavEnumEntry
  MAV_MOUNT_MODE_GPS_POINT(4L),
  /**
   * Gimbal tracks system with specified system ID
   */
  @GeneratedMavEnumEntry
  MAV_MOUNT_MODE_SYSID_TARGET(5L),
  /**
   * Gimbal tracks home position
   */
  @GeneratedMavEnumEntry
  MAV_MOUNT_MODE_HOME_LOCATION(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavMountMode? = when (v) {
      0L -> MAV_MOUNT_MODE_RETRACT
      1L -> MAV_MOUNT_MODE_NEUTRAL
      2L -> MAV_MOUNT_MODE_MAVLINK_TARGETING
      3L -> MAV_MOUNT_MODE_RC_TARGETING
      4L -> MAV_MOUNT_MODE_GPS_POINT
      5L -> MAV_MOUNT_MODE_SYSID_TARGET
      6L -> MAV_MOUNT_MODE_HOME_LOCATION
      else -> null
    }
  }
}

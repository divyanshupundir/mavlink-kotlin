package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavArmAuthDeniedReason(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Not a specific reason
   */
  @GeneratedMavEnumEntry
  MAV_ARM_AUTH_DENIED_REASON_GENERIC(0L),
  /**
   * Authorizer will send the error as string to GCS
   */
  @GeneratedMavEnumEntry
  MAV_ARM_AUTH_DENIED_REASON_NONE(1L),
  /**
   * At least one waypoint have a invalid value
   */
  @GeneratedMavEnumEntry
  MAV_ARM_AUTH_DENIED_REASON_INVALID_WAYPOINT(2L),
  /**
   * Timeout in the authorizer process(in case it depends on network)
   */
  @GeneratedMavEnumEntry
  MAV_ARM_AUTH_DENIED_REASON_TIMEOUT(3L),
  /**
   * Airspace of the mission in use by another vehicle, second result parameter can have the
   * waypoint id that caused it to be denied.
   */
  @GeneratedMavEnumEntry
  MAV_ARM_AUTH_DENIED_REASON_AIRSPACE_IN_USE(4L),
  /**
   * Weather is not good to fly
   */
  @GeneratedMavEnumEntry
  MAV_ARM_AUTH_DENIED_REASON_BAD_WEATHER(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavArmAuthDeniedReason? = when (v) {
      0L -> MAV_ARM_AUTH_DENIED_REASON_GENERIC
      1L -> MAV_ARM_AUTH_DENIED_REASON_NONE
      2L -> MAV_ARM_AUTH_DENIED_REASON_INVALID_WAYPOINT
      3L -> MAV_ARM_AUTH_DENIED_REASON_TIMEOUT
      4L -> MAV_ARM_AUTH_DENIED_REASON_AIRSPACE_IN_USE
      5L -> MAV_ARM_AUTH_DENIED_REASON_BAD_WEATHER
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavArmAuthDeniedReason(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Not a specific reason
   */
  @GeneratedMavEnumEntry
  GENERIC(0u),
  /**
   * Authorizer will send the error as string to GCS
   */
  @GeneratedMavEnumEntry
  NONE(1u),
  /**
   * At least one waypoint have a invalid value
   */
  @GeneratedMavEnumEntry
  INVALID_WAYPOINT(2u),
  /**
   * Timeout in the authorizer process(in case it depends on network)
   */
  @GeneratedMavEnumEntry
  TIMEOUT(3u),
  /**
   * Airspace of the mission in use by another vehicle, second result parameter can have the
   * waypoint id that caused it to be denied.
   */
  @GeneratedMavEnumEntry
  AIRSPACE_IN_USE(4u),
  /**
   * Weather is not good to fly
   */
  @GeneratedMavEnumEntry
  BAD_WEATHER(5u),
  ;

  public companion object : MavEnum.Companion<MavArmAuthDeniedReason> {
    public override fun getEntryFromValueOrNull(v: UInt): MavArmAuthDeniedReason? = when (v) {
      0u -> GENERIC
      1u -> NONE
      2u -> INVALID_WAYPOINT
      3u -> TIMEOUT
      4u -> AIRSPACE_IN_USE
      5u -> BAD_WEATHER
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Actions following geofence breach.
 */
@GeneratedMavEnum
public enum class FenceAction(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Disable fenced mode. If used in a plan this would mean the next fence is disabled.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Fly to geofence MAV_CMD_NAV_FENCE_RETURN_POINT in GUIDED mode. Note: This action is only
   * supported by ArduPlane, and may not be supported in all versions.
   */
  @GeneratedMavEnumEntry
  GUIDED(1u),
  /**
   * Report fence breach, but don't take action
   */
  @GeneratedMavEnumEntry
  REPORT(2u),
  /**
   * Fly to geofence MAV_CMD_NAV_FENCE_RETURN_POINT with manual throttle control in GUIDED mode.
   * Note: This action is only supported by ArduPlane, and may not be supported in all versions.
   */
  @GeneratedMavEnumEntry
  GUIDED_THR_PASS(3u),
  /**
   * Return/RTL mode.
   */
  @GeneratedMavEnumEntry
  RTL(4u),
  /**
   * Hold at current location.
   */
  @GeneratedMavEnumEntry
  HOLD(5u),
  /**
   * Termination failsafe. Motors are shut down (some flight stacks may trigger other failsafe
   * actions).
   */
  @GeneratedMavEnumEntry
  TERMINATE(6u),
  /**
   * Land at current location.
   */
  @GeneratedMavEnumEntry
  LAND(7u),
  ;

  public companion object : MavEnum.MavCompanion<FenceAction> {
    override fun getEntryFromValueOrNull(v: UInt): FenceAction? = when (v) {
      0u -> NONE
      1u -> GUIDED
      2u -> REPORT
      3u -> GUIDED_THR_PASS
      4u -> RTL
      5u -> HOLD
      6u -> TERMINATE
      7u -> LAND
      else -> null
    }
  }
}

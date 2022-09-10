package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Actions following geofence breach.
 */
@GeneratedMavEnum
public enum class FenceAction(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Disable fenced mode. If used in a plan this would mean the next fence is disabled.
   */
  @GeneratedMavEnumEntry
  FENCE_ACTION_NONE(0L),
  /**
   * Fly to geofence MAV_CMD_NAV_FENCE_RETURN_POINT in GUIDED mode. Note: This action is only
   * supported by ArduPlane, and may not be supported in all versions.
   */
  @GeneratedMavEnumEntry
  FENCE_ACTION_GUIDED(1L),
  /**
   * Report fence breach, but don't take action
   */
  @GeneratedMavEnumEntry
  FENCE_ACTION_REPORT(2L),
  /**
   * Fly to geofence MAV_CMD_NAV_FENCE_RETURN_POINT with manual throttle control in GUIDED mode.
   * Note: This action is only supported by ArduPlane, and may not be supported in all versions.
   */
  @GeneratedMavEnumEntry
  FENCE_ACTION_GUIDED_THR_PASS(3L),
  /**
   * Return/RTL mode.
   */
  @GeneratedMavEnumEntry
  FENCE_ACTION_RTL(4L),
  /**
   * Hold at current location.
   */
  @GeneratedMavEnumEntry
  FENCE_ACTION_HOLD(5L),
  /**
   * Termination failsafe. Motors are shut down (some flight stacks may trigger other failsafe
   * actions).
   */
  @GeneratedMavEnumEntry
  FENCE_ACTION_TERMINATE(6L),
  /**
   * Land at current location.
   */
  @GeneratedMavEnumEntry
  FENCE_ACTION_LAND(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FenceAction? = when (v) {
      0L -> FENCE_ACTION_NONE
      1L -> FENCE_ACTION_GUIDED
      2L -> FENCE_ACTION_REPORT
      3L -> FENCE_ACTION_GUIDED_THR_PASS
      4L -> FENCE_ACTION_RTL
      5L -> FENCE_ACTION_HOLD
      6L -> FENCE_ACTION_TERMINATE
      7L -> FENCE_ACTION_LAND
      else -> null
    }
  }
}

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
  NONE(0L),
  /**
   * Fly to geofence MAV_CMD_NAV_FENCE_RETURN_POINT in GUIDED mode. Note: This action is only
   * supported by ArduPlane, and may not be supported in all versions.
   */
  @GeneratedMavEnumEntry
  GUIDED(1L),
  /**
   * Report fence breach, but don't take action
   */
  @GeneratedMavEnumEntry
  REPORT(2L),
  /**
   * Fly to geofence MAV_CMD_NAV_FENCE_RETURN_POINT with manual throttle control in GUIDED mode.
   * Note: This action is only supported by ArduPlane, and may not be supported in all versions.
   */
  @GeneratedMavEnumEntry
  GUIDED_THR_PASS(3L),
  /**
   * Return/RTL mode.
   */
  @GeneratedMavEnumEntry
  RTL(4L),
  /**
   * Hold at current location.
   */
  @GeneratedMavEnumEntry
  HOLD(5L),
  /**
   * Termination failsafe. Motors are shut down (some flight stacks may trigger other failsafe
   * actions).
   */
  @GeneratedMavEnumEntry
  TERMINATE(6L),
  /**
   * Land at current location.
   */
  @GeneratedMavEnumEntry
  LAND(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FenceAction? = when (v) {
      0L -> NONE
      1L -> GUIDED
      2L -> REPORT
      3L -> GUIDED_THR_PASS
      4L -> RTL
      5L -> HOLD
      6L -> TERMINATE
      7L -> LAND
      else -> null
    }
  }
}

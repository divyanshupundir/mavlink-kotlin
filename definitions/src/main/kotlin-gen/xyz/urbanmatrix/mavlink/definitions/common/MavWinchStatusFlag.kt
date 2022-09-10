package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Winch status flags used in WINCH_STATUS
 */
@GeneratedMavEnum
public enum class MavWinchStatusFlag(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Winch is healthy
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_HEALTHY(1L),
  /**
   * Winch line is fully retracted
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_FULLY_RETRACTED(2L),
  /**
   * Winch motor is moving
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_MOVING(4L),
  /**
   * Winch clutch is engaged allowing motor to move freely.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_CLUTCH_ENGAGED(8L),
  /**
   * Winch is locked by locking mechanism.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_LOCKED(16L),
  /**
   * Winch is gravity dropping payload.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_DROPPING(32L),
  /**
   * Winch is arresting payload descent.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_ARRESTING(64L),
  /**
   * Winch is using torque measurements to sense the ground.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_GROUND_SENSE(128L),
  /**
   * Winch is returning to the fully retracted position.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_RETRACTING(256L),
  /**
   * Winch is redelivering the payload. This is a failover state if the line tension goes above a
   * threshold during RETRACTING.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_REDELIVER(512L),
  /**
   * Winch is abandoning the line and possibly payload. Winch unspools the entire calculated line
   * length. This is a failover state from REDELIVER if the number of attemps exceeds a threshold.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_ABANDON_LINE(1024L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavWinchStatusFlag? = when (v) {
      1L -> MAV_WINCH_STATUS_HEALTHY
      2L -> MAV_WINCH_STATUS_FULLY_RETRACTED
      4L -> MAV_WINCH_STATUS_MOVING
      8L -> MAV_WINCH_STATUS_CLUTCH_ENGAGED
      16L -> MAV_WINCH_STATUS_LOCKED
      32L -> MAV_WINCH_STATUS_DROPPING
      64L -> MAV_WINCH_STATUS_ARRESTING
      128L -> MAV_WINCH_STATUS_GROUND_SENSE
      256L -> MAV_WINCH_STATUS_RETRACTING
      512L -> MAV_WINCH_STATUS_REDELIVER
      1024L -> MAV_WINCH_STATUS_ABANDON_LINE
      else -> null
    }
  }
}

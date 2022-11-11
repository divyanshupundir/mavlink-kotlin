package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Winch status flags used in WINCH_STATUS
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavWinchStatusFlag(
  public override val `value`: Long,
) : MavBitmask {
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

    public fun getFlagsFromValue(v: Long): List<MavWinchStatusFlag> = buildList {
      if (v and 1L == 1L) add(MAV_WINCH_STATUS_HEALTHY)
      if (v and 2L == 2L) add(MAV_WINCH_STATUS_FULLY_RETRACTED)
      if (v and 4L == 4L) add(MAV_WINCH_STATUS_MOVING)
      if (v and 8L == 8L) add(MAV_WINCH_STATUS_CLUTCH_ENGAGED)
      if (v and 16L == 16L) add(MAV_WINCH_STATUS_LOCKED)
      if (v and 32L == 32L) add(MAV_WINCH_STATUS_DROPPING)
      if (v and 64L == 64L) add(MAV_WINCH_STATUS_ARRESTING)
      if (v and 128L == 128L) add(MAV_WINCH_STATUS_GROUND_SENSE)
      if (v and 256L == 256L) add(MAV_WINCH_STATUS_RETRACTING)
      if (v and 512L == 512L) add(MAV_WINCH_STATUS_REDELIVER)
      if (v and 1024L == 1024L) add(MAV_WINCH_STATUS_ABANDON_LINE)
    }
  }
}

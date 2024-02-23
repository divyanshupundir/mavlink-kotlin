package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Winch status flags used in WINCH_STATUS
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavWinchStatusFlag(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Winch is healthy
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_HEALTHY(1u),
  /**
   * Winch line is fully retracted
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_FULLY_RETRACTED(2u),
  /**
   * Winch motor is moving
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_MOVING(4u),
  /**
   * Winch clutch is engaged allowing motor to move freely.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_CLUTCH_ENGAGED(8u),
  /**
   * Winch is locked by locking mechanism.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_LOCKED(16u),
  /**
   * Winch is gravity dropping payload.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_DROPPING(32u),
  /**
   * Winch is arresting payload descent.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_ARRESTING(64u),
  /**
   * Winch is using torque measurements to sense the ground.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_GROUND_SENSE(128u),
  /**
   * Winch is returning to the fully retracted position.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_RETRACTING(256u),
  /**
   * Winch is redelivering the payload. This is a failover state if the line tension goes above a
   * threshold during RETRACTING.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_REDELIVER(512u),
  /**
   * Winch is abandoning the line and possibly payload. Winch unspools the entire calculated line
   * length. This is a failover state from REDELIVER if the number of attempts exceeds a threshold.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_ABANDON_LINE(1_024u),
  /**
   * Winch is engaging the locking mechanism.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_LOCKING(2_048u),
  /**
   * Winch is spooling on line.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_LOAD_LINE(4_096u),
  /**
   * Winch is loading a payload.
   */
  @GeneratedMavEnumEntry
  MAV_WINCH_STATUS_LOAD_PAYLOAD(8_192u),
  ;

  public companion object : MavBitmask.MavCompanion<MavWinchStatusFlag> {
    override fun getEntryFromValueOrNull(v: UInt): MavWinchStatusFlag? = when (v) {
      1u -> MAV_WINCH_STATUS_HEALTHY
      2u -> MAV_WINCH_STATUS_FULLY_RETRACTED
      4u -> MAV_WINCH_STATUS_MOVING
      8u -> MAV_WINCH_STATUS_CLUTCH_ENGAGED
      16u -> MAV_WINCH_STATUS_LOCKED
      32u -> MAV_WINCH_STATUS_DROPPING
      64u -> MAV_WINCH_STATUS_ARRESTING
      128u -> MAV_WINCH_STATUS_GROUND_SENSE
      256u -> MAV_WINCH_STATUS_RETRACTING
      512u -> MAV_WINCH_STATUS_REDELIVER
      1024u -> MAV_WINCH_STATUS_ABANDON_LINE
      2048u -> MAV_WINCH_STATUS_LOCKING
      4096u -> MAV_WINCH_STATUS_LOAD_LINE
      8192u -> MAV_WINCH_STATUS_LOAD_PAYLOAD
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavWinchStatusFlag> = buildList {
      if (v and 1u == 1u) add(MAV_WINCH_STATUS_HEALTHY)
      if (v and 2u == 2u) add(MAV_WINCH_STATUS_FULLY_RETRACTED)
      if (v and 4u == 4u) add(MAV_WINCH_STATUS_MOVING)
      if (v and 8u == 8u) add(MAV_WINCH_STATUS_CLUTCH_ENGAGED)
      if (v and 16u == 16u) add(MAV_WINCH_STATUS_LOCKED)
      if (v and 32u == 32u) add(MAV_WINCH_STATUS_DROPPING)
      if (v and 64u == 64u) add(MAV_WINCH_STATUS_ARRESTING)
      if (v and 128u == 128u) add(MAV_WINCH_STATUS_GROUND_SENSE)
      if (v and 256u == 256u) add(MAV_WINCH_STATUS_RETRACTING)
      if (v and 512u == 512u) add(MAV_WINCH_STATUS_REDELIVER)
      if (v and 1024u == 1024u) add(MAV_WINCH_STATUS_ABANDON_LINE)
      if (v and 2048u == 2048u) add(MAV_WINCH_STATUS_LOCKING)
      if (v and 4096u == 4096u) add(MAV_WINCH_STATUS_LOAD_LINE)
      if (v and 8192u == 8192u) add(MAV_WINCH_STATUS_LOAD_PAYLOAD)
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 *
 *         States of the mission state machine.
 *         Note that these states are independent of whether the mission is in a mode that can
 * execute mission items or not (is suspended).
 *         They may not all be relevant on all vehicles.
 *       
 */
@GeneratedMavEnum
public enum class MissionState(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The mission status reporting is not supported.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * No mission on the vehicle.
   */
  @GeneratedMavEnumEntry
  NO_MISSION(1u),
  /**
   * Mission has not started. This is the case after a mission has uploaded but not yet started
   * executing.
   */
  @GeneratedMavEnumEntry
  NOT_STARTED(2u),
  /**
   * Mission is active, and will execute mission items when in auto mode.
   */
  @GeneratedMavEnumEntry
  ACTIVE(3u),
  /**
   * Mission is paused when in auto mode.
   */
  @GeneratedMavEnumEntry
  PAUSED(4u),
  /**
   * Mission has executed all mission items.
   */
  @GeneratedMavEnumEntry
  COMPLETE(5u),
  ;

  public companion object : MavEnum.MavCompanion<MissionState> {
    override fun getEntryFromValueOrNull(v: UInt): MissionState? = when (v) {
      0u -> UNKNOWN
      1u -> NO_MISSION
      2u -> NOT_STARTED
      3u -> ACTIVE
      4u -> PAUSED
      5u -> COMPLETE
      else -> null
    }
  }
}

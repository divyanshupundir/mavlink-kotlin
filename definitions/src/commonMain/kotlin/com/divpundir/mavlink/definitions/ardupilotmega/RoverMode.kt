package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * A mapping of rover flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class RoverMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * MANUAL
   */
  @GeneratedMavEnumEntry
  MANUAL(0u),
  /**
   * ACRO
   */
  @GeneratedMavEnumEntry
  ACRO(1u),
  /**
   * STEERING
   */
  @GeneratedMavEnumEntry
  STEERING(3u),
  /**
   * HOLD
   */
  @GeneratedMavEnumEntry
  HOLD(4u),
  /**
   * LOITER
   */
  @GeneratedMavEnumEntry
  LOITER(5u),
  /**
   * FOLLOW
   */
  @GeneratedMavEnumEntry
  FOLLOW(6u),
  /**
   * SIMPLE
   */
  @GeneratedMavEnumEntry
  SIMPLE(7u),
  /**
   * DOCK
   */
  @GeneratedMavEnumEntry
  DOCK(8u),
  /**
   * CIRCLE
   */
  @GeneratedMavEnumEntry
  CIRCLE(9u),
  /**
   * AUTO
   */
  @GeneratedMavEnumEntry
  AUTO(10u),
  /**
   * RTL
   */
  @GeneratedMavEnumEntry
  RTL(11u),
  /**
   * SMART RTL
   */
  @GeneratedMavEnumEntry
  SMART_RTL(12u),
  /**
   * GUIDED
   */
  @GeneratedMavEnumEntry
  GUIDED(15u),
  /**
   * INITIALISING
   */
  @GeneratedMavEnumEntry
  INITIALIZING(16u),
  ;

  public companion object : MavEnum.MavCompanion<RoverMode> {
    override fun getEntryFromValueOrNull(v: UInt): RoverMode? = when (v) {
      0u -> MANUAL
      1u -> ACRO
      3u -> STEERING
      4u -> HOLD
      5u -> LOITER
      6u -> FOLLOW
      7u -> SIMPLE
      8u -> DOCK
      9u -> CIRCLE
      10u -> AUTO
      11u -> RTL
      12u -> SMART_RTL
      15u -> GUIDED
      16u -> INITIALIZING
      else -> null
    }
  }
}

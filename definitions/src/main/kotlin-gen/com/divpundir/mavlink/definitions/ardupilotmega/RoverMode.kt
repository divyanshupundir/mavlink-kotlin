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
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  MANUAL(0u),
  @GeneratedMavEnumEntry
  ACRO(1u),
  @GeneratedMavEnumEntry
  STEERING(3u),
  @GeneratedMavEnumEntry
  HOLD(4u),
  @GeneratedMavEnumEntry
  LOITER(5u),
  @GeneratedMavEnumEntry
  FOLLOW(6u),
  @GeneratedMavEnumEntry
  SIMPLE(7u),
  @GeneratedMavEnumEntry
  AUTO(10u),
  @GeneratedMavEnumEntry
  RTL(11u),
  @GeneratedMavEnumEntry
  SMART_RTL(12u),
  @GeneratedMavEnumEntry
  GUIDED(15u),
  @GeneratedMavEnumEntry
  INITIALIZING(16u),
  ;

  public companion object : MavEnum.Companion<RoverMode> {
    public override fun getEntryFromValueOrNull(v: UInt): RoverMode? = when (v) {
      0u -> MANUAL
      1u -> ACRO
      3u -> STEERING
      4u -> HOLD
      5u -> LOITER
      6u -> FOLLOW
      7u -> SIMPLE
      10u -> AUTO
      11u -> RTL
      12u -> SMART_RTL
      15u -> GUIDED
      16u -> INITIALIZING
      else -> null
    }
  }
}

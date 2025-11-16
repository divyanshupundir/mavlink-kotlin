package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags used to report computer status.
 */
@GeneratedMavEnum(bitmask = true)
public enum class ComputerStatusFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Indicates if the system is experiencing voltage outside of acceptable range.
   */
  @GeneratedMavEnumEntry
  UNDER_VOLTAGE(1u),
  /**
   * Indicates if CPU throttling is active.
   */
  @GeneratedMavEnumEntry
  CPU_THROTTLE(2u),
  /**
   * Indicates if thermal throttling is active.
   */
  @GeneratedMavEnumEntry
  THERMAL_THROTTLE(4u),
  /**
   * Indicates if main disk is full.
   */
  @GeneratedMavEnumEntry
  DISK_FULL(8u),
  ;

  public companion object : MavBitmask.MavCompanion<ComputerStatusFlags> {
    override fun getEntryFromValueOrNull(v: UInt): ComputerStatusFlags? = when (v) {
      1u -> UNDER_VOLTAGE
      2u -> CPU_THROTTLE
      4u -> THERMAL_THROTTLE
      8u -> DISK_FULL
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<ComputerStatusFlags> = buildList {
      if (v and 1u == 1u) add(UNDER_VOLTAGE)
      if (v and 2u == 2u) add(CPU_THROTTLE)
      if (v and 4u == 4u) add(THERMAL_THROTTLE)
      if (v and 8u == 8u) add(DISK_FULL)
    }
  }
}

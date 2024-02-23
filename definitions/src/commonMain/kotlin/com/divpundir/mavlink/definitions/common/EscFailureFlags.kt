package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags to report ESC failures.
 */
@GeneratedMavEnum(bitmask = true)
public enum class EscFailureFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * No ESC failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_NONE(0u),
  /**
   * Over current failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_OVER_CURRENT(1u),
  /**
   * Over voltage failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_OVER_VOLTAGE(2u),
  /**
   * Over temperature failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_OVER_TEMPERATURE(4u),
  /**
   * Over RPM failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_OVER_RPM(8u),
  /**
   * Inconsistent command failure i.e. out of bounds.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_INCONSISTENT_CMD(16u),
  /**
   * Motor stuck failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_MOTOR_STUCK(32u),
  /**
   * Generic ESC failure.
   */
  @GeneratedMavEnumEntry
  ESC_FAILURE_GENERIC(64u),
  ;

  public companion object : MavBitmask.MavCompanion<EscFailureFlags> {
    override fun getEntryFromValueOrNull(v: UInt): EscFailureFlags? = when (v) {
      0u -> ESC_FAILURE_NONE
      1u -> ESC_FAILURE_OVER_CURRENT
      2u -> ESC_FAILURE_OVER_VOLTAGE
      4u -> ESC_FAILURE_OVER_TEMPERATURE
      8u -> ESC_FAILURE_OVER_RPM
      16u -> ESC_FAILURE_INCONSISTENT_CMD
      32u -> ESC_FAILURE_MOTOR_STUCK
      64u -> ESC_FAILURE_GENERIC
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<EscFailureFlags> = buildList {
      if (v and 0u == 0u) add(ESC_FAILURE_NONE)
      if (v and 1u == 1u) add(ESC_FAILURE_OVER_CURRENT)
      if (v and 2u == 2u) add(ESC_FAILURE_OVER_VOLTAGE)
      if (v and 4u == 4u) add(ESC_FAILURE_OVER_TEMPERATURE)
      if (v and 8u == 8u) add(ESC_FAILURE_OVER_RPM)
      if (v and 16u == 16u) add(ESC_FAILURE_INCONSISTENT_CMD)
      if (v and 32u == 32u) add(ESC_FAILURE_MOTOR_STUCK)
      if (v and 64u == 64u) add(ESC_FAILURE_GENERIC)
    }
  }
}

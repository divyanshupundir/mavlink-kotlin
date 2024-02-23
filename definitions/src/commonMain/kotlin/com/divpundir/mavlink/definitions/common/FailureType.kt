package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * List of possible failure type to inject.
 */
@GeneratedMavEnum
public enum class FailureType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No failure injected, used to reset a previous failure.
   */
  @GeneratedMavEnumEntry
  OK(0u),
  /**
   * Sets unit off, so completely non-responsive.
   */
  @GeneratedMavEnumEntry
  OFF(1u),
  /**
   * Unit is stuck e.g. keeps reporting the same value.
   */
  @GeneratedMavEnumEntry
  STUCK(2u),
  /**
   * Unit is reporting complete garbage.
   */
  @GeneratedMavEnumEntry
  GARBAGE(3u),
  /**
   * Unit is consistently wrong.
   */
  @GeneratedMavEnumEntry
  WRONG(4u),
  /**
   * Unit is slow, so e.g. reporting at slower than expected rate.
   */
  @GeneratedMavEnumEntry
  SLOW(5u),
  /**
   * Data of unit is delayed in time.
   */
  @GeneratedMavEnumEntry
  DELAYED(6u),
  /**
   * Unit is sometimes working, sometimes not.
   */
  @GeneratedMavEnumEntry
  INTERMITTENT(7u),
  ;

  public companion object : MavEnum.MavCompanion<FailureType> {
    override fun getEntryFromValueOrNull(v: UInt): FailureType? = when (v) {
      0u -> OK
      1u -> OFF
      2u -> STUCK
      3u -> GARBAGE
      4u -> WRONG
      5u -> SLOW
      6u -> DELAYED
      7u -> INTERMITTENT
      else -> null
    }
  }
}

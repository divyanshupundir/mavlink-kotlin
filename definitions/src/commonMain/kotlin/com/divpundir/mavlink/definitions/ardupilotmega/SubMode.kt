package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * A mapping of sub flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class SubMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * STABILIZE
   */
  @GeneratedMavEnumEntry
  STABILIZE(0u),
  /**
   * ACRO
   */
  @GeneratedMavEnumEntry
  ACRO(1u),
  /**
   * ALT HOLD
   */
  @GeneratedMavEnumEntry
  ALT_HOLD(2u),
  /**
   * AUTO
   */
  @GeneratedMavEnumEntry
  AUTO(3u),
  /**
   * GUIDED
   */
  @GeneratedMavEnumEntry
  GUIDED(4u),
  /**
   * CIRCLE
   */
  @GeneratedMavEnumEntry
  CIRCLE(7u),
  /**
   * SURFACE
   */
  @GeneratedMavEnumEntry
  SURFACE(9u),
  /**
   * POSHOLD
   */
  @GeneratedMavEnumEntry
  POSHOLD(16u),
  /**
   * MANUAL
   */
  @GeneratedMavEnumEntry
  MANUAL(19u),
  /**
   * MOTORDETECT
   */
  @GeneratedMavEnumEntry
  MOTORDETECT(20u),
  /**
   * SURFTRAK
   */
  @GeneratedMavEnumEntry
  SURFTRAK(21u),
  ;

  public companion object : MavEnum.MavCompanion<SubMode> {
    override fun getEntryFromValueOrNull(v: UInt): SubMode? = when (v) {
      0u -> STABILIZE
      1u -> ACRO
      2u -> ALT_HOLD
      3u -> AUTO
      4u -> GUIDED
      7u -> CIRCLE
      9u -> SURFACE
      16u -> POSHOLD
      19u -> MANUAL
      20u -> MOTORDETECT
      21u -> SURFTRAK
      else -> null
    }
  }
}

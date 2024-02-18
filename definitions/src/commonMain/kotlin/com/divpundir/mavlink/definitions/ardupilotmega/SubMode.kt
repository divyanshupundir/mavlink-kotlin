package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * A mapping of sub flight modes for custom_mode field of heartbeat.
 *
 */
@GeneratedMavEnum
public enum class SubMode(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  STABILIZE(0u),
  @GeneratedMavEnumEntry
  ACRO(1u),
  @GeneratedMavEnumEntry
  ALT_HOLD(2u),
  @GeneratedMavEnumEntry
  AUTO(3u),
  @GeneratedMavEnumEntry
  GUIDED(4u),
  @GeneratedMavEnumEntry
  CIRCLE(7u),
  @GeneratedMavEnumEntry
  SURFACE(9u),
  @GeneratedMavEnumEntry
  POSHOLD(16u),
  @GeneratedMavEnumEntry
  MANUAL(19u),
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
      else -> null
    }
  }
}

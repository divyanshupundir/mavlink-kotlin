package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class NavVtolLandOptions(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Default autopilot landing behaviour.
   */
  @GeneratedMavEnumEntry
  DEFAULT(0u),
  /**
   * Use a fixed wing spiral desent approach before landing.
   */
  @GeneratedMavEnumEntry
  FW_SPIRAL_APPROACH(1u),
  /**
   * Use a fixed wing approach before detransitioning and landing vertically.
   */
  @GeneratedMavEnumEntry
  FW_APPROACH(2u),
  ;

  public companion object : MavEnum.MavCompanion<NavVtolLandOptions> {
    override fun getEntryFromValueOrNull(v: UInt): NavVtolLandOptions? = when (v) {
      0u -> DEFAULT
      1u -> FW_SPIRAL_APPROACH
      2u -> FW_APPROACH
      else -> null
    }
  }
}

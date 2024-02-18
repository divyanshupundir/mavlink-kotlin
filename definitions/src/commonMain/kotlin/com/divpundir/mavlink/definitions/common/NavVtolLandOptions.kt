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
   * Descend in fixed wing mode, transitioning to multicopter mode for vertical landing when close
   * to the ground.
   *           The fixed wing descent pattern is at the discretion of the vehicle (e.g. transition
   * altitude, loiter direction, radius, and speed, etc.).
   *         
   */
  @GeneratedMavEnumEntry
  FW_DESCENT(1u),
  /**
   * Land in multicopter mode on reaching the landing coordinates (the whole landing is by "hover
   * descent").
   */
  @GeneratedMavEnumEntry
  HOVER_DESCENT(2u),
  ;

  public companion object : MavEnum.MavCompanion<NavVtolLandOptions> {
    override fun getEntryFromValueOrNull(v: UInt): NavVtolLandOptions? = when (v) {
      0u -> DEFAULT
      1u -> FW_DESCENT
      2u -> HOVER_DESCENT
      else -> null
    }
  }
}

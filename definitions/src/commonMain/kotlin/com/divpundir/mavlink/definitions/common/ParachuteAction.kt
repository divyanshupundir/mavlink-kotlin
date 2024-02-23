package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Parachute actions. Trigger release and enable/disable auto-release.
 */
@GeneratedMavEnum
public enum class ParachuteAction(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Disable auto-release of parachute (i.e. release triggered by crash detectors).
   */
  @GeneratedMavEnumEntry
  PARACHUTE_DISABLE(0u),
  /**
   * Enable auto-release of parachute.
   */
  @GeneratedMavEnumEntry
  PARACHUTE_ENABLE(1u),
  /**
   * Release parachute and kill motors.
   */
  @GeneratedMavEnumEntry
  PARACHUTE_RELEASE(2u),
  ;

  public companion object : MavEnum.MavCompanion<ParachuteAction> {
    override fun getEntryFromValueOrNull(v: UInt): ParachuteAction? = when (v) {
      0u -> PARACHUTE_DISABLE
      1u -> PARACHUTE_ENABLE
      2u -> PARACHUTE_RELEASE
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 *
 * 	Possible safety switch states.
 *       
 */
@GeneratedMavEnum
public enum class SafetySwitchState(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Safety switch is engaged and vehicle should be safe to approach.
   */
  @GeneratedMavEnumEntry
  SAFE(0u),
  /**
   * Safety switch is NOT engaged and motors, propellers and other actuators should be considered
   * active.
   */
  @GeneratedMavEnumEntry
  DANGEROUS(1u),
  ;

  public companion object : MavEnum.MavCompanion<SafetySwitchState> {
    override fun getEntryFromValueOrNull(v: UInt): SafetySwitchState? = when (v) {
      0u -> SAFE
      1u -> DANGEROUS
      else -> null
    }
  }
}

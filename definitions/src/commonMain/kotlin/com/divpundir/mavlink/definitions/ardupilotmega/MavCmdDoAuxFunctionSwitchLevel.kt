package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavCmdDoAuxFunctionSwitchLevel(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Switch Low.
   */
  @GeneratedMavEnumEntry
  LOW(0u),
  /**
   * Switch Middle.
   */
  @GeneratedMavEnumEntry
  MIDDLE(1u),
  /**
   * Switch High.
   */
  @GeneratedMavEnumEntry
  HIGH(2u),
  ;

  public companion object : MavEnum.MavCompanion<MavCmdDoAuxFunctionSwitchLevel> {
    public override fun getEntryFromValueOrNull(v: UInt): MavCmdDoAuxFunctionSwitchLevel? = when (v)
        {
      0u -> LOW
      1u -> MIDDLE
      2u -> HIGH
      else -> null
    }
  }
}

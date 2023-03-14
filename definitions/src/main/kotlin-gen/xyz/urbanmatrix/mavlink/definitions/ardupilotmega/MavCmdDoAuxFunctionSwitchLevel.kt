package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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

  public companion object : MavEnum.Companion<MavCmdDoAuxFunctionSwitchLevel> {
    public override fun getEntryFromValueOrNull(v: UInt): MavCmdDoAuxFunctionSwitchLevel? = when (v)
        {
      0u -> LOW
      1u -> MIDDLE
      2u -> HIGH
      else -> null
    }
  }
}

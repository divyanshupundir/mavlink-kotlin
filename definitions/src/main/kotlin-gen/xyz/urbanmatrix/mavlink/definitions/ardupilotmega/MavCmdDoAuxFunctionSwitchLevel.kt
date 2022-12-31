package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavCmdDoAuxFunctionSwitchLevel(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Switch Low.
   */
  @GeneratedMavEnumEntry
  LOW(0L),
  /**
   * Switch Middle.
   */
  @GeneratedMavEnumEntry
  MIDDLE(1L),
  /**
   * Switch High.
   */
  @GeneratedMavEnumEntry
  HIGH(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCmdDoAuxFunctionSwitchLevel? = when (v) {
      0L -> LOW
      1L -> MIDDLE
      2L -> HIGH
      else -> null
    }
  }
}

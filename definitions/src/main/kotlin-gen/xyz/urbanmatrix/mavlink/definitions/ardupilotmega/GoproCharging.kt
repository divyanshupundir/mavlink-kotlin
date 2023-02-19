package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproCharging(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Charging disabled.
   */
  @GeneratedMavEnumEntry
  DISABLED(0u),
  /**
   * Charging enabled.
   */
  @GeneratedMavEnumEntry
  ENABLED(1u),
  ;

  public companion object : MavEnum.Companion<GoproCharging> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproCharging? = when (v) {
      0u -> DISABLED
      1u -> ENABLED
      else -> null
    }
  }
}

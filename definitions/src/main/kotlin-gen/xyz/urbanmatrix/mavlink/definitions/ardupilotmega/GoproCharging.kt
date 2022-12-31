package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproCharging(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Charging disabled.
   */
  @GeneratedMavEnumEntry
  DISABLED(0L),
  /**
   * Charging enabled.
   */
  @GeneratedMavEnumEntry
  ENABLED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproCharging? = when (v) {
      0L -> DISABLED
      1L -> ENABLED
      else -> null
    }
  }
}

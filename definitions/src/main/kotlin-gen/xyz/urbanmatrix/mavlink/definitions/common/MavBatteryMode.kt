package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Battery mode. Note, the normal operation mode (i.e. when flying) should be reported as
 * MAV_BATTERY_MODE_UNKNOWN to allow message trimming in normal flight.
 */
@GeneratedMavEnum
public enum class MavBatteryMode(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Battery mode not supported/unknown battery mode/normal operation.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Battery is auto discharging (towards storage level).
   */
  @GeneratedMavEnumEntry
  AUTO_DISCHARGING(1u),
  /**
   * Battery in hot-swap mode (current limited to prevent spikes that might damage sensitive
   * electrical circuits).
   */
  @GeneratedMavEnumEntry
  HOT_SWAP(2u),
  ;

  public companion object : MavEnum.Companion<MavBatteryMode> {
    public override fun getEntryFromValueOrNull(v: UInt): MavBatteryMode? = when (v) {
      0u -> UNKNOWN
      1u -> AUTO_DISCHARGING
      2u -> HOT_SWAP
      else -> null
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Battery mode. Note, the normal operation mode (i.e. when flying) should be reported as
 * MAV_BATTERY_MODE_UNKNOWN to allow message trimming in normal flight.
 */
@GeneratedMavEnum
public enum class MavBatteryMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Battery mode not supported/unknown battery mode/normal operation.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * Battery is auto discharging (towards storage level).
   */
  @GeneratedMavEnumEntry
  AUTO_DISCHARGING(1L),
  /**
   * Battery in hot-swap mode (current limited to prevent spikes that might damage sensitive
   * electrical circuits).
   */
  @GeneratedMavEnumEntry
  HOT_SWAP(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryMode? = when (v) {
      0L -> UNKNOWN
      1L -> AUTO_DISCHARGING
      2L -> HOT_SWAP
      else -> null
    }
  }
}

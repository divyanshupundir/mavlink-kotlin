package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

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
  MAV_BATTERY_MODE_UNKNOWN(0L),
  /**
   * Battery is auto discharging (towards storage level).
   */
  MAV_BATTERY_MODE_AUTO_DISCHARGING(1L),
  /**
   * Battery in hot-swap mode (current limited to prevent spikes that might damage sensitive
   * electrical circuits).
   */
  MAV_BATTERY_MODE_HOT_SWAP(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryMode? = when (v) {
      0L -> MAV_BATTERY_MODE_UNKNOWN
      1L -> MAV_BATTERY_MODE_AUTO_DISCHARGING
      2L -> MAV_BATTERY_MODE_HOT_SWAP
      else -> null
    }
  }
}

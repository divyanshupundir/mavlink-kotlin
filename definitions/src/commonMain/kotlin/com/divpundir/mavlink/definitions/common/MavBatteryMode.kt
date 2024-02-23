package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Battery mode. Note, the normal operation mode (i.e. when flying) should be reported as
 * MAV_BATTERY_MODE_UNKNOWN to allow message trimming in normal flight.
 */
@GeneratedMavEnum
public enum class MavBatteryMode(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<MavBatteryMode> {
    override fun getEntryFromValueOrNull(v: UInt): MavBatteryMode? = when (v) {
      0u -> UNKNOWN
      1u -> AUTO_DISCHARGING
      2u -> HOT_SWAP
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidOperatorLocationType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The location/altitude of the operator is the same as the take-off location.
   */
  @GeneratedMavEnumEntry
  TAKEOFF(0u),
  /**
   * The location/altitude of the operator is dynamic. E.g. based on live GNSS data.
   */
  @GeneratedMavEnumEntry
  LIVE_GNSS(1u),
  /**
   * The location/altitude of the operator are fixed values.
   */
  @GeneratedMavEnumEntry
  FIXED(2u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidOperatorLocationType> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidOperatorLocationType? = when (v) {
      0u -> TAKEOFF
      1u -> LIVE_GNSS
      2u -> FIXED
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * RTK GPS baseline coordinate system, used for RTK corrections
 */
@GeneratedMavEnum
public enum class RtkBaselineCoordinateSystem(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Earth-centered, Earth-fixed
   */
  @GeneratedMavEnumEntry
  ECEF(0u),
  /**
   * RTK basestation centered, north, east, down
   */
  @GeneratedMavEnumEntry
  NED(1u),
  ;

  public companion object : MavEnum.MavCompanion<RtkBaselineCoordinateSystem> {
    override fun getEntryFromValueOrNull(v: UInt): RtkBaselineCoordinateSystem? = when (v) {
      0u -> ECEF
      1u -> NED
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Enumeration of the ADSB altimeter types
 */
@GeneratedMavEnum
public enum class AdsbAltitudeType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Altitude reported from a Baro source using QNH reference
   */
  @GeneratedMavEnumEntry
  PRESSURE_QNH(0u),
  /**
   * Altitude reported from a GNSS source
   */
  @GeneratedMavEnumEntry
  GEOMETRIC(1u),
  ;

  public companion object : MavEnum.MavCompanion<AdsbAltitudeType> {
    override fun getEntryFromValueOrNull(v: UInt): AdsbAltitudeType? = when (v) {
      0u -> PRESSURE_QNH
      1u -> GEOMETRIC
      else -> null
    }
  }
}

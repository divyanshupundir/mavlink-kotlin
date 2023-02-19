package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of the ADSB altimeter types
 */
@GeneratedMavEnum
public enum class AdsbAltitudeType(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<AdsbAltitudeType> {
    public override fun getEntryFromValueOrNull(v: UInt): AdsbAltitudeType? = when (v) {
      0u -> PRESSURE_QNH
      1u -> GEOMETRIC
      else -> null
    }
  }
}

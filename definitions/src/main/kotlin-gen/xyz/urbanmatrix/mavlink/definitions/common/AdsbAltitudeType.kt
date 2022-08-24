package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of the ADSB altimeter types
 */
@GeneratedMavEnum
public enum class AdsbAltitudeType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Altitude reported from a Baro source using QNH reference
   */
  ADSB_ALTITUDE_TYPE_PRESSURE_QNH(0L),
  /**
   * Altitude reported from a GNSS source
   */
  ADSB_ALTITUDE_TYPE_GEOMETRIC(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AdsbAltitudeType? = when (v) {
      0L -> ADSB_ALTITUDE_TYPE_PRESSURE_QNH
      1L -> ADSB_ALTITUDE_TYPE_GEOMETRIC
      else -> null
    }
  }
}

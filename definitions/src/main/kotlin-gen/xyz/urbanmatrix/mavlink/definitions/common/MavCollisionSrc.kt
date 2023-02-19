package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Source of information about this collision.
 */
@GeneratedMavEnum
public enum class MavCollisionSrc(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * ID field references ADSB_VEHICLE packets
   */
  @GeneratedMavEnumEntry
  ADSB(0u),
  /**
   * ID field references MAVLink SRC ID
   */
  @GeneratedMavEnumEntry
  MAVLINK_GPS_GLOBAL_INT(1u),
  ;

  public companion object : MavEnum.Companion<MavCollisionSrc> {
    public override fun getEntryFromValueOrNull(v: UInt): MavCollisionSrc? = when (v) {
      0u -> ADSB
      1u -> MAVLINK_GPS_GLOBAL_INT
      else -> null
    }
  }
}

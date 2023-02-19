package xyz.urbanmatrix.mavlink.definitions.ualberta

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Navigation filter mode
 */
@GeneratedMavEnum
public enum class UalbertaNavMode(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  NAV_AHRS_INIT(1u),
  /**
   * AHRS mode
   */
  @GeneratedMavEnumEntry
  NAV_AHRS(2u),
  /**
   * INS/GPS initialization mode
   */
  @GeneratedMavEnumEntry
  NAV_INS_GPS_INIT(3u),
  /**
   * INS/GPS mode
   */
  @GeneratedMavEnumEntry
  NAV_INS_GPS(4u),
  ;

  public companion object : MavEnum.Companion<UalbertaNavMode> {
    public override fun getEntryFromValueOrNull(v: UInt): UalbertaNavMode? = when (v) {
      1u -> NAV_AHRS_INIT
      2u -> NAV_AHRS
      3u -> NAV_INS_GPS_INIT
      4u -> NAV_INS_GPS
      else -> null
    }
  }
}

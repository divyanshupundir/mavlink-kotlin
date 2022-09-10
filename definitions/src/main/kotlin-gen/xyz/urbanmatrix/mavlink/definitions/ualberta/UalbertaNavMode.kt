package xyz.urbanmatrix.mavlink.definitions.ualberta

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Navigation filter mode
 */
@GeneratedMavEnum
public enum class UalbertaNavMode(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  NAV_AHRS_INIT(1L),
  /**
   * AHRS mode
   */
  @GeneratedMavEnumEntry
  NAV_AHRS(2L),
  /**
   * INS/GPS initialization mode
   */
  @GeneratedMavEnumEntry
  NAV_INS_GPS_INIT(3L),
  /**
   * INS/GPS mode
   */
  @GeneratedMavEnumEntry
  NAV_INS_GPS(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UalbertaNavMode? = when (v) {
      1L -> NAV_AHRS_INIT
      2L -> NAV_AHRS
      3L -> NAV_INS_GPS_INIT
      4L -> NAV_INS_GPS
      else -> null
    }
  }
}

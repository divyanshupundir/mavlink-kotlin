package com.urbanmatrix.mavlink.definitions.ualberta

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Navigation filter mode
 */
@GeneratedMavEnum
public enum class UalbertaNavMode(
  public override val `value`: Long,
) : MavEnum {
  NAV_AHRS_INIT(1L),
  /**
   * AHRS mode
   */
  NAV_AHRS(2L),
  /**
   * INS/GPS initialization mode
   */
  NAV_INS_GPS_INIT(3L),
  /**
   * INS/GPS mode
   */
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

package xyz.urbanmatrix.mavlink.definitions.asluav

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GsmLinkType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * no service
   */
  @GeneratedMavEnumEntry
  NONE(0L),
  /**
   * link type unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(1L),
  /**
   * 2G (GSM/GRPS/EDGE) link
   */
  @GeneratedMavEnumEntry
  _2G(2L),
  /**
   * 3G link (WCDMA/HSDPA/HSPA) 
   */
  @GeneratedMavEnumEntry
  _3G(3L),
  /**
   * 4G link (LTE)
   */
  @GeneratedMavEnumEntry
  _4G(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GsmLinkType? = when (v) {
      0L -> NONE
      1L -> UNKNOWN
      2L -> _2G
      3L -> _3G
      4L -> _4G
      else -> null
    }
  }
}

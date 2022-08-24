package xyz.urbanmatrix.mavlink.definitions.asluav

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GsmLinkType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * no service
   */
  GSM_LINK_TYPE_NONE(0L),
  /**
   * link type unknown
   */
  GSM_LINK_TYPE_UNKNOWN(1L),
  /**
   * 2G (GSM/GRPS/EDGE) link
   */
  GSM_LINK_TYPE_2G(2L),
  /**
   * 3G link (WCDMA/HSDPA/HSPA) 
   */
  GSM_LINK_TYPE_3G(3L),
  /**
   * 4G link (LTE)
   */
  GSM_LINK_TYPE_4G(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GsmLinkType? = when (v) {
      0L -> GSM_LINK_TYPE_NONE
      1L -> GSM_LINK_TYPE_UNKNOWN
      2L -> GSM_LINK_TYPE_2G
      3L -> GSM_LINK_TYPE_3G
      4L -> GSM_LINK_TYPE_4G
      else -> null
    }
  }
}

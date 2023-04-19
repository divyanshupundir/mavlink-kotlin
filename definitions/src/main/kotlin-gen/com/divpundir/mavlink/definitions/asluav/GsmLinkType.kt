package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GsmLinkType(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * no service
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * link type unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(1u),
  /**
   * 2G (GSM/GRPS/EDGE) link
   */
  @GeneratedMavEnumEntry
  _2G(2u),
  /**
   * 3G link (WCDMA/HSDPA/HSPA) 
   */
  @GeneratedMavEnumEntry
  _3G(3u),
  /**
   * 4G link (LTE)
   */
  @GeneratedMavEnumEntry
  _4G(4u),
  ;

  public companion object : MavEnum.Companion<GsmLinkType> {
    public override fun getEntryFromValueOrNull(v: UInt): GsmLinkType? = when (v) {
      0u -> NONE
      1u -> UNKNOWN
      2u -> _2G
      3u -> _3G
      4u -> _4G
      else -> null
    }
  }
}

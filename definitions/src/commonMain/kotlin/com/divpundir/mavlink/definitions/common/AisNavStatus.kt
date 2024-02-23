package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Navigational status of AIS vessel, enum duplicated from AIS standard,
 * https://gpsd.gitlab.io/gpsd/AIVDM.html
 */
@GeneratedMavEnum
public enum class AisNavStatus(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Under way using engine.
   */
  @GeneratedMavEnumEntry
  UNDER_WAY(0u),
  @GeneratedMavEnumEntry
  AIS_NAV_ANCHORED(1u),
  @GeneratedMavEnumEntry
  AIS_NAV_UN_COMMANDED(2u),
  @GeneratedMavEnumEntry
  AIS_NAV_RESTRICTED_MANOEUVERABILITY(3u),
  @GeneratedMavEnumEntry
  AIS_NAV_DRAUGHT_CONSTRAINED(4u),
  @GeneratedMavEnumEntry
  AIS_NAV_MOORED(5u),
  @GeneratedMavEnumEntry
  AIS_NAV_AGROUND(6u),
  @GeneratedMavEnumEntry
  AIS_NAV_FISHING(7u),
  @GeneratedMavEnumEntry
  AIS_NAV_SAILING(8u),
  @GeneratedMavEnumEntry
  AIS_NAV_RESERVED_HSC(9u),
  @GeneratedMavEnumEntry
  AIS_NAV_RESERVED_WIG(10u),
  @GeneratedMavEnumEntry
  AIS_NAV_RESERVED_1(11u),
  @GeneratedMavEnumEntry
  AIS_NAV_RESERVED_2(12u),
  @GeneratedMavEnumEntry
  AIS_NAV_RESERVED_3(13u),
  /**
   * Search And Rescue Transponder.
   */
  @GeneratedMavEnumEntry
  AIS_NAV_AIS_SART(14u),
  /**
   * Not available (default).
   */
  @GeneratedMavEnumEntry
  AIS_NAV_UNKNOWN(15u),
  ;

  public companion object : MavEnum.MavCompanion<AisNavStatus> {
    override fun getEntryFromValueOrNull(v: UInt): AisNavStatus? = when (v) {
      0u -> UNDER_WAY
      1u -> AIS_NAV_ANCHORED
      2u -> AIS_NAV_UN_COMMANDED
      3u -> AIS_NAV_RESTRICTED_MANOEUVERABILITY
      4u -> AIS_NAV_DRAUGHT_CONSTRAINED
      5u -> AIS_NAV_MOORED
      6u -> AIS_NAV_AGROUND
      7u -> AIS_NAV_FISHING
      8u -> AIS_NAV_SAILING
      9u -> AIS_NAV_RESERVED_HSC
      10u -> AIS_NAV_RESERVED_WIG
      11u -> AIS_NAV_RESERVED_1
      12u -> AIS_NAV_RESERVED_2
      13u -> AIS_NAV_RESERVED_3
      14u -> AIS_NAV_AIS_SART
      15u -> AIS_NAV_UNKNOWN
      else -> null
    }
  }
}

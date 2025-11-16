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
  ANCHORED(1u),
  @GeneratedMavEnumEntry
  UN_COMMANDED(2u),
  @GeneratedMavEnumEntry
  RESTRICTED_MANOEUVERABILITY(3u),
  @GeneratedMavEnumEntry
  DRAUGHT_CONSTRAINED(4u),
  @GeneratedMavEnumEntry
  MOORED(5u),
  @GeneratedMavEnumEntry
  AGROUND(6u),
  @GeneratedMavEnumEntry
  FISHING(7u),
  @GeneratedMavEnumEntry
  SAILING(8u),
  @GeneratedMavEnumEntry
  RESERVED_HSC(9u),
  @GeneratedMavEnumEntry
  RESERVED_WIG(10u),
  @GeneratedMavEnumEntry
  RESERVED_1(11u),
  @GeneratedMavEnumEntry
  RESERVED_2(12u),
  @GeneratedMavEnumEntry
  RESERVED_3(13u),
  /**
   * Search And Rescue Transponder.
   */
  @GeneratedMavEnumEntry
  AIS_SART(14u),
  /**
   * Not available (default).
   */
  @GeneratedMavEnumEntry
  UNKNOWN(15u),
  ;

  public companion object : MavEnum.MavCompanion<AisNavStatus> {
    override fun getEntryFromValueOrNull(v: UInt): AisNavStatus? = when (v) {
      0u -> UNDER_WAY
      1u -> ANCHORED
      2u -> UN_COMMANDED
      3u -> RESTRICTED_MANOEUVERABILITY
      4u -> DRAUGHT_CONSTRAINED
      5u -> MOORED
      6u -> AGROUND
      7u -> FISHING
      8u -> SAILING
      9u -> RESERVED_HSC
      10u -> RESERVED_WIG
      11u -> RESERVED_1
      12u -> RESERVED_2
      13u -> RESERVED_3
      14u -> AIS_SART
      15u -> UNKNOWN
      else -> null
    }
  }
}

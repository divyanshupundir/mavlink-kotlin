package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * State flags for ADS-B transponder status report
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutStatusNicNacp(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_20_NM(1u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_8_NM(2u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_4_NM(3u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_2_NM(4u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_1_NM(5u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_0_3_NM(6u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_0_2_NM(7u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_0_1_NM(8u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_75_M(9u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_25_M(10u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NIC_CR_7_5_M(11u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_10_NM(16u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_4_NM(32u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_2_NM(48u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_1_NM(64u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_0_5_NM(80u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_0_3_NM(96u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_0_1_NM(112u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_0_05_NM(128u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_30_M(144u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_10_M(160u),
  @GeneratedMavEnumEntry
  UAVIONIX_ADSB_NACP_EPU_3_M(176u),
  ;

  public companion object : MavEnum.MavCompanion<UavionixAdsbOutStatusNicNacp> {
    override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutStatusNicNacp? = when (v) {
      1u -> UAVIONIX_ADSB_NIC_CR_20_NM
      2u -> UAVIONIX_ADSB_NIC_CR_8_NM
      3u -> UAVIONIX_ADSB_NIC_CR_4_NM
      4u -> UAVIONIX_ADSB_NIC_CR_2_NM
      5u -> UAVIONIX_ADSB_NIC_CR_1_NM
      6u -> UAVIONIX_ADSB_NIC_CR_0_3_NM
      7u -> UAVIONIX_ADSB_NIC_CR_0_2_NM
      8u -> UAVIONIX_ADSB_NIC_CR_0_1_NM
      9u -> UAVIONIX_ADSB_NIC_CR_75_M
      10u -> UAVIONIX_ADSB_NIC_CR_25_M
      11u -> UAVIONIX_ADSB_NIC_CR_7_5_M
      16u -> UAVIONIX_ADSB_NACP_EPU_10_NM
      32u -> UAVIONIX_ADSB_NACP_EPU_4_NM
      48u -> UAVIONIX_ADSB_NACP_EPU_2_NM
      64u -> UAVIONIX_ADSB_NACP_EPU_1_NM
      80u -> UAVIONIX_ADSB_NACP_EPU_0_5_NM
      96u -> UAVIONIX_ADSB_NACP_EPU_0_3_NM
      112u -> UAVIONIX_ADSB_NACP_EPU_0_1_NM
      128u -> UAVIONIX_ADSB_NACP_EPU_0_05_NM
      144u -> UAVIONIX_ADSB_NACP_EPU_30_M
      160u -> UAVIONIX_ADSB_NACP_EPU_10_M
      176u -> UAVIONIX_ADSB_NACP_EPU_3_M
      else -> null
    }
  }
}

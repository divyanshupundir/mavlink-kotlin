package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Type of AIS vessel, enum duplicated from AIS standard, https://gpsd.gitlab.io/gpsd/AIVDM.html
 */
@GeneratedMavEnum
public enum class AisType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Not available (default).
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  @GeneratedMavEnumEntry
  RESERVED_1(1u),
  @GeneratedMavEnumEntry
  RESERVED_2(2u),
  @GeneratedMavEnumEntry
  RESERVED_3(3u),
  @GeneratedMavEnumEntry
  RESERVED_4(4u),
  @GeneratedMavEnumEntry
  RESERVED_5(5u),
  @GeneratedMavEnumEntry
  RESERVED_6(6u),
  @GeneratedMavEnumEntry
  RESERVED_7(7u),
  @GeneratedMavEnumEntry
  RESERVED_8(8u),
  @GeneratedMavEnumEntry
  RESERVED_9(9u),
  @GeneratedMavEnumEntry
  RESERVED_10(10u),
  @GeneratedMavEnumEntry
  RESERVED_11(11u),
  @GeneratedMavEnumEntry
  RESERVED_12(12u),
  @GeneratedMavEnumEntry
  RESERVED_13(13u),
  @GeneratedMavEnumEntry
  RESERVED_14(14u),
  @GeneratedMavEnumEntry
  RESERVED_15(15u),
  @GeneratedMavEnumEntry
  RESERVED_16(16u),
  @GeneratedMavEnumEntry
  RESERVED_17(17u),
  @GeneratedMavEnumEntry
  RESERVED_18(18u),
  @GeneratedMavEnumEntry
  RESERVED_19(19u),
  /**
   * Wing In Ground effect.
   */
  @GeneratedMavEnumEntry
  WIG(20u),
  @GeneratedMavEnumEntry
  WIG_HAZARDOUS_A(21u),
  @GeneratedMavEnumEntry
  WIG_HAZARDOUS_B(22u),
  @GeneratedMavEnumEntry
  WIG_HAZARDOUS_C(23u),
  @GeneratedMavEnumEntry
  WIG_HAZARDOUS_D(24u),
  @GeneratedMavEnumEntry
  WIG_RESERVED_1(25u),
  @GeneratedMavEnumEntry
  WIG_RESERVED_2(26u),
  @GeneratedMavEnumEntry
  WIG_RESERVED_3(27u),
  @GeneratedMavEnumEntry
  WIG_RESERVED_4(28u),
  @GeneratedMavEnumEntry
  WIG_RESERVED_5(29u),
  @GeneratedMavEnumEntry
  FISHING(30u),
  @GeneratedMavEnumEntry
  TOWING(31u),
  /**
   * Towing: length exceeds 200m or breadth exceeds 25m.
   */
  @GeneratedMavEnumEntry
  TOWING_LARGE(32u),
  /**
   * Dredging or other underwater ops.
   */
  @GeneratedMavEnumEntry
  DREDGING(33u),
  @GeneratedMavEnumEntry
  DIVING(34u),
  @GeneratedMavEnumEntry
  MILITARY(35u),
  @GeneratedMavEnumEntry
  SAILING(36u),
  @GeneratedMavEnumEntry
  PLEASURE(37u),
  @GeneratedMavEnumEntry
  RESERVED_20(38u),
  @GeneratedMavEnumEntry
  RESERVED_21(39u),
  /**
   * High Speed Craft.
   */
  @GeneratedMavEnumEntry
  HSC(40u),
  @GeneratedMavEnumEntry
  HSC_HAZARDOUS_A(41u),
  @GeneratedMavEnumEntry
  HSC_HAZARDOUS_B(42u),
  @GeneratedMavEnumEntry
  HSC_HAZARDOUS_C(43u),
  @GeneratedMavEnumEntry
  HSC_HAZARDOUS_D(44u),
  @GeneratedMavEnumEntry
  HSC_RESERVED_1(45u),
  @GeneratedMavEnumEntry
  HSC_RESERVED_2(46u),
  @GeneratedMavEnumEntry
  HSC_RESERVED_3(47u),
  @GeneratedMavEnumEntry
  HSC_RESERVED_4(48u),
  @GeneratedMavEnumEntry
  HSC_UNKNOWN(49u),
  @GeneratedMavEnumEntry
  PILOT(50u),
  /**
   * Search And Rescue vessel.
   */
  @GeneratedMavEnumEntry
  SAR(51u),
  @GeneratedMavEnumEntry
  TUG(52u),
  @GeneratedMavEnumEntry
  PORT_TENDER(53u),
  /**
   * Anti-pollution equipment.
   */
  @GeneratedMavEnumEntry
  ANTI_POLLUTION(54u),
  @GeneratedMavEnumEntry
  LAW_ENFORCEMENT(55u),
  @GeneratedMavEnumEntry
  SPARE_LOCAL_1(56u),
  @GeneratedMavEnumEntry
  SPARE_LOCAL_2(57u),
  @GeneratedMavEnumEntry
  MEDICAL_TRANSPORT(58u),
  /**
   * Noncombatant ship according to RR Resolution No. 18.
   */
  @GeneratedMavEnumEntry
  NONECOMBATANT(59u),
  @GeneratedMavEnumEntry
  PASSENGER(60u),
  @GeneratedMavEnumEntry
  PASSENGER_HAZARDOUS_A(61u),
  @GeneratedMavEnumEntry
  PASSENGER_HAZARDOUS_B(62u),
  @GeneratedMavEnumEntry
  PASSENGER_HAZARDOUS_C(63u),
  @GeneratedMavEnumEntry
  PASSENGER_HAZARDOUS_D(64u),
  @GeneratedMavEnumEntry
  PASSENGER_RESERVED_1(65u),
  @GeneratedMavEnumEntry
  PASSENGER_RESERVED_2(66u),
  @GeneratedMavEnumEntry
  PASSENGER_RESERVED_3(67u),
  @GeneratedMavEnumEntry
  PASSENGER_RESERVED_4(68u),
  @GeneratedMavEnumEntry
  PASSENGER_UNKNOWN(69u),
  @GeneratedMavEnumEntry
  CARGO(70u),
  @GeneratedMavEnumEntry
  CARGO_HAZARDOUS_A(71u),
  @GeneratedMavEnumEntry
  CARGO_HAZARDOUS_B(72u),
  @GeneratedMavEnumEntry
  CARGO_HAZARDOUS_C(73u),
  @GeneratedMavEnumEntry
  CARGO_HAZARDOUS_D(74u),
  @GeneratedMavEnumEntry
  CARGO_RESERVED_1(75u),
  @GeneratedMavEnumEntry
  CARGO_RESERVED_2(76u),
  @GeneratedMavEnumEntry
  CARGO_RESERVED_3(77u),
  @GeneratedMavEnumEntry
  CARGO_RESERVED_4(78u),
  @GeneratedMavEnumEntry
  CARGO_UNKNOWN(79u),
  @GeneratedMavEnumEntry
  TANKER(80u),
  @GeneratedMavEnumEntry
  TANKER_HAZARDOUS_A(81u),
  @GeneratedMavEnumEntry
  TANKER_HAZARDOUS_B(82u),
  @GeneratedMavEnumEntry
  TANKER_HAZARDOUS_C(83u),
  @GeneratedMavEnumEntry
  TANKER_HAZARDOUS_D(84u),
  @GeneratedMavEnumEntry
  TANKER_RESERVED_1(85u),
  @GeneratedMavEnumEntry
  TANKER_RESERVED_2(86u),
  @GeneratedMavEnumEntry
  TANKER_RESERVED_3(87u),
  @GeneratedMavEnumEntry
  TANKER_RESERVED_4(88u),
  @GeneratedMavEnumEntry
  TANKER_UNKNOWN(89u),
  @GeneratedMavEnumEntry
  OTHER(90u),
  @GeneratedMavEnumEntry
  OTHER_HAZARDOUS_A(91u),
  @GeneratedMavEnumEntry
  OTHER_HAZARDOUS_B(92u),
  @GeneratedMavEnumEntry
  OTHER_HAZARDOUS_C(93u),
  @GeneratedMavEnumEntry
  OTHER_HAZARDOUS_D(94u),
  @GeneratedMavEnumEntry
  OTHER_RESERVED_1(95u),
  @GeneratedMavEnumEntry
  OTHER_RESERVED_2(96u),
  @GeneratedMavEnumEntry
  OTHER_RESERVED_3(97u),
  @GeneratedMavEnumEntry
  OTHER_RESERVED_4(98u),
  @GeneratedMavEnumEntry
  OTHER_UNKNOWN(99u),
  ;

  public companion object : MavEnum.MavCompanion<AisType> {
    override fun getEntryFromValueOrNull(v: UInt): AisType? = when (v) {
      0u -> UNKNOWN
      1u -> RESERVED_1
      2u -> RESERVED_2
      3u -> RESERVED_3
      4u -> RESERVED_4
      5u -> RESERVED_5
      6u -> RESERVED_6
      7u -> RESERVED_7
      8u -> RESERVED_8
      9u -> RESERVED_9
      10u -> RESERVED_10
      11u -> RESERVED_11
      12u -> RESERVED_12
      13u -> RESERVED_13
      14u -> RESERVED_14
      15u -> RESERVED_15
      16u -> RESERVED_16
      17u -> RESERVED_17
      18u -> RESERVED_18
      19u -> RESERVED_19
      20u -> WIG
      21u -> WIG_HAZARDOUS_A
      22u -> WIG_HAZARDOUS_B
      23u -> WIG_HAZARDOUS_C
      24u -> WIG_HAZARDOUS_D
      25u -> WIG_RESERVED_1
      26u -> WIG_RESERVED_2
      27u -> WIG_RESERVED_3
      28u -> WIG_RESERVED_4
      29u -> WIG_RESERVED_5
      30u -> FISHING
      31u -> TOWING
      32u -> TOWING_LARGE
      33u -> DREDGING
      34u -> DIVING
      35u -> MILITARY
      36u -> SAILING
      37u -> PLEASURE
      38u -> RESERVED_20
      39u -> RESERVED_21
      40u -> HSC
      41u -> HSC_HAZARDOUS_A
      42u -> HSC_HAZARDOUS_B
      43u -> HSC_HAZARDOUS_C
      44u -> HSC_HAZARDOUS_D
      45u -> HSC_RESERVED_1
      46u -> HSC_RESERVED_2
      47u -> HSC_RESERVED_3
      48u -> HSC_RESERVED_4
      49u -> HSC_UNKNOWN
      50u -> PILOT
      51u -> SAR
      52u -> TUG
      53u -> PORT_TENDER
      54u -> ANTI_POLLUTION
      55u -> LAW_ENFORCEMENT
      56u -> SPARE_LOCAL_1
      57u -> SPARE_LOCAL_2
      58u -> MEDICAL_TRANSPORT
      59u -> NONECOMBATANT
      60u -> PASSENGER
      61u -> PASSENGER_HAZARDOUS_A
      62u -> PASSENGER_HAZARDOUS_B
      63u -> PASSENGER_HAZARDOUS_C
      64u -> PASSENGER_HAZARDOUS_D
      65u -> PASSENGER_RESERVED_1
      66u -> PASSENGER_RESERVED_2
      67u -> PASSENGER_RESERVED_3
      68u -> PASSENGER_RESERVED_4
      69u -> PASSENGER_UNKNOWN
      70u -> CARGO
      71u -> CARGO_HAZARDOUS_A
      72u -> CARGO_HAZARDOUS_B
      73u -> CARGO_HAZARDOUS_C
      74u -> CARGO_HAZARDOUS_D
      75u -> CARGO_RESERVED_1
      76u -> CARGO_RESERVED_2
      77u -> CARGO_RESERVED_3
      78u -> CARGO_RESERVED_4
      79u -> CARGO_UNKNOWN
      80u -> TANKER
      81u -> TANKER_HAZARDOUS_A
      82u -> TANKER_HAZARDOUS_B
      83u -> TANKER_HAZARDOUS_C
      84u -> TANKER_HAZARDOUS_D
      85u -> TANKER_RESERVED_1
      86u -> TANKER_RESERVED_2
      87u -> TANKER_RESERVED_3
      88u -> TANKER_RESERVED_4
      89u -> TANKER_UNKNOWN
      90u -> OTHER
      91u -> OTHER_HAZARDOUS_A
      92u -> OTHER_HAZARDOUS_B
      93u -> OTHER_HAZARDOUS_C
      94u -> OTHER_HAZARDOUS_D
      95u -> OTHER_RESERVED_1
      96u -> OTHER_RESERVED_2
      97u -> OTHER_RESERVED_3
      98u -> OTHER_RESERVED_4
      99u -> OTHER_UNKNOWN
      else -> null
    }
  }
}

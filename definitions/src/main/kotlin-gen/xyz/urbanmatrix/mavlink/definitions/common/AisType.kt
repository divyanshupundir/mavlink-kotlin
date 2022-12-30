package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Type of AIS vessel, enum duplicated from AIS standard, https://gpsd.gitlab.io/gpsd/AIVDM.html
 */
@GeneratedMavEnum
public enum class AisType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Not available (default).
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  @GeneratedMavEnumEntry
  RESERVED_1(1L),
  @GeneratedMavEnumEntry
  RESERVED_2(2L),
  @GeneratedMavEnumEntry
  RESERVED_3(3L),
  @GeneratedMavEnumEntry
  RESERVED_4(4L),
  @GeneratedMavEnumEntry
  RESERVED_5(5L),
  @GeneratedMavEnumEntry
  RESERVED_6(6L),
  @GeneratedMavEnumEntry
  RESERVED_7(7L),
  @GeneratedMavEnumEntry
  RESERVED_8(8L),
  @GeneratedMavEnumEntry
  RESERVED_9(9L),
  @GeneratedMavEnumEntry
  RESERVED_10(10L),
  @GeneratedMavEnumEntry
  RESERVED_11(11L),
  @GeneratedMavEnumEntry
  RESERVED_12(12L),
  @GeneratedMavEnumEntry
  RESERVED_13(13L),
  @GeneratedMavEnumEntry
  RESERVED_14(14L),
  @GeneratedMavEnumEntry
  RESERVED_15(15L),
  @GeneratedMavEnumEntry
  RESERVED_16(16L),
  @GeneratedMavEnumEntry
  RESERVED_17(17L),
  @GeneratedMavEnumEntry
  RESERVED_18(18L),
  @GeneratedMavEnumEntry
  RESERVED_19(19L),
  /**
   * Wing In Ground effect.
   */
  @GeneratedMavEnumEntry
  WIG(20L),
  @GeneratedMavEnumEntry
  WIG_HAZARDOUS_A(21L),
  @GeneratedMavEnumEntry
  WIG_HAZARDOUS_B(22L),
  @GeneratedMavEnumEntry
  WIG_HAZARDOUS_C(23L),
  @GeneratedMavEnumEntry
  WIG_HAZARDOUS_D(24L),
  @GeneratedMavEnumEntry
  WIG_RESERVED_1(25L),
  @GeneratedMavEnumEntry
  WIG_RESERVED_2(26L),
  @GeneratedMavEnumEntry
  WIG_RESERVED_3(27L),
  @GeneratedMavEnumEntry
  WIG_RESERVED_4(28L),
  @GeneratedMavEnumEntry
  WIG_RESERVED_5(29L),
  @GeneratedMavEnumEntry
  FISHING(30L),
  @GeneratedMavEnumEntry
  TOWING(31L),
  /**
   * Towing: length exceeds 200m or breadth exceeds 25m.
   */
  @GeneratedMavEnumEntry
  TOWING_LARGE(32L),
  /**
   * Dredging or other underwater ops.
   */
  @GeneratedMavEnumEntry
  DREDGING(33L),
  @GeneratedMavEnumEntry
  DIVING(34L),
  @GeneratedMavEnumEntry
  MILITARY(35L),
  @GeneratedMavEnumEntry
  SAILING(36L),
  @GeneratedMavEnumEntry
  PLEASURE(37L),
  @GeneratedMavEnumEntry
  RESERVED_20(38L),
  @GeneratedMavEnumEntry
  RESERVED_21(39L),
  /**
   * High Speed Craft.
   */
  @GeneratedMavEnumEntry
  HSC(40L),
  @GeneratedMavEnumEntry
  HSC_HAZARDOUS_A(41L),
  @GeneratedMavEnumEntry
  HSC_HAZARDOUS_B(42L),
  @GeneratedMavEnumEntry
  HSC_HAZARDOUS_C(43L),
  @GeneratedMavEnumEntry
  HSC_HAZARDOUS_D(44L),
  @GeneratedMavEnumEntry
  HSC_RESERVED_1(45L),
  @GeneratedMavEnumEntry
  HSC_RESERVED_2(46L),
  @GeneratedMavEnumEntry
  HSC_RESERVED_3(47L),
  @GeneratedMavEnumEntry
  HSC_RESERVED_4(48L),
  @GeneratedMavEnumEntry
  HSC_UNKNOWN(49L),
  @GeneratedMavEnumEntry
  PILOT(50L),
  /**
   * Search And Rescue vessel.
   */
  @GeneratedMavEnumEntry
  SAR(51L),
  @GeneratedMavEnumEntry
  TUG(52L),
  @GeneratedMavEnumEntry
  PORT_TENDER(53L),
  /**
   * Anti-pollution equipment.
   */
  @GeneratedMavEnumEntry
  ANTI_POLLUTION(54L),
  @GeneratedMavEnumEntry
  LAW_ENFORCEMENT(55L),
  @GeneratedMavEnumEntry
  SPARE_LOCAL_1(56L),
  @GeneratedMavEnumEntry
  SPARE_LOCAL_2(57L),
  @GeneratedMavEnumEntry
  MEDICAL_TRANSPORT(58L),
  /**
   * Noncombatant ship according to RR Resolution No. 18.
   */
  @GeneratedMavEnumEntry
  NONECOMBATANT(59L),
  @GeneratedMavEnumEntry
  PASSENGER(60L),
  @GeneratedMavEnumEntry
  PASSENGER_HAZARDOUS_A(61L),
  @GeneratedMavEnumEntry
  PASSENGER_HAZARDOUS_B(62L),
  @GeneratedMavEnumEntry
  AIS_TYPE_PASSENGER_HAZARDOUS_C(63L),
  @GeneratedMavEnumEntry
  PASSENGER_HAZARDOUS_D(64L),
  @GeneratedMavEnumEntry
  PASSENGER_RESERVED_1(65L),
  @GeneratedMavEnumEntry
  PASSENGER_RESERVED_2(66L),
  @GeneratedMavEnumEntry
  PASSENGER_RESERVED_3(67L),
  @GeneratedMavEnumEntry
  AIS_TYPE_PASSENGER_RESERVED_4(68L),
  @GeneratedMavEnumEntry
  PASSENGER_UNKNOWN(69L),
  @GeneratedMavEnumEntry
  CARGO(70L),
  @GeneratedMavEnumEntry
  CARGO_HAZARDOUS_A(71L),
  @GeneratedMavEnumEntry
  CARGO_HAZARDOUS_B(72L),
  @GeneratedMavEnumEntry
  CARGO_HAZARDOUS_C(73L),
  @GeneratedMavEnumEntry
  CARGO_HAZARDOUS_D(74L),
  @GeneratedMavEnumEntry
  CARGO_RESERVED_1(75L),
  @GeneratedMavEnumEntry
  CARGO_RESERVED_2(76L),
  @GeneratedMavEnumEntry
  CARGO_RESERVED_3(77L),
  @GeneratedMavEnumEntry
  CARGO_RESERVED_4(78L),
  @GeneratedMavEnumEntry
  CARGO_UNKNOWN(79L),
  @GeneratedMavEnumEntry
  TANKER(80L),
  @GeneratedMavEnumEntry
  TANKER_HAZARDOUS_A(81L),
  @GeneratedMavEnumEntry
  TANKER_HAZARDOUS_B(82L),
  @GeneratedMavEnumEntry
  TANKER_HAZARDOUS_C(83L),
  @GeneratedMavEnumEntry
  TANKER_HAZARDOUS_D(84L),
  @GeneratedMavEnumEntry
  TANKER_RESERVED_1(85L),
  @GeneratedMavEnumEntry
  TANKER_RESERVED_2(86L),
  @GeneratedMavEnumEntry
  TANKER_RESERVED_3(87L),
  @GeneratedMavEnumEntry
  TANKER_RESERVED_4(88L),
  @GeneratedMavEnumEntry
  TANKER_UNKNOWN(89L),
  @GeneratedMavEnumEntry
  OTHER(90L),
  @GeneratedMavEnumEntry
  OTHER_HAZARDOUS_A(91L),
  @GeneratedMavEnumEntry
  OTHER_HAZARDOUS_B(92L),
  @GeneratedMavEnumEntry
  OTHER_HAZARDOUS_C(93L),
  @GeneratedMavEnumEntry
  OTHER_HAZARDOUS_D(94L),
  @GeneratedMavEnumEntry
  OTHER_RESERVED_1(95L),
  @GeneratedMavEnumEntry
  OTHER_RESERVED_2(96L),
  @GeneratedMavEnumEntry
  OTHER_RESERVED_3(97L),
  @GeneratedMavEnumEntry
  OTHER_RESERVED_4(98L),
  @GeneratedMavEnumEntry
  OTHER_UNKNOWN(99L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AisType? = when (v) {
      0L -> UNKNOWN
      1L -> RESERVED_1
      2L -> RESERVED_2
      3L -> RESERVED_3
      4L -> RESERVED_4
      5L -> RESERVED_5
      6L -> RESERVED_6
      7L -> RESERVED_7
      8L -> RESERVED_8
      9L -> RESERVED_9
      10L -> RESERVED_10
      11L -> RESERVED_11
      12L -> RESERVED_12
      13L -> RESERVED_13
      14L -> RESERVED_14
      15L -> RESERVED_15
      16L -> RESERVED_16
      17L -> RESERVED_17
      18L -> RESERVED_18
      19L -> RESERVED_19
      20L -> WIG
      21L -> WIG_HAZARDOUS_A
      22L -> WIG_HAZARDOUS_B
      23L -> WIG_HAZARDOUS_C
      24L -> WIG_HAZARDOUS_D
      25L -> WIG_RESERVED_1
      26L -> WIG_RESERVED_2
      27L -> WIG_RESERVED_3
      28L -> WIG_RESERVED_4
      29L -> WIG_RESERVED_5
      30L -> FISHING
      31L -> TOWING
      32L -> TOWING_LARGE
      33L -> DREDGING
      34L -> DIVING
      35L -> MILITARY
      36L -> SAILING
      37L -> PLEASURE
      38L -> RESERVED_20
      39L -> RESERVED_21
      40L -> HSC
      41L -> HSC_HAZARDOUS_A
      42L -> HSC_HAZARDOUS_B
      43L -> HSC_HAZARDOUS_C
      44L -> HSC_HAZARDOUS_D
      45L -> HSC_RESERVED_1
      46L -> HSC_RESERVED_2
      47L -> HSC_RESERVED_3
      48L -> HSC_RESERVED_4
      49L -> HSC_UNKNOWN
      50L -> PILOT
      51L -> SAR
      52L -> TUG
      53L -> PORT_TENDER
      54L -> ANTI_POLLUTION
      55L -> LAW_ENFORCEMENT
      56L -> SPARE_LOCAL_1
      57L -> SPARE_LOCAL_2
      58L -> MEDICAL_TRANSPORT
      59L -> NONECOMBATANT
      60L -> PASSENGER
      61L -> PASSENGER_HAZARDOUS_A
      62L -> PASSENGER_HAZARDOUS_B
      63L -> AIS_TYPE_PASSENGER_HAZARDOUS_C
      64L -> PASSENGER_HAZARDOUS_D
      65L -> PASSENGER_RESERVED_1
      66L -> PASSENGER_RESERVED_2
      67L -> PASSENGER_RESERVED_3
      68L -> AIS_TYPE_PASSENGER_RESERVED_4
      69L -> PASSENGER_UNKNOWN
      70L -> CARGO
      71L -> CARGO_HAZARDOUS_A
      72L -> CARGO_HAZARDOUS_B
      73L -> CARGO_HAZARDOUS_C
      74L -> CARGO_HAZARDOUS_D
      75L -> CARGO_RESERVED_1
      76L -> CARGO_RESERVED_2
      77L -> CARGO_RESERVED_3
      78L -> CARGO_RESERVED_4
      79L -> CARGO_UNKNOWN
      80L -> TANKER
      81L -> TANKER_HAZARDOUS_A
      82L -> TANKER_HAZARDOUS_B
      83L -> TANKER_HAZARDOUS_C
      84L -> TANKER_HAZARDOUS_D
      85L -> TANKER_RESERVED_1
      86L -> TANKER_RESERVED_2
      87L -> TANKER_RESERVED_3
      88L -> TANKER_RESERVED_4
      89L -> TANKER_UNKNOWN
      90L -> OTHER
      91L -> OTHER_HAZARDOUS_A
      92L -> OTHER_HAZARDOUS_B
      93L -> OTHER_HAZARDOUS_C
      94L -> OTHER_HAZARDOUS_D
      95L -> OTHER_RESERVED_1
      96L -> OTHER_RESERVED_2
      97L -> OTHER_RESERVED_3
      98L -> OTHER_RESERVED_4
      99L -> OTHER_UNKNOWN
      else -> null
    }
  }
}

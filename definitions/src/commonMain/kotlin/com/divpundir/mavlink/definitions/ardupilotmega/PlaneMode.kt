package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * A mapping of plane flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class PlaneMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * MANUAL
   */
  @GeneratedMavEnumEntry
  MANUAL(0u),
  /**
   * CIRCLE
   */
  @GeneratedMavEnumEntry
  CIRCLE(1u),
  /**
   * STABILIZE
   */
  @GeneratedMavEnumEntry
  STABILIZE(2u),
  /**
   * TRAINING
   */
  @GeneratedMavEnumEntry
  TRAINING(3u),
  /**
   * ACRO
   */
  @GeneratedMavEnumEntry
  ACRO(4u),
  /**
   * FBWA
   */
  @GeneratedMavEnumEntry
  FLY_BY_WIRE_A(5u),
  /**
   * FBWB
   */
  @GeneratedMavEnumEntry
  FLY_BY_WIRE_B(6u),
  /**
   * CRUISE
   */
  @GeneratedMavEnumEntry
  CRUISE(7u),
  /**
   * AUTOTUNE
   */
  @GeneratedMavEnumEntry
  AUTOTUNE(8u),
  /**
   * AUTO
   */
  @GeneratedMavEnumEntry
  AUTO(10u),
  /**
   * RTL
   */
  @GeneratedMavEnumEntry
  RTL(11u),
  /**
   * LOITER
   */
  @GeneratedMavEnumEntry
  LOITER(12u),
  /**
   * TAKEOFF
   */
  @GeneratedMavEnumEntry
  TAKEOFF(13u),
  /**
   * AVOID ADSB
   */
  @GeneratedMavEnumEntry
  AVOID_ADSB(14u),
  /**
   * GUIDED
   */
  @GeneratedMavEnumEntry
  GUIDED(15u),
  /**
   * INITIALISING
   */
  @GeneratedMavEnumEntry
  INITIALIZING(16u),
  /**
   * QSTABILIZE
   */
  @GeneratedMavEnumEntry
  QSTABILIZE(17u),
  /**
   * QHOVER
   */
  @GeneratedMavEnumEntry
  QHOVER(18u),
  /**
   * QLOITER
   */
  @GeneratedMavEnumEntry
  QLOITER(19u),
  /**
   * QLAND
   */
  @GeneratedMavEnumEntry
  QLAND(20u),
  /**
   * QRTL
   */
  @GeneratedMavEnumEntry
  QRTL(21u),
  /**
   * QAUTOTUNE
   */
  @GeneratedMavEnumEntry
  QAUTOTUNE(22u),
  /**
   * QACRO
   */
  @GeneratedMavEnumEntry
  QACRO(23u),
  /**
   * THERMAL
   */
  @GeneratedMavEnumEntry
  THERMAL(24u),
  /**
   * LOITER2QLAND
   */
  @GeneratedMavEnumEntry
  LOITER_ALT_QLAND(25u),
  /**
   * AUTOLAND
   */
  @GeneratedMavEnumEntry
  AUTOLAND(26u),
  ;

  public companion object : MavEnum.MavCompanion<PlaneMode> {
    override fun getEntryFromValueOrNull(v: UInt): PlaneMode? = when (v) {
      0u -> MANUAL
      1u -> CIRCLE
      2u -> STABILIZE
      3u -> TRAINING
      4u -> ACRO
      5u -> FLY_BY_WIRE_A
      6u -> FLY_BY_WIRE_B
      7u -> CRUISE
      8u -> AUTOTUNE
      10u -> AUTO
      11u -> RTL
      12u -> LOITER
      13u -> TAKEOFF
      14u -> AVOID_ADSB
      15u -> GUIDED
      16u -> INITIALIZING
      17u -> QSTABILIZE
      18u -> QHOVER
      19u -> QLOITER
      20u -> QLAND
      21u -> QRTL
      22u -> QAUTOTUNE
      23u -> QACRO
      24u -> THERMAL
      25u -> LOITER_ALT_QLAND
      26u -> AUTOLAND
      else -> null
    }
  }
}

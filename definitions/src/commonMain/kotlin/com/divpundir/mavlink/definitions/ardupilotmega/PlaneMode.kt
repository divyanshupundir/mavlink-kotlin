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
  @GeneratedMavEnumEntry
  MANUAL(0u),
  @GeneratedMavEnumEntry
  CIRCLE(1u),
  @GeneratedMavEnumEntry
  STABILIZE(2u),
  @GeneratedMavEnumEntry
  TRAINING(3u),
  @GeneratedMavEnumEntry
  ACRO(4u),
  @GeneratedMavEnumEntry
  FLY_BY_WIRE_A(5u),
  @GeneratedMavEnumEntry
  FLY_BY_WIRE_B(6u),
  @GeneratedMavEnumEntry
  CRUISE(7u),
  @GeneratedMavEnumEntry
  AUTOTUNE(8u),
  @GeneratedMavEnumEntry
  AUTO(10u),
  @GeneratedMavEnumEntry
  RTL(11u),
  @GeneratedMavEnumEntry
  LOITER(12u),
  @GeneratedMavEnumEntry
  TAKEOFF(13u),
  @GeneratedMavEnumEntry
  AVOID_ADSB(14u),
  @GeneratedMavEnumEntry
  GUIDED(15u),
  @GeneratedMavEnumEntry
  INITIALIZING(16u),
  @GeneratedMavEnumEntry
  QSTABILIZE(17u),
  @GeneratedMavEnumEntry
  QHOVER(18u),
  @GeneratedMavEnumEntry
  QLOITER(19u),
  @GeneratedMavEnumEntry
  QLAND(20u),
  @GeneratedMavEnumEntry
  QRTL(21u),
  @GeneratedMavEnumEntry
  QAUTOTUNE(22u),
  @GeneratedMavEnumEntry
  QACRO(23u),
  @GeneratedMavEnumEntry
  THERMAL(24u),
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
      else -> null
    }
  }
}

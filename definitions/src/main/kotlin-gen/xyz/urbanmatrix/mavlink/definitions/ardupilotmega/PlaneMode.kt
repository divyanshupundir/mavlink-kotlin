package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * A mapping of plane flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class PlaneMode(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  MANUAL(0L),
  @GeneratedMavEnumEntry
  CIRCLE(1L),
  @GeneratedMavEnumEntry
  STABILIZE(2L),
  @GeneratedMavEnumEntry
  TRAINING(3L),
  @GeneratedMavEnumEntry
  ACRO(4L),
  @GeneratedMavEnumEntry
  FLY_BY_WIRE_A(5L),
  @GeneratedMavEnumEntry
  FLY_BY_WIRE_B(6L),
  @GeneratedMavEnumEntry
  CRUISE(7L),
  @GeneratedMavEnumEntry
  AUTOTUNE(8L),
  @GeneratedMavEnumEntry
  AUTO(10L),
  @GeneratedMavEnumEntry
  RTL(11L),
  @GeneratedMavEnumEntry
  LOITER(12L),
  @GeneratedMavEnumEntry
  TAKEOFF(13L),
  @GeneratedMavEnumEntry
  AVOID_ADSB(14L),
  @GeneratedMavEnumEntry
  GUIDED(15L),
  @GeneratedMavEnumEntry
  INITIALIZING(16L),
  @GeneratedMavEnumEntry
  QSTABILIZE(17L),
  @GeneratedMavEnumEntry
  QHOVER(18L),
  @GeneratedMavEnumEntry
  QLOITER(19L),
  @GeneratedMavEnumEntry
  QLAND(20L),
  @GeneratedMavEnumEntry
  QRTL(21L),
  @GeneratedMavEnumEntry
  QAUTOTUNE(22L),
  @GeneratedMavEnumEntry
  QACRO(23L),
  @GeneratedMavEnumEntry
  THERMAL(24L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): PlaneMode? = when (v) {
      0L -> MANUAL
      1L -> CIRCLE
      2L -> STABILIZE
      3L -> TRAINING
      4L -> ACRO
      5L -> FLY_BY_WIRE_A
      6L -> FLY_BY_WIRE_B
      7L -> CRUISE
      8L -> AUTOTUNE
      10L -> AUTO
      11L -> RTL
      12L -> LOITER
      13L -> TAKEOFF
      14L -> AVOID_ADSB
      15L -> GUIDED
      16L -> INITIALIZING
      17L -> QSTABILIZE
      18L -> QHOVER
      19L -> QLOITER
      20L -> QLAND
      21L -> QRTL
      22L -> QAUTOTUNE
      23L -> QACRO
      24L -> THERMAL
      else -> null
    }
  }
}

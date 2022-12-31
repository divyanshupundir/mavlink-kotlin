package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * A mapping of rover flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class RoverMode(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  MANUAL(0L),
  @GeneratedMavEnumEntry
  ACRO(1L),
  @GeneratedMavEnumEntry
  STEERING(3L),
  @GeneratedMavEnumEntry
  HOLD(4L),
  @GeneratedMavEnumEntry
  LOITER(5L),
  @GeneratedMavEnumEntry
  FOLLOW(6L),
  @GeneratedMavEnumEntry
  SIMPLE(7L),
  @GeneratedMavEnumEntry
  AUTO(10L),
  @GeneratedMavEnumEntry
  RTL(11L),
  @GeneratedMavEnumEntry
  SMART_RTL(12L),
  @GeneratedMavEnumEntry
  GUIDED(15L),
  @GeneratedMavEnumEntry
  INITIALIZING(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): RoverMode? = when (v) {
      0L -> MANUAL
      1L -> ACRO
      3L -> STEERING
      4L -> HOLD
      5L -> LOITER
      6L -> FOLLOW
      7L -> SIMPLE
      10L -> AUTO
      11L -> RTL
      12L -> SMART_RTL
      15L -> GUIDED
      16L -> INITIALIZING
      else -> null
    }
  }
}

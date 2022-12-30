package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * A mapping of sub flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class SubMode(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  STABILIZE(0L),
  @GeneratedMavEnumEntry
  ACRO(1L),
  @GeneratedMavEnumEntry
  ALT_HOLD(2L),
  @GeneratedMavEnumEntry
  AUTO(3L),
  @GeneratedMavEnumEntry
  GUIDED(4L),
  @GeneratedMavEnumEntry
  CIRCLE(7L),
  @GeneratedMavEnumEntry
  SURFACE(9L),
  @GeneratedMavEnumEntry
  POSHOLD(16L),
  @GeneratedMavEnumEntry
  MANUAL(19L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): SubMode? = when (v) {
      0L -> STABILIZE
      1L -> ACRO
      2L -> ALT_HOLD
      3L -> AUTO
      4L -> GUIDED
      7L -> CIRCLE
      9L -> SURFACE
      16L -> POSHOLD
      19L -> MANUAL
      else -> null
    }
  }
}

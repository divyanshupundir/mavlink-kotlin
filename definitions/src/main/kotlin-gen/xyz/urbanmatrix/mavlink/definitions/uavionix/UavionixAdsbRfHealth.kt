package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Status flags for ADS-B transponder dynamic output
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbRfHealth(
  public override val `value`: Long,
) : MavBitmask {
  @GeneratedMavEnumEntry
  INITIALIZING(0L),
  @GeneratedMavEnumEntry
  OK(1L),
  @GeneratedMavEnumEntry
  FAIL_TX(2L),
  @GeneratedMavEnumEntry
  FAIL_RX(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbRfHealth? = when (v) {
      0L -> INITIALIZING
      1L -> OK
      2L -> FAIL_TX
      16L -> FAIL_RX
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<UavionixAdsbRfHealth> = buildList {
      if (v and 0L == 0L) add(INITIALIZING)
      if (v and 1L == 1L) add(OK)
      if (v and 2L == 2L) add(FAIL_TX)
      if (v and 16L == 16L) add(FAIL_RX)
    }
  }
}

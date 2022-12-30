package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Transceiver RF control flags for ADS-B transponder dynamic reports
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbOutRfSelect(
  public override val `value`: Long,
) : MavBitmask {
  @GeneratedMavEnumEntry
  STANDBY(0L),
  @GeneratedMavEnumEntry
  RX_ENABLED(1L),
  @GeneratedMavEnumEntry
  TX_ENABLED(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutRfSelect? = when (v) {
      0L -> STANDBY
      1L -> RX_ENABLED
      2L -> TX_ENABLED
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<UavionixAdsbOutRfSelect> = buildList {
      if (v and 0L == 0L) add(STANDBY)
      if (v and 1L == 1L) add(RX_ENABLED)
      if (v and 2L == 2L) add(TX_ENABLED)
    }
  }
}

package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Transceiver RF control flags for ADS-B transponder dynamic reports
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbOutRfSelect(
  public override val `value`: UInt,
) : MavBitmask {
  @GeneratedMavEnumEntry
  STANDBY(0u),
  @GeneratedMavEnumEntry
  RX_ENABLED(1u),
  @GeneratedMavEnumEntry
  TX_ENABLED(2u),
  ;

  public companion object : MavEnum.Companion<UavionixAdsbOutRfSelect>,
      MavBitmask.Companion<UavionixAdsbOutRfSelect> {
    public override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutRfSelect? = when (v) {
      0u -> STANDBY
      1u -> RX_ENABLED
      2u -> TX_ENABLED
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<UavionixAdsbOutRfSelect> = buildList {
      if (v and 0u == 0u) add(STANDBY)
      if (v and 1u == 1u) add(RX_ENABLED)
      if (v and 2u == 2u) add(TX_ENABLED)
    }
  }
}

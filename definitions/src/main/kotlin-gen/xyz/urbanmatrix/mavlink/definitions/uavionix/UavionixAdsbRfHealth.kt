package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Status flags for ADS-B transponder dynamic output
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbRfHealth(
  public override val `value`: UInt,
) : MavBitmask {
  @GeneratedMavEnumEntry
  INITIALIZING(0u),
  @GeneratedMavEnumEntry
  OK(1u),
  @GeneratedMavEnumEntry
  FAIL_TX(2u),
  @GeneratedMavEnumEntry
  FAIL_RX(16u),
  ;

  public companion object : MavEnum.Companion<UavionixAdsbRfHealth>,
      MavBitmask.Companion<UavionixAdsbRfHealth> {
    public override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbRfHealth? = when (v) {
      0u -> INITIALIZING
      1u -> OK
      2u -> FAIL_TX
      16u -> FAIL_RX
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<UavionixAdsbRfHealth> = buildList {
      if (v and 0u == 0u) add(INITIALIZING)
      if (v and 1u == 1u) add(OK)
      if (v and 2u == 2u) add(FAIL_TX)
      if (v and 16u == 16u) add(FAIL_RX)
    }
  }
}

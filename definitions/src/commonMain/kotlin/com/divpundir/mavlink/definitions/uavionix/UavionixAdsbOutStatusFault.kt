package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * State flags for ADS-B transponder fault report
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbOutStatusFault(
  override val `value`: UInt,
) : MavBitmask {
  @GeneratedMavEnumEntry
  STATUS_MESSAGE_UNAVAIL(8u),
  @GeneratedMavEnumEntry
  GPS_NO_POS(16u),
  @GeneratedMavEnumEntry
  GPS_UNAVAIL(32u),
  @GeneratedMavEnumEntry
  TX_SYSTEM_FAIL(64u),
  @GeneratedMavEnumEntry
  MAINT_REQ(128u),
  ;

  public companion object : MavBitmask.MavCompanion<UavionixAdsbOutStatusFault> {
    override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutStatusFault? = when (v) {
      8u -> STATUS_MESSAGE_UNAVAIL
      16u -> GPS_NO_POS
      32u -> GPS_UNAVAIL
      64u -> TX_SYSTEM_FAIL
      128u -> MAINT_REQ
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<UavionixAdsbOutStatusFault> = buildList {
      if (v and 8u == 8u) add(STATUS_MESSAGE_UNAVAIL)
      if (v and 16u == 16u) add(GPS_NO_POS)
      if (v and 32u == 32u) add(GPS_UNAVAIL)
      if (v and 64u == 64u) add(TX_SYSTEM_FAIL)
      if (v and 128u == 128u) add(MAINT_REQ)
    }
  }
}

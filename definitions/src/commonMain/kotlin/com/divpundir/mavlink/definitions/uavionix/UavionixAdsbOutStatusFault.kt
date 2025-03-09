package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * State flags for ADS-B transponder fault report
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutStatusFault(
  override val `value`: UInt,
) : MavEnum {
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

  public companion object : MavEnum.MavCompanion<UavionixAdsbOutStatusFault> {
    override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbOutStatusFault? = when (v) {
      8u -> STATUS_MESSAGE_UNAVAIL
      16u -> GPS_NO_POS
      32u -> GPS_UNAVAIL
      64u -> TX_SYSTEM_FAIL
      128u -> MAINT_REQ
      else -> null
    }
  }
}

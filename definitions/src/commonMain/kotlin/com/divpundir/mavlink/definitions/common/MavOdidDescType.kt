package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidDescType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Optional free-form text description of the purpose of the flight.
   */
  @GeneratedMavEnumEntry
  TEXT(0u),
  /**
   * Optional additional clarification when status == MAV_ODID_STATUS_EMERGENCY.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(1u),
  /**
   * Optional additional clarification when status != MAV_ODID_STATUS_EMERGENCY.
   */
  @GeneratedMavEnumEntry
  EXTENDED_STATUS(2u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidDescType> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidDescType? = when (v) {
      0u -> TEXT
      1u -> EMERGENCY
      2u -> EXTENDED_STATUS
      else -> null
    }
  }
}

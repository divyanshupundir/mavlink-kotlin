package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidDescType(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<MavOdidDescType> {
    public override fun getEntryFromValueOrNull(v: UInt): MavOdidDescType? = when (v) {
      0u -> TEXT
      1u -> EMERGENCY
      2u -> EXTENDED_STATUS
      else -> null
    }
  }
}

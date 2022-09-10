package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidDescType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Optional free-form text description of the purpose of the flight.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_DESC_TYPE_TEXT(0L),
  /**
   * Optional additional clarification when status == MAV_ODID_STATUS_EMERGENCY.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_DESC_TYPE_EMERGENCY(1L),
  /**
   * Optional additional clarification when status != MAV_ODID_STATUS_EMERGENCY.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_DESC_TYPE_EXTENDED_STATUS(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidDescType? = when (v) {
      0L -> MAV_ODID_DESC_TYPE_TEXT
      1L -> MAV_ODID_DESC_TYPE_EMERGENCY
      2L -> MAV_ODID_DESC_TYPE_EXTENDED_STATUS
      else -> null
    }
  }
}

package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavOdidDescType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Optional free-form text description of the purpose of the flight.
   */
  MAV_ODID_DESC_TYPE_TEXT(0L),
  /**
   * Optional additional clarification when status == MAV_ODID_STATUS_EMERGENCY.
   */
  MAV_ODID_DESC_TYPE_EMERGENCY(1L),
  /**
   * Optional additional clarification when status != MAV_ODID_STATUS_EMERGENCY.
   */
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

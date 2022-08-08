package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class MavOdidOperatorLocationType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The location/altitude of the operator is the same as the take-off location.
   */
  MAV_ODID_OPERATOR_LOCATION_TYPE_TAKEOFF(0L),
  /**
   * The location/altitude of the operator is dynamic. E.g. based on live GNSS data.
   */
  MAV_ODID_OPERATOR_LOCATION_TYPE_LIVE_GNSS(1L),
  /**
   * The location/altitude of the operator are fixed values.
   */
  MAV_ODID_OPERATOR_LOCATION_TYPE_FIXED(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidOperatorLocationType? = when (v) {
      0L -> MAV_ODID_OPERATOR_LOCATION_TYPE_TAKEOFF
      1L -> MAV_ODID_OPERATOR_LOCATION_TYPE_LIVE_GNSS
      2L -> MAV_ODID_OPERATOR_LOCATION_TYPE_FIXED
      else -> null
    }
  }
}

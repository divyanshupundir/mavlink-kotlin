package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidOperatorIdType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * CAA (Civil Aviation Authority) registered operator ID.
   */
  MAV_ODID_OPERATOR_ID_TYPE_CAA(0L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidOperatorIdType? = when (v) {
      0L -> MAV_ODID_OPERATOR_ID_TYPE_CAA
      else -> null
    }
  }
}

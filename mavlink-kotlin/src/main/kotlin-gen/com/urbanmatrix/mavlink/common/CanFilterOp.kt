package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class CanFilterOp(
  public override val `value`: Long,
) : MavEnum {
  CAN_FILTER_REPLACE(0L),
  CAN_FILTER_ADD(1L),
  CAN_FILTER_REMOVE(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CanFilterOp? = when (v) {
      0L -> CAN_FILTER_REPLACE
      1L -> CAN_FILTER_ADD
      2L -> CAN_FILTER_REMOVE
      else -> null
    }
  }
}

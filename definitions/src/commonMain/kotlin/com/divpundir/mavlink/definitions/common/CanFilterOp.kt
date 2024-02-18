package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class CanFilterOp(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  CAN_FILTER_REPLACE(0u),
  @GeneratedMavEnumEntry
  CAN_FILTER_ADD(1u),
  @GeneratedMavEnumEntry
  CAN_FILTER_REMOVE(2u),
  ;

  public companion object : MavEnum.MavCompanion<CanFilterOp> {
    override fun getEntryFromValueOrNull(v: UInt): CanFilterOp? = when (v) {
      0u -> CAN_FILTER_REPLACE
      1u -> CAN_FILTER_ADD
      2u -> CAN_FILTER_REMOVE
      else -> null
    }
  }
}

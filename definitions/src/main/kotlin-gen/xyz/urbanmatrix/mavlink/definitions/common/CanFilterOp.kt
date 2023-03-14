package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class CanFilterOp(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  CAN_FILTER_REPLACE(0u),
  @GeneratedMavEnumEntry
  CAN_FILTER_ADD(1u),
  @GeneratedMavEnumEntry
  CAN_FILTER_REMOVE(2u),
  ;

  public companion object : MavEnum.Companion<CanFilterOp> {
    public override fun getEntryFromValueOrNull(v: UInt): CanFilterOp? = when (v) {
      0u -> CAN_FILTER_REPLACE
      1u -> CAN_FILTER_ADD
      2u -> CAN_FILTER_REMOVE
      else -> null
    }
  }
}

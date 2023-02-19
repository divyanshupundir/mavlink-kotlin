package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidOperatorIdType(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * CAA (Civil Aviation Authority) registered operator ID.
   */
  @GeneratedMavEnumEntry
  CAA(0u),
  ;

  public companion object : MavEnum.Companion<MavOdidOperatorIdType> {
    public override fun getEntryFromValueOrNull(v: UInt): MavOdidOperatorIdType? = when (v) {
      0u -> CAA
      else -> null
    }
  }
}

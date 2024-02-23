package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidOperatorIdType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * CAA (Civil Aviation Authority) registered operator ID.
   */
  @GeneratedMavEnumEntry
  CAA(0u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidOperatorIdType> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidOperatorIdType? = when (v) {
      0u -> CAA
      else -> null
    }
  }
}

package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GsmModemType(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * not specified
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * HUAWEI LTE USB Stick E3372
   */
  @GeneratedMavEnumEntry
  HUAWEI_E3372(1u),
  ;

  public companion object : MavEnum.MavCompanion<GsmModemType> {
    public override fun getEntryFromValueOrNull(v: UInt): GsmModemType? = when (v) {
      0u -> UNKNOWN
      1u -> HUAWEI_E3372
      else -> null
    }
  }
}

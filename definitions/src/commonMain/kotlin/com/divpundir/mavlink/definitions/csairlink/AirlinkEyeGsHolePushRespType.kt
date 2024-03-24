package com.divpundir.mavlink.definitions.csairlink

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class AirlinkEyeGsHolePushRespType(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  AIRLINK_HPR_PARTNER_NOT_READY(0u),
  @GeneratedMavEnumEntry
  AIRLINK_HPR_PARTNER_READY(1u),
  ;

  public companion object : MavEnum.MavCompanion<AirlinkEyeGsHolePushRespType> {
    override fun getEntryFromValueOrNull(v: UInt): AirlinkEyeGsHolePushRespType? = when (v) {
      0u -> AIRLINK_HPR_PARTNER_NOT_READY
      1u -> AIRLINK_HPR_PARTNER_READY
      else -> null
    }
  }
}

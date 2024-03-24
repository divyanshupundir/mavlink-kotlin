package com.divpundir.mavlink.definitions.csairlink

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class AirlinkEyeHolePushType(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  AIRLINK_HP_NOT_PENETRATED(0u),
  @GeneratedMavEnumEntry
  AIRLINK_HP_BROKEN(1u),
  ;

  public companion object : MavEnum.MavCompanion<AirlinkEyeHolePushType> {
    override fun getEntryFromValueOrNull(v: UInt): AirlinkEyeHolePushType? = when (v) {
      0u -> AIRLINK_HP_NOT_PENETRATED
      1u -> AIRLINK_HP_BROKEN
      else -> null
    }
  }
}

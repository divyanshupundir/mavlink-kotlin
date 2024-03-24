package com.divpundir.mavlink.definitions.csairlink

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class AirlinkEyeIpVersion(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  AIRLINK_IP_V4(0u),
  @GeneratedMavEnumEntry
  AIRLINK_IP_V6(1u),
  ;

  public companion object : MavEnum.MavCompanion<AirlinkEyeIpVersion> {
    override fun getEntryFromValueOrNull(v: UInt): AirlinkEyeIpVersion? = when (v) {
      0u -> AIRLINK_IP_V4
      1u -> AIRLINK_IP_V6
      else -> null
    }
  }
}

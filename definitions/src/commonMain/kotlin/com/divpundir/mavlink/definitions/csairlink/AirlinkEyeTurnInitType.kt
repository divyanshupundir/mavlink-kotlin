package com.divpundir.mavlink.definitions.csairlink

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class AirlinkEyeTurnInitType(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  AIRLINK_TURN_INIT_START(0u),
  @GeneratedMavEnumEntry
  AIRLINK_TURN_INIT_OK(1u),
  @GeneratedMavEnumEntry
  AIRLINK_TURN_INIT_BAD(2u),
  ;

  public companion object : MavEnum.MavCompanion<AirlinkEyeTurnInitType> {
    override fun getEntryFromValueOrNull(v: UInt): AirlinkEyeTurnInitType? = when (v) {
      0u -> AIRLINK_TURN_INIT_START
      1u -> AIRLINK_TURN_INIT_OK
      2u -> AIRLINK_TURN_INIT_BAD
      else -> null
    }
  }
}

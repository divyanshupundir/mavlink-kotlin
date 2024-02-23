package com.divpundir.mavlink.definitions.csairlink

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class AirlinkAuthResponseType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Login or password error
   */
  @GeneratedMavEnumEntry
  AIRLINK_ERROR_LOGIN_OR_PASS(0u),
  /**
   * Auth successful
   */
  @GeneratedMavEnumEntry
  AIRLINK_AUTH_OK(1u),
  ;

  public companion object : MavEnum.MavCompanion<AirlinkAuthResponseType> {
    override fun getEntryFromValueOrNull(v: UInt): AirlinkAuthResponseType? = when (v) {
      0u -> AIRLINK_ERROR_LOGIN_OR_PASS
      1u -> AIRLINK_AUTH_OK
      else -> null
    }
  }
}

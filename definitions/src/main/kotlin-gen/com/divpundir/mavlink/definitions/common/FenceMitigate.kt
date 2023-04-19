package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Actions being taken to mitigate/prevent fence breach
 */
@GeneratedMavEnum
public enum class FenceMitigate(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * No actions being taken
   */
  @GeneratedMavEnumEntry
  NONE(1u),
  /**
   * Velocity limiting active to prevent breach
   */
  @GeneratedMavEnumEntry
  VEL_LIMIT(2u),
  ;

  public companion object : MavEnum.Companion<FenceMitigate> {
    public override fun getEntryFromValueOrNull(v: UInt): FenceMitigate? = when (v) {
      0u -> UNKNOWN
      1u -> NONE
      2u -> VEL_LIMIT
      else -> null
    }
  }
}
